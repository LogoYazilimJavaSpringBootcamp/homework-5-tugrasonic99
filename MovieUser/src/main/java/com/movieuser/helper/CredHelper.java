package com.movieuser.helper;

public class CredHelper {// Bu sınıf, User üzerinde manipulasyon yapmak adına kullanacağımız değerleri JSON olarak Rest üzerinden okumamızı sağlar.
	
	private int id;
	private String name;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
