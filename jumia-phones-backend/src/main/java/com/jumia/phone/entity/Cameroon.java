package com.jumia.phone.entity;

public class Cameroon extends Country {
	
	static final String COUNTRY_NAME = "Cameroon";

	public Cameroon(Country next) {
		super(next);
	}

	@Override
	public boolean validateCountryCode(String code) {		
		return code.equalsIgnoreCase("237");		
	}

	@Override
	public boolean validatePhoneNumber(Customer customer) {		
		return customer.getPhone().matches("\\(237\\)\\ ?[2368]\\d{7,8}$");		
	}
	
	@Override
	public void categorizeContact(Customer customer, String code, String number) {		
		customer.setContact( new Contact(COUNTRY_NAME, code, number) );
	}
}
