package com.jumia.phone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jumia.phone.entity.Cameroon;
import com.jumia.phone.entity.Country;
import com.jumia.phone.entity.Customer;
import com.jumia.phone.entity.Ethiopia;
import com.jumia.phone.entity.Morocco;
import com.jumia.phone.entity.Mozambique;
import com.jumia.phone.entity.Uganda;
import com.jumia.phone.repository.CustomerRepository;
import com.jumia.phone.utils.FilterTypes;

@Service
public class CustomerService {
	
	private CustomerRepository customerRepository;	
	private FilterTypes filterTypes;	

	public CustomerService(CustomerRepository customerRepository, FilterTypes filterTypes) {
		this.customerRepository = customerRepository;
		this.filterTypes = filterTypes;
	}

	public List<Customer> checkCustomerInformations(String country, String state) {

		List<Customer> customers = customerRepository.getInfoCustomers();
		
		Country countryRules = new Cameroon(
						       new Ethiopia(
						       new Morocco(
						       new Mozambique(
						       new Uganda(null)))));

		customers.forEach(customer -> countryRules.validate(customer));
		
		int filter = filterTypes.selectFilter(country, state);
		return findCustomer(filter, country, state, customers);
	}
	
	public List<Customer> findCustomer(int filter, String country, String state, List<Customer> customers) {
		
		List<Customer> response = new ArrayList<Customer>();
		
		switch (filter) {
		
		case 2:
			response = customerRepository.customerByCountry(customers, country);
			break;
		case 1:
			response = customerRepository.customerByState(customers, state);
			break;
		case 0:
			response = customers;
			break;

		}
		return response;
	}
}
