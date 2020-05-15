package com.unittesting.demo.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unittesting.demo.webapp.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{


}
