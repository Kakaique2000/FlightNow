package br.usp.sistemasdeinformacao.flight.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class OrdemDePassagem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String destino;
	@NotNull @NotEmpty
	private String origem;
	private LocalDateTime dataDeAquisicao = LocalDateTime.now();
	@NotNull
	private LocalDateTime dataDeVoo;
	@ManyToOne
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}
	
	public String getDestino() {
		return destino;
	}
	public OrdemDePassagem setDestino(String destino) {
		this.destino = destino;
		return this;
	}
	public String getOrigem() {
		return origem;
	}
	public OrdemDePassagem setOrigem(String origem) {
		this.origem = origem;
		return this;
	}
	public LocalDateTime getDataDeAquisicao() {
		return dataDeAquisicao;
	}
	public LocalDateTime getDataDeVoo() {
		return dataDeVoo;
	}
	public OrdemDePassagem setDataDeVoo(LocalDateTime dataDeVoo) {
		this.dataDeVoo = dataDeVoo;
		return this;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public OrdemDePassagem setUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
	
	

}
