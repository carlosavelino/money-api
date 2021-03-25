package com.avelino.money.api.resouce;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avelino.money.api.event.RecursoCriadoEvent;
import com.avelino.money.api.model.Categoria;
import com.avelino.money.api.repository.CategoriaRepository;

@RestController //Controlador rest, já vai converter pra jason
@RequestMapping("/categorias") //realiza o mapeamento da requisição 
public class CategoriaResource {
	
	@Autowired //notação vai encontrar uma implementação de CategoriaRepository e vai injetar em categoriaRepository
	private CategoriaRepository categoriaRepository;
	
	@Autowired //dispara evento 
	private ApplicationEventPublisher publisher;//publicador do evento de aplicação 
	
	@GetMapping //mapeamento para categoria 
	public List<Categoria> listar(){
		 return categoriaRepository.findAll();//findAll já vai realizar o select * from categoria 
	}
	
	@PostMapping//crud de criar
	public ResponseEntity<Categoria> criar (@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	
	@GetMapping("/{codigo}")
	public Categoria buscarPeloCodigo(@PathVariable Long codigo) {
		return categoriaRepository.findOne(codigo);
	}
}
