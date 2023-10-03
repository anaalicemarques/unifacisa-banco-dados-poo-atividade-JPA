package br.com.biblioteca.JPA_PostgreSQL.dao;

import java.io.IOException;

import javax.persistence.EntityManager;

import br.com.biblioteca.JPA_PostgreSQL.log.Log;
import br.com.biblioteca.JPA_PostgreSQL.model.Categoria;

public class CategoriaDAO {
	
	private EntityManager em;
	
	Log meuLogger = new Log("Log.txt");
	
	public CategoriaDAO(EntityManager em) throws IOException {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
		System.out.println("\nA categoria" + categoria.getNome()+ "foi criada com sucesso!\n");
		meuLogger.logger.info("\nA categoria" + categoria.getNome()+ "foi criada na base de dados!\n");
	}
}
