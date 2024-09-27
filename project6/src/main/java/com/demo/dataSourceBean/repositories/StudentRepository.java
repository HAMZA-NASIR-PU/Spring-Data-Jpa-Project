package com.demo.dataSourceBean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dataSourceBean.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
