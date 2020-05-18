package br.usp.sistemasdeinformacao.flight.model.dto;

import java.time.LocalDateTime;

import br.usp.sistemasdeinformacao.flight.model.entity.OrdemDePassagem;

public class OrdemDePassagemDetalharDto {
	
	private Long id;
	private String destino;
	private String origem;
	private LocalDateTime dataDeVoo;
	private LocalDateTime dataDeAquisicao;
	private String usuarioNome;
	private Long usuarioId;
	
	public OrdemDePassagemDetalharDto(OrdemDePassagem ordem) {

		this.id = ordem.getId();
		this.destino = ordem.getDestino();
		this.origem = ordem.getOrigem();
		this.dataDeVoo = ordem.getDataDeVoo();
		this.dataDeAquisicao = ordem.getDataDeAquisicao();
		this.usuarioId = ordem.getUsuario().getId();
		this.usuarioNome = ordem.getUsuario().getNome();
		
	}

	public Long getId() {
		return id;
	}

	public String getDestino() {
		return destino;
	}

	public String getOrigem() {
		return origem;
	}

	public LocalDateTime getDataDeVoo() {
		return dataDeVoo;
	}

	public LocalDateTime getDataDeAquisicao() {
		return dataDeAquisicao;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}
	
	
	
	
}
