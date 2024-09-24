package com.jpa.datajpademo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpa.datajpademo.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{    

}