package com.lefu.ppbasiccalculatekit

import com.besthealth.bhBodyComposition.BhErrorType
import com.lefu.body_sl.ErrorType

object BodyFatCalculateHelper {


    @JvmStatic
    fun calculateZLefuErrorType(errorType: ErrorType): BodyFatErrorType {
//        BD_NONE(0),// 无错误
//        BD_CALCU(1),
//        BD_AGE(2),// 年龄错误
//        BD_HEIGHT(3),// 身高错误
//        BD_WEIGHT(4),// 体重错误
//        BD_SEX(5),// 性别错误
//        BD_SPORTMAN(6),// 用户类型错误
//        BD_IMPEDANCE(7);// 双脚阻抗错误
        when (errorType) {
            ErrorType.BD_NONE -> return BodyFatErrorType.PP_ERROR_TYPE_NONE
            ErrorType.BD_AGE -> return BodyFatErrorType.PP_ERROR_TYPE_AGE
            ErrorType.BD_HEIGHT -> return BodyFatErrorType.PP_ERROR_TYPE_HEIGHT
            ErrorType.BD_WEIGHT -> return BodyFatErrorType.PP_ERROR_TYPE_WEIGHT
            ErrorType.BD_SEX -> return BodyFatErrorType.PP_ERROR_TYPE_SEX
            ErrorType.BD_SPORTMAN -> return BodyFatErrorType.PP_ERROR_TYPE_PEOPLE_TYPE
            ErrorType.BD_IMPEDANCE -> return BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_LEGS
            else -> return BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_LEGS
        }


    }

    @JvmStatic
    fun calculateHTErrorType4AC(bhErrorType: BhErrorType): BodyFatErrorType {
        var ppBodyfatErrorType: BodyFatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
        when {
            bhErrorType == BhErrorType.NONE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
            }

            bhErrorType == BhErrorType.AGE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_AGE
            }

