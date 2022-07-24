package com.movieuser.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.movieuser.helper.MembershipHelper;
import com.movieuser.model.Email;
import com.movieuser.model.Movie;
import com.movieuser.model.User;
import com.movieuser.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserService {
	

	
	@Autowired
	private UserRepository userRepository;
	
	
	public void createUser(User u){// Kullanıcı yaratımında kullanılır. Liste değerleri boş, membership değerleri Free ve 0 olmak üzere uygulanır.
		
		
		List<Email> userEmailList=new ArrayList<Email>();
		u.setReceivedEmails(userEmailList);
		u.setSubmittedMovies(new ArrayList<Movie>());
		u.setMembershipTime(5);
		u.setMembershipType(1);
		u.setMovieCount(0);
		
		String pass=u.getPassword();// Şifre SHA-256 ya uyacak şekilde depolanır.
		String sha256Pass = Hashing.sha256()
				  .hashString(pass, StandardCharsets.UTF_8)
				  .toString();
		u.setPassword(sha256Pass);
		
		userRepository.save(u);
	}
	
	public List<User> getAllUsers(){// Tüm kullanıcıları çekmek.
		return userRepository.findAll();
	}
	
	public List<Movie> getMoviesByUser(int id){// Kullanıcının girdiği filmeri çekmek.
		User user=userRepository.findById(id).get();
		return user.getSubmittedMovies();
	}
	
	public List<Email> getEmailsByUser(int id){// Kullanıcıya gelen emailleri çekmek.
		User user=userRepository.findById(id).get();
		return user.getReceivedEmails();
	}
	
	
	public void setCredentials(int id,String name, String password) {// Verilen değerlerle yeni isim ve şifre girmek.
		User user=userRepository.findById(id).get();
		user.setFullName(name);
		String sha256Pass = Hashing.sha256()
				  .hashString(password, StandardCharsets.UTF_8)
				  .toString();
		user.setPassword(sha256Pass);
		userRepository.save(user);
		log.info(id+" "+user.getFullName()+" "+user.getPassword());
		
	}
	
	public User login(int id,String name, String password) {// Login işlemi.
		User user=userRepository.findById(id).get();
		String sha256Pass = Hashing.sha256()
				  .hashString(password, StandardCharsets.UTF_8)
				  .toString();
		if(name.equals(user.getFullName())&&sha256Pass.equals(user.getPassword())) {
			log.info("Success");
			return user;
		}
		else {
			log.info("Fail");
			return null;
		}
	}
	
	
	public void changeMembership(MembershipHelper helper) {// Membership değiştirme.
		User user=userRepository.findById(helper.getId()).get();
		user.setMembershipTime(helper.getMembershipTime());
		user.setMembershipType(helper.getMembershipType());
		userRepository.save(user);
		log.info("Success");
	}
	
	
	

}
