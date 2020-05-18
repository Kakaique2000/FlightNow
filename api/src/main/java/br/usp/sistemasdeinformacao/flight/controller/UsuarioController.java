package br.usp.sistemasdeinformacao.flight.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.usp.sistemasdeinformacao.flight.model.dto.OrdemDePassagemDto;
import br.usp.sistemasdeinformacao.flight.model.dto.UsuarioDetalhesDto;
import br.usp.sistemasdeinformacao.flight.model.dto.UsuarioDto;
import br.usp.sistemasdeinformacao.flight.model.entity.OrdemDePassagem;
import br.usp.sistemasdeinformacao.flight.model.entity.Usuario;
import br.usp.sistemasdeinformacao.flight.model.form.OrdemDePassagemForm;
import br.usp.sistemasdeinformacao.flight.repository.OrdemDePassagemRepository;
import br.usp.sistemasdeinformacao.flight.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private OrdemDePassagemRepository ordemDePassagemRepository;

	@GetMapping
	public ResponseEntity<Page<UsuarioDto>> getUsuarios(Pageable paginacao) {
		
		Page<UsuarioDto> usuarios = usuarioRepository.findAll(paginacao).map(e -> new UsuarioDto(e));
		if(usuarios.isEmpty()) 
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(usuarios);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDetalhesDto> getUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(!usuario.isPresent())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(new UsuarioDetalhesDto(usuario.get()));
	}
	
	@GetMapping("/{id}/ordens_de_passagem")
	public ResponseEntity<List<OrdemDePassagemDto>> getOrdensDePassagem(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if(!usuario.isPresent())
			return ResponseEntity.notFound().build();
		List<OrdemDePassagem> ordensDePassagens = usuario.get().getOrdensDePassagens();
		
		if(ordensDePassagens.isEmpty())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(ordensDePassagens.stream().map(OrdemDePassagemDto::new).collect(Collectors.toList()));
	}
	
	
	@PostMapping("/{id}/ordens_de_passagem")
	public ResponseEntity<OrdemDePassagemDto> postUsuario(@RequestBody @Valid OrdemDePassagemForm ordemDePassagemForm, @PathVariable Long id, UriComponentsBuilder uriBuilder) {
		
		OrdemDePassagem ordem = ordemDePassagemForm.criarOrdem(usuarioRepository, id);
		ordemDePassagemRepository.save(ordem);
		URI uri = uriBuilder.path("/usuarios/{id}/ordens_de_passagem/{id_ordem}").buildAndExpand(ordem.getUsuario().getId(), ordem.getId()).toUri();
		return ResponseEntity.created(uri).body(new OrdemDePassagemDto(ordem));
		
	}
	
	
}
