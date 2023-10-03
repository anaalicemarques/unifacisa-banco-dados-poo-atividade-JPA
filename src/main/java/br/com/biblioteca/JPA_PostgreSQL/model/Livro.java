package br.com.biblioteca.JPA_PostgreSQL.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long ISBN;
	private String titulo;
	private int ano;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Editora editora;

	@ManyToMany
	@JoinTable(
			name = "livro_autor", 
			joinColumns = @JoinColumn(name = "livro_id"),
			inverseJoinColumns = @JoinColumn(name = "autor_id")
	)
	private List<Autor> autores;

	public Livro() {
	}

	public Livro(Long iSBN, String titulo, int ano, Categoria categoria, Editora editora, List<Autor> autores) {
		this.ISBN = iSBN;
		this.titulo = titulo;
		this.ano = ano;
		this.categoria = categoria;
		this.editora = editora;
		this.autores = autores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getISBN() {
		return ISBN;
	}

	public void setISBN(Long iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", ISBN=" + ISBN + ", titulo=" + titulo + ", ano=" + ano + ", categoria=" + categoria
				+ ", editora=" + editora + ", autores=" + autores + "]";
	}

}
