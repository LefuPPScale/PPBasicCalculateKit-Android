package com.lefu.htcalculatekit

import java.io.Serializable

open class HTBodyFatModel : Serializable {

    /**************** 基础公共参数 ****************************/

    var ppSDKVersion: String? = null//计算库版本号

    // 体脂错误类型
    var errorType: Int = BodyFatErrorType.PP_ERROR_TYPE_NONE.getType()


    var height: Int = 0
    var age: Int = 0
    var sex: Int = 0
    var isAthleteMode: Boolean = false //运动员模式
    var calculateType: Int = 0

    /*********************** 基础4电极参数 ****************************/
    //4电极算法阻抗
    var impedance: Long = 0

    var zTwoLegsDeCode: Float = 0.0f

    var ppImpedance100DeCode: Float = 0.0f

    var ppImpedance100EnCode: Long = 0 // 身体数据新增4电极双频加密阻抗-100频率字段

    /****************************8电极阻抗*****************************************/

    //100KHz左手阻抗加密值(下位机上传值)
    var z100KhzLeftArmEnCode: Long = 0

    //100KHz左腳阻抗加密值(下位机上传值)
    var z100KhzLeftLegEnCode: Long = 0

    //100KHz右手阻抗加密值(下位机上传值)
    var z100KhzRightArmEnCode: Long = 0

    //100KHz右腳阻抗加密值(下位机上传值)
    var z100KhzRightLegEnCode: Long = 0

    //100KHz軀幹阻抗加密值(下位机上传值)
    var z100KhzTrunkEnCode: Long = 0

    //20KHz左手阻抗加密值(下位机上传值)
    var z20KhzLeftArmEnCode: Long = 0

    //20KHz左腳阻抗加密值(下位机上传值)
    var z20KhzLeftLegEnCode: Long = 0

    //20KHz右手阻抗加密值(下位机上传值)
    var z20KhzRightArmEnCode: Long = 0

    //20KHz右腳阻抗加密值(下位机上传值)
    var z20KhzRightLegEnCode: Long = 0

    //20KHz軀幹阻抗加密值(下位机上传值)
    var z20KhzTrunkEnCode: Long = 0

    /****************************8电极阻抗Last版本(上一次的值)*****************************************/

    //平滑值
    var smoothlyK: Double = 1.0

    //20KHz右手阻抗加密值Last(上一次的值)
    var z20KhzRightArmEnCodeLast: Long = 0

    //20KHz左手阻抗加密值Last(上一次的值)
    var z20KhzLeftArmEnCodeLast: Long = 0

    //20KHz軀幹阻抗加密值Last(上一次的值)
    var z20KhzTrunkEnCodeLast: Long = 0

    //20KHz右腳阻抗加密值Last(上一次的值)
    var z20KhzRightLegEnCodeLast: Long = 0

    //20KHz左腳阻抗加密值Last(上一次的值)
    var z20KhzLeftLegEnCodeLast: Long = 0

    //100KHz右手阻抗加密值Last(上一次的值)
    var z100KhzRightArmEnCodeLast: Long = 0

    //100KHz左手阻抗加密值Last(上一次的值)
    var z100KhzLeftArmEnCodeLast: Long = 0

    //100KHz軀幹阻抗加密值Last(上一次的值)
    var z100KhzTrunkEnCodeLast: Long = 0

    //100KHz右腳阻抗加密值Last(上一次的值)
    var z100KhzRightLegEnCodeLast: Long = 0

    //100KHz左腳阻抗加密值Last(上一次的值)
    var z100KhzLeftLegEnCodeLast: Long = 0

    /**************** 基础8电极参数 ****************************/

    var z100KhzLeftArmDeCode: Float = 0f // 100KHz左手阻抗解密值(下位机上传值)
    var z100KhzLeftLegDeCode: Float = 0f // 100KHz左腳阻抗解密值(下位机上传值)
    var z100KhzRightArmDeCode: Float = 0f // 100KHz右手阻抗解密值(下位机上传值)
    var z100KhzRightLegDeCode: Float = 0f // 100KHz右腳阻抗解密值(下位机上传值)
    var z100KhzTrunkDeCode: Float = 0f // 100KHz軀幹阻抗解密值(下位机上传值)
    var z20KhzLeftArmDeCode: Float = 0f // 20KHz左手阻抗解密值(下位机上传值)
    var z20KhzLeftLegDeCode: Float = 0f // 20KHz左腳阻抗解密值(下位机上传值)
    var z20KhzRightArmDeCode: Float = 0f // 20KHz右手阻抗解密值(下位机上传值)
    var z20KhzRightLegDeCode: Float = 0f // 20KHz右腳阻抗解密值(下位机上传值)
    var z20KhzTrunkDeCode: Float = 0f // 20KHz軀幹阻抗解密值(下位机上传值)

