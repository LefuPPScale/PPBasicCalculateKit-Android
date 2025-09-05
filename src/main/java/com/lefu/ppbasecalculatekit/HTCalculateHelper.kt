package com.lefu.ppbasecalculatekit

fun createList(vararg args: Float?): List<Float> {
    val list = mutableListOf<Float>()
    for (i in args.indices) {
        args[i]?.let { list.add(it) }
    }
    list.sorted()
    return list
}

/**
 * 将HTBodyBaseModel对象的所有字段赋值给HTBodyFatModel
 * @param bodyBaseModel HTBodyBaseModel对象
 * @param bodyFatModel HTBodyFatModel对象
 */
fun assignHTBodyBaseModelToBodyFatModel(bodyBaseModel: HTBodyBaseModel, bodyFatModel: HTBodyFatModel) {
    // 基础公共参数
    bodyFatModel.ppWeightKg = (bodyBaseModel?.weight?.toFloat() ?: 0.0f).div(100.0f)
    bodyFatModel.height = bodyBaseModel.height
    bodyFatModel.age = bodyBaseModel.age
    bodyFatModel.sex = bodyBaseModel.sex
    bodyFatModel.isAthleteMode = bodyBaseModel.isAthleteMode
    bodyFatModel.calculateType = bodyBaseModel.calculateType

    // 4电极算法阻抗
    bodyFatModel.impedance = bodyBaseModel.impedance
    bodyFatModel.zTwoLegsDeCode = bodyBaseModel.zTwoLegsDeCode
    bodyFatModel.ppImpedance100DeCode = bodyBaseModel.ppImpedance100DeCode
    bodyFatModel.ppImpedance100EnCode = bodyBaseModel.ppImpedance100EnCode

    // 8电极阻抗加密值
    bodyFatModel.z100KhzLeftArmEnCode = bodyBaseModel.z100KhzLeftArmEnCode
    bodyFatModel.z100KhzLeftLegEnCode = bodyBaseModel.z100KhzLeftLegEnCode
    bodyFatModel.z100KhzRightArmEnCode = bodyBaseModel.z100KhzRightArmEnCode
    bodyFatModel.z100KhzRightLegEnCode = bodyBaseModel.z100KhzRightLegEnCode
    bodyFatModel.z100KhzTrunkEnCode = bodyBaseModel.z100KhzTrunkEnCode
    bodyFatModel.z20KhzLeftArmEnCode = bodyBaseModel.z20KhzLeftArmEnCode
    bodyFatModel.z20KhzLeftLegEnCode = bodyBaseModel.z20KhzLeftLegEnCode
    bodyFatModel.z20KhzRightArmEnCode = bodyBaseModel.z20KhzRightArmEnCode
    bodyFatModel.z20KhzRightLegEnCode = bodyBaseModel.z20KhzRightLegEnCode
    bodyFatModel.z20KhzTrunkEnCode = bodyBaseModel.z20KhzTrunkEnCode

    // 8电极阻抗加密值Last版本
    bodyFatModel.smoothlyK = bodyBaseModel.smoothlyK
    bodyFatModel.z100KhzLeftArmEnCodeLast = bodyBaseModel.z100KhzLeftArmEnCodeLast
    bodyFatModel.z100KhzLeftLegEnCodeLast = bodyBaseModel.z100KhzLeftLegEnCodeLast
    bodyFatModel.z100KhzRightArmEnCodeLast = bodyBaseModel.z100KhzRightArmEnCodeLast
    bodyFatModel.z100KhzRightLegEnCodeLast = bodyBaseModel.z100KhzRightLegEnCodeLast
    bodyFatModel.z100KhzTrunkEnCodeLast = bodyBaseModel.z100KhzTrunkEnCodeLast
    bodyFatModel.z20KhzLeftArmEnCodeLast = bodyBaseModel.z20KhzLeftArmEnCodeLast
    bodyFatModel.z20KhzLeftLegEnCodeLast = bodyBaseModel.z20KhzLeftLegEnCodeLast
    bodyFatModel.z20KhzRightArmEnCodeLast = bodyBaseModel.z20KhzRightArmEnCodeLast
    bodyFatModel.z20KhzRightLegEnCodeLast = bodyBaseModel.z20KhzRightLegEnCodeLast
    bodyFatModel.z20KhzTrunkEnCodeLast = bodyBaseModel.z20KhzTrunkEnCodeLast
}