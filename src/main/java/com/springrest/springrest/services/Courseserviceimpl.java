package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entity.Course;


 @Service
public class Courseserviceimpl implements Courseservice {
	 @Autowired
	 private com.springrest.springrest.dao.Coursedao coursedao;
	
	List<Course> list;
	
	
	public Courseserviceimpl() {
//		list = new ArrayList<>();
//		list.add(new Course(1,"java","this is the basic one"));
//		list.add(new Course(2,"spring","learn rest  api with nikhil"));
//		
		
		
		
	}


	@Override
	public List<Course> getcourses() {
		// TODO Auto-generated method stub
		return coursedao.findAll();
	}


	@Override
	public Course getcourse(Long CourseId) 
	{
//		Course c = null;
//		for (Course course:list)
//		{
//			if (course.getId()==CourseId)
//			{
//				c=course;
//				break;
//			}	
//		}	
		
		return coursedao.getById(CourseId);
	}


	@Override
	public Course addcourse(Course course) {
		//list.add(course);
		coursedao.save(course);
		return course;
	}


	@Override
	public Course deletecourse(long CourseId)
	{
//		Course c= null;
//		for (Course course:list)
//		{
//			if(course.getId()==CourseId)
//			{
//				c=course;
//				list.remove(c);
//			}
//		}
		Course entity = coursedao.getById(CourseId);
		coursedao.delete(entity);
		return entity;
	}


	@Override
	public Course updatecourse(Course course) {
//		list.forEach(e-> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDesc(course.getDesc());
//			}
//		}); 
		coursedao.save(course);
		
		return course;
	}
	
	

}
