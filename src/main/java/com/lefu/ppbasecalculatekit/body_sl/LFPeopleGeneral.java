package com.lefu.ppbasecalculatekit.body_sl;

import com.lefu.body_sl.BodyInput;
import com.lefu.body_sl.BodyOutput;
import com.lefu.body_sl.ErrorType;
import com.lefu.body_sl.LFBody;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * body_ErrorType ERRORTYPE;	// 錯誤類型
 * unsigned short BMI;			// 人體質量指數	(分辨率:  0.1, 範圍: 10~90 )
 * unsigned short MUSCLE;		// 肌肉量  		(分辨率:0.01Kg, 範圍: 10.00  ~  120.00)
 * unsigned short BDFAT;		// 脂肪率  		(分辨率:0.1% , 範圍: 5.1%  ~  70.0%)
 * unsigned short WATER;		// 水分率  		(分辨率:0.1% , 範圍: 20.6% ~  68.5%)
 * unsigned short PROTEIN;		// 蛋白质			(分辨率:0.1% , 範圍: 4.0%  ~  22.0%)
 * unsigned short SKELETAL;	    // 骨骼肌率  		(分辨率:0.1% , 範圍: 17.5% ~  61.3%)
 * unsigned short BMR;			// 基礎代謝		(分辨率:   1 , 範圍: 900   ~  2500	)
 * unsigned short SUBFAT;		// 皮下脂肪率  	(分辨率:0.1% , 範圍: 4.7%  ~  61.0%)
 * unsigned short BONE;		    // 骨量    		(分辨率:0.01kg, 範圍: 0.50kg ~  8.00kg)
 * unsigned char VFAL;			// 內臟脂肪		(分辨率:   1 , 範圍: 1  ~  30  	)
 * unsigned char AGE;			// 身体年龄		(分辨率:   1 , 範圍: 1  ~  99  	)
 * unsigned short NOFATWEIGHT; //  去脂体重		(分辨率:0.01Kg, 範圍: 9.49  ~  170.82)
 * // 分辨率0.1的，结果*10，如:脂肪率=5.1%,即,BODY.BDFAT==51;
 */
public class LFPeopleGeneral {

    float weightKg;            //体重(kg)
    int heightCm;               //身高(cm)，需在 90 ~ 220cm
    int age;                    //年龄(岁)，需在6 ~ 99岁
    int sex;                    //性别 女0 男1
    int sportsman;              //运动员模式1 非运动员模式0  默认0
    long impedance;              //阻抗 200-1200之间为有效脂肪数据
    public int htBodyAge;                                                  //身体年龄,6~99岁
    public float htIdealWeightKg;                                         //理想体重(kg)
    public float htBMI;                                                   //BMI 人体质量指数, 分辨率0.1, 范围10.0 ~ 90.0
    public int htBMR;                                                      //Basal Metabolic Rate基础代谢, 分辨率1, 范围500 ~ 10000
    public int htVFAL;                                                     //Visceral fat area leverl内脏脂肪, 分辨率1, 范围1 ~ 60
    public float htBoneKg;                                                //骨量(kg), 分辨率0.1, 范围0.5 ~ 8.0
    public float htBodyfatPercentage;                                     //脂肪率(%), 分辨率0.1, 范围5.0% ~ 75.0%
    public float htWaterPercentage;                                       //水分率(%), 分辨率0.1, 范围35.0% ~ 75.0%
    public float htMuscleKg;                                              //肌肉量(kg), 分辨率0.1, 范围10.0 ~ 120.0
    public float htProteinPercentage;                                     //蛋白质,分辨率0.1, 范围2.0% ~ 30.0%
    public float ppLoseFatWeightKg;                                       //去脂体重(kg)
    public float ppVFPercentage;                                          //皮下脂肪(%)
    public float ppBonePercentage;                                        //骨骼肌率(%)

    static {
        System.loadLibrary("sl");
    }

    public LFPeopleGeneral(float weightKg, int heightCm, int age, int sex, int sportsman, long impedance) {
        this.weightKg = weightKg;
        this.heightCm = heightCm;
        this.age = age;
        this.sex = sex;
        this.sportsman = sportsman;
        this.impedance = impedance;
    }

    public ErrorType getBodyfatParameters() {

        BigDecimal value1 = new BigDecimal(weightKg);
        BigDecimal multiplier = new BigDecimal("100");
        BigDecimal result = value1.multiply(multiplier);
        BigDecimal roundedResult = result.setScale(0, RoundingMode.HALF_UP);

        BodyInput bodyInput = new BodyInput((short) (roundedResult.intValue()), (char) heightCm, (char) age, (char) sex, (char) sportsman, (short) impedance);
        BodyOutput bodyOutput = LFBody.fun_getBodyFat_sl(bodyInput);

        if (bodyOutput != null) {
            this.htBodyfatPercentage = bodyOutput.getBDFAT() / 10.0f;
            this.htWaterPercentage = bodyOutput.getWATER() / 10.0f;
            this.htBoneKg = bodyOutput.getBONE() / 100.0f;
            this.htMuscleKg = bodyOutput.getMUSCLE() / 100.0f;
            this.htVFAL = bodyOutput.getVFAL();
            this.htBMR = bodyOutput.getBMR();
            this.htBMI = bodyOutput.getBMI() / 10.0f;
            this.htBodyAge = bodyOutput.getAGE();
            this.htProteinPercentage = bodyOutput.getPROTEIN() / 10.0f;
//            this.htIdealWeightKg = (float) (21.75f * Math.sqrt((double) heightCm / 100.0f));
            this.htIdealWeightKg = (float) (21.75f * Math.pow((double) heightCm / 100.0f,2));
            this.ppLoseFatWeightKg = bodyOutput.getNOFATWEIGHT() / 100.0f;
            this.ppVFPercentage = bodyOutput.getSUBFAT() / 10.0f;
            this.ppBonePercentage = bodyOutput.getSKELETAL() / 10.0f;
            //这里的BMI有问题，ppBodyType要在计算完BMI后，再计算。
//            this.ppBodyType = countBodyType(htBMI, htBodyfatPercentage);
            return bodyOutput.getERRORTYPE();
        }
        return ErrorType.BD_NONE;
    }

    @Override
    public String toString() {
        return "LFPeopleGeneral{" +
                "weightKg=" + weightKg +
                ", heightCm=" + heightCm +
                ", age=" + age +
                ", sex=" + sex +
                ", sportsman=" + sportsman +
                ", impedance=" + impedance +
                ", htBodyAge=" + htBodyAge +
                ", htIdealWeightKg=" + htIdealWeightKg +
                ", htBMI=" + htBMI +
                ", htBMR=" + htBMR +
                ", htVFAL=" + htVFAL +
                ", htBoneKg=" + htBoneKg +
                ", htBodyfatPercentage=" + htBodyfatPercentage +
                ", htWaterPercentage=" + htWaterPercentage +
                ", htMuscleKg=" + htMuscleKg +
                ", htProteinPercentage=" + htProteinPercentage +
                ", ppLoseFatWeightKg=" + ppLoseFatWeightKg +
                ", ppVFPercentage=" + ppVFPercentage +
                ", ppBonePercentage=" + ppBonePercentage +
                '}';
    }
}
