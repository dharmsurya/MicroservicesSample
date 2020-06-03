package io.suryacomp.springbootquickstart.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	/*
	 * private List<Topic> topics = new ArrayList<Topic>( Arrays.asList(new
	 * Topic("Spring", "Spring Framework", "Spring Framework Desciption"), new
	 * Topic("Java", "Core Java", "Core Java Desciption"), new Topic("javascript",
	 * "JavaScript", "Javascript Desciption")));
	 */

	public List<Course> getAllCourses(String topicId) {
		List<Course> courses=new ArrayList<>();
		courseRepo.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}

	public Optional<Course> getCourseById(String id) {
		return courseRepo.findById(id);
	}

	public void addCourse(Course course) {
		courseRepo.save(course);

	}

	public void updateCourse(Course course) {
		courseRepo.save(course);
	}

	public void deleteTopic(String id) {
		courseRepo.deleteById(id);
	}
}
