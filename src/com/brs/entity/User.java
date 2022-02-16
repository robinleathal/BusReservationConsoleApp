package com.brs.entity;

public class User {
	private int userID;
	private String userName;
	private String fName;
	private String lName;
	private String passWord;
	private String role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userID, String userName, String fName, String lName, String passWord, String role) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.fName = fName;
		this.lName = lName;
		this.passWord = passWord;
		this.role = role;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
