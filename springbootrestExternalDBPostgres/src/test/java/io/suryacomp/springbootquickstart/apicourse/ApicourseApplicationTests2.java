package io.suryacomp.springbootquickstart.apicourse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.suryacomp.springbootquickstart.courses.CourseController;
import io.suryacomp.springbootquickstart.topic.Topic;
import io.suryacomp.springbootquickstart.topic.TopicController;
import io.suryacomp.springbootquickstart.topic.TopicService;
import io.swagger.annotations.ApiOperation;

@WebMvcTest(controllers = TopicController.class)
class ApicourseApplicationTests2 {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private TopicService topicService;

  @Test
  void whenValidInput_thenReturns200() throws Exception {
    //mockMvc.perform(...);
  }

}
