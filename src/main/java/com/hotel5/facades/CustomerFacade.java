package com.hotel5.facades;

import java.util.List;

import org.hibernate.Session;

import com.hotel5.entities.Customer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CustomerFacade {	
	@Inject
	private Session session;
	
	public void save(Customer c) {
		session.beginTransaction();
		session.persist(c);
		session.getTransaction().commit();
	}
	
	public void edit(int id, Customer customer) {
		Customer c = find(id);
		c.setFirstName(customer.getFirstName());
		c.setLastName(customer.getLastName());

		session.beginTransaction();
		session.merge(c);
		session.getTransaction().commit();
	}
	
	public void remove(int id) {
		session.beginTransaction();
		session.remove(find(id));
		session.getTransaction().commit();
	}
	
	public Customer find(int id) {
		return session.find(Customer.class, id);
	}
	
	public List<Customer> all() {
		return session.createQuery("FROM Customer c", Customer.class).getResultList();
	}
}
