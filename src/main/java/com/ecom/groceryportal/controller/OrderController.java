package com.ecom.groceryportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.groceryportal.entity.Item;
import com.ecom.groceryportal.entity.Order;
import com.ecom.groceryportal.entity.OrderItem;
import com.ecom.groceryportal.repository.OrderItemRepository;
import com.ecom.groceryportal.repository.OrderRepository;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired 
	private OrderItemRepository orderitemRepo;

	//get all Orders
	@RequestMapping(value = "/orders", method=RequestMethod.GET)
	public List<Order> getAllOrders() {
		return this.orderRepo.findAll();
	}
		
	//get Order by ID
	@RequestMapping(value = "/orders/{id}", method=RequestMethod.GET)
	public Optional<Order> getOrderById (@PathVariable("id")long id) {
		return this.orderRepo.findById(id);
	}
	
	//create Order
	@RequestMapping(value = "/orders", method=RequestMethod.POST)
	public Order addOrder(@RequestBody(required=false) Order orderObj) {
		return this.orderRepo.save(orderObj);
	}
	
	//create Order Items
	@RequestMapping(value = "/orders/", method=RequestMethod.PUT)
	public OrderItem addOrderItem(@RequestBody(required=false) OrderItem orderItemObj) {
		return this.orderitemRepo.save(orderItemObj);
	}

	//update Order
	
	//update Order Items
//	@RequestMapping(value = "/orders/{id}", method=RequestMethod.PUT){
	//	public 
	//}
	
	//delete Order
}
