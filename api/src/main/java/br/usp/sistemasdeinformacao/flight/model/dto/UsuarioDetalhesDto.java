package br.usp.sistemasdeinformacao.flight.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.usp.sistemasdeinformacao.flight.model.entity.Usuario;

public class UsuarioDetalhesDto {
	
	private Long id;
	private String nome;
	private String username;
	private List<OrdemDePassagemDto> ordensDePassagens;
	
	public UsuarioDetalhesDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.username = usuario.getUsername();
		this.ordensDePassagens = usuario
				.getOrdensDePassagens()
				.stream()
				.map(OrdemDePassagemDto::new)
				.collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getUsername() {
		return username;
	}

	public List<OrdemDePassagemDto> getOrdensDePassagens() {
		return ordensDePassagens;
	}
	
	
	
	
	

}
