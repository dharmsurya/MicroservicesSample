package io.suryacomp.springbootquickstart.apicourse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import io.suryacomp.springbootquickstart.courses.CourseController;
import io.suryacomp.springbootquickstart.topic.TopicController;

@RunWith(SpringRunner.class)
/* @EnableAutoConfiguration */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = "application.yml")
@AutoConfigureMockMvc

//@EnableJpaRepositories
/*
 * @EnableJpaRepositories(considerNestedRepositories = true)
 * 
 * 
 * @EnableTransactionManagement
 * 
 * @ComponentScan
 */
//@EnableJpaRepositories(basePackages = {"io.suryacomp.springbootquickstart"})
//@WebMvcTest
public class ApicourseApplicationTests {

	@Autowired
	private TopicController controller;

	@Autowired
	private CourseController courseContoller;
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
		assertThat(courseContoller).isNotNull();
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
		// .contains("{\"id\":\"Java\",\"name\":\"Java Language\",\"description\":\"Java
		// Description\"}");
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAddTopicService() throws Exception {
		/*
		 * this.mockMvc.perform(get("/api/topics")).andDo(print()).andExpect(status().
		 * isOk()) .andExpect(content().string(containsString("[]")))
		 * 
		 * ;
		 */

		// topic=topic==null?"{\"id\":\"Java\",\"name\":\"Java
		// Language\",\"description\":\"Java Description\"}":topic;
		/*
		 * Topic topic1=new Topic(); topic1.setId("Java9");
		 * topic1.setName("Java9 Name"); topic1.setDescription("Java9 Desc");
		 * ObjectMapper objectMapper=new ObjectMapper();
		 */
		// objectMapper.
		this.mockMvc
				.perform(post("/api/topics").contentType(MediaType.APPLICATION_JSON)
						.content("{\"id\":\"Java\",\"name\":\"Java Language\",\"description\":\"Java Description\"}"))
				.andDo(print()).andExpect(status().isOk());

		this.mockMvc
				.perform(post("/api/topics").contentType(MediaType.APPLICATION_JSON).content(
						"{\"id\":\"Spring\",\"name\":\"Spring Framework\",\"description\":\"Spring Description\"}"))
				.andDo(print()).andExpect(status().isOk());

		/*
		 * this.mockMvc.perform(get("/api/topics/").contentType(MediaType.
		 * APPLICATION_JSON)).andDo(print())
		 * .andExpect(status().isOk()).andExpect(content().string(containsString(
		 * "[{\"id\":\"Java\",\"name\":\"Java Language\",\"description\":\"Java Description\"},{\"id\":\"Spring\",\"name\":\"Spring Framework\",\"description\":\"Spring Description\"}]"
		 * )));
		 */
	}

	@Test
	public void testAddCoursesService() throws Exception {
		this.mockMvc.perform(post("/api/topics/Java/courses").contentType(MediaType.APPLICATION_JSON).content(
				"{\"id\": \"Java8\", \"name\": \"Java 8 Streams\",\"description\": \"Java 8 Streams Description\"}"))
				.andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(post("/api/topics/Java/courses").contentType(MediaType.APPLICATION_JSON).content(
				"{\"id\": \"Java8 lamdas\",\"name\": \"Java 8 Lamdas\",\"description\": \"Java 8 Functional Pgrmnig Description\"}"))
				.andDo(print()).andExpect(status().isOk());

		this.mockMvc.perform(post("/api/topics/Spring/courses").contentType(MediaType.APPLICATION_JSON).content(
				"{\"id\": \"Spring cloud\",\"name\": \"Spring cloud Framework\",\"description\": \"Spring cloud Description\"}"))
				.andDo(print()).andExpect(status().isOk());

		/*
		 * this.mockMvc.perform(get("/api/topics/Java/courses").contentType(MediaType.
		 * APPLICATION_JSON)).andDo(print())
		 * .andExpect(status().isOk()).andExpect(content().string(containsString(
		 * "[{\"id\":\"Java8\",\"name\":\"Java 8 Streams\",\"description\":\"Java 8 Streams Description\",\"topic\":{\"id\":\"Java\",\"name\":\"Java Language\",\"description\":\"Java Description\"}},{\"id\":\"Java8 lamdas\",\"name\":\"Java 8 Lamdas\",\"description\":\"Java 8 Functional Pgrmnig Description\",\"topic\":{\"id\":\"Java\",\"name\":\"Java Language\",\"description\":\"Java Description\"}}]"
		 * )));
		 */
		/*
		 * this.mockMvc.perform(get("/api/topics/Spring/courses").contentType(MediaType.
		 * APPLICATION_JSON)).andDo(print())
		 * .andExpect(status().isOk()).andExpect(content().string(containsString(
		 * "[{\"id\":\"Spring cloud\",\"name\":\"Spring cloud Framework\",\"description\":\"Spring cloud Description\",\"topic\":{\"id\":\"Spring\",\"name\":\"Spring Framework\",\"description\":\"Spring Description\"}}]"
		 * )));
		 */
	}

	@Test
	public void testGetAllTopics() throws Exception {
		this.testAddTopicService();
		this.mockMvc.perform(get("/api/topics/").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(containsString(
						"[{\"id\":\"Java\",\"name\":\"Java Language\",\"description\":\"Java Description\"},{\"id\":\"Spring\",\"name\":\"Spring Framework\",\"description\":\"Spring Description\"}]")));
	}

	@Test
	public void testGetAllCoursesForTopic1() throws Exception {
		this.testAddCoursesService();
		this.mockMvc.perform(get("/api/topics/Java/courses").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(containsString(
						"[{\"id\":\"Java8\",\"name\":\"Java 8 Streams\",\"description\":\"Java 8 Streams Description\",\"topic\":{\"id\":\"Java\",\"name\":\"Java Language\",\"description\":\"Java Description\"}},{\"id\":\"Java8 lamdas\",\"name\":\"Java 8 Lamdas\",\"description\":\"Java 8 Functional Pgrmnig Description\",\"topic\":{\"id\":\"Java\",\"name\":\"Java Language\",\"description\":\"Java Description\"}}]")));

	}

	@Test
	public void testGetAllCoursesForTopic2() throws Exception {
		this.testAddCoursesService();
		this.mockMvc.perform(get("/api/topics/Spring/courses").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(containsString(
						"[{\"id\":\"Spring cloud\",\"name\":\"Spring cloud Framework\",\"description\":\"Spring cloud Description\",\"topic\":{\"id\":\"Spring\",\"name\":\"Spring Framework\",\"description\":\"Spring Description\"}}]")));

	}

}
