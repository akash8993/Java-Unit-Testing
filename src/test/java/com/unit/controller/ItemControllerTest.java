package com.unit.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unit.buisness.ItemBuisnessService;
import com.unit.entity.Item;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private ItemBuisnessService buisnessService;
	
	@Test
	void test() throws Exception {
	
		RequestBuilder request= MockMvcRequestBuilders.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result= mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(
				"{\"id\":1,\"name\":\"ball\",\"price\":10,\"quantity\":100}")).andReturn();
		
	}
	
	
	
	@Test
	void testItemFromBuisnessService() throws Exception {
	
		
		when(buisnessService.retreiveHardcodedItem()).thenReturn(new Item(1,"ball",10,100));
		
		RequestBuilder request= MockMvcRequestBuilders.get("/item-from-buisness-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result= mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(
				"{id:1,name:ball,price:10,quantity:100}")).andReturn();
		
	}

}
