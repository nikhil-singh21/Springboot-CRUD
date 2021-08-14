package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entity.Course;



public interface Courseservice {
	
	public List<Course> getcourses();
	
	public Course getcourse(Long CourseId);
	public Course addcourse(Course course);
	public Course deletecourse(long courseId);
	public Course updatecourse(Course course);

}kya ji