    /**************** 四电极算法 ****************************/

    // 体重(kg)
    var ppWeightKg: Float = 0.0f

    var ppWeightKgList: List<Float>? = null

    // Body Mass Index
    var ppBMI: Float = 0f

    // 脂肪率(%)
    var ppFat: Float = 0f
    var ppFatList: List<Float>? = null

    // 脂肪量(kg)
    var ppBodyfatKg: Float = 0f
    var ppBodyfatKgList: List<Float>? = null

    // 肌肉率(%)
    var ppMusclePercentage: Float = 0f
    var ppMusclePercentageList: List<Float>? = null

    // 肌肉量(kg)
    var ppMuscleKg: Float = 0f
    var ppMuscleKgList: List<Float>? = null

    // 骨骼肌率(%)
    var ppBodySkeletal: Float = 0f
    var ppBodySkeletalList: List<Float>? = null

    // 骨骼肌量(kg)
    var ppBodySkeletalKg: Float = 0f
    var ppBodySkeletalKgList: List<Float>? = null

    // 水分率(%), 分辨率0.1,
    var ppWaterPercentage: Float = 0f
    var ppWaterPercentageList: List<Float>? = null

    //水分量(Kg)
    var ppWaterKg: Float = 0f
    var ppWaterKgList: List<Float>? = null

    // 蛋白质率(%)
    var ppProteinPercentage: Float = 0f
    var ppProteinPercentageList: List<Float>? = null

    //蛋白质量(Kg)
    var ppProteinKg: Float = 0f
    var ppProteinKgList: List<Float>? = null

    // 去脂体重(kg)
    var ppLoseFatWeightKg: Float = 0f
    var ppLoseFatWeightKgList: List<Float>? = null

    // 皮下脂肪率(%)
    var ppBodyFatSubCutPercentage: Float = 0f
    var ppBodyFatSubCutPercentageList: List<Float>? = null

    // 皮下脂肪量
    var ppBodyFatSubCutKg: Float = 0f
    var ppBodyFatSubCutKgList: List<Float>? = null

    // 基础代谢
    var ppBMR: Int = 0
    var ppBMRList: List<Float>? = null

    // 内脏脂肪等级
    var ppVisceralFat: Int = 0
    var ppVisceralFatList: List<Float>? = null

    // 骨量(kg)
    var ppBoneKg: Float = 0f
    var ppBoneKgList: List<Float>? = null

    // 肌肉控制量(kg)
    var ppBodyMuscleControl: Float = 0f

    // 脂肪控制量(kg)
    var ppFatControlKg: Float = 0f

    // 标准体重
    var ppBodyStandardWeightKg: Float = 0f

    // 理想体重(kg)
    var ppIdealWeightKg: Float = 0f

    // 控制体重(kg)
    var ppControlWeightKg: Float = 0f

    // 身体类型
    var ppBodyType: Int? = 0

    // 身体年龄
    var ppBodyAge: Int = 0

    // 身体得分
    var ppBodyScore: Int = 0

    /**************** 八电极算法独有 ****************************/

    //8电极算法-计算类型
    var bhProduct = 1

    // 輸出參數-全身体组成:身体细胞量(kg)
    var ppCellMassKg: Float = 0.0f
    var ppCellMassKgList: List<Float> = listOf()

    // 輸出參數-评价建议:建议卡路里摄入量 Kcal/day
    var ppDCI: Int = 0

    // 輸出參數-全身体组成:无机盐量(Kg)
    var ppMineralKg: Float = 0.0f
    var ppMineralKgList: List<Float> = listOf()

    // 輸出參數-评价建议: 肥胖度(%)
    var ppObesity: Float = 0.0f
    var ppObesityList: List<Float> = listOf()

