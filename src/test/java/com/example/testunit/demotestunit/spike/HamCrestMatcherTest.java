package com.example.testunit.demotestunit.spike;

 
 
import static org.assertj.core.api.Assertions.assertThat;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
 
//@RunWith(SpringRunner.class)

// assertj run configuration junit 4
public class HamCrestMatcherTest {
	
	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12,15,45);
		assertThat(numbers).hasSize(3).contains(12,15).allMatch( x -> x > 10);
		 
		assertThat("").isEmpty();
		assertThat("ABC").contains("BC").startsWith("A");
	}

}
