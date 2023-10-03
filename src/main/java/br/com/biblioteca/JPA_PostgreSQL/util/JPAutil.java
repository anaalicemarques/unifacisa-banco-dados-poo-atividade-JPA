package br.com.biblioteca.JPA_PostgreSQL.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("JPA_PostgreSQL");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
		
	}
	
}
