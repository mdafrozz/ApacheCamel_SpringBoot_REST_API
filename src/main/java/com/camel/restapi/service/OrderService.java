package com.camel.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camel.restapi.dto.Order;
import com.camel.restapi.model.OrderModel;
import com.camel.restapi.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repo;
		
	public OrderModel addOrder(Order order) {
		OrderModel model = new OrderModel(order);
		return repo.save(model);
	}
	
	public List<OrderModel> getOrders(){
		return repo.findAll();
	}
}
