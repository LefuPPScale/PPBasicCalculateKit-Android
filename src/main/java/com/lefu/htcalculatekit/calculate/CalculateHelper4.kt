package com.lefu.htcalculatekit.calculate

import com.besthealth.bhBodyComposition.BhErrorType
import com.besthealth.bhBodyComposition.BhPeopleType
import com.besthealth.bhBodyComposition.BhSex
import com.besthealth.bhBodyComposition.BhTwoLegs140
import com.lefu.htcalculatekit.BodyFatCalculateHelper
import com.lefu.htcalculatekit.BodyFatErrorType
import com.lefu.htcalculatekit.HTBodyBaseModel
import com.lefu.htcalculatekit.HTBodyFatModel
import com.lefu.htcalculatekit.HTErrorType
import com.lefu.htcalculatekit.assignHTBodyBaseModelToBodyFatModel
import com.lefu.htcalculatekit.body_sl.LFPeopleGeneral
import com.lefu.htcalculatekit.createList

object CalculateHelper4 {

    const val LF_4_Z = "LF_4_ZLefu_2023-05-15_V1.0.0"

    /**
     * 直流算法
     *
     * @param bodyFatModel
     */
    fun calculateTypeDCAlgorithm(bodyBaseModel: HTBodyBaseModel): HTBodyFatModel {
        val bodyFatModel = HTBodyFatModel()
        assignHTBodyBaseModelToBodyFatModel(bodyBaseModel, bodyFatModel)

        //非八电极
        bodyFatModel.ppSDKVersion = LF_4_Z
        val bodyfat = LFPeopleGeneral(
            bodyFatModel.ppWeightKg, bodyBaseModel.height,
            bodyBaseModel.age,
            bodyBaseModel.sex,
            if (bodyBaseModel.isAthleteMode) 1 else 0,
            bodyBaseModel.impedance
        )
        bodyFatModel.errorType = BodyFatCalculateHelper.calculateZLefuErrorType(bodyfat.getBodyfatParameters()).getType()
        if (bodyFatModel.errorType == BodyFatErrorType.PP_ERROR_TYPE_NONE.getType()) {
            bodyFatModel.ppProteinPercentage = bodyfat.htProteinPercentage
            bodyFatModel.ppIdealWeightKg = bodyfat.htIdealWeightKg
            bodyFatModel.ppBMI =if (bodyfat.htBMI >= 10) bodyfat.htBMI else 10.0f
            bodyFatModel.ppBMR = bodyfat.htBMR
            bodyFatModel.ppVisceralFat = bodyfat.htVFAL
            bodyFatModel.ppBoneKg = bodyfat.htBoneKg
            bodyFatModel.ppFat = bodyfat.htBodyfatPercentage
            bodyFatModel.ppWaterPercentage = bodyfat.htWaterPercentage
            bodyFatModel.ppMuscleKg = bodyfat.htMuscleKg
            bodyFatModel.ppLoseFatWeightKg = bodyfat.ppLoseFatWeightKg
            bodyFatModel.ppBodyFatSubCutPercentage = bodyfat.ppVFPercentage
            bodyFatModel.ppBodySkeletal = bodyfat.ppBonePercentage
            bodyFatModel.ppBodyAge = bodyfat.htBodyAge
            bodyFatModel.ppBodyStandardWeightKg = bodyfat.htIdealWeightKg
        }
        return bodyFatModel
    }

    /**
     * 4电极双脚阻抗
     *
     * @param bodyBaseModel
     * @param bodyFatModel
     */
    fun calcuteTypeAlternateTwoLegs(bodyBaseModel: HTBodyBaseModel): HTBodyFatModel {
        val bodyFatModel = HTBodyFatModel()
        assignHTBodyBaseModelToBodyFatModel(bodyBaseModel, bodyFatModel)
        val body = BhTwoLegs140()
        bodyFatModel.ppSDKVersion = body.getSDKVersion()
        body.secret = bodyBaseModel.secret
        body.bhAge = bodyBaseModel.age
        body.bhHeightCm = bodyBaseModel.height * 1.0f
        body.bhWeightKg = bodyFatModel.ppWeightKg
        body.bhSex = if (bodyBaseModel.sex == 1) BhSex.MALE.ordinal else BhSex.FEMALE.ordinal
        body.bhPeopleType = if (bodyBaseModel.isAthleteMode ?: false) BhPeopleType.ATHLETE.ordinal else BhPeopleType.NORMAL.ordinal
        body.bhZTwoLegsEnCode = bodyBaseModel.impedance
        val bhErrorType: BhErrorType = BhErrorType.values().get(body.getBodyComposition())
        println("impedance：" + bodyBaseModel.impedance)
        println("错误信息：$bhErrorType")
        System.out.println(body.getSDKVersion())

        bodyFatModel.errorType = BodyFatCalculateHelper.calculateHTErrorType4AC(bhErrorType).getType()
        if (bodyFatModel.errorType == BodyFatErrorType.PP_ERROR_TYPE_NONE.getType()) {
            System.out.println("體重(Kg)=" + body.bhWeightKg)
            System.out.println("身高(cm)=" + body.bhHeightCm)
            System.out.println("年齡(歲)=" + body.bhAge)
            System.out.println("性別=" + BhSex.values().get(body.bhSex))
            System.out.println("用戶類型=" + body.bhPeopleType)
            System.out.println("加密阻抗-雙腳=" + body.bhZTwoLegsEnCode)
            System.out.println("解密阻抗-雙腳(Ω)=" + body.bhZTwoLegsDeCode)
            bodyFatModel.zTwoLegsDeCode = body.bhZTwoLegsDeCode
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
            bodyFatModel.ppLoseFatWeightKg = bodyFatModel.ppWeightKg - bodyFatModel.ppBodyfatKg

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
            bodyFatModel.ppBodySkeletalKgList = bhSkeletalMuscleKgList
            bodyFatModel.ppProteinPercentageList = bhProteinRateList
            bodyFatModel.ppBodyFatSubCutPercentageList = bhBodyFatSubCutRateList
            bodyFatModel.ppBMRList = bhBMRList
        } else {

        }
        return bodyFatModel
    }


}
