package com.hotel5.database;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProducer {
	@ApplicationScoped
	@Produces
	public EntityManagerFactory create() {
		return Persistence.createEntityManagerFactory("gestionhotel-jsfPU");
	}
}
