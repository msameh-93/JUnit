package com.unittesting.demo.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unittesting.demo.webapp.model.Item;
import com.unittesting.demo.webapp.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepo;
	
	public Item getItem() {
		return new Item(1, "ABC");
	}
	public List<Item> getItems() {
		return itemRepo.findAll();
	}
}
