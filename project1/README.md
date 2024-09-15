```xml
<dependency>
  <groupId>org.hibernate</groupId>
  <artifactId>hibernate-entitymanager</artifactId>
  <version>5.6.15.Final</version>
</dependency>`

<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <version>1.4.200</version>
  <scope>complete</scope>
</dependency>
```


- mvn dependency:copy-dependencies

- javac -cp ".\lib\*" -d .\bin .\src\com\myapp\*.java

- java -cp "META-INF/*;bin;lib/*" com.myapp.MainApp

- jar cvfm MyApp.jar manifest.txt -C bin/ .

- java -jar MyApp.jar
