package com.moviehome.model;

import java.util.List;



public class User {// MovieUser'daki versiyonundan nazaran daha az bilgi taşır. Bunun amacı sadece Movie sınıfına gerekli olabilecek bilgilere sahip olmasıdır.
	
	
	private int userId;
	
	private String fullName;
	
	private String email;
	
	private String membershipType;
	
	private int membershipTime;
	
	private int movieCount;

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

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public int getMembershipTime() {
		return membershipTime;
	}

	public void setMembershipTime(int membershipTime) {
		this.membershipTime = membershipTime;
	}

	public int getMovieCount() {
		return movieCount;
	}

	public void setMovieCount(int movieCount) {
		this.movieCount = movieCount;
	}
	
	
	
	
	

}
