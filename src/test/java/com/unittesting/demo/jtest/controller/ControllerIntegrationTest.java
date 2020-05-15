package com.unittesting.demo.jtest.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:test-config.properties"})
public class ControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws JSONException {
		String response= this.restTemplate.getForObject("/hello/all", String.class);
		
		JSONAssert.assertEquals("[{id:1,name:ABC},{id:2,name:DEF},{id:3,name:GHI}]", response, false); //false restriction means not every element has to be present
	}
}
