package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entity.Order;
import com.sportyshoes.services.OrderService;



@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	
	@GetMapping("/list")
	public List<Order> getAll()
	{
		return service.getAllOrders();

}
}
