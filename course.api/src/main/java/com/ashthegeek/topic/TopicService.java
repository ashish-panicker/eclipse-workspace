package com.ashthegeek.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

//business service is a singleton service object
@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("CS", "C#", "C#.NET course"),
			new Topic("JV", "Java", "Java 8 course"),
			new Topic("SP", "Spring Boot", "Spring Boot course"),
			new Topic("HB", "Hibernate", "hibernate ORM mapping course"),
			new Topic("JS", "Javascript", "Javascript course")
		
		));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		System.err.println("ID = " + id);
		for(int i = 0; i < topics.size();i++) {
			Topic t = topics.get(i);
			
			if(t.getId().equalsIgnoreCase(id)) {
				System.err.println(t.getId());
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		
	}
}


















