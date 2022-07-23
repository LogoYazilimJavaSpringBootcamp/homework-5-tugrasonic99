package com.movieuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieuser.model.User;
import com.movieuser.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public void create(@RequestBody User userRequest) {
		userService.createUser(userRequest);
		
	}
	
	
	@GetMapping
	public List<User> getAll() {
		return userService.getAllUsers();
		
	}

}
