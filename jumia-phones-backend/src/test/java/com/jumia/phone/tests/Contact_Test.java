package com.jumia.phone.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.jumia.phone.entity.Contact;

public class Contact_Test {	
	
	@InjectMocks
	Contact contact;
	
	@Test
	public void validateContactInfo_Test() {
		
		Contact contact = new Contact("Brazil", "55", "5491915");
		assertEquals("Brazil", contact.getCountry());
		assertEquals("55", contact.getCountryCode());
		assertEquals("5491915", contact.getNumber());
	}
 
	@Test
	public void testContactObj() {
		
		Contact contact = new Contact();
		contact.setCountry("Morocco");
		contact.setCountryCode("212");
		contact.setNumber("6617344445");
		contact.setState("valid");
		assertFalse(contact.getState().equalsIgnoreCase("not valid"));
	}
}
