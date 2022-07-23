package com.movieuser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.movieuser.enums.MemberTypeEnum;

@Entity
public class Membership {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Enumerated(EnumType.STRING)
	private MemberTypeEnum memberTypeEnum;
	@Column
	private int membershipTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MemberTypeEnum getMemberTypeEnum() {
		return memberTypeEnum;
	}
	public void setMemberTypeEnum(MemberTypeEnum memberTypeEnum) {
		this.memberTypeEnum = memberTypeEnum;
	}
	public int getMembershipTime() {
		return membershipTime;
	}
	public void setMembershipTime(int membershipTime) {
		this.membershipTime = membershipTime;
	}
	
	
	

}
