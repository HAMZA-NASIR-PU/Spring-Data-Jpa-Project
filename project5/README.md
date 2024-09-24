# Java Persistence with Hibernate Book 2nd Edition

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

        <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>5.0.0.Final</version>
        </dependency>


    </dependencies>

</project>  
```

### NOTE
Use JDK version 21 and not above it. Otherwise you got may got the following exception:

```xml
Caused by: java.io.IOException: ASM ClassReader failed to parse class file - probably due to a new Java class file version that isn't supported yet: file [MyFile.class]
```


### Compile the Java files

- javac -cp "src\resources\META-INF\persistence.xml;.\lib\*" -d .\bin .\src\com\hibernateTut\app\*.java .\src\com\hibernateTut\app\model\*.java

### Run the Java application

- java -cp "bin;lib/*" com.jpa.datajpademo.App

### Setting mysql using docker

- docker run -p 3306:3306 -p 33060:33060 --name=mysqldb -e MYSQL_ROOT_PASSWORD=root -d mysql

- docker exec -it mysqldb mysql -uroot -p

```sql
CREATE TABLE students (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    mobile VARCHAR(255),
    address VARCHAR(255),
    PRIMARY KEY (id)
);
```

### SETTING JAVA EN VARIABLES ON WINDOWS

- SET JAVA_HOME=C:\Program Files\Java\jdk-21
- SET PATH=%JAVA_HOME%\bin;%PATH%