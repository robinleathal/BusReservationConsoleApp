package com.brs.dao;

public interface TicketDao {
	void bookTicket();
	void cancelTicket();
	int availableTickets(int bId);
}
