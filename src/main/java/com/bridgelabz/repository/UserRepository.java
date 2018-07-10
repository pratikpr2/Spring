package com.bridgelabz.repository;

import org.springframework.stereotype.Repository;

import com.bridgelabz.model.User;

@Repository
public interface UserRepository {

	public User getUser(String email);
	
	public boolean regUser(User user);
}
