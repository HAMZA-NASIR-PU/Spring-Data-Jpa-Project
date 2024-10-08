package com.myapp.config;

import java.util.Properties;

import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import com.myapp.MainBean;

import javax.sql.DataSource;
import jakarta.annotation.Resource;

@Configuration
@PropertySource("classpath:hibernate.properties")
@EnableJpaRepositories
@EnableTransactionManagement
public class JpaConfiguration {

        private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
        private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
        private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
        private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

        private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
        private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
        private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.myapp.entities";

        @Resource
        private Environment env;

        @Bean
        public DataSource dataSource() {
                DriverManagerDataSource dataSource = new DriverManagerDataSource();

                dataSource.setDriverClassName(
                                env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
                dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
                dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
                dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

                return dataSource;
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
                LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
                emf.setDataSource(dataSource());
                // emf.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
                emf.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
                // emf.setJpaProperties(hibProperties());
                emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
                return emf;
        }

        private Properties hibProperties() {
                Properties properties = new Properties();
                properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
                                env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
                properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
                                env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
                return properties;
        }

        @Bean
        public JpaTransactionManager transactionManager() {
                JpaTransactionManager transactionManager = new JpaTransactionManager();
                transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
                return transactionManager;
        }

        @Bean
        public MainBean mainBean() {
                return new MainBean();
        }
}
