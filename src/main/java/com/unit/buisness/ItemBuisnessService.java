package com.unit.buisness;

import org.springframework.stereotype.Component;

import com.unit.entity.Item;

@Component
public class ItemBuisnessService {

	public Item retreiveHardcodedItem() {
		// TODO Auto-generated method stub
		return new Item(1,"Ball",10,100);
	}

}
