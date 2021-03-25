package com.avelino.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avelino.money.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
