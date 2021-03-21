package com.avelino.money.api.repository;

import org.apache.catalina.startup.Catalina;
import org.springframework.data.jpa.repository.JpaRepository;

import com.avelino.money.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
