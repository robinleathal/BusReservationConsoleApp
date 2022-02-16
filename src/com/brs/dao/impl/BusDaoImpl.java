package com.brs.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.brs.dao.BusDao;
import com.brs.entity.Bus;

public class BusDaoImpl implements BusDao {
	Scanner sc = new Scanner(System.in);
	List<Bus> busList = new ArrayList<>();
	@Override
	public void addBus() {
		int k = 1;
		while (k == 1) {
			System.out.println("Add a Bus");
			System.out.println("Enter Bus ID");
			int bId =sc.nextInt();
			System.out.println("Enter Bus Type");
			String busType= sc.next();
			System.out.println("Enter Route From");
			String routefrom = sc.next();
			System.out.println("Enter Route To");
			String routeTo= sc.next();
			System.out.println("Enter Ticket Price");
			double ticketPrice= sc.nextDouble();
			System.out.println("Enter Total Seats");
			int totalSeats= sc.nextInt();
			Bus busObj = new Bus(bId, busType, routefrom, routeTo, ticketPrice, totalSeats);
			busList.add(busObj);

			System.out.println("Bus Registred Successfully");
			System.out.println("Do You Want to One more Bus 1)Yes 2)No");
			k = sc.nextInt();
		}

	}

	@Override
	public List<Bus> viewAllBuses() {
		
		return busList;
	}

	@Override
	public Bus viewBus(int bId) {
		for (Bus b : busList) {
			if (b.getId() == bId) {
				return b;
			}
		}
		return null;
	}

	@Override
	public void updateBus(int bId) {
		int j=0;
		for (Bus b : busList) {
			if (b.getId() == bId) {
				++j;
				System.out.println("Choose What you want to update for Bus.");
				System.out.println("1. Bus Type, 2. Bus Route From, 3. Bus Route To, 4. Ticket Price, 5. Total seats ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter Bus Type");
					b.setType(sc.next());
					System.out.println("Bus Type is updated");
					break;
				case 2:
					System.out.println("Enter Bus Route From");
					b.setRouteFrom(sc.next());
					System.out.println("Bus Route From updated Sucessfully");
					break;
				case 3:
					System.out.println("Enter Bus Route To");
					b.setRouteTo(sc.next());
					System.out.println("Bus Route To updated Sucessfully");
					break;
				case 4:
					System.out.println("Enter Bus Ticket Price");
					b.setTicketPrice(sc.nextDouble());
					System.out.println("Enter Bus Ticket Price updated Sucessfully");
					break;
				case 5:
					System.out.println("Enter Bus Total seats");
					b.setTotalSeats(sc.nextInt());
					System.out.println("Bus Total seats updated Sucessfully");
					break;
				default:
					System.out.println("Choose between 1 to 5");

				}
			}
		}
		if (j==0) {
			System.out.println("Product Doest Not Exist");
		}

	}

	@Override
	public void deleteBus(int bId) {
		int j = 0;
		for (Bus b : busList) {
			if (b.getId() == bId) {
				++j;
				busList.remove(bId);
				System.out.println("Bus is Deleted SuccessFully");
				break;
			}
		}
		if (j==0) {
			System.out.println("Product Doest Not Exist");
		}

	}
	
	public void buyProduct() {
		System.out.println("Enter Bus Id you want to buy");
		int id = sc.nextInt();
		
		for (Bus b : busList) {
			if (b.getId() == id) {
				int totalSeats = b.getTotalSeats();
				totalSeats-=1;
				b.setTotalSeats(totalSeats);
				
				System.out.println("Thank you for your purchase.");
				break;
			} else {
				System.out.println("Bus detail doesn't match.");
			}
		}
	}

}
