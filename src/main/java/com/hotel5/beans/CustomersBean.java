package com.hotel5.beans;

import java.util.List;

import com.hotel5.entities.Customer;
import com.hotel5.facades.CustomerFacade;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named @RequestScoped
public class CustomersBean {
	@Inject
	private CustomerFacade customerFacade;
	private List<Customer> customers;
	
	@PostConstruct
	public void initCustomers() {
		// A l'intialisation de CustomersBean, on récupère toutes les customer
		this.customers = customerFacade.all();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
