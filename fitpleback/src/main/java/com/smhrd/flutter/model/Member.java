package com.smhrd.flutter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_email")
	private long email;
	
	@Column(name="user_password")
	private long password;
	
	@Column(name="user_nick")
	private long nick;
	
	@Column(name="user_name")
	private long name;
	
	@Column(name="gender")
	private long gender;
	
	@Column(name="age")
	private int age;
}
