package com.jpa.datajpademo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class DBConfig {

    // setup connection to database
    // You can create multiple datasources by using the following bean.
    @Bean
    DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();

        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.jpa.datajpademo.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); // Specifying persistence provider and that is
                                                                  // hibernate.
        emf.setPersistenceUnitName("mysqldb");
        return emf;
    };

    // Manually setting EntityManager.
    // @Bean
    // EntityManager entityManager(@Autowired EntityManagerFactory entityManagerFactory) {
    //     EntityManager entityManager = entityManagerFactory.createEntityManager();

    //     return entityManager;
    // }

    @Bean
    PlatformTransactionManager transactionManager(@Autowired EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);
        
        return jpaTransactionManager;
    }

    

}
