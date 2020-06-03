package io.suryacomp.springbootquickstart.apicourse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import io.suryacomp.springbootquickstart.courses.CourseController;
import io.suryacomp.springbootquickstart.topic.Topic;
import io.suryacomp.springbootquickstart.topic.TopicController;
import io.suryacomp.springbootquickstart.topic.TopicService;
import io.swagger.annotations.ApiOperation;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = "application.yml")
@AutoConfigureMockMvc
@ComponentScan
//@WebMvcTest
public class ApicourseApplicationTests {

	@Autowired
	private TopicController controller;
	/*
	 * @Autowired private CourseController courseContoller;
	 * 
	 * @Autowired private TopicService topicService;
	 */

	/*
	 * @RequestMapping("/topics")
	 * 
	 * @ApiOperation(value="Get all the available topics",
	 * notes="No arguments required for calling this method", response = List.class)
	 * public List<Topic> getAllTopics() { return topicService.getAllTopics(); }
	 */
	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void topicsShouldReturnDefaultTopics() throws Exception {
		System.out.println(this.restTemplate.getForObject("http://localhost:" + port + "/api/topics", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/topics", String.class))
				.contains("[]");
		// } //
		// .contains("{\"id\":\"Java\",\"name\":\"Java topic
		// details\",\"description\":\"Java description\"}");
	}

	/*
	 * @Autowired private MockMvc mockMvc;
	 * 
	 * @Test public void shouldReturnDefaultMessage() throws Exception {
	 * this.mockMvc.perform(get("http://localhost:8080/api/topics")).andDo(print()).
	 * andExpect(status().isOk()) .andExpect(content().string(containsString(
	 * "{\"id\":\"Java\",\"name\":\"Java Language\",\"description\":\"Java Description\"}"
	 * ))); }
	 */
}
