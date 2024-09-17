```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.myapp.project1</groupId>
    <artifactId>project1</artifactId>
    <version>1.0</version>
    <packaging>jar</packaging>

    <name>Maven Quick Start Archetype</name>
    <url>http://maven.apache.org</url>

    <dependencies>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>5.6.15.Final</version>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>1.4.200</version>
            <scope>complete</scope>
        </dependency>
    </dependencies>

</project>  
```


- mvn dependency:copy-dependencies

- javac -cp ".\lib\*" -d .\bin .\src\com\myapp\*.java

- java -cp "META-INF/*;bin;lib/*" com.myapp.MainApp

- jar cvfm MyApp.jar manifest.txt -C bin/ .

- java -jar MyApp.jar
