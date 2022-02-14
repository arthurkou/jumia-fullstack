package com.jumia.phone.utils;

import org.springframework.stereotype.Component;

@Component
public class FilterTypes {
		
	int indFilterCustomer;
	
	public int selectFilter(String country, String state) {
		
		if (country != null && !country.isEmpty()) {
			indFilterCustomer = 2;
			
		} else if (state != null && !state.isEmpty()) {
			indFilterCustomer = 1;
		
		} else {
			indFilterCustomer = 0;			
		}
		
		return indFilterCustomer;		
	} 
}
