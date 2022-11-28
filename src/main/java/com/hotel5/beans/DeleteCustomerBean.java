package com.hotel5.beans;


import com.hotel5.facades.CustomerFacade;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named @RequestScoped
public class DeleteCustomerBean {
	@Inject
	private CustomerFacade customerFacade;
	
	public void delete(int id) {
		customerFacade.remove(id);
		System.out.println("Removing id " + id + "...");
	}
}
