package com.example.testunit.demotestunit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testunit.demotestunit.model.Item;
import com.example.testunit.demotestunit.model.ItemRepository;
import com.example.testunit.demotestunit.service.BusinessService;

 
@SpringBootTest
public class BusinessServiceTest {
	
	
	
	@InjectMocks
	private BusinessService business;
	
	@Mock
	private ItemRepository repository;
	
	@Test
	public void testRetrieveAll() {
 		List<Item> x = new ArrayList<>();
		x.add(new Item(1,"Ball",10,10,0));
		when(repository.findAll()).thenReturn(x);
		
		List<Item> items = business.retrieveAllItems();
		assertEquals(100,items.get(0).getValue());
		
	}
	

}
