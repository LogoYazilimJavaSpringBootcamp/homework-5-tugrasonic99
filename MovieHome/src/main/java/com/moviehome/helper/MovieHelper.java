package com.moviehome.helper;

public class MovieHelper {// Bu sınıf controllerda Movie sınıfı için gereken verileri tutabilecek bir JSON olması için tasarlandı.
	
	private int movieId;
	private int userId;
	private String comment;
	
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
