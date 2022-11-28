package com.hotel5.beans;

import java.io.IOException;

import com.hotel5.entities.Customer;
import com.hotel5.facades.CustomerFacade;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named @RequestScoped
public class AddCustomerBean {
	@Inject
	private CustomerFacade customerFacade;
	
	private String firstName;
	private String lastName;
	private String passWord;
	private String email;
	private int phone;
	private String address;
	private String state;
	private int zipCode;
	
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
	
	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}
	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
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
	
	public void save() {
		Customer c = new Customer(firstName, lastName, passWord, email, phone, address, state, zipCode);
		customerFacade.save(c);
		
		//Why don't add other attributes 
		System.out.println("Adding " + firstName + " " + lastName + "...");
		
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect("index.xhtml");
		} catch(IOException e) {
			this.firstName = "";
			this.lastName = "";
			this.passWord = "";
			this.email = "";
			this.address = "";
			this.state = "";
			
		}
	}
}
