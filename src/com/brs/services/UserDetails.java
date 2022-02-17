package com.brs.services;

import java.util.List;
import java.util.Scanner;

import com.brs.client.ReservationClient;
import com.brs.dao.impl.BusDaoImpl;
import com.brs.entity.Bus;


public class UserDetails {
	Scanner sc = new Scanner(System.in);
	BusDaoImpl busDaoImplObj = new BusDaoImpl();
	
	public void adminMenu() {
		while (true) {
			System.out.println("Admin Menu");
			System.out.println("1. Add a Bus");
			System.out.println("2. View All Buses");
			System.out.println("3. View A Bus");
			System.out.println("4. Update a Bus");
			System.out.println("5. Delete a Bus");
			System.out.println("6. Back");
			System.out.println("Choose an Option");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				busDaoImplObj.addBus();
				
				break;
			case 2:
				
				List<Bus> busList = busDaoImplObj.viewAllBuses();
				System.out.println("*****************************************");
				System.out.println("Bus ID \t  Type\t From \t To \t Price \t Seats");
				System.out.println("*****************************************");
				for (Bus b: busList) {
					System.out.println(b.getId()+"\tt" + b.getType()+"\tt"+ b.getRouteFrom()+"\tt"+ b.getRouteTo()+"\tt"+ b.getTotalSeats());
					
				}
				
				
				busDaoImplObj.viewAllBuses();
				break;
			case 3:
				System.out.println("Enter Bus Id");
				
				int id= sc.nextInt();
				Bus b = busDaoImplObj.viewBus(id);
				System.out.println("*****************************************");
				System.out.println("Bus ID \t  Type\t From \t To \t Price \t Seats");
				System.out.println("*****************************************");
				if (b != null) {
					System.out.println(b.getId()+"\tt" + b.getType()+"\tt"+ b.getRouteFrom()+"\tt"+ b.getRouteTo()+"\tt"+ b.getTotalSeats());
					
				}
				break;
			case 4:
				System.out.println("Enter Product Id");
				int id1= sc.nextInt();
				busDaoImplObj.updateBus(id1);
				break;
			case 5:
				System.out.println("Enter Product Id");
				int id2= sc.nextInt();
				busDaoImplObj.deleteBus(id2);
				break;
			case 6:
				ReservationClient.main(null);
				break;
			default:
				System.out.println("Choose between 1 to 6");
			}
		}
	}
	
	public void customerMenu() {
		while (true) {
			System.out.println("Customer Menu");

			System.out.println("1. View All Buses");
			System.out.println("2. View A Bus");
			System.out.println("3. Book a Ticket");
			System.out.println("4. Cancel a Ticket");
			System.out.println("5. Back");
			System.out.println("Choose an Option");
			int choice = sc.nextInt();
			switch (choice) {
			
			case 1:
				
				List<Bus> busList = busDaoImplObj.viewAllBuses();
				System.out.println("*****************************************");
				System.out.println("Bus ID \t  Type\t From \t To \t Price \t Seats");
				System.out.println("*****************************************");
				for (Bus b: busList) {
					System.out.println(b.getId()+"\tt" + b.getType()+"\tt"+ b.getRouteFrom()+"\tt"+ b.getRouteTo()+"\tt"+ b.getTotalSeats());
					
				}
				
				
				busDaoImplObj.viewAllBuses();
				break;
			case 2:
				System.out.println("Enter Bus Id");
				
				int id= sc.nextInt();
				Bus b = busDaoImplObj.viewBus(id);
				System.out.println("*****************************************");
				System.out.println("Bus ID \t  Type\t From \t To \t Price \t Seats");
				System.out.println("*****************************************");
				if (b != null) {
					System.out.println(b.getId()+"\tt" + b.getType()+"\tt"+ b.getRouteFrom()+"\tt"+ b.getRouteTo()+"\tt"+ b.getTotalSeats());
					
				}
				break;
			case 3:
				//book a ticket
				break;
			case 4:
				//cancel code
				break;
			case 5:
				ReservationClient.main(null);
				break;
			default:
				System.out.println("Choose between 1 to 5");
			}
		}
	}
}
