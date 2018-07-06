package com.bridgelabz.springdemo.topic;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	private List<Topic> list;
	
	@Autowired
	private TopicService topicservice;
	
	
	
}
