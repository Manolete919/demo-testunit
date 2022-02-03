package com.example.testunit.demotestunit.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.example.testunit.demotestunit.model.Item;
import com.example.testunit.demotestunit.model.ItemRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {
	
	//it is aware of the port
	@Autowired
	private TestRestTemplate restTemplate;
	
	//if i want to mock out the itemRepository
	@MockBean
	private ItemRepository repository;

	@Test
	public void contentLoad() throws JSONException {
  
		List<Item> x = Arrays.asList(new Item(1,"Ball",10,10,0));
		when(repository.findAll()).thenReturn(x);
		
		when(repository.findAll()).thenReturn(x);
		
		String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
		
		//restric means all objects must be in the object
		JSONAssert.assertEquals("[{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":10,\"value\":100}]", response, false);
		//JSONAssert.assertEquals("[]", response, false);

		
	}
	
	
	
}
