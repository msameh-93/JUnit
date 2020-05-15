package com.unittesting.demo.jtest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.unittesting.demo.webapp.model.Item;
import com.unittesting.demo.webapp.repository.ItemRepository;

@DataJpaTest
public class ItemRepositoryTest {
	@Autowired
	private ItemRepository itemRepo;
	
	@Test
	public void testFindAll() {
		List<Item> items= itemRepo.findAll();
		
		assertThat(items.size()).isEqualTo(3);
	}
}
