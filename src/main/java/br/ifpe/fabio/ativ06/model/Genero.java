package br.ifpe.fabio.ativ06.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Título deve ser preenchido.")
	@Size(max = 60, message = "O título deve ter no máximo {max} caracteres.")
	@Column(length = 60, nullable = false, unique = true)
	private String titulo;
	
	@ManyToMany(mappedBy = "genero")
	private List<Filme> filmes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String nome) {
		this.titulo = nome;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	

	
}
