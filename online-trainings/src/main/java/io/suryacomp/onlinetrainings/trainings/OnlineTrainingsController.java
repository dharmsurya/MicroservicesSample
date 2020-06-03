package io.suryacomp.onlinetrainings.trainings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.suryacomp.onlinetrainings.model.Topic;
import io.suryacomp.onlinetrainings.model.Course;

@RestController
@RequestMapping("/api")
public class OnlineTrainingsController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/trainings")
	public List<Course> getAllTopicCourses() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response,
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		
		List<Course> courses = new ArrayList<>();
		ResponseEntity<Topic[]> topicBody = restTemplate.getForEntity("http://localhost:8080/api/topics",
				Topic[].class);
		
		
		for (Topic topic : topicBody.getBody()) {
			System.out.println("Topic: "+topic);
			ResponseEntity<Course[]> courseBody =restTemplate.getForEntity("http://localhost:8080/api/topics/" + topic.getId()+"/courses", Course[].class);
			for (Course course: courseBody.getBody()) {
				System.out.println("course: "+course);
				courses.add(course);
				
			}
		}
		
		
		
		return courses;
	}

	/*
	 * public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
	 * 
	 * UserRating userRating =
	 * restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" +
	 * userId, UserRating.class);
	 * 
	 * return userRating.getRatings().stream().map(rating -> { Movie movie =
	 * restTemplate.getForObject("http://movie-info-service/movies/" +
	 * rating.getMovieId(), Movie.class); return new CatalogItem(movie.getName(),
	 * movie.getDescription(), rating.getRating()); }).collect(Collectors.toList());
	 * 
	 * }
	 */

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}
}
