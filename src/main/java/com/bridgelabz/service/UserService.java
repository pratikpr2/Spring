package com.bridgelabz.service;

import org.springframework.stereotype.Repository;

import com.bridgelabz.model.User;

@Repository
public interface UserService {

	
	public User login(String emailId, String password);
	public boolean register(User user);
	
}
