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
        <!-- https://mvnrepository.com/artifact/jakarta.persistence/jakarta.persistence-api -->
        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
            <version>3.1.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>6.0.10</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>6.0.10</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.2.6.Final</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>9.0.0</version>
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

- javac -cp ".\lib\*" -d .\bin .\src\com\jpa\datajpademo\*.java .\src\com\jpa\datajpademo\dao\*.java .\src\com\jpa\datajpademo\entity\*.java .\src\com\jpa\datajpademo\config\*.java

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