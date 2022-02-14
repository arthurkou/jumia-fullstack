package com.jumia.phone.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.jumia.phone.entity.Cameroon;
import com.jumia.phone.entity.Country;
import com.jumia.phone.entity.Customer;

public class Camaroon_Test {
	
	@InjectMocks
	Cameroon camaroon;
	
	@Mock
	Country country;
		
	@Test
	public void validateCountryCode_test() {
		
		Cameroon camaroon = new Cameroon(country);
		assertTrue(camaroon.validateCountryCode("237"));
	}
	
	@Test
	public void validatePhoneNumber_test() {
		
		Customer customer = new Customer("JOSEPH FELICIEN NOMO", "(237) 695539786");		
		Cameroon camaroon = new Cameroon(country);
		assertTrue(camaroon.validatePhoneNumber(customer));
	}
	
	@Test
	public void categorizeContact_test() {
		
		Customer customer = new Customer("JOSEPH FELICIEN NOMO", "(237) 695539786");		
		Cameroon camaroon = new Cameroon(country);
		camaroon.categorizeContact(customer, "237", "695539786");
	}
 
}
