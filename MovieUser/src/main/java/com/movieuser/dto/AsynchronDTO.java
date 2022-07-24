package com.movieuser.dto;

public class AsynchronDTO {// Bu sınıfla RabbitMQ görüşmeleri taşınacak. Asenkron olarak gerçekleşecek.
	
	// Her kullanıcıya mail gidebilmesi adına mail bilgileri taşınacak
	private String mailSender;
	private String mailContext;
	private String mailReceiver;
	// Girilen filmin giren kullanıcının girilen film listesine girebilmesi adına bu bilgiler de taşınacak.
	private String movieName;
	private int addedBy;
	
	public AsynchronDTO(String moviename,int addedBy) {// Bazı default değerler tanımlanmalı.
		mailSender="MovieHome@mail.com";// Default değer. Herkese aynı yerden email gidecek.
		mailContext="Movie "+moviename+" is added";// // Film adına içerik.
		mailReceiver="";// Bu değer maili alana göre tanımlanacak.
		this.movieName=moviename;
		this.addedBy=addedBy;
	}
	
	
	public String getMailSender() {
		return mailSender;
	}
	public void setMailSender(String mailSender) {
		this.mailSender = mailSender;
	}
	public String getMailContext() {
		return mailContext;
	}
	public void setMailContext(String mailContext) {
		this.mailContext = mailContext;
	}
	public String getMailReceiver() {
		return mailReceiver;
	}
	public void setMailReceiver(String mailReceiver) {
		this.mailReceiver = mailReceiver;
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
	
	
	

}
