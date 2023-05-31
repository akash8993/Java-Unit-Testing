package com.unit.buisness;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {
	
	List mock= Mockito.mock(List.class);
	
	@Test
	public void test()
	{
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnDifferentValues()
	{
	
		when(mock.size()).thenReturn(5).thenReturn(4);
		assertEquals(5, mock.size());
		assertEquals(4, mock.size());
	}
	
	@Test
	public void returnWithParameters()
	{
		when(mock.get(0)).thenReturn("Akash");
		assertEquals("Akash", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	public void returnWithGenericParameters()
	{
		//Here anyInt() is argument matcher
		
		when(mock.get(anyInt())).thenReturn("Akash");
		assertEquals("Akash", mock.get(0));
		assertEquals("Akash", mock.get(1));
	}
	
	@Test
	public void verificationBasics()
	{
		List<String> mock= Mockito.mock(List.class);
		
		String value= mock.get(0);
		
		//Verify
		verify(mock).get(0);
		verify(mock).get(anyInt());
		verify(mock, times(1)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		
	}
	
	//Capture the arguments called in method
	
	@Test
	public void argumentCapturing()
	{
		// Ab jo humne paas kia hum chahte hai vo mile hume
		
		List<String> mock= Mockito.mock(List.class);
		mock.add("SomeString");
		
		//verification  verify(mock).mehtod()  -it means it checks weather the mock is called one time or not with this method
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("SomeString", captor.getValue());
	}
	
	@Test
	public void argumentCapturingMultipleTimes()
	{
		// Ab jo humne paas kia hum chahte hai vo mile hume
		
		List<String> mock= Mockito.mock(List.class);
		
		mock.add("SomeString");
		mock.add("SomeString2");
		
		//verification  verify(mock).mehtod()  -it means it checks weather the mock is called one time or not with this method
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		assertEquals("SomeString", captor.getAllValues().get(0));
		assertEquals("SomeString2", captor.getAllValues().get(1));
	}
	
	
	@Test
	public void Mockito()
	{
		ArrayList arrayListMock= Mockito.mock(ArrayList.class);
		
		System.out.println(arrayListMock.get(0)); // By default null
		System.out.println(arrayListMock.size()); //By default 0
		
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		
		System.out.println(arrayListMock.size());//0
		
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size()); //5
		
	}
	
	@Test
	public void spying()
	{
		ArrayList arrayListSpy= spy(ArrayList.class);
		
		arrayListSpy.add("Test0");
		
		System.out.println(arrayListSpy.get(0)); // It would be Test0
		System.out.println(arrayListSpy.size()); //It would be 1
		
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		
		System.out.println(arrayListSpy.size());//0
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size()); //5
		
		
	}
	
	
}
