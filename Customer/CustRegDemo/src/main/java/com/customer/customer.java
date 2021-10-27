package com.customer;

public class customer {
	

	private int id;
	private String name;
	private String address;
	private String phone;
	private String dateOfBirth;
	private String email;
	private String password;
	
	public customer(int id, String name, String address, String phone, String dateOfBirth, String email,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	

}
