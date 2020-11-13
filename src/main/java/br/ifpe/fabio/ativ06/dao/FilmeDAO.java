package br.ifpe.fabio.ativ06.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.fabio.ativ06.model.Filme;

public interface FilmeDAO extends JpaRepository<Filme, Integer> {

}
