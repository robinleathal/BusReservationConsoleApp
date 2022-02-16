package com.brs.dao;

import java.util.List;

import com.brs.entity.User;

public interface UserDao {
	public void addUsers();
	List<User>viewAllUsers();
	User viewUser(int uId);
	void updateUser(int uId);
	void deleteUser(int uId);
	boolean isAdminUser(String r);
	boolean isUserExist(int uId);

}
