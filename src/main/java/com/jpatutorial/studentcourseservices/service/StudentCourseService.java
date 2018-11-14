package com.jpatutorial.studentcourseservices.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpatutorial.studentcourseservices.entity.Course;
import com.jpatutorial.studentcourseservices.entity.Student;
import com.jpatutorial.studentcourseservices.repository.CourseRepository;
import com.jpatutorial.studentcourseservices.repository.StudentRepository;

@Component
@Transactional
public class StudentCourseService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Set<Course> getCoursesByStudentId(int id) {
		Student student = studentRepository.findById(id);
		if (student == null)
			return null;

		return student.getCourses();
	}

	public Set<Student> getStudentsByCourseId(int id) {
		Course course = courseRepository.findById(id);
		if (course == null)
			return null;

		return course.getStudent();

	}

	public void assignCourseToStudent(int studentId, int courseId) {
		Course course = courseRepository.findById(studentId);
		Student student = studentRepository.findById(courseId);

		student.getCourses().add(course);
		studentRepository.save(student);

	}
}
