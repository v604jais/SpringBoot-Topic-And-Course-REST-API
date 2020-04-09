package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    
	@Autowired
    private CourseRepository courseRepository;
	
	

	public List<Course> getAllcourses(String topicId ) {
		
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
		
	}

	public Optional<Course> getCourse(String id) {
		
		return courseRepository.findById(id);
	}

	public void addCourse(Course courses) {
		
		
		courseRepository.save(courses);
		
		
	}

	public void updateCourse(Course courses) {
		
		courseRepository.save(courses);
		
	}

	public void deleteCourse(String id) {
		
		courseRepository.deleteById(id);
		
	}
	
	

}
