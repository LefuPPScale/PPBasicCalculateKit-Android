package com.lefu.ppbasecalculatekit.calculate

import com.besthealth.bh4BodyComposition.BhErrorType
import com.besthealth.bh4BodyComposition.BhSex
import com.besthealth.bh4BodyComposition.BhTwoArms140
import com.besthealth.bhBodyComposition.BhPeopleType
import com.lefu.ppbasecalculatekit.BodyFatCalculateHelper
import com.lefu.ppbasecalculatekit.BodyFatErrorType
import com.lefu.ppbasecalculatekit.HTBodyBaseModel
import com.lefu.ppbasecalculatekit.HTBodyFatModel
import com.lefu.ppbasecalculatekit.assignHTBodyBaseModelToBodyFatModel
import com.lefu.ppbasecalculatekit.createList

object CalculateHelper4TwoArms {

    /**
     * 双手算法
     *
     * @param bodyBaseModel
     * @param bodyFatModel
     */
    fun calcuteTypeAlternateTwoArms(bodyBaseModel: HTBodyBaseModel): HTBodyFatModel {

        val bodyFatModel = HTBodyFatModel()

        assignHTBodyBaseModelToBodyFatModel(bodyBaseModel, bodyFatModel)

        val body = BhTwoArms140()
        bodyFatModel.ppSDKVersion = body.getSDKVersion()
        body.secret = bodyBaseModel.secret
        body.bhAge = bodyBaseModel.age
        body.bhHeightCm = bodyBaseModel.height * 1.0f
        body.bhWeightKg = bodyFatModel.ppWeightKg
        body.bhSex = if (bodyBaseModel.sex == 1) com.besthealth.bhBodyComposition.BhSex.MALE.ordinal else com.besthealth.bhBodyComposition.BhSex.FEMALE.ordinal
        body.bhPeopleType = if (bodyBaseModel.isAthleteMode ?: false) BhPeopleType.ATHLETE.ordinal else BhPeopleType.NORMAL.ordinal
        body.bhZTwoArmsEnCode = bodyBaseModel.impedance
        val bhErrorType: BhErrorType = BhErrorType.values().get(body.getBodyComposition())
        println("impedance：" + bodyBaseModel.impedance)
        println("错误信息：$bhErrorType")
        System.out.println(body.getSDKVersion())
        bodyFatModel.errorType = BodyFatCalculateHelper.calculateHTErrorTypeTwoArms(bhErrorType).getType()
        if (bodyFatModel.errorType == BodyFatErrorType.PP_ERROR_TYPE_NONE.getType()) {
            System.out.println("體重(Kg)=" + body.bhWeightKg)
            System.out.println("身高(cm)=" + body.bhHeightCm)
            System.out.println("年齡(歲)=" + body.bhAge)
            System.out.println("性別=" + BhSex.values().get(body.bhSex))
            System.out.println("用戶類型=" + body.bhPeopleType)
            System.out.println("加密阻抗-雙手50Khz(Ω)=" + body.bhZTwoArmsEnCode)
            System.out.println("解密阻抗-雙手50Khz(Ω)=" + body.bhZTwoArmsDeCode)
            bodyBaseModel.zTwoLegsDeCode = body.bhZTwoArmsDeCode
            bodyFatModel.ppProteinPercentage = body.bhProteinRate
            bodyFatModel.ppIdealWeightKg = body.bhIdealWeightKg
            bodyFatModel.ppBMI = if (body.bhBMI >= 10) body.bhBMI else 10.0f
            bodyFatModel.ppBMR = body.bhBMR
            bodyFatModel.ppVisceralFat = body.bhVFAL
            bodyFatModel.ppBoneKg = body.bhBoneKg
            bodyFatModel.ppFat = body.bhBodyFatRate
            bodyFatModel.ppWaterPercentage = body.bhWaterRate
            bodyFatModel.ppMuscleKg = body.bhMuscleKg
            bodyFatModel.ppBodyScore = body.bhBodyScore
            bodyFatModel.ppMusclePercentage = body.bhMuscleRate
            bodyFatModel.ppBodySkeletalKg = body.bhSkeletalMuscleKg
            bodyFatModel.ppBodyStandardWeightKg = body.bhIdealWeightKg
            bodyFatModel.ppIdealWeightKg = body.bhIdealWeightKg
            bodyFatModel.ppLoseFatWeightKg = body.bhBodyFatFreeMassKg

            bodyFatModel.ppMuscleKgList = createList(body.bhMuscleKgListUnderOrStandard, body.bhMuscleKgListStandardOrExcellent)
            bodyFatModel.ppMusclePercentageList = createList(body.bhMuscleKgListUnderOrStandard, body.bhMuscleKgListStandardOrExcellent)
            bodyFatModel.ppWaterPercentageList = createList(body.bhWaterRateListUnderOrStandard, body.bhWaterRateListStandardOrExcellent)
            bodyFatModel.ppWaterKgList = createList(body.bhWaterRateListUnderOrStandard, body.bhWaterRateListStandardOrExcellent)
            bodyFatModel.ppBoneKgList = createList(body.bhBoneKgListUnderOrStandard, body.bhBoneKgListStandardOrExcellent)

            val ppBodyfatRateCreateList = createList(
                body.bhBodyFatRateListUnderFatOrStandardMinus,
                body.bhBodyFatRateListStandardMinusOrStandardPlus,
                body.bhBodyFatRateListStandardPlusOrOverFat,
                body.bhBodyFatRateListOverFatOrObese
            )
            val bhSkeletalMuscleKgList = createList(
                body.bhSkeletalMuscleKgListUnderOrStandard,
                body.bhSkeletalMuscleKgListStandardOrExcellent
            )
            val bhProteinRateList = createList(
                body.bhProteinRateListUnderOrStandard,
                body.bhProteinRateListStandardOrExcellent
            )
            val bhBodyFatSubCutRateList = createList(
                body.bhBodyFatSubCutRateListUnderOrStandard,
                body.bhBodyFatSubCutRateListStandardOrOver
            )
            val bhBMRList = createList(body.bhBMRListUnderOrStandard.toFloat())
            bodyFatModel.ppBodyfatKgList = ppBodyfatRateCreateList
            bodyFatModel.ppFatList = ppBodyfatRateCreateList
            bodyFatModel.ppBodySkeletalList = bhSkeletalMuscleKgList
            bodyFatModel.ppBodySkeletalKgList = bhSkeletalMuscleKgList
            bodyFatModel.ppProteinPercentageList = bhProteinRateList
            bodyFatModel.ppProteinKgList = bhProteinRateList
            bodyFatModel.ppBodyFatSubCutPercentageList = bhBodyFatSubCutRateList
            bodyFatModel.ppBodyFatSubCutKgList = bhBodyFatSubCutRateList
            bodyFatModel.ppBMRList = bhBMRList
        } else {

        }
        return bodyFatModel
    }

}
