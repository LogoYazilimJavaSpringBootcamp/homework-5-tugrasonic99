package com.moviehome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviehome.model.User;
import com.moviehome.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public boolean isUserPresent(int id) {
		return userRepository.userPresent(id);
	}
	
	
	public User findUser(int id) {
		if(userRepository.userPresent(id)==true) {
			return userRepository.findUserSubVer(id);
		}
		else {
			return null;
		}
	}

}
