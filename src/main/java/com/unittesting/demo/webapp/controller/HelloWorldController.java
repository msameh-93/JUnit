package com.unittesting.demo.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unittesting.demo.webapp.model.Item;
import com.unittesting.demo.webapp.service.ItemService;

@RestController
public class HelloWorldController {
	@Autowired
	private ItemService itemServ;
	
	@GetMapping("/hello")
	public Item helloWorld() {
		return itemServ.getItem();
	}
	@GetMapping("/hello/all")
	public List<Item> allItems() {
		
		return itemServ.getItems();
	}
}
