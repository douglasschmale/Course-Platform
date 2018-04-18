package com.codingdojo.coursePlatform.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.coursePlatform.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
//	ArrayList<Course> findByName(String name);


}
