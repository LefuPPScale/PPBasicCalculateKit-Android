1、Secret配置：
你需要提供根据你的应用的包名去生成对应的secret，具体流程如下：
- 将你的包名发送给pengsiyuan@lefu.cc，并说明需要什么算法的secret，
- 等邮件回复，你会收到算法库相应的zip文件，
- 将zip文件解压后，拿到Android的aar文件
- 解压aar文件，将jni目录下的.so包一一替换当前项目的.so
- 将拿到的secret.xlsx中的secret一一替换SecretManager中的secret.
- 将此module作为lib引入到你的项目中，

2、如何拿到计算后的体脂数据
PPBasicCalculateKit是基础的计算库计算，在你配置Secret完成后，你需要引入PPBaseKit/PPDataAnalysisKit/PPBluetoothKit三个模块，
在你调用PPBasicCalculateKit计算出来体脂信息后会返回一个Json，将该Json再调用PPDataAnalysisKit库，拿到PPBodyFatModel至此PPBodyFatModel就是完成的体脂信息。
具体的计算库可查看文档：
https://xinzhiyun.feishu.cn/docx/L0UxdNKFPorB77xBjnmcqijtnVb?from=from_copylink
