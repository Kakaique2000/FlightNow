package br.usp.sistemasdeinformacao.flight.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.usp.sistemasdeinformacao.flight.model.dto.OrdemDePassagemDetalharDto;
import br.usp.sistemasdeinformacao.flight.model.dto.OrdemDePassagemDto;
import br.usp.sistemasdeinformacao.flight.model.entity.OrdemDePassagem;
import br.usp.sistemasdeinformacao.flight.model.form.OrdemDePassagemForm;
import br.usp.sistemasdeinformacao.flight.repository.OrdemDePassagemRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ordens_de_passagem")
public class OrdemDePassagemController {

	@Autowired
	OrdemDePassagemRepository ordemDePassagemRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemDePassagemDetalharDto> getOrdemDePassagem(@PathVariable Long id) {
		
		Optional<OrdemDePassagem> ordem = ordemDePassagemRepository.findById(id);
		if(!ordem.isPresent())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(new OrdemDePassagemDetalharDto(ordem.get()));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletaOrdemDePassagem(@PathVariable Long id) {
		
		Optional<OrdemDePassagem> ordem = ordemDePassagemRepository.findById(id);
		if(!ordem.isPresent())
			return ResponseEntity.notFound().build();
		
		ordemDePassagemRepository.delete(ordem.get());
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizaOrdemDePassagem(@RequestBody @Valid OrdemDePassagemForm ordemDePassagemForm, @PathVariable Long id) {
		
		Optional<OrdemDePassagem> ordem = ordemDePassagemForm.atualizarOrdem(id, ordemDePassagemRepository);
		if(!ordem.isPresent())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}
	
	
	
}
