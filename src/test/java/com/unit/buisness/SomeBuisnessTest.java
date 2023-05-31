package com.unit.buisness;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBuisnessTest {

	SomeBuisnessImpl someBuisnessImpl = new SomeBuisnessImpl();
	@Test
	void test() {
	 
	 int actualResult = someBuisnessImpl.sum(new int [] {1,2,3,4,5});
	 
	 int expectedResult =15;
	 assertEquals(expectedResult,actualResult );
	}
	
	@Test
	void test_withEmpty()
	{
		int actual = someBuisnessImpl.sum(new int[] {});
		int expected = 0;
		
		assertEquals(expected, actual);
		
	}
	
	
	

}
