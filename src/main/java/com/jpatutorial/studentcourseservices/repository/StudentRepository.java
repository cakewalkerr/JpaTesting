package com.jpatutorial.studentcourseservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpatutorial.studentcourseservices.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByName(String name);

	Student findById(int id);

}
