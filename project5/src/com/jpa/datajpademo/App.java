package com.jpa.datajpademo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.jpa.datajpademo.dao.StudentDao;
import com.jpa.datajpademo.entity.Student;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(App.class, args);
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