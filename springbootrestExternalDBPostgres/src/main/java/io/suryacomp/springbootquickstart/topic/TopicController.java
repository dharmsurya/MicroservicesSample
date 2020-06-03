package io.suryacomp.springbootquickstart.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	@ApiOperation(value="Get all the available topics",
	notes="No arguments required for calling this method",
	response = List.class)
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	@ApiOperation(value="Get the topic based on the id provided",
	notes="String argument is required for mapping to id",
	response = Topic.class)
	public Optional<Topic> getTopic(@ApiParam(value="Id value of the Topic you are requeting for.",required=true)@PathVariable String id) { //public Topic getTopic(@PathVariable("id") String id)
		return topicService.getTopicById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		//return topicService.getAllTopics();
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		//return topicService.getAllTopics();
		topicService.updateTopic(topic,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		//return topicService.getAllTopics();
		topicService.deleteTopic(id);
	}
}
