package com.demo.dataSourceBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.SpringVersion;

import com.demo.dataSourceBean.models.Student;
import com.demo.dataSourceBean.repositories.StudentRepository;

import javax.sql.DataSource;

@SpringBootApplication
public class DataSourceBeanApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(DataSourceBeanApplication.class, args);
		
		System.out.println("Spring Version: " + SpringVersion.getVersion());
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		System.out.println(dataSource);

		StudentRepository studentRepository = context.getBean("studentRepository", StudentRepository.class);

		Student student = studentRepository.getReferenceById(1);

		System.out.println(student.getId());

	}

}
