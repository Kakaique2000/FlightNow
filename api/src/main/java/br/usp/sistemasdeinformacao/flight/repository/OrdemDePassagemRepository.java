package br.usp.sistemasdeinformacao.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usp.sistemasdeinformacao.flight.model.entity.OrdemDePassagem;

public interface OrdemDePassagemRepository extends JpaRepository<OrdemDePassagem, Long>{

}