    // 輸出參數-全身体组成:细胞外水量(kg)
    var ppWaterECWKg: Float = 0.0f
    var ppWaterECWKgList: List<Float> = listOf()

    // 輸出參數-全身体组成:细胞内水量(kg)
    var ppWaterICWKg: Float = 0.0f
    var ppWaterICWKgList: List<Float> = listOf()

    // 左手脂肪量(%), 分辨率0.1
    var ppBodyFatKgLeftArm: Float = 0.0f

    // 左脚脂肪量(%), 分辨率0.1
    var ppBodyFatKgLeftLeg: Float = 0.0f

    // 右手脂肪量(%), 分辨率0.1
    var ppBodyFatKgRightArm: Float = 0.0f

    // 右脚脂肪量(%), 分辨率0.1
    var ppBodyFatKgRightLeg: Float = 0.0f

    // 躯干脂肪量(%), 分辨率0.1
    var ppBodyFatKgTrunk: Float = 0.0f

    // 左手脂肪率(%), 分辨率0.1
    var ppBodyFatRateLeftArm: Float = 0.0f

    // 左脚脂肪率(%), 分辨率0.1
    var ppBodyFatRateLeftLeg: Float = 0.0f

    // 右手脂肪率(%), 分辨率0.1
    var ppBodyFatRateRightArm: Float = 0.0f

    // 右脚脂肪率(%), 分辨率0.1
    var ppBodyFatRateRightLeg: Float = 0.0f

    // 躯干脂肪率(%), 分辨率0.1
    var ppBodyFatRateTrunk: Float = 0.0f

    // 左手肌肉量(kg), 分辨率0.1shi
    var ppMuscleKgLeftArm: Float = 0.0f

    // 左脚肌肉量(kg), 分辨率0.1
    var ppMuscleKgLeftLeg: Float = 0.0f

    // 右手肌肉量(kg), 分辨率0.1
    var ppMuscleKgRightArm: Float = 0.0f

    // 右脚肌肉量(kg), 分辨率0.1
    var ppMuscleKgRightLeg: Float = 0.0f

    // 躯干肌肉量(kg), 分辨率0.1
    var ppMuscleKgTrunk: Float = 0.0f

    //左手肌肉率(%), 分辨率0.1
    var ppMuscleRateLeftArm: Float = 0.0f

    //左脚肌肉率(%), 分辨率0.1
    var ppMuscleRateLeftLeg: Float = 0.0f

    //右手肌肉率(%), 分辨率0.1
    var ppMuscleRateRightArm: Float = 0.0f

    //右脚肌肉率(%), 分辨率0.1
    var ppMuscleRateRightLeg: Float = 0.0f

    //躯干肌肉率(%), 分辨率0.1
    var ppMuscleRateTrunk: Float = 0.0f

    // 骨骼肌质量指数
    var ppSmi: Float = 0.0f
    var ppSmiList: List<Float> = listOf()

    // 腰臀比
    var ppWHR: Float = 0.0f

    // 腰臀比列表
    var ppWHRList: List<Float> = listOf()

    // 右手肌肉标准
    var ppRightArmMuscleLevel: Int = 0

    // 左手肌肉标准
    var ppLeftArmMuscleLevel: Int = 0

    //躯干肌肉标准
    var ppTrunkMuscleLevel: Int = 0

    //右脚肌肉标准
    var ppRightLegMuscleLevel: Int = 0

    //左脚肌肉标准
    var ppLeftLegMuscleLevel: Int = 0

    //右手脂肪标准
    var ppRightArmFatLevel: Int = 0

    //左手脂肪标准
    var ppLeftArmFatLevel: Int = 0

    //躯干脂肪标准
    var ppTrunkFatLevel: Int = 0

    //右脚脂肪标准
    var ppRightLegFatLevel: Int = 0

    //左脚脂肪标准
    var ppLeftLegFatLevel: Int = 0

    //上肢肌肉均衡
    var ppBalanceArmsLevel: Int = 0

    //下肢肌肉均衡
    var ppBalanceLegsLevel: Int = 0

    //肌肉-上下均衡度
    var ppBalanceArmLegLevel: Int = 0

    //上肢脂肪均衡
    var ppBalanceFatArmsLevel: Int = 0

