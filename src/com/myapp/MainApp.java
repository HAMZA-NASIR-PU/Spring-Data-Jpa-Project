package com.myapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        // Print the classpath to debug issues
        System.out.println("Classpath: " + System.getProperty("java.class.path"));
        // Create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        try {
            // Start transaction
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Create and save a new user
            User user = new User();
            user.setName("John Doe");
            em.persist(user);

            // Commit transaction
            transaction.commit();

            // Fetch and print all users
            System.out.println("Users found with findAll():");
            List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
            for (User u : users) {
                System.out.println(u.getId() + ": " + u.getName());
            }

            // Find a user by ID
            User foundUser = em.find(User.class, user.getId());
            if (foundUser != null) {
                System.out.println("Found user: " + foundUser.getName());
            }

        } finally {
            // Close EntityManager
            em.close();
            emf.close();
        }
    }
}
