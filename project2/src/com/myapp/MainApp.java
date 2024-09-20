package com.myapp;

import com.myapp.entities.MyUser;
import com.myapp.services.impl.MyServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext();

        MyServiceImpl bean = container.getBean("MyServiceImpl", MyServiceImpl.class);

        MyUser myUser = new MyUser();
        myUser.setName("ALI RAZA");
        // System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
    }

}