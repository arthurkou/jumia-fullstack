package com.jumia.phone.entity;

public class Ethiopia extends Country {
	
	static final String COUNTRY_NAME = "Ethiopia";

	public Ethiopia(Country next) {
		super(next);
	}

	@Override
	public boolean validateCountryCode(String code) {
		return code.equalsIgnoreCase("251");
	}

	@Override
	public boolean validatePhoneNumber(Customer customer) {
		return customer.getPhone().matches("\\(251\\)\\ ?[1-59]\\d{8}$");
	}

	@Override
	public void categorizeContact(Customer customer, String code, String number) {
		customer.setContact( new Contact(COUNTRY_NAME, code, number) );
	}	
}