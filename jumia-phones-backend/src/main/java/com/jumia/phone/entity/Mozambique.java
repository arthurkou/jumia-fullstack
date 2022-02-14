package com.jumia.phone.entity;

public class Mozambique extends Country {
	
	static final String COUNTRY_NAME = "Mozambique";

	public Mozambique(Country next) {
		super(next);
	}

	@Override
	public boolean validateCountryCode(String code) {
		return code.equalsIgnoreCase("258");
	}

	@Override
	public boolean validatePhoneNumber(Customer customer) {
		return customer.getPhone().matches("\\(258\\)\\ ?[28]\\d{7,8}$");
	}

	@Override
	public void categorizeContact(Customer customer, String code, String number) {
		customer.setContact( new Contact(COUNTRY_NAME, code, number) );
	}
}
