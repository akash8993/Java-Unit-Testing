package com.unit.buisness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.unit.data.SomeDataService;

class SomeBuisnessMock {

	SomeBuisnessImpl someBuisnessImpl = new SomeBuisnessImpl();
	SomeDataService dataServiceMock= mock(SomeDataService.class);
	
	
	@BeforeEach()
	public void setup()
	{
		someBuisnessImpl.setSomeDataService(dataServiceMock);
	}
	@Test
	void test() {
	 
	 when(dataServiceMock.retriveAllData()).thenReturn(new int [] {1,2,3,4,5});
	
	 int actualResult = someBuisnessImpl.calculateSumWithSevice();
	 
	 
	 int expectedResult =15;
	 assertEquals(expectedResult,actualResult );
	}
	
	@Test
	void test_withEmpty()
	{
		int actual = someBuisnessImpl.sum(new int[] {});
		
		when(dataServiceMock.retriveAllData()).thenReturn(new int [] {});
	
		int actual2 = someBuisnessImpl.calculateSumWithSevice();
		
		int expected = 0;
		
		assertEquals(expected, actual);
		
		assertEquals(expected, actual2);
	}
	
	
	

}
