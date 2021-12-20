package com.appsdeveloperblog.photoapp.api.users.business.abstracts;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appsdeveloperblog.photoapp.api.users.business.dtos.UserDto;

public interface UserService extends UserDetailsService {
		UserDto createUser(UserDto userDto); 
		
		UserDto getUserDetailsByEmail(String email);
}
