package com.unittesting.demo.jtest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unittesting.demo.webapp.model.Item;
import com.unittesting.demo.webapp.repository.ItemRepository;
import com.unittesting.demo.webapp.service.ItemService;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {
	@Mock	//no need for @BeforeEach Setter
	private ItemRepository itemRepo;
	
	@InjectMocks
	private ItemService itemServ;

	@Test
	void calc_sum_basic() {
		when(itemRepo.findAll()).thenReturn(Arrays.asList(
				new Item(1,"ABC"),
				new Item(2,"DEF")
				));
		
		List<Item> items= itemServ.getItems();
		
		assertThat(items.get(0).getName()).isEqualTo("ABC");
		assertThat(items.get(1).getName()).isEqualTo("DEF");
	}
}
