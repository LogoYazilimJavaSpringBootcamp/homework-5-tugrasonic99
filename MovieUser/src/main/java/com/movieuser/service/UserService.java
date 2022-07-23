package com.movieuser.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieuser.model.Email;
import com.movieuser.model.Membership;
import com.movieuser.model.Movie;
import com.movieuser.model.User;
import com.movieuser.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void createUser(User u) {
		
		u.setMembership(new Membership());
		List<Email> userEmailList=new ArrayList<Email>();
		Email e=new Email();
		e.setReceiver("12");
		e.setSender("1213");
		e.setContext("24214");
		userEmailList.add(e);
		u.setReceivedEmails(userEmailList);
		u.setSubmittedMovies(new ArrayList<Movie>());
		userRepository.save(u);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	

}
