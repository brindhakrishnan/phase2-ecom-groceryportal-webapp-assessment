package com.ecom.groceryportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	//properties
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="customer_id")
	private long customer_id;
	
	@Column(name="details")
	private String details;
	
	@Column(name="delivery_city_id")
	private long city;
	
	@Column(name="delivery_address")
	private String address;
	
	public Order() {
		super();

	}

	public Order(long id, long customer_id, String details, long city, String address) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.details = details;
		this.city = city;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public long getCity() {
		return city;
	}

	public void setCity(long city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

		
}
