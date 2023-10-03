package br.com.biblioteca.JPA_PostgreSQL.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.biblioteca.JPA_PostgreSQL.log.Log;
import br.com.biblioteca.JPA_PostgreSQL.model.Livro;

public class LivroDAO {

	private EntityManager em;

	Log meuLogger = new Log("Log.txt");

	public LivroDAO(EntityManager em) throws IOException {
		this.em = em;
	}

	public void cadastrar(Livro livro) {
		this.em.persist(livro);
		System.out.println("\nO " + livro + "foi criado com sucesso!\n");
		meuLogger.logger.info("\nO " + livro + "foi criado na base de dados!\n");
	}

	public void atualizar(Livro livro) {
		this.em.merge(livro);
		System.out.println("\nLivro de id: " + livro.getId() + "agora possui o título: " + livro.getTitulo() + "\n");
		meuLogger.logger.info(
				"\nLivro de id: " + livro.getId() + "teve seu título atualizado para: " + livro.getTitulo() + "\n");
	}

	public void remover(Livro livro) {
		livro = em.merge(livro);
		this.em.remove(livro);
		System.out.println("\nO " + livro + " foi excluído com sucesso");
		meuLogger.logger.info("\nO " + livro + " foi exclído na base de dados!\n");
	}

	public List<Livro> buscarTodosOsLivros() {
		String jpql = "SELECT DISTINCT 1 FROM Livro 1 JOIN FETCH 1.autores";
		return em.createQuery(jpql, Livro.class).getResultList();
	}

}
