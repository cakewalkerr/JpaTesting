package com.jpatutorial.studentcourseservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpatutorial.studentcourseservices.entity.Course;
import com.jpatutorial.studentcourseservices.entity.Student;
import com.jpatutorial.studentcourseservices.repository.CourseRepository;
import com.jpatutorial.studentcourseservices.repository.StudentRepository;

@SpringBootApplication
public class StudentCourseServicesApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	private static final Logger log = LoggerFactory.getLogger(StudentCourseServicesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StudentCourseServicesApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		Course course1 = new Course("spring", "10 Steps",
				Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
		Course course2 = new Course("springMVC", "10 Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));

		Student student1 = new Student("Ranga Karanam", "Hiker, Programmer and Architect");
		Student student2 = new Student("Panda Pandom", "Biker, Programmer and Joker");
		// Student student2 = new Student();

		Set<Course> coursesSet1 = new HashSet<>();
		coursesSet1.add(course1);
		coursesSet1.add(course2);

		Set<Student> studentSet1 = new HashSet<>();
		studentSet1.add(student1);
		studentSet1.add(student2);

		student1.setCourses(coursesSet1);
		student2.setCourses(coursesSet1);

		course1.setStudent(studentSet1);
		course2.setStudent(studentSet1);

		courseRepository.save(course1);
		courseRepository.save(course2);
		studentRepository.save(student1);
		studentRepository.save(student2);

		// Student student3 = new Student("Key smth", "Boxer, Programmer and
		// Architect");
		/*
		 * course1.setName("spring"); course1.setDescription("10 Steps");
		 * course1.setSteps(Arrays.asList("Learn Maven", "Import Project",
		 * "First Example", "Second Example"));
		 * 
		 * course2.setName("springMVC"); course2.setDescription("10 Examples");
		 * course2.setSteps(Arrays.asList("Learn Maven", "Import Project",
		 * "First Example", "Second Example"));
		 */
		// student1.setName("Ranga Karanam");
		// student2.setName("Satish T");
		// student1.setDescription("Hiker, Programmer and Architect");
		// student2.setDescription("Hiker, Programmer and Architect");

		/*
		 * studentRepository.save(student1); studentRepository.save(student2);
		 * 
		 * courseRepository.save(course1); courseRepository.save(course2);
		 */
		/*
		 * courseRepository.saveAll(new HashSet<Course>() { { add(new Course("spring",
		 * "10 Steps", Arrays.asList("Learn Maven", "Import Project", "First Example",
		 * "Second Example"), new HashSet<Student>() { { add(new
		 * Student("Ranga Karanam", "Hiker, Programmer and Architect")); add(new
		 * Student("Satish T", "Hiker, Programmer and Joker")); } }));
		 * 
		 * add(new Course("springMVC", "10 Examples", Arrays.asList("Learn Maven",
		 * "Import Project", "First Example", "Second Example"), new HashSet<Student>()
		 * { { add(new Student("Ranga Karanam", "Hiker, Programmer and Architect"));
		 * add(new Student("Satish T", "Hiker, Programmer and Joker")); } })); } });
		 * 
		 * studentRepository.saveAll(new HashSet<Student>() { { add(new
		 * Student("Satish T", "Hiker, Programmer and Architect", new HashSet<Course>()
		 * { { add(new Course("spring", "10 Steps", Arrays.asList("Learn Maven",
		 * "Import Project", "First Example", "Second Example"))); add(new
		 * Course("springMVC", "10 Examples", Arrays.asList("Learn Maven",
		 * "Import Project", "First Example", "Second Example"))); } })); add(new
		 * Student("Ranga Karanam", "Hiker, Programmer and Architect", new
		 * HashSet<Course>() { { add(new Course("spring", "10 Steps",
		 * Arrays.asList("Learn Maven", "Import Project", "First Example",
		 * "Second Example"))); add(new Course("springMVC", "10 Examples",
		 * Arrays.asList("Learn Maven", "Import Project", "First Example",
		 * "Second Example"))); } })); } });
		 */
		/*
		 * for (Course course : courseRepository.findAll()) { log.info("Course: " +
		 * course.toString()); } for (Student student : studentRepository.findAll()) {
		 * log.info("Student: " + student.toString()); }
		 */

	}
}
