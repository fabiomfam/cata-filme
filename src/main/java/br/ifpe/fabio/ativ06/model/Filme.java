package br.ifpe.fabio.ativ06.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Título deve ser preenchido.")
	@Size(max = 200, message = "O título deve ter no máximo {max} caracteres.")
	@Column(length = 200, nullable = false)
	private String titulo;
	
	@NotNull(message="Selecione a data de lançamento do filme")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(columnDefinition = "Date", nullable = false)
	private LocalDate dataLancamento;
	
	@Valid
	@NotNull(message = "Selecione o gênero do filme.")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			   name="filme_genero",
			   joinColumns=@JoinColumn(name="filme_id", referencedColumnName="id"),
			   inverseJoinColumns=@JoinColumn(name="genero_id", referencedColumnName="id"))
	private List<Genero> genero;
	
	@Valid
	@NotNull(message = "Selecione o diretor do filme.")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			   name="filme_diretor",
			   joinColumns=@JoinColumn(name="filme_id", referencedColumnName="id"),
			   inverseJoinColumns=@JoinColumn(name="diretor_id", referencedColumnName="id"))
	private List<Diretor> diretor;
	
	@NotNull(message = "Selecione a nota do filme.")
	@Column(length = 5, nullable = false)
	private Integer nota;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public List<Genero> getGenero() {
		return genero;
	}

	public void setGenero(List<Genero> genero) {
		this.genero = genero;
	}

	public List<Diretor> getDiretor() {
		return diretor;
	}

	public void setDiretor(List<Diretor> diretor) {
		this.diretor = diretor;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	

}
