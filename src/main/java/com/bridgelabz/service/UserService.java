package com.bridgelabz.service;

import com.bridgelabz.model.User;

public interface UserService {

	
	public User login(String emailId, String password);
	public boolean register(User user);
	
}
