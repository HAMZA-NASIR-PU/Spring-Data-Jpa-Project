package com.myapp;

import org.springframework.beans.factory.annotation.Autowired;

public class MainApp {
    @Autowired
    private MyUserRepository myUserRepository;
    

    public static void main(String[] args) {
        MainApp abc = new MainApp();
        System.out.println(abc.myUserRepository);
        System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
    }

}