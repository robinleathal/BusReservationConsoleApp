package com.brs.dao;

import java.util.List;

import com.brs.entity.Bus;

public interface BusDao {
	public void addBus();
	List<Bus> viewAllBuses();
	//Bus viewBus(int id, String routeFrom, String routeTo);
	Bus viewBus(int bId);
	Bus searchBus(int bId);
	void updateBus(int bId);
	void deleteBus(int bId);
	
}
