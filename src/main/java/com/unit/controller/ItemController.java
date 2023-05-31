package com.unit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unit.buisness.ItemBuisnessService;
import com.unit.entity.Item;

@RestController
public class ItemController {

	
	@Autowired
	ItemBuisnessService itemBuisnessService;
	
	
	@GetMapping("/dummy-item")
	public Item dummyItems()
	{
		return new Item(1,"ball", 10, 100);
		
	}
	
	@GetMapping("item-from-buisness-service")
	public Item itemFromBuisnessService()
	{
		return itemBuisnessService.retreiveHardcodedItem();
	}
}
