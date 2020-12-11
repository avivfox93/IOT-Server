package org.aei.iotserver.restController;

import org.aei.iotserver.boundary.UserBoundary;
import org.aei.iotserver.dal.UserDao;
import org.aei.iotserver.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(
			value = "/api/signup",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public void signup(@RequestBody UserBoundary userBoundary) {
		User userDetails = null;
		try {
			userDetails = userDao.findByName(userBoundary.getUsername());
		}catch(Exception e) {
			
		}
		if(userDetails != null)
			throw new RuntimeException("Username already taken!");
		userDao.save(new User(userBoundary.getUsername(),new BCryptPasswordEncoder().encode(userBoundary.getPassword())));
	}
	
	@RequestMapping(
			value = "/api/stam",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public void login(@RequestBody UserBoundary userBoundary) {
		User userDetails = userDao.findByName(userBoundary.getUsername());
		if(userDetails == null)
			throw new RuntimeException("Login failed");
		
	}
}