    //下肢脂肪均衡
    var ppBalanceFatLegsLevel: Int = 0

    //脂肪-上下均衡度
    var ppBalanceFatArmLegLevel: Int = 0


    //4电极toJson
    // 辅助函数：将List转换为JSON数组字符串
    private fun listToJsonArray(list: List<Float>?): String {
        return if (list == null || list.isEmpty()) {
            "null"
        } else {
            "[" + list.joinToString(",") + "]"
        }
    }

    fun to4ElectrodeJson(): String {
        val json = StringBuilder()
        json.append("{")
        
        // 基础公共参数
        json.append("\"height\":$height,")
        json.append("\"age\":$age,")
        json.append("\"sex\":$sex,")
        json.append("\"isAthleteMode\":$isAthleteMode,")
        json.append("\"calculateType\":$calculateType,")
        json.append("\"ppSDKVersion\":\"$ppSDKVersion\",")
        json.append("\"errorType\":$errorType,")

        // 4电极特有参数
        json.append("\"impedance\":$impedance,")
        json.append("\"zTwoLegsDeCode\":$zTwoLegsDeCode,")
        json.append("\"ppImpedance100DeCode\":$ppImpedance100DeCode,")
        json.append("\"ppImpedance100EnCode\":$ppImpedance100EnCode,")
        
        // 通用计算结果参数（4电极和8电极共有的，在分界线之前的）
        json.append("\"ppWeightKg\":$ppWeightKg,")
        json.append("\"ppWeightKgList\":${listToJsonArray(ppWeightKgList)},")
        json.append("\"ppBMI\":$ppBMI,")
        json.append("\"ppFat\":$ppFat,")
        json.append("\"ppFatList\":${listToJsonArray(ppFatList)},")
        json.append("\"ppBodyfatKg\":$ppBodyfatKg,")
        json.append("\"ppBodyfatKgList\":${listToJsonArray(ppBodyfatKgList)},")
        json.append("\"ppMusclePercentage\":$ppMusclePercentage,")
        json.append("\"ppMusclePercentageList\":${listToJsonArray(ppMusclePercentageList)},")
        json.append("\"ppMuscleKg\":$ppMuscleKg,")
        json.append("\"ppMuscleKgList\":${listToJsonArray(ppMuscleKgList)},")
        json.append("\"ppBodySkeletal\":$ppBodySkeletal,")
        json.append("\"ppBodySkeletalList\":${listToJsonArray(ppBodySkeletalList)},")
        json.append("\"ppBodySkeletalKg\":$ppBodySkeletalKg,")
        json.append("\"ppBodySkeletalKgList\":${listToJsonArray(ppBodySkeletalKgList)},")
        json.append("\"ppWaterPercentage\":$ppWaterPercentage,")
        json.append("\"ppWaterPercentageList\":${listToJsonArray(ppWaterPercentageList)},")
        json.append("\"ppWaterKg\":$ppWaterKg,")
        json.append("\"ppWaterKgList\":${listToJsonArray(ppWaterKgList)},")
        json.append("\"ppProteinPercentage\":$ppProteinPercentage,")
        json.append("\"ppProteinPercentageList\":${listToJsonArray(ppProteinPercentageList)},")
        json.append("\"ppProteinKg\":$ppProteinKg,")
        json.append("\"ppProteinKgList\":${listToJsonArray(ppProteinKgList)},")
        json.append("\"ppLoseFatWeightKg\":$ppLoseFatWeightKg,")
        json.append("\"ppLoseFatWeightKgList\":${listToJsonArray(ppLoseFatWeightKgList)},")
        json.append("\"ppBodyFatSubCutPercentage\":$ppBodyFatSubCutPercentage,")
        json.append("\"ppBodyFatSubCutPercentageList\":${listToJsonArray(ppBodyFatSubCutPercentageList)},")
        json.append("\"ppBodyFatSubCutKg\":$ppBodyFatSubCutKg,")
        json.append("\"ppBodyFatSubCutKgList\":${listToJsonArray(ppBodyFatSubCutKgList)},")
        json.append("\"ppBMR\":$ppBMR,")
        json.append("\"ppBMRList\":${listToJsonArray(ppBMRList)},")
        json.append("\"ppVisceralFat\":$ppVisceralFat,")
        json.append("\"ppVisceralFatList\":${listToJsonArray(ppVisceralFatList)},")
        json.append("\"ppBoneKg\":$ppBoneKg,")
        json.append("\"ppBoneKgList\":${listToJsonArray(ppBoneKgList)},")
        json.append("\"ppBodyMuscleControl\":$ppBodyMuscleControl,")
        json.append("\"ppFatControlKg\":$ppFatControlKg,")
        json.append("\"ppBodyStandardWeightKg\":$ppBodyStandardWeightKg,")
        json.append("\"ppIdealWeightKg\":$ppIdealWeightKg,")
        json.append("\"ppControlWeightKg\":$ppControlWeightKg,")
        json.append("\"ppBodyType\":$ppBodyType,")
        json.append("\"ppBodyAge\":$ppBodyAge,")
        json.append("\"ppBodyScore\":$ppBodyScore")
        
        json.append("}")
        return json.toString()
    }

