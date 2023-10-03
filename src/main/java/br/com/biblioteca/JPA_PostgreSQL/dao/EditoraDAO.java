package br.com.biblioteca.JPA_PostgreSQL.dao;

import java.io.IOException;

import javax.persistence.EntityManager;

import br.com.biblioteca.JPA_PostgreSQL.log.Log;
import br.com.biblioteca.JPA_PostgreSQL.model.Editora;

public class EditoraDAO {
	
	private EntityManager em;
	
	Log meuLogger = new Log("Log.txt");
	
	public EditoraDAO(EntityManager em) throws IOException {
		this.em = em;
	}

	public void cadastrar(Editora editora) {
		this.em.persist(editora);
		System.out.println("\nA editora" + editora.getNome()+ "foi criada com sucesso!\n");
		meuLogger.logger.info("\nA editora" + editora.getNome()+ "foi criada na base de dados!\n");
	}

}
