package com.unit.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

	//whnever we are using WebMvcTest then we have to use mockMvc in order to call the controller
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_basic() throws Exception
	{
		RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
		// To upar wale method ne call kia hello world controller ke get method ko and request kr rha hai application/Json
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		assertEquals("Hello Akash This is Junit Test Cases",result.getResponse().getContentAsString());
	}
	
	@Test
	public void getDataFromController()throws Exception
	{
		RequestBuilder request= MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello Akash This is Junit Test Cases"))
				.andReturn();
	}

}
