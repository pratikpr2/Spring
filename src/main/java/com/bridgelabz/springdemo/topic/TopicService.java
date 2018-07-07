package com.bridgelabz.springdemo.topic;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics=new LinkedList<>();
	
	public List<Topic> getalltopics() {
		topics.add(new Topic("java","spring","Framework"));
		topics.add(new Topic("python","django","Framework"));
		
		return topics;
	}

	public Topic gettopic(String id) {
		// TODO Auto-generated method stub
	 return	topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addtopic(Topic topic) {
		// TODO Auto-generated method stub
		topics.add(topic);
	}

	public void updatetopic(String id,Topic topic) {
		// TODO Auto-generated method stub
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
		
		
	}

	public void deletetopic(String id) {
		// TODO Auto-generated method stub
		topics.removeIf(t -> t.getId().equals(id));
	}
	
}
