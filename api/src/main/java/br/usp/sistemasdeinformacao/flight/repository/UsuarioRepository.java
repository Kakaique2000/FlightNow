package br.usp.sistemasdeinformacao.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usp.sistemasdeinformacao.flight.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

}
