package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>,CrudRepository<Student,Long>{

	
}
