package com.brs.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.brs.dao.BusDao;
import com.brs.dao.TicketDao;
import com.brs.entity.Bus;
import com.brs.entity.Ticket;

public class BusDaoImpl implements BusDao, TicketDao {
	Scanner sc = new Scanner(System.in);
	List<Bus> busList = new ArrayList<>();
	int ticketId =0; // just for console
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
		if (busList.isEmpty()) {
			System.out.println("No Buses are available for now!!!");
		}
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
			System.out.println("Bus Doest Not Exist");
		}

	}
	
	public void bookTicket() {
		System.out.println("Enter Bus Id you want to book");
		int bId = sc.nextInt();
		if (!busList.isEmpty()) {
			if (availableTickets(bId) > 0) {
				System.out.println("How many tickets you want to book");
				int ticketQty = sc.nextInt();
				for (Bus b : busList) {
					if (b.getId() == bId) {
						if (b.getTotalSeats() >= 1 && ticketQty <= b.getTotalSeats()) {
							int totalSeats = b.getTotalSeats();
							totalSeats-=ticketQty;
							b.setTotalSeats(totalSeats);
							Random random = new Random();
							int ticketId = random.nextInt(100);
							Ticket ticket = new Ticket(ticketId, ticketQty);
							System.out.println("Thank you for booking " +ticketQty+ "ticket.");
							//break;
						}
						
					} else {
						System.out.println("Bus detail doesn't match.");
					}
				}
				
			} else {
				System.out.println("No Seats available. ");
			}
			
			
		}
		
		
	}
	
	public void cancelTicket() {
		/*
		System.out.println("Enter Bus Id you want to book");
		int id = sc.nextInt();
		System.out.println("How many tickets you want to cancel book");
		int ticketQty = sc.nextInt();
		if (totalSeats){
			
		}
		for (Bus b : busList) {
			if (b.getId() == id) {
				int totalSeats = b.getTotalSeats();
				totalSeats+=ticketQty;
				b.setTotalSeats(totalSeats);
				
				System.out.println(ticketQty+ " ticket cancelled, Thank you for booking ");
				break;
			} else {
				System.out.println("Bus detail doesn't match.");
			}
		}
		*/
	}

	@Override
	public Bus searchBus(int bId) {
		if (!busList.isEmpty()) {
			for (Bus b: busList) {
				if (bId == b.getId()) {
					return b;
				} else {
					System.out.println("No Buses are found!!!");
				}
			}
		}
		return null;
	}

	@Override
	public int availableTickets(int bId) {
		if (!busList.isEmpty()) {
			for (Bus b : busList) {
				if (bId == b.getId()) {
					return b.getTotalSeats();
				}
			}
		}
		return 0;
	}

}
