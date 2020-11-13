package br.ifpe.fabio.ativ06.access;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Nome deve ser preenchido.")
	@Size(max = 70, message = "O nome deve ter no máximo {max} caracteres.")
	@Column(length = 70, nullable = false)
	private String nome;
	
	@NotBlank(message = "Login deve ser preenchido.")
	@Size(min = 5, max = 30, message = "O login deve ter entre {min} e {max} caracteres.")
	@Column(length = 30, nullable = false, unique = true)
	private String login;
	
	@NotBlank(message = "Senha deve ser preenchida.")
	@Size(min = 7, max = 50, message = "A senha deve ter entre {min} e {max} caracteres.")
	@Column(length = 50, nullable = false)
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private NivelAcesso nivelAcesso;
	

}
