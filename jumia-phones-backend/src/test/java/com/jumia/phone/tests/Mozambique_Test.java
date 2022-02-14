package com.jumia.phone.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.jumia.phone.entity.Country;
import com.jumia.phone.entity.Customer;
import com.jumia.phone.entity.Mozambique;

public class Mozambique_Test {
	
	@InjectMocks
	Mozambique mozambique;
	
	@Mock
	Country country;
		
	@Test
	public void validateCountryCode_test() {
		
		Mozambique mozambique = new Mozambique(country);
		assertTrue(mozambique.validateCountryCode("258"));
	}
	
	@Test
	public void validatePhoneNumber_test() {
		
		Customer customer = new Customer("Pedro B 173", "(258) 823747618");		
		Mozambique mozambique = new Mozambique(country);
		assertTrue(mozambique.validatePhoneNumber(customer));
	}
	
	@Test
	public void categorizeContact_test() {
		
		Customer customer = new Customer("Pedro B 173", "(258) 823747618");		
		Mozambique mozambique = new Mozambique(country);
		mozambique.categorizeContact(customer, "258", "823747618");
	}
 
}