            bhErrorType == BhErrorType.HEIGHT -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_HEIGHT
            }

            bhErrorType == BhErrorType.WEIGHT -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_WEIGHT
            }

            bhErrorType == BhErrorType.SEX -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_SEX
            }

            bhErrorType == BhErrorType.PEOPLE_TYPE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_PEOPLE_TYPE
            }

            bhErrorType == BhErrorType.IMPEDANCE_TWO_LEGS -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_LEGS
            }

            bhErrorType == BhErrorType.IMPEDANCE_TWO_ARMS -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_ARMS
            }

            bhErrorType == BhErrorType.IMPEDANCE_LEFT_BODY -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_BODY
            }

            bhErrorType == BhErrorType.IMPEDANCE_LEFT_ARM -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_ARM
            }

            bhErrorType == BhErrorType.IMPEDANCE_RIGHT_ARM -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_ARM
            }

            bhErrorType == BhErrorType.IMPEDANCE_LEFT_LEG -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_LEG
            }

            bhErrorType == BhErrorType.IMPEDANCE_RIGHT_LEG -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_LEG
            }

            bhErrorType == BhErrorType.IMPEDANCE_TRUNK -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TRUNK
            }
        }
        return ppBodyfatErrorType
    }

    @JvmStatic
    fun calculateHTErrorType_172(bhErrorType: com.besthealth.bh2BodyComposition.BhErrorType): BodyFatErrorType {
        var ppBodyfatErrorType: BodyFatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
        when (bhErrorType) {
            com.besthealth.bh2BodyComposition.BhErrorType.NONE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
            }

            com.besthealth.bh2BodyComposition.BhErrorType.AGE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_AGE
            }

            com.besthealth.bh2BodyComposition.BhErrorType.HEIGHT -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_HEIGHT
            }

            com.besthealth.bh2BodyComposition.BhErrorType.WEIGHT -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_WEIGHT
            }

            com.besthealth.bh2BodyComposition.BhErrorType.SEX -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_SEX
            }

            com.besthealth.bh2BodyComposition.BhErrorType.PEOPLE_TYPE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_PEOPLE_TYPE
            }

            com.besthealth.bh2BodyComposition.BhErrorType.IMPEDANCE_TWO_LEGS -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_LEGS
            }

            com.besthealth.bh2BodyComposition.BhErrorType.IMPEDANCE_TWO_ARMS -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_ARMS
            }

            com.besthealth.bh2BodyComposition.BhErrorType.IMPEDANCE_LEFT_BODY -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_BODY
            }

            com.besthealth.bh2BodyComposition.BhErrorType.IMPEDANCE_LEFT_ARM -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_ARM
            }

            com.besthealth.bh2BodyComposition.BhErrorType.IMPEDANCE_RIGHT_ARM -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_ARM
            }

            com.besthealth.bh2BodyComposition.BhErrorType.IMPEDANCE_LEFT_LEG -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_LEG
            }

            com.besthealth.bh2BodyComposition.BhErrorType.IMPEDANCE_RIGHT_LEG -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_LEG
            }

            com.besthealth.bh2BodyComposition.BhErrorType.IMPEDANCE_TRUNK -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TRUNK
            }

            else -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
            }
        }
        return ppBodyfatErrorType
    }

    @JvmStatic
    fun calculateHTErrorType(bhErrorType: com.besthealth.bh5BodyComposition.BhErrorType): BodyFatErrorType {
        var ppBodyfatErrorType: BodyFatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
        when (bhErrorType) {
            com.besthealth.bh5BodyComposition.BhErrorType.NONE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
            }

            com.besthealth.bh5BodyComposition.BhErrorType.AGE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_AGE
            }

            com.besthealth.bh5BodyComposition.BhErrorType.HEIGHT -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_HEIGHT
            }

            com.besthealth.bh5BodyComposition.BhErrorType.WEIGHT -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_WEIGHT
            }

            com.besthealth.bh5BodyComposition.BhErrorType.SEX -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_SEX
            }

            com.besthealth.bh5BodyComposition.BhErrorType.PEOPLE_TYPE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_PEOPLE_TYPE
            }

            com.besthealth.bh5BodyComposition.BhErrorType.IMPEDANCE_TWO_LEGS -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_LEGS
            }

            com.besthealth.bh5BodyComposition.BhErrorType.IMPEDANCE_TWO_ARMS -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_ARMS
            }

            com.besthealth.bh5BodyComposition.BhErrorType.IMPEDANCE_LEFT_BODY -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_BODY
            }

            com.besthealth.bh5BodyComposition.BhErrorType.IMPEDANCE_LEFT_ARM -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_ARM
            }

            com.besthealth.bh5BodyComposition.BhErrorType.IMPEDANCE_RIGHT_ARM -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_ARM
            }

            com.besthealth.bh5BodyComposition.BhErrorType.IMPEDANCE_LEFT_LEG -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_LEG
            }

            com.besthealth.bh5BodyComposition.BhErrorType.IMPEDANCE_RIGHT_LEG -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_LEG
            }

            com.besthealth.bh5BodyComposition.BhErrorType.IMPEDANCE_TRUNK -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TRUNK
            }

            else -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
            }
        }
        return ppBodyfatErrorType
    }

    @JvmStatic
    fun calculateHTErrorTypeTwoArms(bhErrorType: com.besthealth.bh4BodyComposition.BhErrorType): BodyFatErrorType {
        var ppBodyfatErrorType: BodyFatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
        when (bhErrorType) {
            com.besthealth.bh4BodyComposition.BhErrorType.NONE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
            }

            com.besthealth.bh4BodyComposition.BhErrorType.AGE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_AGE
            }

            com.besthealth.bh4BodyComposition.BhErrorType.HEIGHT -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_HEIGHT
            }

            com.besthealth.bh4BodyComposition.BhErrorType.WEIGHT -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_WEIGHT
            }

            com.besthealth.bh4BodyComposition.BhErrorType.SEX -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_SEX
            }

            com.besthealth.bh4BodyComposition.BhErrorType.PEOPLE_TYPE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_PEOPLE_TYPE
            }

            com.besthealth.bh4BodyComposition.BhErrorType.IMPEDANCE_TWO_LEGS -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_LEGS
            }

            com.besthealth.bh4BodyComposition.BhErrorType.IMPEDANCE_TWO_ARMS -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_ARMS
            }

            com.besthealth.bh4BodyComposition.BhErrorType.IMPEDANCE_LEFT_BODY -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_BODY
            }

            com.besthealth.bh4BodyComposition.BhErrorType.IMPEDANCE_LEFT_ARM -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_ARM
            }

            com.besthealth.bh4BodyComposition.BhErrorType.IMPEDANCE_RIGHT_ARM -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_ARM
            }

            com.besthealth.bh4BodyComposition.BhErrorType.IMPEDANCE_LEFT_LEG -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_LEG
            }

            com.besthealth.bh4BodyComposition.BhErrorType.IMPEDANCE_RIGHT_LEG -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_LEG
            }

            com.besthealth.bh4BodyComposition.BhErrorType.IMPEDANCE_TRUNK -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TRUNK
            }

            else -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
            }
        }
        return ppBodyfatErrorType
    }

    @JvmStatic
    fun calculateHTErrorTypeTwoChannel(bhErrorType: com.besthealth.bh3BodyComposition.BhErrorType): BodyFatErrorType {
        var ppBodyfatErrorType: BodyFatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
        when {
            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.NONE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.AGE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_AGE
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.HEIGHT -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_HEIGHT
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.WEIGHT -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_WEIGHT
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.SEX -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_SEX
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.PEOPLE_TYPE -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_PEOPLE_TYPE
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.IMPEDANCE_TWO_LEGS -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_LEGS
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.IMPEDANCE_TWO_ARMS -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_ARMS
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.IMPEDANCE_LEFT_BODY -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_BODY
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.IMPEDANCE_LEFT_ARM -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_ARM
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.IMPEDANCE_RIGHT_ARM -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_ARM
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.IMPEDANCE_LEFT_LEG -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_LEG
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.IMPEDANCE_RIGHT_LEG -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_LEG
            }

            bhErrorType == com.besthealth.bh3BodyComposition.BhErrorType.IMPEDANCE_TRUNK -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TRUNK
            }
        }
        return ppBodyfatErrorType
    }

    @JvmStatic
    fun calculateHTErrorType4Leg(bhErrorType: com.besthealth.bh1BodyComposition.BhErrorType): BodyFatErrorType {
        //    NONE,
        //    AGE,
        //    HEIGHT,
        //    WEIGHT,
        //    SEX,
        //    PEOPLE_TYPE,
        //    IMPEDANCE_TWO_LEGS,
        //    IMPEDANCE_TWO_ARMS,
        //    IMPEDANCE_LEFT_BODY,
        //    IMPEDANCE_LEFT_ARM,
        //    IMPEDANCE_RIGHT_ARM,
        //    IMPEDANCE_LEFT_LEG,
        //    IMPEDANCE_RIGHT_LEG,
        //    IMPEDANCE_TRUNK;
        var ppBodyfatErrorType: BodyFatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
        when {
            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.NONE.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_NONE
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.AGE.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_AGE
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.HEIGHT.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_HEIGHT
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.WEIGHT.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_WEIGHT
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.SEX.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_SEX
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.PEOPLE_TYPE.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_PEOPLE_TYPE
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.IMPEDANCE_TWO_LEGS.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_LEGS
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.IMPEDANCE_TWO_ARMS.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TWO_ARMS
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.IMPEDANCE_LEFT_BODY.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_BODY
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.IMPEDANCE_LEFT_ARM.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_ARM
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.IMPEDANCE_RIGHT_ARM.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_ARM
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.IMPEDANCE_LEFT_LEG.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_LEFT_LEG
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.IMPEDANCE_RIGHT_LEG.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_RIGHT_LEG
            }

            bhErrorType.ordinal == com.besthealth.bh1BodyComposition.BhErrorType.IMPEDANCE_TRUNK.ordinal -> {
                ppBodyfatErrorType = BodyFatErrorType.PP_ERROR_TYPE_IMPEDANCE_TRUNK
            }
        }
        return ppBodyfatErrorType
    }

}