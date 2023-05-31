package com.unit.buisness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unit.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
class SomeBuisnessMockUpdated {

	@InjectMocks
	SomeBuisnessImpl someBuisnessImpl = new SomeBuisnessImpl();
	
	@Mock
	SomeDataService dataServiceMock;
	
	
//	@BeforeEach()
//	public void setup()
//	{
//		someBuisnessImpl.setSomeDataService(dataServiceMock);
//	}
	@Test
	void test() {
	 
	 when(dataServiceMock.retriveAllData()).thenReturn(new int [] {1,2,3,4,5});
	 assertEquals(15,someBuisnessImpl.calculateSumWithSevice() );
	}
	
	@Test
	void test_withEmpty()
	{
//		int actual = someBuisnessImpl.sum(new int[] {});
		
		when(dataServiceMock.retriveAllData()).thenReturn(new int [] {});
	
	//	int actual2 = someBuisnessImpl.calculateSumWithSevice();
		
	//	int expected = 0;
		
		assertEquals(0, someBuisnessImpl.sum(new int[] {}));
		
		assertEquals(0, someBuisnessImpl.calculateSumWithSevice());
	}
	
	
	

}
