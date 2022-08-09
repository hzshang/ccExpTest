


Apache Commons Collection 漏洞复现

测试

export JAVA_HOME=/opt/jdk1.7.0_80
mvn clean package
$JAVA_HOME/bin/java -cp target/cc-1.jar com.Exp.Main
$JAVA_HOME/bin/java -cp target/cc-1.jar com.Exp.Exp

检查是否创建了hack.txt文件

