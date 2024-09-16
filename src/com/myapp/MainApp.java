package com.myapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApp {

  public static void main(String[] args) {
    // Creating a student object
    Student student = new Student();
    student.setId(1);
    student.setName("Sohail Shah");
    // Creating a entity manager factory object
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    // creating entity manager using the entity manager factory
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    // creating a transaction object using the entity manager
    EntityTransaction transaction = entityManager.getTransaction();
    // beginning the transaction
    transaction.begin();
    // Persisting the student object
    entityManager.persist(student);
    // committing the transaction
    transaction.commit();

    System.out.println("***********************************************");
    Student std = entityManager.find(Student.class, student.getId());
    System.out.println("got object " + std.getName() + " " + std.getId());
    System.out.println("***********************************************");
    // closing the entity manager
    entityManager.close();
    // closing the entity manager factory
    entityManagerFactory.close();
  }
}