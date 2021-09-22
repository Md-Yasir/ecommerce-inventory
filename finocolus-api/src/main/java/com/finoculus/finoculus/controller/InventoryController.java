package com.finoculus.finoculus.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finoculus.finoculus.entity.CategoryT;
import com.finoculus.finoculus.entity.ItemsT;
import com.finoculus.finoculus.service.ItemsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("/item")
@RequestMapping("/item")
public class InventoryController {
	
	@Autowired
	private ItemsService itemService;
	
	//ADD
	
	@RequestMapping(value = "/add/category", method = RequestMethod.POST)
	@ResponseBody
	public CategoryT addItem(@RequestBody CategoryT categoryT) {
		
		return itemService.addCategory(categoryT);
		
	}
	
	@RequestMapping(value = "/add/item", method = RequestMethod.POST)
	@ResponseBody
	public ItemsT addItem(@RequestBody ItemsT itemst) {
		
		return itemService.addItem(itemst);
		
	}	
	
	//GET
	
	@RequestMapping(value = "/get/items", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<ItemsT> getAllItems() {

		return itemService.getAllItems();
	}
	
	@RequestMapping(value = "/get/categories", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<CategoryT> getAllCategories() {

		return itemService.getCategories();
	}
	
}
