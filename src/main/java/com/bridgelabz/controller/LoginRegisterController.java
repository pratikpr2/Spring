package com.bridgelabz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;
import com.bridgelabz.util.Utility;

@RestController
@RequestMapping("/LoginRegister")

@SuppressWarnings({ "rawtypes", "unchecked" })
public class LoginRegisterController {

	public static final Logger logger =  LoggerFactory.getLogger(LoginRegisterController.class);
	
	@Autowired
	UserService userService;
	
	//--------------------User Login-------------------------------
	
	
	@RequestMapping(value="/login/", method =RequestMethod.POST)
	
	public ResponseEntity<String> login(@RequestBody User checkuser){
		logger.info("Logging User : {}",checkuser);
		
		User user = userService.login(checkuser.getEmail(), checkuser.getPassword());
		
		if(user==null) {
			logger.error("User with email {} not found.",checkuser.getEmail());
			
			return new ResponseEntity(new Utility("User with email"+ checkuser.getEmail()+"not Found"),HttpStatus.NOT_FOUND);
		}
		
		String message = "Hello "+ user.getUserName()+ "ID: "+ user.getUserId()+"Email: "+user.getEmail()+"Contact Number: "+ user.getContactNumber();
	
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	//-------------------User Registration----------------------------
	@RequestMapping(value="/register/",method = RequestMethod.POST)
	
	public ResponseEntity<String> register(@RequestBody User regUser){
		
		logger.info("Regster User : {}" ,regUser);
		
		boolean registered = userService.register(regUser);
		
		if(!registered) {
			logger.error("User with email {} already present"+ regUser.getEmail());
			return new ResponseEntity(new Utility("User with Email: "+ regUser.getEmail()+" already Present"),HttpStatus.CONFLICT);
		}
		
		logger.info("User registered with : {}",regUser.getEmail());
		String message = " Successfully Registered";
		
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
}
