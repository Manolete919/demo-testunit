package com.example.testunit.demotestunit.service;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.testunit.demotestunit.model.Item;
import com.example.testunit.demotestunit.model.ItemRepository;

@Component
public class BusinessService {
	@Autowired
	private ItemRepository repository;
	
	public Item retriveHardCodedItem() {
		
		
		
		return (new Item(1,"Ball",2,10,0));
		
	}
	/**
	 * 
	 * @return all values
	 */
	public List<Item> retrieveAllItems(){
		
		List<Item> items = repository.findAll();
		for(Item item: items) {
			item.setValue(item.getQuantity()*item.getPrice());
		}
		return items;
	}
	
	public int calculateSum(int[] data) {
		OptionalInt number = Arrays.stream(data).reduce(Integer::sum);
		return number.orElse(0);
	}

}
