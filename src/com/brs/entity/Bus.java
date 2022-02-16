package com.brs.entity;

public class Bus {
	private int id;
	private String type;
	private String routeFrom;
	private String routeTo;
	private Double ticketPrice;
	private int totalSeats;
	
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Bus(int id, String type, String routeFrom, String routeTo, Double ticketPrice, int totalSeats) {
		super();
		this.id = id;
		this.type = type;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.ticketPrice = ticketPrice;
		this.totalSeats = totalSeats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}


	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}


	public int getTotalSeats() {
		return totalSeats;
	}


	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}


	@Override
	public String toString() {
		return "Bus [id=" + id + ", type=" + type + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo
				+ ", ticketPrice=" + ticketPrice + ", totalSeats=" + totalSeats + "]";
	}

	
	
}
