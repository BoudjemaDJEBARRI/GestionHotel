package com.hotel5.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String passWord;
	private String email;
	private int phone;
	private String address;
	private String state;
	@Column(name = "zip_code")
	private int zipCode;
	
	//Display Customer data
	public String getCustomerData() {
		return firstName + " " + lastName + " " + phone + " " + email + " " 
	+ address + " " + zipCode + " " + state;
	}
	
	// Use Constructor
	public Customer() {}
	/**
	 * @param firstName
	 * @param lastName
	 */
	
	public Customer(String firstName, String lastName, String passWord, String email, int phone, String address,
			String state, int zipCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.passWord = passWord;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	
	//Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
}
