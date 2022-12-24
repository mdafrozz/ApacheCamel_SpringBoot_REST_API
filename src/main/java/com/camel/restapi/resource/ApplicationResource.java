package com.camel.restapi.resource;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.camel.restapi.dto.Order;
import com.camel.restapi.processor.OrderProcessor;
import com.camel.restapi.service.OrderService;

@Component
public class ApplicationResource extends RouteBuilder {
	
	@Autowired
	private OrderService service;
	
	@BeanInject
	private OrderProcessor processor;
	
	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);
		
		rest().get("/hello").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(constant("welcome")).endRest();
		
		rest().get("/getorders").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(()-> service.getOrders()).endRest();
		
		rest().post("/addorder").consumes(MediaType.APPLICATION_JSON_VALUE).type(Order.class).outType(Order.class).route().process(processor).endRest();
		
	}

}
