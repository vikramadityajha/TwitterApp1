package com.tweetapp;

public class Register {
	
	private String userid;
	private String first_name;
	private String last_name;
	private String gender;
	private String dob;
	private String email;
	private String password;

	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
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
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public Register(String userid, String first_name, String last_name, String gender, String dob, String email,
			String password) {
		super();
		this.userid = userid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}
	
	public Register(String first_name, String last_name, String gender, String dob, String email, String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}
	
	public Register() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Register [userid=" + userid + ", first_name=" + first_name + ", last_name=" + last_name + ", gender="
				+ gender + ", dob=" + dob + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
