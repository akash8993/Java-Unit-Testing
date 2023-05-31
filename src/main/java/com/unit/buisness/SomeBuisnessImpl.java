package com.unit.buisness;

import java.util.Arrays;
import java.util.List;

import com.unit.data.SomeDataService;

public class SomeBuisnessImpl {
	
	public SomeDataService someDataService;
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}


	public int sum(int [] arr)
	{
		int add =0;
		
		for(int x: arr)
		{
			add=add+x;
		}
		return add;
	}
	
	
	public int  calculateSumWithSevice()
	{
		int [] arr= someDataService.retriveAllData();
	
		int add=0;
		
		for(int x : arr)
		{
			add=add+x;
		}
		
		return add;
	}

}
