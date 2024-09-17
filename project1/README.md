# Project Title: Hibernate Learning Project for Beginners

This project is designed as a learning resource for students and developers who want to understand how Hibernate works without relying on more advanced technologies like Spring Boot, Spring Data JPA, or Spring Data Commons. The focus is to give a clear understanding of how Hibernate ORM (Object-Relational Mapping) functions in a Java application.


## Why Use a pom.xml File Initially?

Why Use a pom.xml File Initially?

- `Hibernate EntityManager`: I wanted to introduce Hibernate’s core capabilities, particularly using the hibernate-entitymanager dependency.

- `H2 Database`: As this is a learning project, I used the lightweight in-memory H2 database for simplicity and easy setup.

Here’s the `pom.xml` that I used:

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

This allowed me to quickly pull the required dependencies and their transitive dependencies.

## Why I Removed the `pom.xml` and Manual Setup

Afterward, I decided to remove the `pom.xml` file and handle the dependencies manually. Here's why:

- `Transitive Dependency Issues`: When downloading JARs manually, there were some issues with transitive dependencies, specifically with how certain libraries like Hibernate and Spring manage their dependencies. For example, conflicts arose when parsing the persistence.xml file due to missing or conflicting dependencies.

- `Control and Simplicity`: Manually downloading and managing dependencies gave me full control over which versions of the JARs were included in the project, and it also forced me to understand the underlying dependencies and how they interact.


- mvn dependency:copy-dependencies

### Compile the Java files

- javac -cp ".\lib\*" -d .\bin .\src\com\myapp\*.java

### Run the Java application

- java -cp "META-INF/*;bin;lib/*" com.myapp.MainApp

This approach is intentional for teaching purposes. It allows students to:

- Understand the role of each JAR file.

- Experience the challenges of manual dependency management.

- Learn how to build and run Java projects without modern build tools like Maven or Gradle.

By avoiding tools like Spring Boot and sticking with core Hibernate, students get to appreciate the fundamentals of ORM, persistence units, and database operations in Java.