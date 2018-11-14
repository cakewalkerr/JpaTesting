
package com.jpatutorial.studentcourseservices;

import java.util.Arrays;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpatutorial.studentcourseservices.entity.Course;
import com.jpatutorial.studentcourseservices.entity.Student;
import com.jpatutorial.studentcourseservices.repository.CourseRepository;
import com.jpatutorial.studentcourseservices.repository.StudentRepository;

@Component
public class StudentCourseServiceCommandLineRunner implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	private static final Logger log = LoggerFactory.getLogger(StudentCourseServiceCommandLineRunner.class);

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		Student student1 = new Student("Ranga Karanam", "Hiker, Programmer and Architect");
		Student student2 = new Student("Satish T", "Hiker, Programmer and Architect");
		// Student student3 = new Student("Key smth", "Boxer, Programmer and
		// Architect");

		courseRepository.saveAll(new HashSet<Course>() {
			{
				add(new Course("spring", "10 Steps",
						Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"),
						new HashSet<Student>() {
							{
								add(student1);
								add(student2);
							}
						}));

				add(new Course("springMVC", "10 Examples",
						Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"),
						new HashSet<Student>() {
							{
								add(student1);
								add(student2);
							}
						}));
			}
		});

		Course course1 = new Course("spring", "10 Steps",
				Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));

		Course course2 = new Course("springMVC", "10 Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));

		studentRepository.saveAll(new HashSet<Student>() {
			{
				add(new Student("Satish T", "Hiker, Programmer and Architect", new HashSet<Course>() {
					{
						add(course1);
						add(course2);
					}
				}));
				add(new Student("Ranga Karanam", "Hiker, Programmer and Architect", new HashSet<Course>() {
					{
						add(course1);
						add(course2);
					}
				}));
			}
		});

		for (Course course : courseRepository.findAll()) {
			log.info("Course: " + course.toString());
		}
		for (Student student : studentRepository.findAll()) {
			log.info("Student: " + student.toString());
		}
	}

	/*
	 * Course course1 = new Course("spring", "10 Steps",
	 * Arrays.asList("Learn Maven", "Import Project", "First Example",
	 * "Second Example")); courses.add(course1);
	 * 
	 * Course course2 = new Course("springMVC", "10 Examples",
	 * Arrays.asList("Learn Maven", "Import Project", "First Example",
	 * "Second Example")); courses.add(course2);
	 * 
	 * Course course3 = new Course("springBoot", "6K Students",
	 * Arrays.asList("Learn Maven", "Learn Spring", "Learn Spring MVC",
	 * "First Example", "Second Example")); courses.add(course3);
	 * 
	 * Course course4 = new Course("maven",
	 * "Most popular maven course on internet!", Arrays.asList("Pom.xml",
	 * "Build Life Cycle", "Parent POM", "Importing into Eclipse"));
	 * courses.add(course4);
	 */
	/*
	 * Student ranga = new Student("Ranga Karanam",
	 * "Hiker, Programmer and Architect", new HashSet()<>(Arrays.asList(course1,
	 * course2, course3, course4)));
	 * 
	 * Student satish = new Student("Satish T", "Hiker, Programmer and Architect",
	 * new ArrayList<>(Arrays.asList(course1, course2, course3, course4)));
	 */

}
