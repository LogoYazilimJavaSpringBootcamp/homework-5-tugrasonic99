package com.movieuser.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	@Column
	private String fullName;
	@Column
	private String email;
	@Column
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id", insertable = true, updatable = false)
	private Membership membership;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "email_id", insertable = true, updatable = false)
	private List<Email> receivedEmails;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_id", insertable = true, updatable = false)
	private List<Movie> submittedMovies;
	// Ana fonksiyonlar:
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Membership getMembership() {
		return membership;
	}
	public void setMembership(Membership membership) {
		this.membership = membership;
	}
	public List<Email> getReceivedEmails() {
		return receivedEmails;
	}
	public void setReceivedEmails(List<Email> receivedEmails) {
		this.receivedEmails = receivedEmails;
	}
	public List<Movie> getSubmittedMovies() {
		return submittedMovies;
	}
	public void setSubmittedMovies(List<Movie> submittedMovies) {
		this.submittedMovies = submittedMovies;
	}
	
	
	
	
	
	
	
	
	
	

}
