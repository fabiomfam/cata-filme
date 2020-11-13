package br.ifpe.fabio.ativ06.access;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

	public Usuario findByLoginAndSenha (String login, String senha);

	public Object findByLogin(String string);
}
