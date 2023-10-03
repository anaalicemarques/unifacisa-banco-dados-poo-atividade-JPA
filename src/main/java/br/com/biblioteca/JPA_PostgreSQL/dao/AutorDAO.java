package br.com.biblioteca.JPA_PostgreSQL.dao;

import java.io.IOException;

import javax.persistence.EntityManager;

import br.com.biblioteca.JPA_PostgreSQL.log.Log;
import br.com.biblioteca.JPA_PostgreSQL.model.Autor;

public class AutorDAO {

	private EntityManager em;
	
	Log meuLogger = new Log("Log.txt");
	
	public AutorDAO(EntityManager em) throws IOException {
		this.em = em;
	}

	public void cadastrar(Autor autor) {
		this.em.persist(autor);
		System.out.println("\nO autor " + autor.getNome() + "foi criado com sucesso!\n");
		meuLogger.logger.info("\nO autor " + autor.getNome() + "foi criado na base de dados!\n");
	}
}
