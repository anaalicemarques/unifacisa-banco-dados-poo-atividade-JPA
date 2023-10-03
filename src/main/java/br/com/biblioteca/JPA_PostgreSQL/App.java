package br.com.biblioteca.JPA_PostgreSQL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.biblioteca.JPA_PostgreSQL.dao.AutorDAO;
import br.com.biblioteca.JPA_PostgreSQL.dao.CategoriaDAO;
import br.com.biblioteca.JPA_PostgreSQL.dao.EditoraDAO;
import br.com.biblioteca.JPA_PostgreSQL.dao.LivroDAO;
import br.com.biblioteca.JPA_PostgreSQL.model.Autor;
import br.com.biblioteca.JPA_PostgreSQL.model.Categoria;
import br.com.biblioteca.JPA_PostgreSQL.model.Editora;
import br.com.biblioteca.JPA_PostgreSQL.model.Livro;
import br.com.biblioteca.JPA_PostgreSQL.util.JPAutil;

public class App {

	public static void main(String[] args) throws IOException {

		EntityManager em = JPAutil.getEntityManager();

		LivroDAO livroDAO = new LivroDAO(em);
		EditoraDAO editoraDAO = new EditoraDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		AutorDAO autorDAO = new AutorDAO(em);

		Categoria categoria1 = new Categoria("Ação");
		Categoria categoria2 = new Categoria("Comédia");

		Editora editora1 = new Editora("Aleph");
		Editora editora2 = new Editora("Rocco");

		Autor autor1 = new Autor("Ação");
		Autor autor2 = new Autor("Ação");

		List<Autor> autores = new ArrayList<>();
		autores.add(autor1);
		autores.add(autor2);

		Livro harryPotter = new Livro(123456789L, "Harry Potter", 1999, categoria1, editora1, autores);
		Livro piorQueTaNaoFica = new Livro(15198487L, "Pior quqe tá nao fica", 2015, categoria2, editora2, autores);
		Livro oEspadachimCarvao = new Livro(15198487L, "O Espadachim carvão", 2010, categoria1, editora2, autores);

		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(categoria1);
		categoriaDAO.cadastrar(categoria2);

		editoraDAO.cadastrar(editora1);
		editoraDAO.cadastrar(editora2);

		autorDAO.cadastrar(autor1);
		autorDAO.cadastrar(autor2);

		livroDAO.cadastrar(harryPotter);
		livroDAO.cadastrar(piorQueTaNaoFica);
		livroDAO.cadastrar(oEspadachimCarvao);

//      //Persistindo as instâncias de categoria criadas anteriormente
//      categoriaDAO.cadastrar(categoria1);
//      categoriaDAO.cadastrar(categoria2);
//
//      //Persistindo as instâncias de editora criadas anteriormente
//      editoraDAO.cadastrar(editora1);
//      editoraDAO.cadastrar(editora2);
//
//      //Persistindo as instâncias de autor criadas anteriormente
//      autorDAO.cadastrar(autor1);
//      autorDAO.cadastrar(autor2);
//
//      //Persistindo as instâncias de livros criadas anteriormente
//      livroDAO.cadastrar(harryPotter);
//      livroDAO.cadastrar(piorQueTaNaoFica);
//      livroDAO.cadastrar(oEspadachimDeCarvao);

//      //Buscando todos os livros cadastrados
//      List<Livro> todosLivros = livroDAO.buscarTodosOsLivros();
//      todosLivros.forEach(livro -> {
//          System.out.println("\nID do Livro: " + livro.getId());
//          System.out.println("ISBN: " + livro.getISBN());
//          System.out.println("Título: " + livro.getTitulo());
//          System.out.println("Ano de lançamento: " + livro.getAno());
//          System.out.println("Categoria: " + livro.getCategoria().getNome());
//          System.out.println("Editora: " + livro.getEditora().getNome());
//          System.out.println("Autores: " + livro.getAutores());
//      });

//      //Atualizando um livro
//      Livro atualizaLivro = em.find(Livro.class, 1l);
//      System.out.println("Livro: " + atualizaLivro);
//      atualizaLivro.setTitulo("Senhor dos Anéis");
//      livroDAO.atualizar(atualizaLivro);

//      //Buscando livro por ID
//      Livro livro = livroDAO.buscarPorId(1l);
//      System.out.println("\n" + livro.getId());
//      System.out.println(livro.getISBN());
//      System.out.println(livro.getTitulo());
//      System.out.println(livro.getAno());
//      System.out.println(livro.getCategoria().getNome());
//      System.out.println(livro.getEditora().getNome());
//      System.out.println("Autores: " + livro.getAutores());

//      //Removendo livro
//      livroDAO.remover(livro);
		
		em.getTransaction().commit();
		
		em.close();
	}
}
