package com.jpa.datajpademo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpa.datajpademo.dao.StudentDao;
import com.jpa.datajpademo.entity.Student;
import com.jpa.datajpademo.config.AppConfig;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao studentDao = container.getBean("studentDao", StudentDao.class);

        // Inserting a new entry
        Student std = new Student("RAZA", "123456789", "Lahore");

        studentDao.save(std);

        // Reading all students from db
        List<Student> students = studentDao.findAll();

        students.forEach(student -> System.out.println(student.getId()));

        Optional<Student> optionalStudent = studentDao.findById(3);

        System.out.println("Finding student with id 3 *****");
        if (optionalStudent.isPresent()) {
            System.out.println("Student found");
        }
    }
}