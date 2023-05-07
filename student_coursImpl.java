package com.example.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.sms.entity.student_course;
import com.example.sms.repository.student_courseRepository;
import com.example.sms.service.student_courseService;

@Service
public class student_coursImpl implements student_courseService{
	private student_courseRepository student_courseRepository;

	public student_coursImpl(com.example.sms.repository.student_courseRepository student_courseRepository) {
		super();
		this.student_courseRepository = student_courseRepository;
	}

	@Override
	public List<student_course> getAllStudentCourses() {
	
		return null;
	}

	
	@Override
	public student_course savestudentCourse(student_course student_course) {
		
			return student_courseRepository.save(student_course);
	}

	@Override
	public student_course getstudentCourseById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public student_course updatestgudentCourse(student_course student_course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudentCourseById(Long id) {
		// TODO Auto-generated method stub
		
	}}
