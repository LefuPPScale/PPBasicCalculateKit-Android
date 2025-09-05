package com.lefu.ppbasecalculatekit

import java.io.Serializable


open class HTBodyBaseModel : Serializable {

    //体重 重量放大了100倍
    var weight = 0
    //AppKey
    var secret =""

    //4电极算法阻抗
    var impedance: Long = 0
    var zTwoLegsDeCode: Float = 0.0f
    var ppImpedance100DeCode: Float = 0.0f
    var ppImpedance100EnCode: Long = 0 // 身体数据新增4电极双频加密阻抗-100频率字段

    var height: Int = 0
    var age: Int = 0
    var sex: Int = 0
    var isAthleteMode: Boolean = false //运动员模式

    var calculateType: Int = 0

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


}