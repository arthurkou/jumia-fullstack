package com.jumia.phone.entity;

public class Contact {

	private String country;
	private String state;
	private String countryCode;
	private String number;

	public Contact() {}

	public Contact(String country, String countryCode, String number) {
		this.country = country;
		this.countryCode = countryCode;
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}