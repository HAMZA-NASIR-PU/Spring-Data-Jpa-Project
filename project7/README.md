# Learn how to use HikariCP without using any Ioc Container like Spring Boot.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.4</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.demo</groupId>
	<artifactId>dataSourceBean</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>dataSourceBean</name>
	<description>Demo project for learning about javax.sql.DataSource and related stuff in Spring Boot</description>
	<url />
	<licenses>
		<license />
	</licenses>
	<developers>
		<developer />
	</developers>
	<scm>
		<connection />
		<developerConnection />
		<tag />
		<url />
	</scm>
	<properties>
		<java.version>21</java.version>
	</properties>
	<dependencies>

		<!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
		<dependency>
			<groupId>com.zaxxer</groupId>
			<artifactId>HikariCP</artifactId>
			<version>6.0.0</version>
		</dependency>


		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>

	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```


### Compile the Java files

- javac -cp ".\lib\*" -d .\bin .\src\*.java 

### Run the Java application

- java -cp "bin;lib/*" com.demo.hikaridemo.App


### What is try-with-resources statement

The try-with-resources statement in Java is a feature introduced in Java 7 that simplifies resource management, ensuring that resources like files, database connections, or network sockets are closed automatically after their usage. Any resource that implements the java.lang.AutoCloseable interface can be used within a try-with-resources statement. This reduces the need to explicitly write finally blocks to close the resources, making the code more concise and less error-prone.


```java
try (ResourceType resource = new ResourceType()) {
    // Use the resource
} catch (ExceptionType e) {
    // Handle exceptions
}
```

#### Key points

- The resource declared in the parentheses after try will be closed automatically after the block is executed.
- You can declare multiple resources by separating them with semicolons.
- Resources must implement the `AutoCloseable` or `java.io.Closeable` interface.
- The closing of resources happens in the reverse order of their declaration.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

    public static void main(String[] args) {
        // Database URL, username, and password
        String jdbcUrl = "jdbc:h2:~/test"; // H2 Database as an example
        String username = "sa";
        String password = "";

        // SQL Query
        String sql = "SELECT id, name, email FROM users";

        // Try-with-resources block to handle Connection, Statement, and ResultSet
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Iterate through the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                // Output the data
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

