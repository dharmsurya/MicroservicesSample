package io.suryacomp.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRep;
	
	/*
	 * private List<Topic> topics = new ArrayList<Topic>( Arrays.asList(new
	 * Topic("Spring", "Spring Framework", "Spring Framework Desciption"), new
	 * Topic("Java", "Core Java", "Core Java Desciption"), new Topic("javascript",
	 * "JavaScript", "Javascript Desciption")));
	 */

	public List<Topic> getAllTopics() {
		List<Topic> topics=new ArrayList<>();
		
		topicRep.findAll()
		.forEach(topics::add);
		
		return topics;
	}

	public Optional<Topic> getTopicById(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return topicRep.findById(id);
	}

	public void addTopic(Topic topic) {
		
		//topics.add(topic);
		
		topicRep.save(topic);

	}

	@SuppressWarnings("unlikely-arg-type")
	public void updateTopic(Topic topic, String id) {

		/*
		 * for (Topic inTopic : topics) { if (inTopic.getId().equals(id)) {
		 * inTopic.setName(topic.getName());
		 * inTopic.setDescription(topic.getDescription()); } }
		 */

		/*
		 * for(Topic inTopic:topics) { if(inTopic.getId().equals(id)) {
		 * topics.set(topics.indexOf(id), topic); } }
		 */
		
		topicRep.save(topic);
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRep.deleteById(id);
	}
}