    //8电极toJson
    fun to8ElectrodeJson(): String {
        val json = StringBuilder()
        json.append("{")
        
        // 基础公共参数
        json.append("\"height\":$height,")
        json.append("\"age\":$age,")
        json.append("\"sex\":$sex,")
        json.append("\"isAthleteMode\":$isAthleteMode,")
        json.append("\"calculateType\":$calculateType,")
        json.append("\"ppSDKVersion\":\"$ppSDKVersion\",")
        json.append("\"errorType\":$errorType,")
        json.append("\"bhProduct\":$bhProduct,")

        // 8电极加密阻抗值
        json.append("\"z100KhzLeftArmEnCode\":$z100KhzLeftArmEnCode,")
        json.append("\"z100KhzLeftLegEnCode\":$z100KhzLeftLegEnCode,")
        json.append("\"z100KhzRightArmEnCode\":$z100KhzRightArmEnCode,")
        json.append("\"z100KhzRightLegEnCode\":$z100KhzRightLegEnCode,")
        json.append("\"z100KhzTrunkEnCode\":$z100KhzTrunkEnCode,")
        json.append("\"z20KhzLeftArmEnCode\":$z20KhzLeftArmEnCode,")
        json.append("\"z20KhzLeftLegEnCode\":$z20KhzLeftLegEnCode,")
        json.append("\"z20KhzRightArmEnCode\":$z20KhzRightArmEnCode,")
        json.append("\"z20KhzRightLegEnCode\":$z20KhzRightLegEnCode,")
        json.append("\"z20KhzTrunkEnCode\":$z20KhzTrunkEnCode,")
        
        // 8电极Last版本阻抗值
        json.append("\"z100KhzLeftArmEnCodeLast\":$z100KhzLeftArmEnCodeLast,")
        json.append("\"z100KhzLeftLegEnCodeLast\":$z100KhzLeftLegEnCodeLast,")
        json.append("\"z100KhzRightArmEnCodeLast\":$z100KhzRightArmEnCodeLast,")
        json.append("\"z100KhzRightLegEnCodeLast\":$z100KhzRightLegEnCodeLast,")
        json.append("\"z100KhzTrunkEnCodeLast\":$z100KhzTrunkEnCodeLast,")
        json.append("\"z20KhzLeftArmEnCodeLast\":$z20KhzLeftArmEnCodeLast,")
        json.append("\"z20KhzLeftLegEnCodeLast\":$z20KhzLeftLegEnCodeLast,")
        json.append("\"z20KhzRightArmEnCodeLast\":$z20KhzRightArmEnCodeLast,")
        json.append("\"z20KhzRightLegEnCodeLast\":$z20KhzRightLegEnCodeLast,")
        json.append("\"z20KhzTrunkEnCodeLast\":$z20KhzTrunkEnCodeLast,")
        
        // 8电极解密阻抗值
        json.append("\"z100KhzLeftArmDeCode\":$z100KhzLeftArmDeCode,")
        json.append("\"z100KhzLeftLegDeCode\":$z100KhzLeftLegDeCode,")
        json.append("\"z100KhzRightArmDeCode\":$z100KhzRightArmDeCode,")
        json.append("\"z100KhzRightLegDeCode\":$z100KhzRightLegDeCode,")
        json.append("\"z100KhzTrunkDeCode\":$z100KhzTrunkDeCode,")
        json.append("\"z20KhzLeftArmDeCode\":$z20KhzLeftArmDeCode,")
        json.append("\"z20KhzLeftLegDeCode\":$z20KhzLeftLegDeCode,")
        json.append("\"z20KhzRightArmDeCode\":$z20KhzRightArmDeCode,")
        json.append("\"z20KhzRightLegDeCode\":$z20KhzRightLegDeCode,")
        json.append("\"z20KhzTrunkDeCode\":$z20KhzTrunkDeCode,")
        
        // 8电极特有的分部位计算结果
        json.append("\"ppBodyFatKgLeftArm\":$ppBodyFatKgLeftArm,")
        json.append("\"ppBodyFatKgLeftLeg\":$ppBodyFatKgLeftLeg,")
        json.append("\"ppBodyFatKgRightArm\":$ppBodyFatKgRightArm,")
        json.append("\"ppBodyFatKgRightLeg\":$ppBodyFatKgRightLeg,")
        json.append("\"ppBodyFatKgTrunk\":$ppBodyFatKgTrunk,")
        json.append("\"ppBodyFatRateLeftArm\":$ppBodyFatRateLeftArm,")
        json.append("\"ppBodyFatRateLeftLeg\":$ppBodyFatRateLeftLeg,")
        json.append("\"ppBodyFatRateRightArm\":$ppBodyFatRateRightArm,")
        json.append("\"ppBodyFatRateRightLeg\":$ppBodyFatRateRightLeg,")
        json.append("\"ppBodyFatRateTrunk\":$ppBodyFatRateTrunk,")
        json.append("\"ppMuscleKgLeftArm\":$ppMuscleKgLeftArm,")
        json.append("\"ppMuscleKgLeftLeg\":$ppMuscleKgLeftLeg,")
        json.append("\"ppMuscleKgRightArm\":$ppMuscleKgRightArm,")
        json.append("\"ppMuscleKgRightLeg\":$ppMuscleKgRightLeg,")
        json.append("\"ppMuscleKgTrunk\":$ppMuscleKgTrunk,")
        json.append("\"ppMuscleRateLeftArm\":$ppMuscleRateLeftArm,")
        json.append("\"ppMuscleRateLeftLeg\":$ppMuscleRateLeftLeg,")
        json.append("\"ppMuscleRateRightArm\":$ppMuscleRateRightArm,")
        json.append("\"ppMuscleRateRightLeg\":$ppMuscleRateRightLeg,")
        json.append("\"ppMuscleRateTrunk\":$ppMuscleRateTrunk,")
        
        // 通用计算结果（包含单值和List）
        json.append("\"ppWeightKg\":$ppWeightKg,")
        json.append("\"ppWeightKgList\":${listToJsonArray(ppWeightKgList)},")
        json.append("\"ppBMI\":$ppBMI,")
        json.append("\"ppFat\":$ppFat,")
        json.append("\"ppFatList\":${listToJsonArray(ppFatList)},")
        json.append("\"ppBodyfatKg\":$ppBodyfatKg,")
        json.append("\"ppBodyfatKgList\":${listToJsonArray(ppBodyfatKgList)},")
        json.append("\"ppMusclePercentage\":$ppMusclePercentage,")
        json.append("\"ppMusclePercentageList\":${listToJsonArray(ppMusclePercentageList)},")
        json.append("\"ppMuscleKg\":$ppMuscleKg,")
        json.append("\"ppMuscleKgList\":${listToJsonArray(ppMuscleKgList)},")
        json.append("\"ppBodySkeletal\":$ppBodySkeletal,")
        json.append("\"ppBodySkeletalList\":${listToJsonArray(ppBodySkeletalList)},")
        json.append("\"ppBodySkeletalKg\":$ppBodySkeletalKg,")
        json.append("\"ppBodySkeletalKgList\":${listToJsonArray(ppBodySkeletalKgList)},")
        json.append("\"ppWaterPercentage\":$ppWaterPercentage,")
        json.append("\"ppWaterPercentageList\":${listToJsonArray(ppWaterPercentageList)},")
        json.append("\"ppWaterKg\":$ppWaterKg,")
        json.append("\"ppWaterKgList\":${listToJsonArray(ppWaterKgList)},")
        json.append("\"ppProteinPercentage\":$ppProteinPercentage,")
        json.append("\"ppProteinPercentageList\":${listToJsonArray(ppProteinPercentageList)},")
        json.append("\"ppProteinKg\":$ppProteinKg,")
        json.append("\"ppProteinKgList\":${listToJsonArray(ppProteinKgList)},")
        json.append("\"ppLoseFatWeightKg\":$ppLoseFatWeightKg,")
        json.append("\"ppLoseFatWeightKgList\":${listToJsonArray(ppLoseFatWeightKgList)},")
        json.append("\"ppBodyFatSubCutPercentage\":$ppBodyFatSubCutPercentage,")
        json.append("\"ppBodyFatSubCutPercentageList\":${listToJsonArray(ppBodyFatSubCutPercentageList)},")
        json.append("\"ppBodyFatSubCutKg\":$ppBodyFatSubCutKg,")
        json.append("\"ppBodyFatSubCutKgList\":${listToJsonArray(ppBodyFatSubCutKgList)},")
        json.append("\"ppBMR\":$ppBMR,")
        json.append("\"ppBMRList\":${listToJsonArray(ppBMRList)},")
        json.append("\"ppVisceralFat\":$ppVisceralFat,")
        json.append("\"ppVisceralFatList\":${listToJsonArray(ppVisceralFatList)},")
        json.append("\"ppBoneKg\":$ppBoneKg,")
        json.append("\"ppBoneKgList\":${listToJsonArray(ppBoneKgList)},")
        json.append("\"ppCellMassKg\":$ppCellMassKg,")
        json.append("\"ppCellMassKgList\":${listToJsonArray(ppCellMassKgList)},")
        json.append("\"ppMineralKg\":$ppMineralKg,")
        json.append("\"ppMineralKgList\":${listToJsonArray(ppMineralKgList)},")
        json.append("\"ppObesity\":$ppObesity,")
        json.append("\"ppObesityList\":${listToJsonArray(ppObesityList)},")
        json.append("\"ppWaterECWKg\":$ppWaterECWKg,")
        json.append("\"ppWaterECWKgList\":${listToJsonArray(ppWaterECWKgList)},")
        json.append("\"ppWaterICWKg\":$ppWaterICWKg,")
        json.append("\"ppWaterICWKgList\":${listToJsonArray(ppWaterICWKgList)},")
        json.append("\"ppSmi\":$ppSmi,")
        json.append("\"ppSmiList\":${listToJsonArray(ppSmiList)},")
        json.append("\"ppWHR\":$ppWHR,")
        json.append("\"ppWHRList\":${listToJsonArray(ppWHRList)},")
        json.append("\"ppBodyMuscleControl\":$ppBodyMuscleControl,")
        json.append("\"ppFatControlKg\":$ppFatControlKg,")
        json.append("\"ppBodyStandardWeightKg\":$ppBodyStandardWeightKg,")
        json.append("\"ppIdealWeightKg\":$ppIdealWeightKg,")
        json.append("\"ppControlWeightKg\":$ppControlWeightKg,")
        json.append("\"ppBodyType\":$ppBodyType,")
        json.append("\"ppBodyAge\":$ppBodyAge,")
        json.append("\"ppBodyScore\":$ppBodyScore,")
        
        // 8电极独有参数（第206行分界线之后的参数）
        json.append("\"ppCellMassKg\":$ppCellMassKg,")
        json.append("\"ppCellMassKgList\":${listToJsonArray(ppCellMassKgList)},")
        json.append("\"ppDCI\":$ppDCI,")
        json.append("\"ppMineralKg\":$ppMineralKg,")
        json.append("\"ppMineralKgList\":${listToJsonArray(ppMineralKgList)},")
        json.append("\"ppObesity\":$ppObesity,")
        json.append("\"ppObesityList\":${listToJsonArray(ppObesityList)},")
        json.append("\"ppWaterECWKg\":$ppWaterECWKg,")
        json.append("\"ppWaterECWKgList\":${listToJsonArray(ppWaterECWKgList)},")
        json.append("\"ppWaterICWKg\":$ppWaterICWKg,")
        json.append("\"ppWaterICWKgList\":${listToJsonArray(ppWaterICWKgList)},")
        json.append("\"ppBodyFatKgLeftArm\":$ppBodyFatKgLeftArm,")
        json.append("\"ppBodyFatKgLeftLeg\":$ppBodyFatKgLeftLeg,")
        json.append("\"ppBodyFatKgRightArm\":$ppBodyFatKgRightArm,")
        json.append("\"ppBodyFatKgRightLeg\":$ppBodyFatKgRightLeg,")
        json.append("\"ppBodyFatKgTrunk\":$ppBodyFatKgTrunk,")
        json.append("\"ppBodyFatRateLeftArm\":$ppBodyFatRateLeftArm,")
        json.append("\"ppBodyFatRateLeftLeg\":$ppBodyFatRateLeftLeg,")
        json.append("\"ppBodyFatRateRightArm\":$ppBodyFatRateRightArm,")
        json.append("\"ppBodyFatRateRightLeg\":$ppBodyFatRateRightLeg,")
        json.append("\"ppBodyFatRateTrunk\":$ppBodyFatRateTrunk,")
        json.append("\"ppMuscleKgLeftArm\":$ppMuscleKgLeftArm,")
        json.append("\"ppMuscleKgLeftLeg\":$ppMuscleKgLeftLeg,")
        json.append("\"ppMuscleKgRightArm\":$ppMuscleKgRightArm,")
        json.append("\"ppMuscleKgRightLeg\":$ppMuscleKgRightLeg,")
        json.append("\"ppMuscleKgTrunk\":$ppMuscleKgTrunk,")
        json.append("\"ppMuscleRateLeftArm\":$ppMuscleRateLeftArm,")
        json.append("\"ppMuscleRateLeftLeg\":$ppMuscleRateLeftLeg,")
        json.append("\"ppMuscleRateRightArm\":$ppMuscleRateRightArm,")
        json.append("\"ppMuscleRateRightLeg\":$ppMuscleRateRightLeg,")
        json.append("\"ppMuscleRateTrunk\":$ppMuscleRateTrunk,")
        json.append("\"ppSmi\":$ppSmi,")
        json.append("\"ppSmiList\":${listToJsonArray(ppSmiList)},")
        json.append("\"ppWHR\":$ppWHR,")
        json.append("\"ppWHRList\":${listToJsonArray(ppWHRList)},")
        json.append("\"ppRightArmMuscleLevel\":$ppRightArmMuscleLevel,")
        json.append("\"ppLeftArmMuscleLevel\":$ppLeftArmMuscleLevel,")
        json.append("\"ppTrunkMuscleLevel\":$ppTrunkMuscleLevel,")
        json.append("\"ppRightLegMuscleLevel\":$ppRightLegMuscleLevel,")
        json.append("\"ppLeftLegMuscleLevel\":$ppLeftLegMuscleLevel,")
        json.append("\"ppRightArmFatLevel\":$ppRightArmFatLevel,")
        json.append("\"ppLeftArmFatLevel\":$ppLeftArmFatLevel,")
        json.append("\"ppTrunkFatLevel\":$ppTrunkFatLevel,")
        json.append("\"ppRightLegFatLevel\":$ppRightLegFatLevel,")
        json.append("\"ppLeftLegFatLevel\":$ppLeftLegFatLevel,")
        json.append("\"ppBalanceArmsLevel\":$ppBalanceArmsLevel,")
        json.append("\"ppBalanceLegsLevel\":$ppBalanceLegsLevel,")
        json.append("\"ppBalanceArmLegLevel\":$ppBalanceArmLegLevel,")
        json.append("\"ppBalanceFatArmsLevel\":$ppBalanceFatArmsLevel,")
        json.append("\"ppBalanceFatLegsLevel\":$ppBalanceFatLegsLevel,")
        json.append("\"ppBalanceFatArmLegLevel\":$ppBalanceFatArmLegLevel")
        
        json.append("}")
        return json.toString()
    }

    // 动态根据calculateType选择toJson方法
    fun toJson(): String {
        return when (calculateType) {
            4 -> to4ElectrodeJson()
            8 -> to8ElectrodeJson()
            else -> to4ElectrodeJson() // 默认使用4电极
        }
    }

}