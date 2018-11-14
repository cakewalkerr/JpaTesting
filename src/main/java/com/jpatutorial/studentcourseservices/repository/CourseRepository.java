package com.jpatutorial.studentcourseservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpatutorial.studentcourseservices.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	Course findByName(String name);

	Course findById(int id);

}
