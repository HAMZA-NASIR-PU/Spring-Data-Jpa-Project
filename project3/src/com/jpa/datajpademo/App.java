package com.jpa.datajpademo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpa.datajpademo.dao.StudentDao;
import com.jpa.datajpademo.dao.StudentDaoImpl;
import com.jpa.datajpademo.entity.Student;
import com.jpa.datajpademo.config.AppConfig;

public class App {
    public static void main(String[] args) {
        // StudentDao studentDao = new StudenDaoImpl(); //we dont want to do this manually.
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDaoImpl studentDaoImpl = container.getBean("studentDaoImpl", StudentDaoImpl.class);
        
        Student student = new Student("ALI", "123456789", "Lahore");

        studentDaoImpl.saveStudent(student);

    }
}