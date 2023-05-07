package com.example.sms.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="students")

public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column(name="adi", nullable=false)
	private String firstName;
	
	@Column(name="soyadi", nullable=false)
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="tcno")
	private Long tcno;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = 
										{CascadeType.PERSIST,
										 CascadeType.MERGE})
    @JoinTable(name = "students_courses",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "courseid",
                            nullable = false, updatable = false)})
    private Set<Course> courses = new HashSet<>();
	
	 @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	    @JsonIgnore
	    private List<student_course> student_course = new ArrayList<>();
	    

	public Student() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTcno() {
		return tcno;
	}
	public void setTcno(Long tcno) {
		this.tcno = tcno;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	 public List<student_course> getstudent_course() {
	        return student_course;
	    }
	

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public boolean hasCourse(Course course) {
		for (Course studentCourse: getCourses()) {
			if (studentCourse.getCourseid() == course.getCourseid()) {
				return true;
			}
		}
		return false;
	}	

	public Student(String firstName, String lastName, String email,Long tcno) {
		super(); 
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tcno=tcno;
	}	
	public Student(String firstName, String lastName, String email,Long tcno,Set<Course> courses) {
		super(); 
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tcno=tcno;
		this.courses=courses;
	}	
	public void addCourse(Course course) {
		this.courses.add(course);
		course.getStudents().add(this);
	}
	//-----------------------------------------------------------------------------------------------------
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = 
		{CascadeType.PERSIST,
		 CascadeType.MERGE})
@JoinTable(name = "students_grades",
joinColumns = {
@JoinColumn(name = "student_id", referencedColumnName = "id",
nullable = false, updatable = false)},
inverseJoinColumns = {
@JoinColumn(name = "grade_id", referencedColumnName = "gradeid",
nullable = false, updatable = false)})
private Set<Grade> grades = new HashSet<>();


	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	public void addGrade(Grade grade) {
		this.grades.add(grade);
		grade.getStudents().add(this);
	}
	public boolean hasGrade(Grade grade) {
		for (Grade grades: getGrades()) {
			if (grades.getId() == grade.getId()) {
				return true;
			}
		}
		return false;
	}	

	public Student(Long id, String firstName, String lastName, String email, Long tcno, Set<Course> courses,
			Set<Grade> grades) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tcno = tcno;
		this.courses = courses;
		this.grades = grades;
	}

	
	
	 
}
