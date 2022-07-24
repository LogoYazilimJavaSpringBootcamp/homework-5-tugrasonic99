package com.moviehome.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {// Movie sınıfı. Film ismi, kim tarafından girildiği ve yorumları içerir.
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column
	private String movieName;
	@Column
	private int addedBy;
	@OneToMany
	@JoinColumn(name = "com_id", insertable = true, updatable = false)
	private List<Comment> comments;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
	
 	

}
