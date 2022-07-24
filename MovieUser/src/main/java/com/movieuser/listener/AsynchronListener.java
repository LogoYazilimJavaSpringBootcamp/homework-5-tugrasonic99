package com.movieuser.listener;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.movieuser.dto.AsynchronDTO;
import com.movieuser.model.Email;
import com.movieuser.model.Movie;
import com.movieuser.model.User;
import com.movieuser.repository.UserRepository;



public class AsynchronListener {// RabbitMQ queue'sundan gelen değerleri yerleştirmek üzere tasarlanan sınıftır.
	
	@Autowired
	private UserRepository userRepository;

	@RabbitListener(queues = "movie.exchange")
	public void asynchronListener(AsynchronDTO asynchronDTO) throws Exception {// Yeni film ile alakalı email ve id bilgilerini içeren queue değerlerini dinler.
		// Değerler yeni email objesinde tanınır.
		Email newEmail=new Email();
		newEmail.setSender(asynchronDTO.getMailSender());
		newEmail.setContext(asynchronDTO.getMailContext());
		
		List<User> userList=userRepository.findAll();
		
		for(User u: userList) {// Herkese yeni film ile alakalı mail gönderir.
			newEmail.setReceiver(u.getEmail());
			List<Email> holderList=u.getReceivedEmails();
			holderList.add(newEmail);
			u.setReceivedEmails(holderList);
			userRepository.save(u);
		}
		
		
		// Film, filmi ekleyen kullanıcının film listesine eklenir.
		User u=userRepository.findById(asynchronDTO.getAddedBy()).get();
		
		
	
		Movie movie=new Movie();
		movie.setAddedBy(u.getFullName());
		movie.setMovieName(asynchronDTO.getMovieName());
		List<Movie> holderList=u.getSubmittedMovies();
		holderList.add(movie);
		u.setSubmittedMovies(holderList);
		int movieCount=u.getMovieCount();
		movieCount++;
		u.setMovieCount(movieCount);
		userRepository.save(u);
		
		
		
	
	}

}
