package com.jumia.phone.tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.jumia.phone.utils.FilterTypes;

public class CustomerUtils_Test {
	
	@InjectMocks
	FilterTypes types;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void filterByCountry_test() {
		
		types.selectFilter("Morocco", null);
	}
	
	@Test
	public void filterByState_test() {
		
		types.selectFilter(null, "valid");
	}
	
	@Test
	public void noFilter_test() {
		
		types.selectFilter(null, null);
	}
 
}
