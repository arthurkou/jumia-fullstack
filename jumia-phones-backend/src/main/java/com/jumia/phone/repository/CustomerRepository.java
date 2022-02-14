package com.jumia.phone.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jumia.phone.entity.Customer;

@Repository
public class CustomerRepository implements CustomerRepositoryInterface {
	
	@Autowired
    private final JdbcTemplate jdbcTemplate;
	
	public CustomerRepository(DataSource jdbc) {
		jdbcTemplate = new JdbcTemplate(jdbc);
	}

	@Override
	public List<Customer> getInfoCustomers() {
		
			List<Customer> customers = jdbcTemplate.query(" SELECT * FROM CUSTOMER ",
					
					(rs, rowNum) -> 
									new Customer(
											rs.getString("name"),
											rs.getString("phone")
			));
			
			return customers;
	}
	
	public List<Customer> customerByCountry(List<Customer> listCustomer, String country) {
		
		return listCustomer.stream()
				.filter(a -> a.getContact().getCountry().equalsIgnoreCase(country))
				.collect(Collectors.toList());
	}
	
	public List<Customer> customerByState(List<Customer> listCustomer, String state) {
		
		return listCustomer.stream()
				.filter(a -> a.getContact().getState().equalsIgnoreCase(state))
				.collect(Collectors.toList());
	}
	
}
