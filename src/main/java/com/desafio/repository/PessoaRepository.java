package com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	Pessoa findById(long id);
}
