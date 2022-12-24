package com.camel.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.camel.restapi.dto.Order;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderModel {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	
	public OrderModel(Order order)
	{
		this.name=order.getName();
		this.price=order.getPrice();
	}
	
}
