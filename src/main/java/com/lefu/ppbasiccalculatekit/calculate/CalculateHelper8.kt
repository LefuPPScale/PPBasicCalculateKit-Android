package com.lefu.ppbasiccalculatekit.calculate

import com.besthealth.bh5BodyComposition.BhBody270
import com.besthealth.bh5BodyComposition.BhErrorType
import com.besthealth.bh5BodyComposition.BhSex
import com.besthealth.bh5BodyComposition.BuildConfig
import com.lefu.ppbasiccalculatekit.BodyFatCalculateHelper
import com.lefu.ppbasiccalculatekit.BodyFatErrorType
import com.lefu.ppbasiccalculatekit.HTBodyBaseModel
import com.lefu.ppbasiccalculatekit.HTBodyFatModel
import com.lefu.ppbasiccalculatekit.assignHTBodyBaseModelToBodyFatModel
import com.lefu.ppbasiccalculatekit.createList

object CalculateHelper8 {

    /**
     * 8电极算法-使用新版本的算法，
     *
     * @param bodyFatModel
     */
    fun calculateTypeAlternate8(bodyBaseModel: HTBodyBaseModel, product: Int): HTBodyFatModel {
        val bodyFatModel = HTBodyFatModel()
        assignHTBodyBaseModelToBodyFatModel(bodyBaseModel, bodyFatModel)
        bodyBaseModel?.let {
            val body = BhBody270()

            bodyFatModel.ppSDKVersion = body.getSDKVersion()
            body.secret = bodyBaseModel.secret
            body.bhAge = bodyBaseModel.age
            body.bhHeightCm = bodyBaseModel.height * 1.0f
            body.bhWeightKg = bodyFatModel.ppWeightKg
            body.bhSex = if (bodyBaseModel.sex == 1) com.besthealth.bhBodyComposition.BhSex.MALE.ordinal else com.besthealth.bhBodyComposition.BhSex.FEMALE.ordinal

            body.bhProduct = product
            body.bhTrimming = 1.0f
            body.bhIsHome = false
            body.bhIsEnhancedRepeat = false
            body.bhSmoothlyK = 1.0

            body.bhZ20KhzRightArmEnCode = bodyBaseModel.z20KhzRightArmEnCode
            body.bhZ20KhzLeftArmEnCode = bodyBaseModel.z20KhzLeftArmEnCode
            body.bhZ20KhzTrunkEnCode = bodyBaseModel.z20KhzTrunkEnCode
            body.bhZ20KhzRightLegEnCode = bodyBaseModel.z20KhzRightLegEnCode
            body.bhZ20KhzLeftLegEnCode = bodyBaseModel.z20KhzLeftLegEnCode
            body.bhZ100KhzRightArmEnCode = bodyBaseModel.z100KhzRightArmEnCode
            body.bhZ100KhzLeftArmEnCode = bodyBaseModel.z100KhzLeftArmEnCode
            body.bhZ100KhzTrunkEnCode = bodyBaseModel.z100KhzTrunkEnCode
            body.bhZ100KhzRightLegEnCode = bodyBaseModel.z100KhzRightLegEnCode
            body.bhZ100KhzLeftLegEnCode = bodyBaseModel.z100KhzLeftLegEnCode

            bodyFatModel.bhProduct = product

            val bhErrorType: BhErrorType = BhErrorType.values().get(body.getBodyComposition())
            println("错误信息：$bhErrorType")
            System.out.println("SDKVersion=" + bodyFatModel.ppSDKVersion)
            bodyFatModel.errorType = BodyFatCalculateHelper.calculateHTErrorType(bhErrorType).getType()
            System.out.println("體重(Kg)=" + body.bhWeightKg)
            System.out.println("身高(cm)=" + body.bhHeightCm)
            System.out.println("年齡(歲)=" + body.bhAge)
            System.out.println("性別=" + BhSex.values().get(body.bhSex))
            System.out.println("bhProduct=" + body.bhProduct)
            System.out.println("加密阻抗-100Khz右手=" + body.bhZ100KhzRightArmEnCode)
            System.out.println("加密阻抗-100Khz左手=" + body.bhZ100KhzLeftArmEnCode)
            System.out.println("加密阻抗-100Khz躯干=" + body.bhZ100KhzTrunkEnCode)
            System.out.println("加密阻抗-100Khz右脚=" + body.bhZ100KhzRightLegEnCode)
            System.out.println("加密阻抗-100Khz左脚=" + body.bhZ100KhzLeftLegEnCode)
            System.out.println("加密阻抗-20Khz右手=" + body.bhZ20KhzRightArmEnCode)
            System.out.println("加密阻抗-20Khz左手=" + body.bhZ20KhzLeftArmEnCode)
            System.out.println("加密阻抗-20Khz躯干=" + body.bhZ20KhzTrunkEnCode)
            System.out.println("加密阻抗-20Khz右脚=" + body.bhZ20KhzRightLegEnCode)
            System.out.println("加密阻抗-20Khz左脚=" + body.bhZ20KhzLeftLegEnCode)
            System.out.println("解密阻抗-100Khz右手=" + body.bhZ100KhzRightArmDeCode)
            System.out.println("解密阻抗-100Khz左手=" + body.bhZ100KhzLeftArmDeCode)
            System.out.println("解密阻抗-100Khz躯干=" + body.bhZ100KhzTrunkDeCode)
            System.out.println("解密阻抗-100Khz右脚=" + body.bhZ100KhzRightLegDeCode)
            System.out.println("解密阻抗-100Khz左脚=" + body.bhZ100KhzLeftLegDeCode)
            System.out.println("解密阻抗-20Khz右手=" + body.bhZ20KhzRightArmDeCode)
            System.out.println("解密阻抗-20Khz左手=" + body.bhZ20KhzLeftArmDeCode)
            System.out.println("解密阻抗-20Khz躯干=" + body.bhZ20KhzTrunkDeCode)
            System.out.println("解密阻抗-20Khz右脚=" + body.bhZ20KhzRightLegDeCode)
            System.out.println("解密阻抗-20Khz左手=" + body.bhZ20KhzLeftLegDeCode)
            bodyFatModel.z100KhzLeftArmDeCode = body.bhZ100KhzLeftArmDeCode
            bodyFatModel.z100KhzLeftLegDeCode = body.bhZ100KhzLeftLegDeCode
            bodyFatModel.z100KhzRightArmDeCode = body.bhZ100KhzRightArmDeCode
            bodyFatModel.z100KhzRightLegDeCode = body.bhZ100KhzRightLegDeCode
            bodyFatModel.z100KhzTrunkDeCode = body.bhZ100KhzTrunkDeCode
            bodyFatModel.z20KhzLeftArmDeCode = body.bhZ20KhzLeftArmDeCode
            bodyFatModel.z20KhzLeftLegDeCode = body.bhZ20KhzLeftLegDeCode
            bodyFatModel.z20KhzRightArmDeCode = body.bhZ20KhzRightArmDeCode
            bodyFatModel.z20KhzRightLegDeCode = body.bhZ20KhzRightLegDeCode
            bodyFatModel.z20KhzTrunkDeCode = body.bhZ20KhzTrunkDeCode
            if (bodyFatModel.errorType == BodyFatErrorType.PP_ERROR_TYPE_NONE.getType()) {
                if (BuildConfig.DEBUG) {
                    System.out.println("全身体组成参数")
                    System.out.println("水分量(Kg)=" + body.bhWaterKg)
                    System.out.println("身體類型=" + body.bhBodyType)
                    System.out.println("脂肪率=" + body.bhBodyFatRate)
                    System.out.println("bhBMI=" + body.bhBMI)
                    System.out.println("bhWaterKg=" + body.bhWaterKg)
                    System.out.println("bhProteinKg=" + body.bhProteinKg)
                    System.out.println("bhBodyFatSubCutRate=" + body.bhBodyFatSubCutRate)
                    System.out.println("bhMuscleKg=" + body.bhMuscleKg)
                    System.out.println("bhBodyType=" + body.bhBodyType)
                    System.out.println("bhMineralKg=" + body.bhMineralKg)
                    System.out.println("bhBoneKg=" + body.bhBoneKg)
                    System.out.println("bhBodyFatKg=" + body.bhBodyFatKg)
                    System.out.println("bhProteinKg=" + body.bhProteinKg)
                    System.out.println("bhBodyFatFreeMassKg=" + body.bhBodyFatFreeMassKg)
                    System.out.println("bhMuscleRate=" + body.bhMuscleRate)
                    System.out.println("bhSkeletalMuscleKg=" + body.bhSkeletalMuscleKg)
                    System.out.println("bhWaterECWKg=" + body.bhWaterECWKg)
                    System.out.println("bhWaterICWKg=" + body.bhWaterICWKg)
                    System.out.println("bhCellMassKg=" + body.bhCellMassKg)
                    System.out.println("bhDCI=" + body.bhDCI)
                    System.out.println("bhBodyScore=" + body.bhBodyScore)
                    System.out.println("bhVFAL=" + body.bhVFAL)
                    System.out.println("bhObesity=" + body.bhObesity)
                    System.out.println("bhIdealWeightKg=" + body.bhIdealWeightKg)
                    System.out.println("bhTargetWeight=" + body.bhTargetWeight)
                    System.out.println("bhWeightKgCon=" + body.bhWeightKgCon)
                    System.out.println("bhBodyFatKgTrunk=" + body.bhBodyFatKgTrunk)
                    System.out.println("bhBodyFatKgLeftLeg=" + body.bhBodyFatKgLeftLeg)
                    System.out.println("bhBodyFatKgRightLeg=" + body.bhBodyFatKgRightLeg)
                    System.out.println("bhBodyFatKgLeftArm=" + body.bhBodyFatKgLeftArm)
                    System.out.println("bhBodyFatKgRightArm=" + body.bhBodyFatKgRightArm)
                    System.out.println("bhBodyFatRateTrunk=" + body.bhBodyFatRateTrunk)
                    System.out.println("bhBodyFatRateLeftLeg=" + body.bhBodyFatRateLeftLeg)
                    System.out.println("bhBodyFatRateRightLeg=" + body.bhBodyFatRateRightLeg)
                    System.out.println("bhBodyFatRateLeftArm=" + body.bhBodyFatRateLeftArm)
                    System.out.println("bhBodyFatRateRightArm=" + body.bhBodyFatRateRightArm)
                    System.out.println("bhMuscleKgTrunk=" + body.bhMuscleKgTrunk)
                    System.out.println("bhMuscleKgLeftLeg=" + body.bhMuscleKgLeftLeg)
                    System.out.println("bhMuscleKgRightLeg=" + body.bhMuscleKgRightLeg)
                    System.out.println("bhMuscleKgLeftArm=" + body.bhMuscleKgLeftArm)
                    System.out.println("bhMuscleKgRightArm=" + body.bhMuscleKgRightArm)
                }
                bodyFatModel.ppFat = body.bhBodyFatRate
                bodyFatModel.ppBMI = if (body.bhBMI >= 10) body.bhBMI else 10.0f
                bodyFatModel.ppBMR = body.bhBMR
                bodyFatModel.ppWaterKg = body.bhWaterKg
                bodyFatModel.ppProteinPercentage = body.bhProteinRate
                bodyFatModel.ppBodyFatSubCutPercentage = body.bhBodyFatSubCutRate //皮下脂肪率
                bodyFatModel.ppBodyFatSubCutKg = body.bhBodyFatSubCutKg //皮下脂肪量
                bodyFatModel.ppMuscleKg = body.bhMuscleKg
                bodyFatModel.ppBodyType = body.bhBodyType
                bodyFatModel.ppMineralKg = body.bhMineralKg
                bodyFatModel.ppBoneKg = body.bhBoneKg
                bodyFatModel.ppProteinKg = body.bhProteinKg
                bodyFatModel.ppLoseFatWeightKg = body.bhBodyFatFreeMassKg //去脂体重(kg)
                bodyFatModel.ppBodySkeletalKg = body.bhSkeletalMuscleKg
                bodyFatModel.ppBodySkeletal = body.bhSkeletalMuscleRate
                bodyFatModel.ppWaterECWKg = body.bhWaterECWKg
                bodyFatModel.ppWaterICWKg = body.bhWaterICWKg
                bodyFatModel.ppCellMassKg = body.bhCellMassKg
                bodyFatModel.ppDCI = body.bhDCI
                bodyFatModel.ppBodyScore = body.bhBodyScore
                bodyFatModel.ppVisceralFat = body.bhVFAL
                bodyFatModel.ppObesity = body.bhObesity
                bodyFatModel.ppIdealWeightKg = body.bhIdealWeightKg
                bodyFatModel.ppControlWeightKg = body.bhWeightKgCon
                bodyFatModel.ppBodyMuscleControl = body.bhMuscleKgCon
                bodyFatModel.ppFatControlKg = body.bhBodyFatKgCon
                bodyFatModel.ppBodyFatKgTrunk = body.bhBodyFatKgTrunk
                bodyFatModel.ppBodyFatKgLeftLeg = body.bhBodyFatKgLeftLeg
                bodyFatModel.ppBodyFatKgRightLeg = body.bhBodyFatKgRightLeg
                bodyFatModel.ppBodyFatKgLeftArm = body.bhBodyFatKgLeftArm
                bodyFatModel.ppBodyFatKgRightArm = body.bhBodyFatKgRightArm
                bodyFatModel.ppBodyFatRateTrunk = body.bhBodyFatRateTrunk
                bodyFatModel.ppBodyFatRateLeftLeg = body.bhBodyFatRateLeftLeg
                bodyFatModel.ppBodyFatRateRightLeg = body.bhBodyFatRateRightLeg
                bodyFatModel.ppBodyFatRateLeftArm = body.bhBodyFatRateLeftArm
                bodyFatModel.ppBodyFatRateRightArm = body.bhBodyFatRateRightArm
                bodyFatModel.ppMuscleKgTrunk = body.bhMuscleKgTrunk
                bodyFatModel.ppMuscleKgLeftLeg = body.bhMuscleKgLeftLeg
                bodyFatModel.ppMuscleKgRightLeg = body.bhMuscleKgRightLeg
                bodyFatModel.ppMuscleKgLeftArm = body.bhMuscleKgLeftArm
                bodyFatModel.ppMuscleKgRightArm = body.bhMuscleKgRightArm
                //1.6.6
                bodyFatModel.ppBodyStandardWeightKg = body.bhTargetWeight
                bodyFatModel.ppSmi = body.bhSmi
                bodyFatModel.ppWHR = body.bhWHR
                bodyFatModel.ppMuscleRateLeftArm = body.bhMuscleRateLeftArm
                bodyFatModel.ppMuscleRateLeftLeg = body.bhMuscleRateLeftLeg
                bodyFatModel.ppMuscleRateRightArm = body.bhMuscleRateRightArm
                bodyFatModel.ppMuscleRateRightLeg = body.bhMuscleRateRightLeg
                bodyFatModel.ppMuscleRateTrunk = body.bhMuscleRateTrunk
                //1.6.8 16项八电极
                bodyFatModel.ppRightArmMuscleLevel = body.bhRightArmMuscleLevel
                bodyFatModel.ppLeftArmMuscleLevel = body.bhLeftArmMuscleLevel
                bodyFatModel.ppTrunkMuscleLevel = body.bhTrunkMuscleLevel
                bodyFatModel.ppRightLegMuscleLevel = body.bhRightLegMuscleLevel
                bodyFatModel.ppLeftLegMuscleLevel = body.bhLeftLegMuscleLevel
                bodyFatModel.ppRightArmFatLevel = body.bhRightArmFatLevel
                bodyFatModel.ppLeftArmFatLevel = body.bhLeftArmFatLevel
                bodyFatModel.ppTrunkFatLevel = body.bhTrunkFatLevel
                bodyFatModel.ppRightLegFatLevel = body.bhRightLegFatLevel
                bodyFatModel.ppLeftLegFatLevel = body.bhLeftLegFatLevel
                bodyFatModel.ppBalanceArmsLevel = body.bhBalanceArmsLevel
                bodyFatModel.ppBalanceLegsLevel = body.bhBalanceLegsLevel
                bodyFatModel.ppBalanceArmLegLevel = body.bhBalanceArmLegLevel
                bodyFatModel.ppBalanceFatArmsLevel = body.bhBalanceFatArmsLevel
                bodyFatModel.ppBalanceFatLegsLevel = body.bhBalanceFatLegsLevel
                bodyFatModel.ppBalanceFatArmLegLevel = body.bhBalanceFatArmLegLevel

                bodyFatModel.ppWeightKgList = createList(body.bhWeightKgListMin, body.bhWeightKgListMax)
                bodyFatModel.ppFatList = createList(body.bhBodyFatRateListMin, body.bhBodyFatRateListMax)
                bodyFatModel.ppBodyfatKgList = createList(body.bhBodyFatKgListMin, body.bhBodyFatKgListMax)
                bodyFatModel.ppMusclePercentageList = createList(body.bhMuscleRateListMin, body.bhMuscleRateListMax)
                bodyFatModel.ppMuscleKgList = createList(body.bhMuscleKgListMin, body.bhMuscleKgListMax)
                bodyFatModel.ppBodySkeletalList = createList(body.bhSkeletalMuscleRateListMin, body.bhSkeletalMuscleRateListMax)
                bodyFatModel.ppBodySkeletalKgList = createList(body.bhSkeletalMuscleKgListMin, body.bhSkeletalMuscleKgListMax)
                bodyFatModel.ppWaterPercentageList = createList(body.bhWaterRateListMin, body.bhWaterRateListMax)

                bodyFatModel.ppWaterKgList = createList(body.bhWaterKgListMin, body.bhWaterKgListMax)
                bodyFatModel.ppProteinPercentageList = createList(body.bhProteinRateListMin, body.bhProteinRateListMax)

                bodyFatModel.ppProteinKgList = createList(body.bhProteinKgListMin, body.bhProteinKgListMax)
                bodyFatModel.ppLoseFatWeightKgList = createList(body.bhBodyFatFreeMassKgListMin, body.bhBodyFatFreeMassKgListMax)
                bodyFatModel.ppBodyFatSubCutPercentageList = createList(body.bhBodyFatSubCutRateListMin, body.bhBodyFatSubCutRateListMax)
                bodyFatModel.ppBodyFatSubCutKgList = createList(body.bhBodyFatSubCutKgListMin, body.bhBodyFatSubCutKgListMax)
                bodyFatModel.ppBMRList = createList(body.bhBMRListMin, body.bhBMRListMax)
                bodyFatModel.ppVisceralFatList = createList(body.bhVFALListMin, body.bhVFALListMax)
                bodyFatModel.ppBoneKgList = createList(body.bhBoneKgListMin, body.bhBoneKgListMax)

                /**************** 八电极算法独有 ****************************/
                bodyFatModel.ppCellMassKgList = createList(body.bhCellMassKgListMin, body.bhCellMassKgListMax)
                bodyFatModel.ppMineralKgList = createList(body.bhMineralKgListMin, body.bhMineralKgListMax)
                bodyFatModel.ppObesityList = createList(body.bhObesityListMin, body.bhObesityListMax)
                bodyFatModel.ppWaterECWKgList = createList(body.bhWaterECWKgListMin, body.bhWaterECWKgListMax)
                bodyFatModel.ppWaterICWKgList = createList(body.bhWaterICWKgListMin, body.bhWaterICWKgListMax)
                bodyFatModel.ppWHRList = createList(body.bhWHRListMin, body.bhWHRListMax)
                bodyFatModel.ppSmiList = createList(body.bhSmiListMin)

            } else {

            }

        }
        return bodyFatModel
    }

}
