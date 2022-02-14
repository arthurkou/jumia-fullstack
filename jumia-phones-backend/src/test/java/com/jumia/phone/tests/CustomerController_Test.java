package com.jumia.phone.tests;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jumia.phone.controller.CustomerController;
import com.jumia.phone.entity.Customer;
import com.jumia.phone.service.CustomerService;


public class CustomerController_Test {
	
	@InjectMocks
	CustomerController controller;
	
	@Mock
	CustomerService service;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}	
	
	@Test
	public void customerController_Test() {
		
		List<Customer> customers = new ArrayList<Customer>();
		Customer arthur = new Customer("Arthur", "(237) 695539786");
		customers.add(arthur);
		
		when(service.checkCustomerInformations("Morocco", "212")).thenReturn(customers);
		controller.retrieveCustomerInformations(null, null);
	}
}