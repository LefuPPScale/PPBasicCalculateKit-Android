package com.lefu.ppbasecalculatekit

/**
 * 错误类型(针对输入的参数)
 */
enum class BodyFatErrorType {

    PP_ERROR_TYPE_NONE(0),                  //无错误
    PP_ERROR_TYPE_AGE(1),                   //年龄参数有误，需在 6   ~ 99岁(不计算除BMI/idealWeightKg以外参数)
    PP_ERROR_TYPE_HEIGHT(2),                //身高参数有误，需在 90 ~ 220cm(不计算所有参数)
    PP_ERROR_TYPE_WEIGHT(3),                //体重有误 10 ~ 200kg
    PP_ERROR_TYPE_SEX(4),                   //性別有误 0 ~ 1
    PP_ERROR_TYPE_PEOPLE_TYPE(5),               //用户类型错误
    PP_ERROR_TYPE_IMPEDANCE_TWO_LEGS(6),        //阻抗有误
    PP_ERROR_TYPE_IMPEDANCE_TWO_ARMS(7),        //阻抗有误
    PP_ERROR_TYPE_IMPEDANCE_LEFT_BODY(8),       //阻抗有误
    PP_ERROR_TYPE_IMPEDANCE_RIGHT_ARM(9),       //阻抗有误
    PP_ERROR_TYPE_IMPEDANCE_LEFT_ARM(10),        //阻抗有误
    PP_ERROR_TYPE_IMPEDANCE_LEFT_LEG(11),       //阻抗有误
    PP_ERROR_TYPE_IMPEDANCE_RIGHT_LEG(12),      //阻抗有误
    PP_ERROR_TYPE_IMPEDANCE_TRUNK(13);          //阻抗有误

    private var type = 0

    constructor(type: Int) {
        this.type = type
    }

    open fun getType(): Int {
        return type
    }

}