package com.jumia.phone.entity;

import org.apache.commons.lang3.StringUtils;

public abstract class Country {

	protected Country next;

	public Country(Country next) {
		this.next = next;
	}
	
	public void validate(Customer customer) {
		
		String code = StringUtils.substringBetween(customer.getPhone(), "(", ")");
		String number = customer.getPhone().substring(customer.getPhone().lastIndexOf(")") + 1).trim();
		
		if (validateCountryCode(code)) {
			categorizeContact(customer, code, number);
		}
		
		if (customer.getContact() != null) {
			customer.getContact().setState(validatePhoneNumber(customer) ? "valid" : "not valid");
			
		} else {
			next.validate(customer);			
		}
	}

	protected abstract void categorizeContact(Customer customer, String code, String number);
	protected abstract boolean validateCountryCode(String code);
	protected abstract boolean validatePhoneNumber(Customer customer);
	
}
