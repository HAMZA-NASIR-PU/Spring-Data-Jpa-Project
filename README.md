- mvn dependency:copy-dependencies

- javac -cp ".\lib\*" -d .\bin .\src\com\myapp\*.java

- java -cp "META-INF/*;bin;lib/*" com.myapp.MainApp

- jar cvfm MyApp.jar manifest.txt -C bin/ .

- java -jar MyApp.jar