package com.example.testunit.demotestunit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	int id;
	String name;
	int price;
	int quantity;
	int value;
	 
	
	
	public Item() {
 
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getValue() {
		return value;
	}



	public void setValue(int value) {
		this.value = value;
	}



	public Item(int id, String name, int price, int quantity, int value) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.value = value;
	}
	 
	
	
}
