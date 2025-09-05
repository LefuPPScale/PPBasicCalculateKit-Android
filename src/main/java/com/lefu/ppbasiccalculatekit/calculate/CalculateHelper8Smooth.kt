package com.lefu.ppbasiccalculatekit.calculate

import android.util.Log
import com.besthealth.bh5BodyComposition.BhBody270
import com.besthealth.bh5BodyComposition.BhErrorType
import com.besthealth.bh5BodyComposition.BhSex
import com.besthealth.bh5BodyComposition.BuildConfig
import com.lefu.ppbasiccalculatekit.BodyFatCalculateHelper
import com.lefu.ppbasiccalculatekit.BodyFatErrorType
import com.lefu.ppbasiccalculatekit.HTCalculateManager
import com.lefu.ppbasiccalculatekit.HTBodyBaseModel
import com.lefu.ppbasiccalculatekit.HTBodyFatModel
import com.lefu.ppbasiccalculatekit.assignHTBodyBaseModelToBodyFatModel
import com.lefu.ppbasiccalculatekit.createList
import kotlin.math.abs

object CalculateHelper8Smooth {

    /**
     * 8电极算法-平滑
     *
     * @param bodyFatModel
     */
    fun calculateTypeAlternate8Smooth(bodyBaseModel: HTBodyBaseModel): HTBodyFatModel {
        Log.i("", "CalculateHelper8Smooth calculateTypeAlternate8Smooth 第一次计算")
        //第一次计算
        val currentBodyFatModel = CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 6)

