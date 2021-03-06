package br.usp.sistemasdeinformacao.flight.model.dto;

import br.usp.sistemasdeinformacao.flight.model.entity.Usuario;

public class UsuarioDto {
	
	private Long id;
	private String nome;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
