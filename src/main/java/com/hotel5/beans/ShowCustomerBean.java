package com.hotel5.beans;

import java.io.IOException;

import com.hotel5.entities.Customer;
import com.hotel5.facades.CustomerFacade;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named @RequestScoped
public class ShowCustomerBean {
	private Customer customer;
	
	@Inject
	private CustomerFacade customerFacade;
	
	// Ici, "param" fait référence aux paramètres (de la requête)
	// -> request.getParameter
	// Et on appelle "id". // show.xhtml?id=3 --> id = "3"
	
	@Inject
	@ManagedProperty("#{param.id}")
	private String id;
	
	// Exemple : URI courante de la page
	@Inject
	@ManagedProperty("#{request.requestURI}")
	private String uri;
	
	@Inject
	@ManagedProperty("#{request.method}")
	private String method; // Autre exemple : GET ou POST 

	// Méthode qui sera appelée au moment choisi par JSF (avant tout autre méthode de votre bean)
	// (mais après le constructeur) et permet de faire une initialisation de votre Bean, ici
	// de définir la propriété "person" en fonction de l'identifiant fourni dans l'URL
	
	@PostConstruct
	public void initCustomer() {
		// Récupérer l'id de la page web. 
		// Exemple : 2 si l'URL est : /show.xhtml?id=2
		try {
			// On tente de transformer l'id de l'URL en int
			int id = Integer.parseInt(this.id);
			// On tente de trouver la personne avec l'id correspondant
			customer = customerFacade.find(id);
			// Si la personne n'existe pas
			if(customer == null) {
				// On déclenche une exception pour tomber dans le bloc "catch"
				throw new NumberFormatException();
			}
		} catch(NumberFormatException e) {
			// Ici, on fait le traitement d'erreurs pour les cas suivants :
			// - id n'était pas un nombre
			// - l'id ne correspondait à aucune personne
			
			// Dans ces cas, on redirige vers index.xhtml
			try {
				// Un équivalent à response.sendRedirect (JSP)
				// Cette opération peut déclencher une exception également (IOException)
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.redirect("index.xhtml");
			} catch(IOException ex) {
				// Dans ce cas, on ne fait rien
			}
		}
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
}
