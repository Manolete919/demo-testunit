package com.example.testunit.demotestunit.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.testunit.demotestunit.model.Item;
import com.example.testunit.demotestunit.service.BusinessService;

//@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
//@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	BusinessService businessService;
	
	@Test
	public void helloWorld_basic() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				 .andExpect(status().isOk())
				 .andExpect(content().string("Hello World"))
				.andReturn();
		
		
		assertEquals("Hello World", result.getResponse().getContentAsString());
		
		
	}
	

	
	@Test
	public void itemFromBusinessService_basic() throws Exception {
		
		when(businessService.retriveHardCodedItem()).thenReturn(new Item(1,"Ball",10,10,0));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				//.andExpect(status().isOk())
				//.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"quantity\":2}"))
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"quantity\":10}"))
				.andReturn();
 		
		
	}
	
	@Test
	public void retrieveAllItems() throws Exception {
		
		List<Item> x = new ArrayList<>();
		x.add(new Item(1,"Ball",10,10,0));
	 
		when(businessService.retrieveAllItems()).thenReturn(x);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				//.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"quantity\":2}"))
				.andExpect(content().json("[{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":10,\"value\":0}]"))
				.andReturn();
 		
		
	}
	
	@Test
	public void testPost_basic() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/items/item")
				.accept(MediaType.APPLICATION_JSON)
				// request
				.content("{    \"id\": 0,    \"name\": null,    \"price\": 0,    \"quantity\": 0,    \"value\": 0 }")
				.contentType(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder)
				 .andExpect(status().isCreated())
				 //.andExpect(header().string("location", containsString("/item/")))
				.andReturn();
		
		JSONAssert.assertEquals("{    \"id\": 0,    \"name\": null,    \"price\": 0,    \"quantity\": 0,    \"value\": 0 }", result.getResponse().getContentAsString(), false);
		
 		
		
	}

}
