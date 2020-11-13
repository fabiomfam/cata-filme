package br.ifpe.fabio.ativ06.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Diretor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Nome deve ser preenchido.")
	@Size(max = 70, message = "O nome deve ter no máximo {max} caracteres.")
	@Column(length = 70, nullable = false)
	private String nome;
	
	@Size(max = 50, message = "A nacionalidade deve ter no máximo {max} caracteres.")
	@Column(length = 50)
	private String nacionalidade;
	
	@PastOrPresent(message = "Data inválida.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(columnDefinition = "DATE")
	private LocalDate dataNascimento;
	
	@ManyToMany(mappedBy = "diretor")
	private List<Filme> filmes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}
