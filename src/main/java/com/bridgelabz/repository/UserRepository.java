package com.bridgelabz.repository;

import com.bridgelabz.model.User;

public interface UserRepository {

	public User getUser(String email);
	
	public boolean regUser(User user);
}
