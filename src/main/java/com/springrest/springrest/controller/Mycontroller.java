package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.services.Courseservice;



@RestController
public class Mycontroller {
	@Autowired
	private Courseservice courseservice;
	
	@GetMapping("/home")
	public String home() 
	{
		return "this is homepage";
	}
	
	
	// get courses
	@GetMapping("/courses")
	public List<Course> getcourses()
	{
		return this.courseservice.getcourses();
	}
	
	
	//get course by id
	@GetMapping("/courses/{courseId}")
	public Course getcourse(@PathVariable String courseId)
	{
		return this.courseservice.getcourse(Long.parseLong(courseId));
	}
	
	//add course
	@PostMapping(path="/courses",consumes="application/json")
	public Course addcourse(@RequestBody Course course)
	{
		return this.courseservice.addcourse(course);
	}
	
	//delete course
	@DeleteMapping("/courses/{CourseId}")
	public ResponseEntity<HttpStatus> deletecourse(@PathVariable String CourseId)
	{   try
		{
		 this.courseservice.deletecourse(Long.parseLong(CourseId));
		 return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	//Update course
	@PutMapping("/courses")
	public Course updatecourse(@RequestBody Course course) 
	{
		return this.courseservice.updatecourse(course);
	}
	

}
