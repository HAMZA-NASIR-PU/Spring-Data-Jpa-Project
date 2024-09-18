
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
        <!-- https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa -->
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-jpa</artifactId>
            <version>3.3.4</version>
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

### Compile the Java files

- javac -cp ".\lib\*" -d .\bin .\src\com\myapp\*.java

### Run the Java application

- java -cp "META-INF/*;bin;lib/*" com.myapp.MainApp


- mvn dependency:copy-dependencies