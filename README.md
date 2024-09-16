My application is using Jakarta Persistence (JPA) and Hibernate for ORM, which are part of the Jakarta EE (Enterprise Edition) specification. However, since I am running it in a standalone fashion without a full Jakarta EE server (like WildFly, TomEE, or GlassFish) and managing my own dependencies and configuration, it's more accurate to classify your setup as: `Java SE (Standard Edition) with Jakarta EE Components`


javac -cp ".\lib\*" -d .\bin .\src\com\myapp\*.java
java -cp "bin;lib/*" com.myapp.MainApp