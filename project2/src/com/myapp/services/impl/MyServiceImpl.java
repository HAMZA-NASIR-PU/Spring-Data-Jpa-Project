package com.myapp.services.impl;

import com.myapp.entities.MyUser;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.myapp.services.MyService;

@Repository
public class MyServiceImpl implements MyService {

    @PersistenceContext
    EntityManager entitymanager;


    @Override
    public void createUser(MyUser myUser) {
        entitymanager.persist(myUser);
        System.err.println("Record inserted");
    }

}
