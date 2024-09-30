package com.demo.dataSourceBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.SpringVersion;

import com.demo.dataSourceBean.models.Student;
import com.demo.dataSourceBean.repositories.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

@SpringBootApplication
public class DataSourceBeanApplication {

	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext context = SpringApplication.run(DataSourceBeanApplication.class, args);

		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);

		System.out.println("Spring Version: " + SpringVersion.getVersion());
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		System.out.println(dataSource);

		// StudentRepository studentRepository = context.getBean("studentRepository",
		// StudentRepository.class);

		// Student student = studentRepository.getReferenceById(1);

		// System.out.println(student.getId());

		Connection connection = dataSource.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students");

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			String name = resultSet.getString(2);
		}

	}

}