        //如果第一次计算没有错误, 并且上一次缓存不为空则进入第二次计算
        Log.i("", "CalculateHelper8Smooth calculateTypeAlternate8Smooth currentBodyFatModel ppFat:${currentBodyFatModel?.ppFat}  errorType:${currentBodyFatModel?.errorType} ")
        if (currentBodyFatModel?.errorType == BodyFatErrorType.PP_ERROR_TYPE_NONE.getType()) {


            val lastBaseModel = HTCalculateManager.lastBodyBaseModel
            //对比身高，性别，年龄是否与上一组一致
            val isUserInfoConsistent = lastBaseModel?.let { lastModel ->
                val currentHeight = currentBodyFatModel.height
                val currentGender = currentBodyFatModel.sex
                val currentAge = currentBodyFatModel.age

                val lastHeight = lastModel.height
                val lastGender = lastModel.sex
                val lastAge = lastModel.age

                currentHeight == lastHeight && currentGender == lastGender && currentAge == lastAge
            } ?: false


            Log.i("", "CalculateHelper8Smooth 用户信息的一致 isUserInfoConsistent: 走平滑计算")
            //第二次计算
            Log.i("", "CalculateHelper8Smooth 第二次计算 计算上一组数据")

            if (isUserInfoConsistent) {

                val lastBodyFatModel = CalculateHelper8.calculateTypeAlternate8(lastBaseModel!!, 6)

                Log.i("", "CalculateHelper8Smooth calculateTypeAlternate8Smooth lastBodyFatModel ppFat:${lastBodyFatModel?.ppFat} errorType :${lastBodyFatModel?.errorType} ")

                if (lastBodyFatModel?.errorType == BodyFatErrorType.PP_ERROR_TYPE_NONE.getType()) {
                    val timeDT = System.currentTimeMillis() - (HTCalculateManager.testTimeInterval ?: 0)
                    val fatDT = abs(lastBodyFatModel.ppFat - currentBodyFatModel.ppFat)
                    Log.i("", "CalculateHelper8Smooth fatDT:$fatDT lastModel.ppFat:${lastBodyFatModel.ppFat} bodyFatModel.ppFat:${currentBodyFatModel.ppFat} ")
                    Log.i("", "CalculateHelper8Smooth lastBaseModel:${lastBaseModel.toString()}")
                    var bhSmoothlyK = 1.0
                    if (timeDT < 30 * 60 * 1000) { // 小于30min
                        Log.i("", "CalculateHelper8Smooth timeDT:$timeDT 小于30min")
                        if (fatDT < 4) { // 使用上一次阻抗计算
                            bhSmoothlyK = 1.0
                            bodyBaseModel.z20KhzLeftArmEnCode = lastBaseModel?.z20KhzLeftArmEnCode ?: 0
                            bodyBaseModel.z20KhzRightArmEnCode = lastBaseModel?.z20KhzRightArmEnCode ?: 0
                            bodyBaseModel.z20KhzLeftLegEnCode = lastBaseModel?.z20KhzLeftLegEnCode ?: 0
                            bodyBaseModel.z20KhzRightLegEnCode = lastBaseModel?.z20KhzRightLegEnCode ?: 0
                            bodyBaseModel.z20KhzTrunkEnCode = lastBaseModel?.z20KhzTrunkEnCode ?: 0
                            bodyBaseModel.z100KhzLeftArmEnCode = lastBaseModel?.z100KhzLeftArmEnCode ?: 0
                            bodyBaseModel.z100KhzRightArmEnCode = lastBaseModel?.z100KhzRightArmEnCode ?: 0
                            bodyBaseModel.z100KhzLeftLegEnCode = lastBaseModel?.z100KhzLeftLegEnCode ?: 0
                            bodyBaseModel.z100KhzRightLegEnCode = lastBaseModel?.z100KhzRightLegEnCode ?: 0
                            bodyBaseModel.z100KhzTrunkEnCode = lastBaseModel?.z100KhzTrunkEnCode ?: 0
                        } else if (fatDT < 6) {
                            bhSmoothlyK = 0.1
                        } else if (fatDT < 15) {
                            bhSmoothlyK = 0.2
                        } else {

                        }
                    } else if (timeDT < 60 * 60 * 24 * 3 * 1000) { // 小于3天
                        Log.i("", "CalculateHelper8Smooth timeDT:$timeDT 小于3天")
                        if (fatDT < 4) {
                            bhSmoothlyK = 0.1
                        } else if (fatDT < 6) {
                            bhSmoothlyK = 0.2
                        } else if (fatDT < 15) {
                            bhSmoothlyK = 0.3
                        } else {

                        }
                    } else {
                        if (fatDT < 3.5) {
                            bhSmoothlyK = 0.2
                        } else if (fatDT < 6) {
                            bhSmoothlyK = 0.5
                        } else {

                        }
                    }
                    Log.i("", "CalculateHelper8Smooth 第三次计算，平滑因子bhSmoothlyK:${bhSmoothlyK}")
                    bodyBaseModel.smoothlyK = bhSmoothlyK
                    val finalBodyFatModel = calculateTypeAlternate8(bodyBaseModel, 6)
                    if (finalBodyFatModel.errorType != BodyFatErrorType.PP_ERROR_TYPE_NONE.getType()) {
                        Log.i("", "CalculateHelper8Smooth 计算出错，第四次计算 errorType:${finalBodyFatModel.errorType} 重新计算")
                        //重新计算
                        return currentBodyFatModel
                    } else {
                        return finalBodyFatModel
                    }
                }
            } else {
                Log.i("", "CalculateHelper8Smooth 用户信息的不一致 isUserInfoConsistent: $isUserInfoConsistent 不走平滑计算，直接使用计算结果")
            }
        }
        return currentBodyFatModel
    }


    fun calculateTypeAlternate8(bodyBaseModel: HTBodyBaseModel, product: Int): HTBodyFatModel {
        val bodyFatModel = HTBodyFatModel()
        assignHTBodyBaseModelToBodyFatModel(bodyBaseModel, bodyFatModel)

        bodyBaseModel?.let {
            val body = BhBody270()
            body.secret = bodyBaseModel.secret
            bodyFatModel.ppSDKVersion = body.getSDKVersion()
            body.bhAge = bodyBaseModel.age
            body.bhHeightCm = bodyBaseModel.height * 1.0f
            body.bhWeightKg = bodyFatModel.ppWeightKg
            body.bhSex = if (bodyBaseModel.sex == 1) com.besthealth.bhBodyComposition.BhSex.MALE.ordinal else com.besthealth.bhBodyComposition.BhSex.FEMALE.ordinal

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

            body.bhZ20KhzRightArmEnCodeLast = bodyBaseModel.z20KhzRightArmEnCode
            body.bhZ20KhzLeftArmEnCodeLast = bodyBaseModel.z20KhzLeftArmEnCode
            body.bhZ20KhzTrunkEnCodeLast = bodyBaseModel.z20KhzTrunkEnCode
            body.bhZ20KhzRightLegEnCodeLast = bodyBaseModel.z20KhzRightLegEnCode
            body.bhZ20KhzLeftLegEnCodeLast = bodyBaseModel.z20KhzLeftLegEnCode
            body.bhZ100KhzRightArmEnCodeLast = bodyBaseModel.z100KhzRightArmEnCode
            body.bhZ100KhzLeftArmEnCodeLast = bodyBaseModel.z100KhzLeftArmEnCode
            body.bhZ100KhzTrunkEnCodeLast = bodyBaseModel.z100KhzTrunkEnCode
            body.bhZ100KhzRightLegEnCodeLast = bodyBaseModel.z100KhzRightLegEnCode
            body.bhZ100KhzLeftLegEnCodeLast = bodyBaseModel.z100KhzLeftLegEnCode

            body.bhProduct = product
            body.bhTrimming = 1.0f
            body.bhIsHome = false
            body.bhIsEnhancedRepeat = false
            body.bhSmoothlyK = bodyBaseModel.smoothlyK

            bodyFatModel.bhProduct = product

            val bhErrorType: BhErrorType = BhErrorType.values().get(body.getBodyComposition())
            println("错误信息：$bhErrorType")
            bodyFatModel.ppSDKVersion = body.getSDKVersion()
            System.out.println("SDKVersion=" + bodyFatModel.ppSDKVersion)
            bodyFatModel.errorType = BodyFatCalculateHelper.calculateHTErrorType(bhErrorType).getType()
            System.out.println("體重(Kg)=" + body.bhWeightKg)
            System.out.println("身高(cm)=" + body.bhHeightCm)
            System.out.println("年齡(歲)=" + body.bhAge)
            System.out.println("性別=" + BhSex.values().get(body.bhSex))
            System.out.println("bhProduct=" + body.bhProduct)
            System.out.println("bhSmoothlyK=" + body.bhSmoothlyK)
            System.out.println("加密阻抗-100Khz右手=" + body.bhZ100KhzRightArmEnCodeNew)
            System.out.println("加密阻抗-100Khz左手=" + body.bhZ100KhzLeftArmEnCodeNew)
            System.out.println("加密阻抗-100Khz躯干=" + body.bhZ100KhzTrunkEnCodeNew)
            System.out.println("加密阻抗-100Khz右脚=" + body.bhZ100KhzRightLegEnCodeNew)
            System.out.println("加密阻抗-100Khz左脚=" + body.bhZ100KhzLeftLegEnCodeNew)
            System.out.println("加密阻抗-20Khz右手=" + body.bhZ20KhzRightArmEnCodeNew)
            System.out.println("加密阻抗-20Khz左手=" + body.bhZ20KhzLeftArmEnCodeNew)
            System.out.println("加密阻抗-20Khz躯干=" + body.bhZ20KhzTrunkEnCodeNew)
            System.out.println("加密阻抗-20Khz右脚=" + body.bhZ20KhzRightLegEnCodeNew)
            System.out.println("加密阻抗-20Khz左脚=" + body.bhZ20KhzLeftLegEnCodeNew)
            System.out.println("解密阻抗-100Khz右手=" + body.bhZ100KhzRightArmDeCodeNew)
            System.out.println("解密阻抗-100Khz左手=" + body.bhZ100KhzLeftArmDeCodeNew)
            System.out.println("解密阻抗-100Khz躯干=" + body.bhZ100KhzTrunkDeCodeNew)
            System.out.println("解密阻抗-100Khz右脚=" + body.bhZ100KhzRightLegDeCodeNew)
            System.out.println("解密阻抗-100Khz左脚=" + body.bhZ100KhzLeftLegDeCodeNew)
            System.out.println("解密阻抗-20Khz右手=" + body.bhZ20KhzRightArmDeCodeNew)
            System.out.println("解密阻抗-20Khz左手=" + body.bhZ20KhzLeftArmDeCodeNew)
            System.out.println("解密阻抗-20Khz躯干=" + body.bhZ20KhzTrunkDeCodeNew)
            System.out.println("解密阻抗-20Khz右脚=" + body.bhZ20KhzRightLegDeCodeNew)
            System.out.println("解密阻抗-20Khz左手=" + body.bhZ20KhzLeftLegDeCodeNew)

            if (bodyFatModel.errorType == BodyFatErrorType.PP_ERROR_TYPE_NONE.getType()) {
                bodyFatModel.z20KhzLeftArmEnCode = body?.bhZ20KhzLeftArmEnCodeNew ?: 0
                bodyFatModel.z20KhzRightArmEnCode = body?.bhZ20KhzRightArmEnCodeNew ?: 0
                bodyFatModel.z20KhzLeftLegEnCode = body?.bhZ20KhzLeftLegEnCodeNew ?: 0
                bodyFatModel.z20KhzRightLegEnCode = body?.bhZ20KhzRightLegEnCodeNew ?: 0
                bodyFatModel.z20KhzTrunkEnCode = body?.bhZ20KhzTrunkEnCodeNew ?: 0
                bodyFatModel.z100KhzLeftArmEnCode = body?.bhZ100KhzLeftArmEnCodeNew ?: 0
                bodyFatModel.z100KhzRightArmEnCode = body?.bhZ100KhzRightArmEnCodeNew ?: 0
                bodyFatModel.z100KhzLeftLegEnCode = body?.bhZ100KhzLeftLegEnCodeNew ?: 0
                bodyFatModel.z100KhzRightLegEnCode = body?.bhZ100KhzRightLegEnCodeNew ?: 0
                bodyFatModel.z100KhzTrunkEnCode = body?.bhZ100KhzTrunkEnCodeNew ?: 0

                bodyFatModel.z100KhzLeftArmDeCode = body.bhZ100KhzLeftArmDeCodeNew
                bodyFatModel.z100KhzLeftLegDeCode = body.bhZ100KhzLeftLegDeCodeNew
                bodyFatModel.z100KhzRightArmDeCode = body.bhZ100KhzRightArmDeCodeNew
                bodyFatModel.z100KhzRightLegDeCode = body.bhZ100KhzRightLegDeCodeNew
                bodyFatModel.z100KhzTrunkDeCode = body.bhZ100KhzTrunkDeCodeNew
                bodyFatModel.z20KhzLeftArmDeCode = body.bhZ20KhzLeftArmDeCodeNew
                bodyFatModel.z20KhzLeftLegDeCode = body.bhZ20KhzLeftLegDeCodeNew
                bodyFatModel.z20KhzRightArmDeCode = body.bhZ20KhzRightArmDeCodeNew
                bodyFatModel.z20KhzRightLegDeCode = body.bhZ20KhzRightLegDeCodeNew
                bodyFatModel.z20KhzTrunkDeCode = body.bhZ20KhzTrunkDeCodeNew
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
