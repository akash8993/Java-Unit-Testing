package com.unit.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(ItemController.class)
public class JsonAssertTest {

	String actualResponse ="{\"id\":1,\"name\":\"ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert() throws JSONException
	{
		
		String expectedResponse ="{\"id\":1,\"name\":\"ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		//Here when we put true at last then jsonAssert Do a strict check (spaces ho sakte hai)
		
		// To if we put false instead of true to fir ye dekhega bas value jaise name= ball hai , price=10 hai
		
		// Jis bhi value mein space ho to hume \ chahie vrna hum seedha bhi check kro and false kr do
		
	}
	
	@Test
	public void jsonAssertFalse()throws JSONException
	{
		String expected= "{id:1,name:ball,price:10,quantity:100}";
		JSONAssert.assertEquals(expected, actualResponse, false);
	}
}
