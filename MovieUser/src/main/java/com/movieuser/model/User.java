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
public class User {// Kullanıcı sınıfı. isim, email ve şifre değerleri dışında üyelik sınıfı, gelen emailler ve girilen filmleri de içerecek.
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	@Column
	private String fullName;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String membershipType;// Switch case ile 2 durum olacak şekilde tasarlandı. 1:"Free",2"Paid".
	@Column
	private int membershipTime;// Switch case ile 0-3-6-9-12 ay olacak şekilde hazırlandı
	@Column
	private int movieCount;// Film sayısı kullanıcının üyelik tipine göre film eklemede yardımcı olacak.
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "email_id", insertable = true, updatable = false)
	private List<Email> receivedEmails;// Kullanıcı emailleri.
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_id", insertable = true, updatable = false)
	private List<Movie> submittedMovies;// Kullanıcının eklediği filmler.
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
	
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipTime(int option) {
		switch (option) {
		  case 1:
		    membershipTime=3;
		    break;
		  case 2:
			membershipTime=6;
		    break;
		  case 3:
			membershipTime=9;
			break;
		  case 4:
			membershipTime=12;
			break;
		  case 5:
			membershipTime=0;
			break;
		  default:
		    System.out.println("No applicable value");
		}
	}
	public int getMembershipTime() {
		return membershipTime;
	}
	public void setMembershipType(int option) {
		switch (option) {
		  case 1:
		    membershipType="Free";
		    break;
		  case 2:
			membershipType="Paid";
		    break;
		  default:
		    System.out.println("No applicable value");
		}
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
	public int getMovieCount() {
		return movieCount;
	}
	public void setMovieCount(int movieCount) {
		this.movieCount = movieCount;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
