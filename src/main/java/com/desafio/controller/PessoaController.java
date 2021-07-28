package com.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.models.Pessoa;
import com.desafio.repository.PessoaRepository;

@RestController
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/pessoas")
	public List<Pessoa> listaProdutos() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/pessoa/{id}")
	public Pessoa pessoaUnica(@PathVariable(value = "id") long id) {
		return pessoaRepository.findById(id);
	}

	@PostMapping("/pessoa")
	public Pessoa salvaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);

	}

	@PutMapping("/produto/{id}")

	public Pessoa atualizaPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);

	}

}
