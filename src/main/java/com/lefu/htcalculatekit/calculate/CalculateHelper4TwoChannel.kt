package com.lefu.htcalculatekit.calculate

import com.besthealth.bh3BodyComposition.BhErrorType
import com.besthealth.bh3BodyComposition.BhSex
import com.besthealth.bh3BodyComposition.BhTwoLegs240
import com.besthealth.bhBodyComposition.BhPeopleType
import com.lefu.htcalculatekit.BodyFatCalculateHelper
import com.lefu.htcalculatekit.BodyFatErrorType
import com.lefu.htcalculatekit.HTBodyBaseModel
import com.lefu.htcalculatekit.HTBodyFatModel
import com.lefu.htcalculatekit.assignHTBodyBaseModelToBodyFatModel
import com.lefu.htcalculatekit.createList

object CalculateHelper4TwoChannel {

    /**
     * 4电极双频
     *
     * @param bodyBaseModel
     * @param bodyFatModel
     */
    fun calcuteTypeAlternate4TwoChannel(bodyBaseModel: HTBodyBaseModel): HTBodyFatModel {
        val bodyFatModel = HTBodyFatModel()

        assignHTBodyBaseModelToBodyFatModel(bodyBaseModel, bodyFatModel)

        val body = BhTwoLegs240()
        bodyFatModel.ppSDKVersion = body.getSDKVersion()
        body.secret = bodyBaseModel.secret
        body.bhAge = bodyBaseModel.age
        body.bhHeightCm = bodyBaseModel.height * 1.0f
        body.bhWeightKg = bodyFatModel.ppWeightKg
        body.bhSex = if (bodyBaseModel.sex == 1) com.besthealth.bhBodyComposition.BhSex.MALE.ordinal else com.besthealth.bhBodyComposition.BhSex.FEMALE.ordinal
        body.bhPeopleType = if (bodyBaseModel.isAthleteMode ?: false) BhPeopleType.ATHLETE.ordinal else BhPeopleType.NORMAL.ordinal
        body.bhZTwoLegsEnCode50Khz = bodyBaseModel.impedance
        if (bodyBaseModel.ppImpedance100EnCode == 0L) {
            bodyBaseModel.ppImpedance100EnCode = bodyBaseModel.impedance
        }
        body.bhZTwoLegsEnCode100Khz = bodyBaseModel.ppImpedance100EnCode
        val bhErrorType: BhErrorType = BhErrorType.values().get(body.getBodyComposition())
        bodyFatModel.errorType = BodyFatCalculateHelper.calculateHTErrorTypeTwoChannel(bhErrorType).getType()
        if (bodyBaseModel.impedance <= 0) {
            bodyFatModel.errorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_LEGS.getType()
        }
        println("erropType：$bhErrorType")
        System.out.println(body.getSDKVersion())
        System.out.println("Weight(Kg)=" + body.bhWeightKg)
        System.out.println("Height(cm)=" + body.bhHeightCm)
        System.out.println("Age=" + body.bhAge)
        System.out.println("Sex=" + BhSex.values().get(body.bhSex))
        System.out.println("PeopleType=" + body.bhPeopleType)
        System.out.println("bhZTwoLegsEnCode50Khz=" + body.bhZTwoLegsEnCode50Khz)
        System.out.println("bhZTwoLegsEnCode100Khz=" + body.bhZTwoLegsEnCode100Khz)
        System.out.println("bhZTwoLegsDeCode50Khz(Ω)=" + body.bhZTwoLegsDeCode50Khz)
        System.out.println("bhZTwoLegsDeCode100Khz(Ω)=" + body.bhZTwoLegsDeCode100Khz)
        System.out.println("bodyFatModel.errorType=" + bodyFatModel.errorType)
        if (bodyFatModel.errorType == BodyFatErrorType.PP_ERROR_TYPE_NONE.getType()) {
            System.out.println("bhWaterRate=" + body.bhWaterRate)
            System.out.println("BodyType=" + body.bhBodyType)
            System.out.println("BodyFat=" + body.bhBodyFatRate)
            System.out.println("bhBMI=" + body.bhBMI)
            System.out.println("bhBodyFatSubCutRate=" + body.bhBodyFatSubCutRate)
            System.out.println("bhMuscleKg=" + body.bhMuscleKg)
            System.out.println("bhBoneKg=" + body.bhBoneKg)
            System.out.println("bhBodyFatKg=" + body.bhBodyFatKg)
            System.out.println("bhBodyFatFreeMassKg=" + body.bhBodyFatFreeMassKg)
            System.out.println("bhMuscleRate=" + body.bhMuscleRate)
            System.out.println("bhSkeletalMuscleKg=" + body.bhSkeletalMuscleKg)
            System.out.println("bhBodyScore=" + body.bhBodyScore)
            System.out.println("bhVFAL=" + body.bhVFAL)
            System.out.println("bhIdealWeightKg=" + body.bhIdealWeightKg)
            System.out.println("bhProteinRate=" + body.bhProteinRate)
            System.out.println("bhSkeletalMuscleKg=" + body.bhSkeletalMuscleKg)
            System.out.println("bhBodyAge=" + body.bhBodyAge)

            bodyBaseModel.zTwoLegsDeCode = body.bhZTwoLegsDeCode50Khz
            bodyBaseModel.ppImpedance100DeCode = body.bhZTwoLegsDeCode100Khz
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

            bodyFatModel.ppBodyAge = body.bhBodyAge
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
