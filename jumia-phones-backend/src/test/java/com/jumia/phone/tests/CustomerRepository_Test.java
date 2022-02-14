package com.jumia.phone.tests;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jumia.phone.entity.Contact;
import com.jumia.phone.entity.Customer;
import com.jumia.phone.repository.CustomerRepository;

public class CustomerRepository_Test {
	
	@InjectMocks
	CustomerRepository repository;
	
	@Mock
	DataSource dataSource;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}	
	
	@Test
	public void searchByCountry_Test() {
		List<Customer> customers = new ArrayList<Customer>();
		Contact contact = new Contact("Morocco", "212", "6007989253");		
		Customer customer = new Customer("Walid Hammadi", "(212) 6007989253");
		customer.setContact(contact);
		customers.add(customer);
		
		repository.customerByCountry(customers, customer.getContact().getCountry());
	}
	
	@Test
	public void searchByState_Test() {
		List<Customer> customers = new ArrayList<Customer>();
		Contact contact = new Contact("Morocco", "212", "6007989253");		
		contact.setState("valid");
		Customer customer = new Customer("Walid Hammadi", "(212) 6007989253");
		customer.setContact(contact);
		customers.add(customer);
		
		repository.customerByState(customers, customer.getContact().getState());
	}
}
