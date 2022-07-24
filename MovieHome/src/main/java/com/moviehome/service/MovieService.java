package com.moviehome.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviehome.dto.AsynchronDTO;
import com.moviehome.model.Comment;
import com.moviehome.model.Movie;
import com.moviehome.model.User;
import com.moviehome.repository.MovieRepository;
import com.moviehome.repository.UserRepository;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void saveMovie(Movie m) {// Film eklemek için kullanılır.
		
		    
			if(userRepository.findUserSubVer(m.getAddedBy()).getMembershipTime()>0) {// Eğer üyelik süresi 0'dan büyükse(ücretli üye), ekleme yapar.
				
				m.setComments(new ArrayList<Comment>());
				movieRepository.save(m);
				log.info("here");
				rabbitTemplate.convertAndSend("movie.exchange", new AsynchronDTO(m.getMovieName(),m.getAddedBy()));// Alınan değerler RabbitMQ ile queue a gönderilir.
			}
			
			else if((userRepository.findUserSubVer(m.getAddedBy()).getMembershipTime()==0)&&(userRepository.findUserSubVer(m.getAddedBy()).getMovieCount()<0)) {
				// Ücretsiz üye ve eklediği film sayısı 3'den az ise ekleme yapar.
				m.setComments(new ArrayList<Comment>());
				movieRepository.save(m);
				rabbitTemplate.convertAndSend("movie.exchange", new AsynchronDTO(m.getMovieName(),m.getAddedBy()));// Alınan değerler RabbitMQ ile queue a gönderilir.
				
			}

		
		
	}
	
	public List<Movie> allMovies(){// Tüm filmleri çeker.
		return movieRepository.findAll();
	}
	
	public void commentMovie(int movieId,int userId, String comment) {// Verilen bir film için yeni yorum oluşturur.
		if(userRepository.userPresent(userId)==true) {
			User u=userRepository.findUserSubVer(userId);
			if(u.getMembershipType().equals("Paid")) {// Ancak eğer üye paralı ise comment oluşturur ve filme ekler.
				Comment c=new Comment();
				c.setComment(comment);
				c.setCommentPoster(u.getFullName());
				Movie m=movieRepository.findById(movieId).get();
				List<Comment> comments=m.getComments();
				comments.add(c);
				m.setComments(comments);
				movieRepository.save(m);
			}
		}
		
		
	}
	
	public Movie findMovie(int movieId) {// id ile film bulma.
		return movieRepository.findById(movieId).get();
		
	}
	
	public void deleteMovie(int movieId) {// id ile film silme.
		movieRepository.deleteById(movieId);
	}

}
