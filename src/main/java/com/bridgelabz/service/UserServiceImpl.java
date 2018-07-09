package com.bridgelabz.service;

import org.springframework.stereotype.Repository;

import com.bridgelabz.model.User;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.repository.UserRepositoryImpl;

@Repository
public class UserServiceImpl implements UserService{

	@Override
	public User login(String emailId, String password) {
		// TODO Auto-generated method stub
		UserRepository repository = new UserRepositoryImpl();
		User user = repository.getUser(emailId);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		UserRepository repository = new UserRepositoryImpl();
		User checkUser = repository.getUser(user.getEmail());
		if(checkUser != null) {
			return false;
		}
		else {
			repository.regUser(user);
			return true;
		}
	}

}
