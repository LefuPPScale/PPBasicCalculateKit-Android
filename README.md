1、Secret配置：
你需要提供根据你的应用的包名去生成对应的secret，具体流程如下：
- 将你的包名发送给pengsiyuan@lefu.cc，并说明需要什么算法的secret，
- 等邮件回复，你会收到独属于你自己的secret.xlsx
- 将拿到的secret.xlsx中的secret一一替换SecretManager中的secret.
- 将此module作为lib引入到你的项目中，

2、如何拿到计算后的体脂数据
PPBasicCalculateKit是PPCalculateKit的基础计算库，
PPBaseKit/PPBasicCalculateKit/PPCalculateKit三个模块都需要引入到你的项目中，
其中PPBasicCalculateKit采用library方式引入，PPBaseKit&PPCalculateKit采用aar/maven方式引入，

具体的计算库可查看文档：
https://xinzhiyun.feishu.cn/docx/L0UxdNKFPorB77xBjnmcqijtnVb?from=from_copylink
