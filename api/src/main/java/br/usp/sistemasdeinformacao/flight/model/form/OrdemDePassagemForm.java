package br.usp.sistemasdeinformacao.flight.model.form;

import java.time.LocalDateTime;
import java.util.Optional;

import br.usp.sistemasdeinformacao.flight.model.entity.OrdemDePassagem;
import br.usp.sistemasdeinformacao.flight.repository.OrdemDePassagemRepository;
import br.usp.sistemasdeinformacao.flight.repository.UsuarioRepository;

public class OrdemDePassagemForm {
	
	private String destino;
	private String origem;
	private LocalDateTime dataDeVoo;
	
	public OrdemDePassagemForm() {
		
	}
	
	public OrdemDePassagemForm(String destino, String origem, LocalDateTime dataDeVoo) {
		this.destino = destino;
		this.origem = origem;
		this.dataDeVoo = dataDeVoo;
	}
	
	public OrdemDePassagem criarOrdem(UsuarioRepository usuarioRepository, Long usuarioId) {
		return new OrdemDePassagem()
				.setDestino(destino)
				.setDataDeVoo(dataDeVoo)
				.setOrigem(origem)
				.setUsuario(usuarioRepository.getOne(usuarioId));
				
	}
	
	public Optional<OrdemDePassagem> atualizarOrdem(Long id, OrdemDePassagemRepository ordemDePassagemRepository) {
		Optional<OrdemDePassagem> ordem = ordemDePassagemRepository.findById(id);
		if(ordem.isPresent()) {
			ordem
			.get()
			.setOrigem(origem)
			.setDestino(destino)
			.setDataDeVoo(dataDeVoo);
		}
		return ordem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public LocalDateTime getDataDeVoo() {
		return dataDeVoo;
	}

	public void setDataDeVoo(LocalDateTime dataDeVoo) {
		this.dataDeVoo = dataDeVoo;
	}
	
	
	
	

}
