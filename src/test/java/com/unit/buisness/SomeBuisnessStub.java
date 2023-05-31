package com.unit.buisness;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.unit.data.SomeDataService;

// Since our class is depending over some other class so we will be adding stub in order to perform operation over that

class SomeDataServiceStub implements SomeDataService
{

	@Override
	public int[] retriveAllData() {
			return new int [] {1,2,3,4,5};
	}
	
}


class SomeDataServiceStub2 implements SomeDataService
{

	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int [] {};
	}
}


class SomeBuisnessStub {

	SomeBuisnessImpl someBuisnessImpl = new SomeBuisnessImpl();
	@Test
	void test() {
	
	// bcoz the somebuisnessImpl require some data service in order to perform the operation

	someBuisnessImpl.setSomeDataService(new SomeDataServiceStub());
	 
	//int actualResult = someBuisnessImpl.sum(new int [] {1,2,3,4,5});
	 
	int actualResult = someBuisnessImpl.calculateSumWithSevice();
	
	 int expectedResult =15;
	 assertEquals(expectedResult,actualResult );
	}
	
	@Test
	void test_withEmpty()
	{
		int actual = someBuisnessImpl.sum(new int[] {});
		
		someBuisnessImpl.setSomeDataService(new SomeDataServiceStub2());
		int actualwithStub = someBuisnessImpl.calculateSumWithSevice();
		
		int expected = 0;
		
		assertEquals(expected, actual);
		assertEquals(expected, actualwithStub);
	}
	
	
	

}
