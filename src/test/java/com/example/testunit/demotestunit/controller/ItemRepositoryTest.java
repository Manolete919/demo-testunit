package com.example.testunit.demotestunit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.testunit.demotestunit.model.Item;
import com.example.testunit.demotestunit.model.ItemRepository;

@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired 
	private ItemRepository repository;
	
	@Test
	public void testFindAll() {
		List<Item> items = repository.findAll();
		assertEquals(0, items.size());
	}

}
