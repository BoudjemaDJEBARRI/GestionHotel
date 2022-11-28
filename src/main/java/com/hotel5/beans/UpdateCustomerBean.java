package com.hotel5.beans;

import com.hotel5.entities.Customer;
import com.hotel5.facades.CustomerFacade;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named @RequestScoped
public class UpdateCustomerBean {
	@Inject
	private CustomerFacade customerFacade;

	public void update(Customer p) {
		customerFacade.edit(p.getId(), p);
	}

}