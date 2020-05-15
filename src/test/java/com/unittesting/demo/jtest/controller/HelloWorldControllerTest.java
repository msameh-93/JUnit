package com.unittesting.demo.jtest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unittesting.demo.webapp.model.Item;
import com.unittesting.demo.webapp.service.ItemService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class HelloWorldControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemServ;	//Creates a mock service layer for testing
	//COnfiguration loads Controller layer only
	
	@Test
	public void getItem() {
		RequestBuilder request= MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		
		when(itemServ.getItem()).thenReturn(new Item(1, "ABC"));
		
		try {
			
			MvcResult jsonResult= mockMvc.perform(request)
						.andExpect(status().isOk())
						.andExpect(content().json("{id: 1,name: ABC}"))
						.andReturn();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getAllItems() {
		RequestBuilder request= MockMvcRequestBuilders.get("/hello/all").accept(MediaType.APPLICATION_JSON);
		
		when(itemServ.getItems()).thenReturn(
				Arrays.asList(
						new Item(1,"ABC"),
						new Item(2,"DEF")
				));
		
		try {
			
			MvcResult jsonResult= mockMvc.perform(request)
						.andExpect(status().isOk())
						.andExpect(content().json("[{id: 1,name: ABC},{id: 2,name: DEF}]"))
						.andReturn();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
