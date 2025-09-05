package com.lefu.ppbasiccalculatekit

    /**
     * 计算方式 默认体脂率采用原始值
     */
    enum class PPDeviceCalculateType {
        PPDeviceCalculateTypeUnknow(0),//未知
        PPDeviceCalculateTypeInScale(1), //秤端计算
        PPDeviceCalculateTypeDirect(2), //直流4DC
        PPDeviceCalculateTypeAlternate(3),//4电极交流-V5.0.5固定版本-做减法
        PPDeviceCalculateTypeAlternate8(4),// 8电极交流算法, bhProduct=1--CF577
        PPDeviceCalculateTypeNormal(5), //4电极交流4-V5.0.5固定版本-不做减法
        PPDeviceCalculateTypeNeedNot(6),//不需要计算
        PPDeviceCalculateTypeAlternate8_0(7),//8电极算法，bhProduct =4--CF597
        PPDeviceCalculateTypeAlternate8_1(8),//8电极算法，bhProduct =3--CF586
        PPDeviceCalculateTypeAlternate4_0(9),//4电极交流(新)-跟随方案商，最新版本
        PPDeviceCalculateTypeAlternate4_1(10),//4电极双频-跟随方案商，最新版本
        PPDeviceCalculateTypeAlternate8_2(11),//8电极算法，bhProduct =7==CF610
        PPDeviceCalculateTypeAlternate8_3(12),//8电极算法，bhProduct =5 --CF577_N1
        PPDeviceCalculateTypeAlternate8_4(13),//8电极算法，bhProduct =6 -- CF597_N
        PPDeviceCalculateTypeAlternate8_5(14);//8电极算法，bhProduct =6--CF597 平滑阻抗算法 ScaleType =60
        

        private var type = 0

        constructor(bodygrade: Int) {
            this.type = bodygrade
        }

        open fun getType(): Int {
            return type
        }

    }