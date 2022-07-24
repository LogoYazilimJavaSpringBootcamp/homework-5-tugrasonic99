package com.moviehome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviehome.helper.MovieHelper;
import com.moviehome.model.Movie;
import com.moviehome.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {// Movie fonksiyonlarını çalıştıracağımız controller
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping
	public void insertMovie(@RequestBody Movie movie) {// Movie girişi. JSON olarak Movie sınıfı girilmesi gerek.
		movieService.saveMovie(movie);
		
	}
	
	@GetMapping
	public List<Movie> allMovies() {// Tüm filmleri döndürür.
		return movieService.allMovies();
		
	}
	
	@PostMapping(value="/comment")
	public Movie commentMovie(@RequestBody MovieHelper helper) {// MovieHelper sınıfı yardımıyla comment ekleme.
		movieService.commentMovie(helper.getMovieId(), helper.getUserId(), helper.getComment());
		return movieService.findMovie(helper.getMovieId());
	}
	
	@GetMapping(value="/findmovie")
	public Movie findMovie(@RequestBody MovieHelper helper) {// MovieHelper sınıfı yardımıyla film bulma.
		return movieService.findMovie(helper.getMovieId());
	}
	
	@PostMapping(value="/delete")
	public void deleteMovie(@RequestBody MovieHelper helper) {// MovieHelper sınıfı yardımıyla film silme.
		
		movieService.deleteMovie(helper.getMovieId());
	}

}
