package com.avelino.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avelino.money.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
