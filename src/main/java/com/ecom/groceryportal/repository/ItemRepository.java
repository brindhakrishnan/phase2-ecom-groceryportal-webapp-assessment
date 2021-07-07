package com.ecom.groceryportal.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.groceryportal.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	/*
	@Query("SELECT p FROM item p WHERE p.name LIKE %?1%")
	public List<Item> search(String keyword);
	
	*/
}
