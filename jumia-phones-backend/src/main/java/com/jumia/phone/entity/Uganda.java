package com.jumia.phone.entity;

public class Uganda extends Country {
	
	static final String COUNTRY_NAME = "Uganda";

	public Uganda(Country next) {
		super(next);
	}

	@Override
	public boolean validateCountryCode(String code) {
		return code.equalsIgnoreCase("256");
	}

	@Override
	public boolean validatePhoneNumber(Customer customer) {
		return customer.getPhone().matches("\\(256\\)\\ ?\\d{9}$");
	}

	@Override
	public void categorizeContact(Customer customer, String code, String number) {
		customer.setContact( new Contact(COUNTRY_NAME, code, number) );		
	}
}
