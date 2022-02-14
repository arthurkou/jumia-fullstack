package com.jumia.phone.tests;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.jumia.phone.entity.Contact;
import com.jumia.phone.entity.Country;
import com.jumia.phone.entity.Customer;
import com.jumia.phone.repository.CustomerRepository;
import com.jumia.phone.service.CustomerService;
import com.jumia.phone.utils.FilterTypes;

public class CustomerService_Test {
	
	@InjectMocks
	CustomerService service;
	
	@Mock
	JdbcTemplate jdbcTemplate;
	
	@Mock
	CustomerRepository repository;
	
	@Mock
	Country country;
	
	@Mock
	FilterTypes filter;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}	
	
	@Test
	public void checkInformations_test() {
		
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("/data.sql")
				.build();
		
		CustomerRepository repo = new CustomerRepository(dataSource);
		
		CustomerService service = new CustomerService(repo, filter);
		
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = new Customer("JOSEPH FELICIEN NOMO", "(237) 695539786");
		customers.add(customer);
		
		service.checkCustomerInformations(null, "valid");
	} 
	
	@Test
	public void filtercustomerByCountry() {
		CustomerService service = new CustomerService(repository, filter);
		 
		List<Customer> customers = new ArrayList<Customer>();
		Contact contact = new Contact("Morocco", "212", "6007989253");		
		Customer customer = new Customer("Walid Hammadi", "(212) 6007989253");
		customer.setContact(contact);
		customers.add(customer);
		
		service.findCustomer(2, customer.getContact().getCountry(), customer.getContact().getState(), customers);
	}
	
	@Test
	public void filtercustomerByState() {
		CustomerService service = new CustomerService(repository, filter);
		 
		List<Customer> customers = new ArrayList<Customer>();
		Contact contact = new Contact("Morocco", "212", "6007989253");		
		Customer customer = new Customer("Walid Hammadi", "(212) 6007989253");
		customer.setContact(contact);
		customers.add(customer);
		
		service.findCustomer(1, customer.getContact().getCountry(), customer.getContact().getState(), customers);
	}
}
