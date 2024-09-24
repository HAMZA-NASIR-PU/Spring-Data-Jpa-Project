package com.hibernateTut.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import com.hibernateTut.app.model.Message;

public class HelloWorldJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");

        UserTransaction tx = TM.getUserTransaction();
        tx.begin();

        EntityManager em = emf.createEntityManager();
        Message message = new Message();
        message.setText("Hello World!");
        em.persist(message);
        tx.commit();
        // INSERT into MESSAGE (ID, TEXT) values (1, 'Hello World!')
        em.close();
    }
}