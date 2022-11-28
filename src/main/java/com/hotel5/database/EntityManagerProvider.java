package com.hotel5.database;

import org.hibernate.Session;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityManagerProvider {
	@Inject
	transient EntityManagerFactory emf;
	
	@RequestScoped @Produces
	public EntityManager create() {
		return emf.createEntityManager();
	}
	
	@RequestScoped @Produces
	public Session createSession() {
		return create().unwrap(Session.class);
	}
}
