package com.jumia.phone.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.jumia.phone.entity.Country;
import com.jumia.phone.entity.Customer;
import com.jumia.phone.entity.Uganda;

public class Uganda_Test {
	
	@InjectMocks
	Uganda uganda;
	
	@Mock
	Country country;
		
	@Test
	public void validateCountryCode_test() {
		
		Uganda uganda = new Uganda(country);
		assertTrue(uganda.validateCountryCode("256"));
	}
	
	@Test
	public void validatePhoneNumber_test() {
		
		Customer customer = new Customer("Ogwal David", "(256) 7771031454");		
		Uganda uganda = new Uganda(country);
		assertFalse(uganda.validatePhoneNumber(customer));
	}
	
	@Test
	public void categorizeContact_test() {
		
		Customer customer = new Customer("Ogwal David", "(256) 7771031454");		
		Uganda uganda = new Uganda(country);
		uganda.categorizeContact(customer, "256", "7771031454");
	}
 
}
