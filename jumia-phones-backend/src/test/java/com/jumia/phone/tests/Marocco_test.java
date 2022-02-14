package com.jumia.phone.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.jumia.phone.entity.Country;
import com.jumia.phone.entity.Customer;
import com.jumia.phone.entity.Morocco;

public class Marocco_test {
	
	@InjectMocks
	Morocco marocco;
	
	@Mock
	Country country;
		
	@Test
	public void validateCountryCode_test() {
		
		Morocco marocco = new Morocco(country);
		assertTrue(marocco.validateCountryCode("212"));
	}
	
	@Test
	public void validatePhoneNumber_test() {
		
		Customer customer = new Customer("Nada Sofie", "(212) 654642448");		
		Morocco marocco = new Morocco(country);
		assertTrue(marocco.validatePhoneNumber(customer));
	}
	
	@Test
	public void categorizeContact_test() {
		
		Customer customer = new Customer("Nada Sofie", "(212) 654642448");		
		Morocco marocco = new Morocco(country);
		marocco.categorizeContact(customer, "212", "654642448");
	}
 
}
