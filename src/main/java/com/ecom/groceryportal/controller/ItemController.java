package com.ecom.groceryportal.controller;

import java.util.List;
import javax.websocket.server.PathParam;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.groceryportal.entity.Item;
import com.ecom.groceryportal.repository.ItemRepository;
import com.ecom.groceryportal.exception.InvalidItemException;
import com.ecom.groceryportal.exception.ItemNotFoundException;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository itemRepo;

	//get all items
	@RequestMapping(value = "/items", method=RequestMethod.GET)
	public List<Item> getAllItems() {
		return this.itemRepo.findAll();
	}
		
	//get item by ID
	@RequestMapping(value = "/items/{id}" , method=RequestMethod.GET)
	public Item getItemById(@PathVariable("id") long id) {
		return this.itemRepo.findById(id).orElseThrow(()->{
			throw new ItemNotFoundException();
		});
	}
	
	//get item by name
	/*
	@RequestMapping(value = "/items" , method = RequestMethod.GET)
	public Item getItemByName(Model model, @Param("keyword") String keyword) {
		if (keyword != null) {
            return (Item) this.itemRepo.search(keyword);
        }
		throw new ItemNotFoundException();
	}
	/*
	@RequestMapping(value = "/items" , method = RequestMethod.GET)
	public Item getItemByName(@PathParam("name") String name) {
		items = itemRepo.findAll();
		for (Item item : items) {
			System.out.println(name);
			if (item.getName().equals(name)) {
				return item;
			}
		}
	}
	/*
	ExampleMatcher matcher = Examplematcher.matching()
			.withIgnorePaths("name")
			.withStringMatcherEnding();
	*/	
		
	//create item
	@RequestMapping(value = "/items" , method = RequestMethod.POST)
	public Item addItem(@RequestBody(required=false) Item itemObj) {
		if(itemObj == null)
		{
			throw new InvalidItemException();
		}
		return this.itemRepo.save(itemObj);
	}
	
	//update item
	@RequestMapping(value = "/items/{id}" , method = RequestMethod.PUT)
	public Item updateItem(@PathVariable("id") long id, @RequestBody(required=false) Item itemObj) {
	//find record
		this.itemRepo.findById(id).orElseThrow(()->{
		throw new ItemNotFoundException();
		});
		return this.itemRepo.save(itemObj);
	}
	
	/*
	 * 	@RequestMapping(value = "/products/{id}", method= RequestMethod.PUT)
	public Product updateOneProduct(@PathVariable("id") long id, @RequestBody(required=false) Product productObj) {
		//find record 
		this.productRepo.findById(id).orElseThrow(()->{
			throw new ProductNotFoundException();
		});
		return this.productRepo.save(productObj);
	}

	 */
	
	//delete item
	@RequestMapping(value = "/items/{id}" , method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable("id") long id) {
		Item fetchedItem = this.itemRepo.findById(id).orElseThrow(()->{
			throw new ItemNotFoundException();
		});
		this.itemRepo.delete(fetchedItem);
	}
	
}
