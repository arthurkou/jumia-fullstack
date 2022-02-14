package com.jumia.phone.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.jumia.phone.entity.Contact;
import com.jumia.phone.entity.Customer;

public class Customer_Test {	
	
	@InjectMocks
	Customer customer;
	
	@Test
	public void validateContactInfo_Test() {
		
		Customer customer = new Customer("Karim Niki", "(251) 966002259");
		assertEquals("Karim Niki", customer.getName());
		assertFalse(customer.getName().equalsIgnoreCase("Kar Niki"));
		assertEquals("(251) 966002259", customer.getPhone());
	}
 
	@Test
	public void testContactObj() {
		
		Customer customer = new Customer();
		customer.setName("Karim Niki");
		customer.setPhone("(251) 966002259");
		customer.setContact(new Contact("Ethiopia", "251", "966002259"));
		assertFalse(customer.getPhone().equalsIgnoreCase("(237) 966002259"));
		assertEquals("Ethiopia", customer.getContact().getCountry());
	}
}
