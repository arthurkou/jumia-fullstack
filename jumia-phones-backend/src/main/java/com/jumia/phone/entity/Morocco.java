package com.jumia.phone.entity;

public class Morocco extends Country {
	
	static final String COUNTRY_NAME = "Morocco";

	public Morocco(Country next) {
		super(next);
	}

	@Override
	public boolean validateCountryCode(String code) {
		return code.equalsIgnoreCase("212");
	}

	@Override
	public boolean validatePhoneNumber(Customer customer) {
		return customer.getPhone().matches("\\(212\\)\\ ?[5-9]\\d{8}$");
	}

	@Override
	public void categorizeContact(Customer customer, String code, String number) {
		customer.setContact( new Contact(COUNTRY_NAME, code, number) );		
	}
}
