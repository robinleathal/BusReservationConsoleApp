package com.brs.client;

import java.util.Scanner;

import com.brs.dao.impl.UserDaoImpl;


public class ReservationClient {
	static UserDaoImpl uDaoImplObj = new UserDaoImpl();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while (true) {
			System.out.println("****************************************************");
			System.out.println("Welcome to Bus Reservation Console App.");
			System.out.println("1. Register.");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("****************************************************");
			System.out.println("Enter Choice");
			//Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:		
				uDaoImplObj.addUsers();
				break;
			case 2:
				System.out.println("Login");
				uDaoImplObj.userLogin();
				break;
			case 3:
				System.out.println("Thx for Using App!");
				System.exit(0);
			default :
				System.out.println("Choose between 1 to 3");
			}
			sc.close();
		}
		

	}

}
