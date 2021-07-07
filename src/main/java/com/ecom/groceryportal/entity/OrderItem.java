package com.ecom.groceryportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_item")
public class OrderItem {

	//properties
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="order_id")
	private long order_id;
	
	@Column(name="item_id")
	private long item_id;
	
	@Column(name="quantity")
	private float quantity;
	
	@Column(name="price")
	private float price;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(long id, long order_id, long item_id, float quantity, float price) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.item_id = item_id;
		this.quantity = quantity;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	

	
}
