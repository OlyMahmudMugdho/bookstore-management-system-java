package com.entity;

public class User {
	
	private String id;
	private String name;
	private String dob;
	private String phone;
	private String email;
	private String joiningDate;
	private String role;
	private String address;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public User(String id, String name, String dob, String phone, String email, String joiningDate, String role,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.joiningDate = joiningDate;
		this.role = role;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", phone=" + phone + ", email=" + email
				+ ", joiningDate=" + joiningDate + ", role=" + role + ", address=" + address + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getDob()=" + getDob() + ", getPhone()=" + getPhone() + ", getEmail()="
				+ getEmail() + ", getJoiningDate()=" + getJoiningDate() + ", getRole()=" + getRole() + ", getAddress()="
				+ getAddress() + "]";
	}

	public User(String name, String dob, String phone, String email, String joiningDate, String role, String address) {
		super();
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.joiningDate = joiningDate;
		this.role = role;
		this.address = address;
	}
	
	
}
