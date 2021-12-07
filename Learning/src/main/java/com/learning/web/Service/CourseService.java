package com.learning.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.web.Entity.Course;
import com.learning.web.Repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}
	
	public Course saveCourse(Course course){
		return courseRepo.save(course);
	}
	
	public Course getCourseById(Long id) {
		return courseRepo.findById(id).get();
	}
	
	public Course updateCourse(Course course) {
		return courseRepo.save(course);
	}
	
	public void deleteUserById(Long id) {
		courseRepo.deleteById(id);
	}

}
