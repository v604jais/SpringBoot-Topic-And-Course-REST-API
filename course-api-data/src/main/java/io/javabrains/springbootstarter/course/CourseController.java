package io.javabrains.springbootstarter.course;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllcourses(@PathVariable String id) {
		return courseService.getAllcourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course courses, @PathVariable String topicId) {
		courses.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(courses);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course courses, @PathVariable String topicId, @PathVariable String id) {
		courses.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(courses);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}