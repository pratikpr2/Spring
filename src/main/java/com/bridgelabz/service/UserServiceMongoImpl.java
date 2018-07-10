package com.bridgelabz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.User;
import com.bridgelabz.repository.UserMongoRepository;

@Repository
@Component(value="mongodb")
public class UserServiceMongoImpl implements UserService {

	@Autowired
	UserMongoRepository userRepository;
	
	@Override
	public User login(String emailId, String password) {
		// TODO Auto-generated method stub
		
		
		Optional<User> user = userRepository.findById(emailId);
		if(user!=null) {
			if(user.get().getPassword().equals(password)) {
				User loginuser =new User();
				loginuser.setUserId(user.get().getUserId());
				loginuser.setUserName(user.get().getUserName());
				loginuser.setEmail(user.get().getEmail());
				loginuser.setContactNumber(user.get().getContactNumber());
				loginuser.setPassword(user.get().getPassword());
			
				return loginuser;
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
	//	UserMongoRepository userRepository;
		Optional<User> checkuser = userRepository.findById(user.getEmail());
		
		if(checkuser.isPresent()) {
			return false;
		}
		else {
			userRepository.save(user);
			return true;
		}
		
	}

}
