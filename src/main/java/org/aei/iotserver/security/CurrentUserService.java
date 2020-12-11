package org.aei.iotserver.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService {
	public String getCurrentUsername() {
		UserDetails userDetails = (UserDetails) 
				SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();
		return userDetails.getUsername();
	}
	
	public String getCurrentPassword() {
		UserDetails userDetails = (UserDetails) 
				SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();
		return userDetails.getPassword();
	}
}
