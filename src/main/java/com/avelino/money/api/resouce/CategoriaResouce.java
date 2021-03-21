package com.avelino.money.api.resouce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avelino.money.api.model.Categoria;
import com.avelino.money.api.repository.CategoriaRepository;

@RestController //Controlador rest, já vai converter pra jason
@RequestMapping("/categorias") //realiza o mapeamento da requisição 
public class CategoriaResouce {
	
	@Autowired //notação vai encontrar uma implementação de CategoriaRepository e vai injetar em categoriaRepository
	private CategoriaRepository categoriaRepository;
	
	@GetMapping //mapeamento para categoria 
	public List<Categoria> listar(){
		return categoriaRepository.findAll();//findAll já vai realizar o select * from categoria 
	}
	
}
