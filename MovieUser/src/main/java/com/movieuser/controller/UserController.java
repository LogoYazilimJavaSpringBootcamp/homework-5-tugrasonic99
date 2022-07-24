package com.movieuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieuser.helper.CredHelper;
import com.movieuser.helper.MembershipHelper;
import com.movieuser.model.Email;
import com.movieuser.model.Movie;
import com.movieuser.model.User;
import com.movieuser.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {// User fonksiyonlarını çalıştıracağımız controller.
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public void create(@RequestBody User userRequest) { // User yaratma.
		userService.createUser(userRequest);
		
	}
	
	
	@PostMapping(value = "/login")
	public User login(@RequestBody CredHelper helper) {// Login işlemi, CredHelper sınıfı ile gerçekleştirilecek.
		return userService.login(helper.getId(), helper.getName(), helper.getPassword());
		
	}
	
	@PostMapping(value = "/change")
	public void changeCredentials(@RequestBody CredHelper helper) {// İsim, şifre değişimi, CredHelper sınıfı ile gerçekleştirilecek.
		userService.setCredentials(helper.getId(), helper.getName(), helper.getPassword());
		
	}
	
	@GetMapping(value="/usermovies")
	public List<Movie> userMovies(@RequestBody CredHelper helper){// Kulanıcı filmleri,  CredHelper sınıfı ile gerçekleştirilecek.
		return userService.getMoviesByUser(helper.getId());
	}
	
	@GetMapping(value="/useremails")
	public List<Email> userEmails(@RequestBody CredHelper helper){// Kulanıcı emailleri,  CredHelper sınıfı ile gerçekleştirilecek.
		return userService.getEmailsByUser(helper.getId());
	}
	
	@PostMapping(value="/changemembership")
    public void changeMembership(@RequestBody MembershipHelper helper) {// Üyelik değiştirme, MembershipHelper sınıfı ile gerçekleştirilecek.
		userService.changeMembership(helper);
		
	}

}
