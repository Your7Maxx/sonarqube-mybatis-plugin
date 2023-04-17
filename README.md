# sonarqube-mybatis-plugin

## 插件概要
  本插件在[sonarqube-xml-plugin](https://github.com/SonarSource/sonar-xml.git)的基础上进行了修改，修改后的插件能够自动地检测出使用mybatis框架的项目中存在sql注入漏洞风险的代码片段，目前只是针对使用“$”的场景进行扫描，但对like、in等特殊的查询并没有作进一步的判断检测，这只是一个自定义插件的简单实践。
## 使用说明
* 编译打包：`mvn clean install -DskipTests`
![image](https://github.com/Your7Maxx/sonarqube-mybatis-plugin/blob/main/sonar-mybatis-master/1.png?raw=true)
* 启动sonar，以管理员权限卸载Soner内置的xml检测规则，避免冲突：
![image](https://github.com/Your7Maxx/sonarqube-mybatis-plugin/blob/main/sonar-mybatis-master/2.png?raw=true)
* 将编译所得的可执行jar包导入Sonar的/extention/plugins目录下：
![image](https://github.com/Your7Maxx/sonarqube-mybatis-plugin/blob/main/sonar-mybatis-master/3.png?raw=true)
* 重启Sonar
* 登陆Sonar，并在Rules中查看新建的XML检测规则信息如下：
![image](https://github.com/Your7Maxx/sonarqube-mybatis-plugin/blob/main/sonar-mybatis-master/4.png?raw=true)
![image](https://github.com/Your7Maxx/sonarqube-mybatis-plugin/blob/main/sonar-mybatis-master/5.png?raw=true)
* 在Quality-Profiles中将该条规则启动并设为default模式：
[参考链接](https://blog.csdn.net/qq_39430776/article/details/79104249)
* 使用sonar-scanner测试规则：<br>
`sonar-scanner -Dsonar.projectKey=test -Dsonar.sources=./src/ -Dsonar.host.url=http://xxx.xxx.xxx.xxx -Dsonar.login=xxxxxxxxxxxxxxxxxxx -Dproject.settings=./sonar-project.properties -Dsonar.scm.disabled=true`<br>
其中：<br>
`-Dsonar.sources`:设置扫描代码项目所在路径<br>
sonar-project.properties配置文件里添加如下内容：<br>
`sonar.projectKey=test`<br> 
`sonar.projectName=test`<br>
`sonar.sources=/opt/sonar-xml-master/src`<br>
`sonar.java.binaries=/opt/sonar-xml-master/sonar-xml-plugin/target/classes`<br>
<br>简单的测试用例：
![image](https://github.com/Your7Maxx/sonarqube-mybatis-plugin/blob/main/sonar-mybatis-master/6.png?raw=true)<br>
该插件会自动扫描${}链接符的使用情况，在并其所在sql语句的id处进行标注：<br>
![image](https://github.com/Your7Maxx/sonarqube-mybatis-plugin/blob/main/sonar-mybatis-master/7.png?raw=true)<br>
![image](https://github.com/Your7Maxx/sonarqube-mybatis-plugin/blob/main/sonar-mybatis-master/8.png?raw=true)<br>

## 参考链接
* https://docs.sonarqube.org/latest/extend/developing-plugin/
* https://github.com/SonarSource/sonar-xml
* https://www.tabnine.com/code/java/methods/org.w3c.dom.Node/getFirstChild

## 功能添加
* 完善针对ibatis框架的检测规则，针对`like`、`in`等特殊场景下`${}`的使用进行细粒度的检测
* 其他主流框架代码风险发现插件开发
