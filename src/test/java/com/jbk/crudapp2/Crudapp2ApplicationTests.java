package com.jbk.crudapp2;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class Crudapp2ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetallemployee() throws URISyntaxException {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/getAllEmployee";
		URI uri = new URI(url);
		ResponseEntity<String> resp= rt.getForEntity(uri, String.class);
		Assertions.assertEquals(200, resp.getStatusCodeValue());
		System.out.println("Test 1 Passed");
		
	}
	
	@Test
	public void testcalcaladdition() {
		calculator cal = new calculator();
			int result = cal.addition(2, 4);
			int expected = 6;
//			assertThat(result).isEqualTo(expected);
			Assertions.assertEquals(expected, result);
			System.out.println("Test");} 
	
	
	@Test
	public void testcreateEmployee() throws URISyntaxException {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/createEmployee";
		URI uri = new URI(url);
		Employee e= new Employee(9, "Sidhu", "Moosa", 60000);
		ResponseEntity<String> resp= rt.postForEntity(uri, e, String.class);
		Assertions.assertEquals(200, resp.getStatusCodeValue());
		System.out.println("Test 4 Passed");
		
	}
	
	
	 

}
 