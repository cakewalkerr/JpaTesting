package com.jpatutorial.studentcourseservices.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpatutorial.studentcourseservices.entity.Course;
import com.jpatutorial.studentcourseservices.entity.Student;
import com.jpatutorial.studentcourseservices.repository.StudentRepository;
import com.jpatutorial.studentcourseservices.service.StudentCourseService;

@RestController
public class StudentCourseController {

	@Autowired
	StudentCourseService studentCourseService;

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		// return studentRepository.findAll();
		return studentCourseService.getAllStudents();
	}

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return studentCourseService.getAllCourses();
	}

	@GetMapping("/student/{id}/courses")
	public Set<Course> getCoursesByStudentId(@PathVariable int id) {
		return studentCourseService.getCoursesByStudentId(id);
	}

	@GetMapping("/course/{id}/students")
	public Set<Student> getStudentsByCourseId(@PathVariable int id) {
		return studentCourseService.getStudentsByCourseId(id);

	}

	@PostMapping("/student/{studentId}/{courseId}")
	public void assignCourseToStudent(@PathVariable int studentId, @PathVariable int courseId) {
		studentCourseService.assignCourseToStudent(studentId, courseId);
	}

	@GetMapping("/student/{studentId}/{courseName}")
	public String assignCourseToStudentByName(@PathVariable int studentId, @PathVariable String courseName) {
		return studentCourseService.assignCourseToStudentByName(studentId, courseName);
	}

}
