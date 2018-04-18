package com.codingdojo.coursePlatform.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.coursePlatform.models.Course;
import com.codingdojo.coursePlatform.repositories.CourseRepository;

@Service
public class CourseService {

	private CourseRepository cR;
	
	public CourseService(CourseRepository cR) {
		this.cR = cR;
	}
	
	public void create(Course newCourse) {
		cR.save(newCourse);
	}
	
	public ArrayList<Course> all(){
		return (ArrayList<Course>) cR.findAll();
	}
	
	public Course find(Long id) {
		return cR.findById(id).orElse(null);
	}
	
	//Update
	public void update(Course thisCourse) {
		cR.save(thisCourse);
	}
	
	public void destroy(Course course) {
		cR.delete(course);
	}
}
