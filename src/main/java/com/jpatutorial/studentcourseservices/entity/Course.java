package com.jpatutorial.studentcourseservices.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	@ElementCollection(targetClass = String.class)
	private List<String> steps;
	@ElementCollection(targetClass = String.class)
	private Set<Student> student;

	protected Course() {

	}

	public Course(String name, String description, List<String> steps) {
		super();
		this.name = name;
		this.description = description;
		this.steps = steps;
	}

	public Course(String name, String description, List<String> steps, Set<Student> student) {
		super();
		this.name = name;
		this.description = description;
		this.steps = steps;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

	@ManyToMany(mappedBy = "courses")
	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return String.format("Course [id=%i, name=%s, description=%s, steps=%s]", id, name, description, steps);
	}
}
