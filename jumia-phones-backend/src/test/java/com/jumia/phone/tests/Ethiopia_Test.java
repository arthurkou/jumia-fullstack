package com.jumia.phone.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.jumia.phone.entity.Country;
import com.jumia.phone.entity.Customer;
import com.jumia.phone.entity.Ethiopia;

public class Ethiopia_Test {
	
	@InjectMocks
	Ethiopia ethiopia;
	
	@Mock
	Country country;
		
	@Test
	public void validateCountryCode_test() {
		
		Ethiopia ethiopia = new Ethiopia(country);
		assertTrue(ethiopia.validateCountryCode("251"));
	}
	
	@Test
	public void validatePhoneNumber_test() {
		
		Customer customer = new Customer("Frehiwot Teka", "(251) 988200000");		
		Ethiopia ethiopia = new Ethiopia(country);
		assertTrue(ethiopia.validatePhoneNumber(customer));
	}
	
	@Test
	public void categorizeContact_test() {
		
		Customer customer = new Customer("Frehiwot Teka", "(251) 988200000");		
		Ethiopia ethiopia = new Ethiopia(country);
		ethiopia.categorizeContact(customer, "237", "695539786");
	}
 
}
