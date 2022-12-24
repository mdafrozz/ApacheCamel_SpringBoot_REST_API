package com.camel.restapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.camel.restapi.dto.Order;

@Service
public class OrderService {
	
	private List<Order> list = new ArrayList<>();
	
	@PostConstruct
	public void initDB() {
		list.add(new Order(67, "Mobile", 5000));
		list.add(new Order(68, "Book", 800));		
	}
	
	public Order addOrder(Order order) {
		list.add(order);
		return order;
	}
	
	public List<Order> getOrders(){
		return list;
	}
}
