package com.example.sms.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.sms.entity.student_course;

@Service
public interface student_courseService {
List<student_course> getAllStudentCourses();
	
	student_course savestudentCourse(student_course student_course);
	
	student_course getstudentCourseById(Long id);
	student_course updatestgudentCourse(student_course student_course);
	
	void deleteStudentCourseById(Long id);


}
