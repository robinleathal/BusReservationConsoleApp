package com.brs.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.brs.client.ReservationClient;
import com.brs.dao.UserDao;
import com.brs.entity.User;
import com.brs.services.UserDetails;

public class UserDaoImpl implements UserDao {
	List<User> userList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	UserDetails uDetails = new UserDetails();

	@Override
	public void addUsers() {
		System.out.println("Register a User");
		System.out.println("Enter User ID");
		int id=sc.nextInt();
		System.out.println("Enter Username");
		String uName= sc.next();
		System.out.println("Enter Password");
		String pWord= sc.next();
		System.out.println("Enter First Name");	
		String fName= sc.next();
		System.out.println("Enter Last Name");	
		String lName= sc.next();
		System.out.println("Enter Role");
		String role= sc.next();
		User user = new User(id, uName, fName, lName, pWord, role);
		userList.add(user);
		System.out.println("Role ="+role);
		System.out.println("is it admin ="+isAdminUser(role));
		if (isAdminUser(role)) {
			System.out.println(uName + " Registred Successfully");
			
			
		} else {
			System.out.println("Customer "+uName + " Registred Successfully");
			
			
		}
		ReservationClient.main(null);
	}

	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public User viewUser(int uId) {
		// TODO Auto-generated method stub
		return userList.get(uId);
	}

	@Override
	public void updateUser(int uId) {
		int j =0;
		for (User u : userList) {
			if (u.getUserID() == uId) {
				++j;
				System.out.println("Do You Want to Update a User?");
				System.out.println("1) Username 2) Password, 3) Role 4) First name 5) Last Name");
				int choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter Username");
					u.setUserName(sc.next());//
					System.out.println("Username is updated");
					break;
				case 2:
					System.out.println("Enter Employee Address");
					u.setPassWord(sc.next());
					System.out.println("Password is updated");
					break;
				case 3:
					System.out.println("Enter Role");
					u.setRole(sc.next());
					System.out.println("Username is updated");
					break;
				case 4:
					System.out.println("Enter First name");
					u.setfName(sc.next());
					System.out.println("First name is updated");
					break;
				case 5:
					System.out.println("Enter First name");
					u.setlName(sc.next());
					System.out.println("Last name is updated");
					break;

				default:

					System.out.println("Choose between 1 to 6");
				}
			}
		}


	}

	@Override
	public void deleteUser(int uId) {
		int j =0;
		for (User u: userList) {
			if (u.getUserID()== uId) {
				++j;
				userList.remove(u);
				System.out.println("User is Deleted SuccessFully");
				break;
			}
		}
		if (j==0) {
			System.out.println("User Doest Not Exist");
		}

	}

	@Override
	public boolean isAdminUser(String role) {
		System.out.println("Role is "+role+ " ");
		if (role.equalsIgnoreCase("admin")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isUserExist(int uId) {
		if (!userList.isEmpty()) {
			viewUser(uId);
			return true;
		}
		return false;
	}
	
	public void userLogin() {
		System.out.println("is userlist empty = "+userList.isEmpty());
		
		if (!userList.isEmpty()) {
			System.out.println("Enter Username");
			String uName= sc.next();
			System.out.println("Enter Password");
			String pWord= sc.next();
			System.out.println("Username = "+uName);
			System.out.println("Password = "+pWord);

			for (User u : userList) {
				
				if (uName.equals(u.getUserName()) && pWord.equals(u.getPassWord())){
					System.out.println("uName = "+u.getUserName());
					System.out.println("pWord = "+u.getPassWord());
					System.out.println("Login Successful...");
					
					if (isAdminUser(u.getRole())) {
						uDetails.adminMenu();
						break;
					} else {
						uDetails.customerMenu();
						break;
					}
				} else {
					System.out.println("Login Credentials did not match.");
					ReservationClient.main(null);
				}
			}
			
		} else {
			System.out.println("Users do not exists");
			ReservationClient.main(null);
		}
		
	}

}
