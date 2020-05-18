package br.usp.sistemasdeinformacao.flight.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String username;
	@NotNull @NotEmpty
	private String password;
	@OneToMany(mappedBy = "usuario")
	private List<OrdemDePassagem> ordensDePassagens;
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<OrdemDePassagem> getOrdensDePassagens() {
		return ordensDePassagens;
	}
	public void setOrdensDePassagens(List<OrdemDePassagem> ordensDePassagens) {
		this.ordensDePassagens = ordensDePassagens;
	}
	
	
	
}
