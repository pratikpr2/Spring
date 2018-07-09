package com.bridgelabz.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.User;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.repository.UserRepositoryMongo;

@Repository
@Component(value="mongo")
public class UserServiceMongoImpl implements UserService {

	
	
	@Override
	public User login(String emailId, String password) {
		// TODO Auto-generated method stub
		UserRepository userRepository = new UserRepositoryMongo();
		
		User user = userRepository.getUser(emailId);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
			else
				return null;
		}
		else
			return null;
		
		
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		UserRepository userRepository = new UserRepositoryMongo();
		User checkuser = userRepository.getUser(user.getEmail());
		
		if(checkuser!=null) {
			return false;
		}
		else {
			userRepository.regUser(user);
			return true;
		}
		
	}

}
