package com.brs.entity;

public class Ticket {
	private int ticketId;
	private int ticketQty;
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(int ticketId, int ticketQty) {
		super();
		this.ticketId = ticketId;
		this.ticketQty = ticketQty;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getTicketQty() {
		return ticketQty;
	}

	public void setTicketQty(int ticketQty) {
		this.ticketQty = ticketQty;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketQty=" + ticketQty + "]";
	}

	
	
	
	
}
