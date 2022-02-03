package com.example.testunit.demotestunit.spike;

 
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JSONPathTest {
	
	@Test
	public void learning() {
		
		String responseFromService = "[{\"id\": 1,\"name\": \"Ball\",\"price\": 10,\"quantity\": 10,\"value\": 100 },"
				+ "{\"id\": 2,\"name\": \"Shirts\",\"price\": 10,\"quantity\": 10,\"value\": 100 },"
				+ "{\"id\": 1,\"name\": \"Ball\",\"price\": 10,\"quantity\": 10,\"value\": 100 }]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		System.out.println(context.read("$..id").toString());
		List<Integer> ids = context.read("$..id");
		assertThat(ids).contains(1,2,1);
		//return the element at index one
		System.out.println("NUMBER AT INDEX ONE: " + context.read("$.[1]").toString());
		System.out.println("NUMBER AT INDEX 0:1: " + context.read("$.[0:1]").toString());
		System.out.println("BUSCA BALON: " + context.read("$.[?(@.name=='Ball')]").toString());
		assertThat(length).isEqualTo(3);
		
		
		
	}

}
