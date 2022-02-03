package com.example.testunit.demotestunit.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.testunit.demotestunit.model.Item;
import com.example.testunit.demotestunit.service.BusinessService;

@RestController
public class HelloWorldController {
	
	@Autowired
	BusinessService businessService;
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		
		return "Hello World";
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		
		return businessService.retriveHardCodedItem();
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		
		return businessService.retrieveAllItems();
	}
	
	@PostMapping(path = "items/item", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Item> postItem(@RequestBody Item item) {
		return new ResponseEntity<>(item, HttpStatus.CREATED);	
	}


}
