package com.lefu.ppbasecalculatekit

import com.lefu.ppbasecalculatekit.calculate.CalculateHelper4
import com.lefu.ppbasecalculatekit.calculate.CalculateHelper4Leg2
import com.lefu.ppbasecalculatekit.calculate.CalculateHelper4TwoArms
import com.lefu.ppbasecalculatekit.calculate.CalculateHelper4TwoChannel
import com.lefu.ppbasecalculatekit.calculate.CalculateHelper8
import com.lefu.ppbasecalculatekit.calculate.CalculateHelper8Smooth
import com.lefu.ppbasecalculatekit.calculate.CalculateHelper8_172

object HTCalculateManager {

    var lastBodyBaseModel: HTBodyBaseModel? = null
    var testTimeInterval: Long? = 0L

    fun calculateData(bodyBaseModel: HTBodyBaseModel): HTBodyFatModel {
        val calculateType = bodyBaseModel.calculateType
        if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeDirect.getType()) {
            //4电极直流算法
            return CalculateHelper4.calculateTypeDCAlgorithm(bodyBaseModel)
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate4_0.getType()) {
            //4电极双脚新算法
            return CalculateHelper4Leg2.calcuteTypeAlternateTwoLegs2(bodyBaseModel)
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate4_1.getType()) {
            //4电极双频算法
            return CalculateHelper4TwoChannel.calcuteTypeAlternate4TwoChannel(bodyBaseModel)
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_0.getType()) {
            //8电极算法 bhProduct = 4
            return CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 4)
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_1.getType()) {
            //8电极算法 bhProduct = 3
            return CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 3)
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_2.getType()) {
            //8电极算法 bhProduct = 7
            return CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 7)
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_3.getType()) {
            //8电极算法 bhProduct =5 --CF577_N1
            return CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 5)
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_4.getType()) {
            //8电极算法 bhProduct =6 --CF597_N
            return CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 6)
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_5.getType()) {
            //8电极算法 bhProduct =6 --CF597_N
            return CalculateHelper8Smooth.calculateTypeAlternate8(bodyBaseModel, 6)
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8.getType()) {
            if (bodyBaseModel.z20KhzRightArmEnCode > 0 && bodyBaseModel.z100KhzRightArmEnCode <= 0) {
                bodyBaseModel.impedance = bodyBaseModel.z20KhzRightArmEnCode
                //4电极双手算法
                return CalculateHelper4TwoArms.calcuteTypeAlternateTwoArms(bodyBaseModel)
            } else {
                //8电极算法 bhProduct = 1
                //使用固定V1.7.2版本的算法，
                return CalculateHelper8_172.calcuteTypeAlternate8(bodyBaseModel, 1)
            }
        } else {
            //4电极双脚阻抗
            return CalculateHelper4.calcuteTypeAlternateTwoLegs(bodyBaseModel)
        }
    }

    fun calculateDataJson(bodyBaseModel: HTBodyBaseModel): String {
        val calculateType = bodyBaseModel.calculateType
        if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeDirect.getType()) {
            //4电极直流算法
            return CalculateHelper4.calculateTypeDCAlgorithm(bodyBaseModel).to4ElectrodeJson()
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate4_0.getType()) {
            //4电极双脚新算法
            return CalculateHelper4Leg2.calcuteTypeAlternateTwoLegs2(bodyBaseModel).to4ElectrodeJson()
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate4_1.getType()) {
            //4电极双频算法
            return CalculateHelper4TwoChannel.calcuteTypeAlternate4TwoChannel(bodyBaseModel).to4ElectrodeJson()
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_0.getType()) {
            //8电极算法 bhProduct = 4
            return CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 4).to8ElectrodeJson()
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_1.getType()) {
            //8电极算法 bhProduct = 3
            return CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 3).to8ElectrodeJson()
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_2.getType()) {
            //8电极算法 bhProduct = 7
            return CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 7).to8ElectrodeJson()
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_3.getType()) {
            //8电极算法 bhProduct =5 --CF577_N1
            return CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 5).to8ElectrodeJson()
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_4.getType()) {
            //8电极算法 bhProduct =6 --CF597_N
            return CalculateHelper8.calculateTypeAlternate8(bodyBaseModel, 6).to8ElectrodeJson()
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8_5.getType()) {
            //8电极算法 bhProduct =6 --CF597_N
            return CalculateHelper8Smooth.calculateTypeAlternate8(bodyBaseModel, 6).to8ElectrodeJson()
        } else if (calculateType == PPDeviceCalculateType.PPDeviceCalculateTypeAlternate8.getType()) {
            if (bodyBaseModel.z20KhzRightArmEnCode > 0 && bodyBaseModel.z100KhzRightArmEnCode <= 0) {
                bodyBaseModel.impedance = bodyBaseModel.z20KhzRightArmEnCode
                //4电极双手算法
                return CalculateHelper4TwoArms.calcuteTypeAlternateTwoArms(bodyBaseModel).to4ElectrodeJson()
            } else {
                //8电极算法 bhProduct = 1
                //使用固定V1.7.2版本的算法，
                return CalculateHelper8_172.calcuteTypeAlternate8(bodyBaseModel, 1).to8ElectrodeJson()
            }
        } else {
            //4电极双脚阻抗
            return CalculateHelper4.calcuteTypeAlternateTwoLegs(bodyBaseModel).to4ElectrodeJson()
        }
    }


}