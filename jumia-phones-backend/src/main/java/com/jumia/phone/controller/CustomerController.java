package com.jumia.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.phone.entity.Customer;
import com.jumia.phone.service.CustomerService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("jumia")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers")
	@ResponseBody
	public List<Customer> retrieveCustomerInformations(@RequestParam(required = false) String country, 
													   @RequestParam(required = false) String state) {
		
 		return service.checkCustomerInformations(country, state);
	}
}
