package com.movieuser.helper;

public class MembershipHelper {// Bu sınıf, Membership işlemlerinde Rest üzerinden JSON ile değerleri alıp manipulasyonda yardımcı olur.
	
	private int id;
	
	// Bu değerlerin int olması User içerisinde belirtilmiştir.
	private int membershipType;
	private int membershipTime;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(int membershipType) {
		this.membershipType = membershipType;
	}
	public int getMembershipTime() {
		return membershipTime;
	}
	public void setMembershipTime(int membershipTime) {
		this.membershipTime = membershipTime;
	}
	
	

}
