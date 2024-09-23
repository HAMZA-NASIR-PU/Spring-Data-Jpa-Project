package com.jpa.datajpademo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.datajpademo.dao.StudentDao;
import com.jpa.datajpademo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
public class StudentDaoImpl {

    @PersistenceContext(unitName = "mysqldb")
    EntityManager entityManager;

    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
        System.out.println("Entity saved");
    } 

}