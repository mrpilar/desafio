package com.desafio.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.desafio.models.Pessoa;
import com.desafio.repository.PessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/api")
@Api(value="API REST cadastro de Pessoas e seu Endereco")
@CrossOrigin(origins="*")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/pessoas")
	@ApiOperation(value="Retorna uma lista de pessoas")
	public List<Pessoa> listaPessoa() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/pessoa/{id}")
	@ApiOperation(value="Retorna uma pessoa especifica")
	public Pessoa pessoaUnica(@PathVariable(value = "id") long id) {
		return pessoaRepository.findById(id);
	}

	@PostMapping("/pessoa")
	@Transactional
	@ApiOperation(value="Salva uma pessoa e seu endereco")
	public Pessoa salvaPessoa(@RequestBody Pessoa pessoa, UriComponentsBuilder uriBuilder) {
		return pessoaRepository.save(pessoa);

	}

	@PutMapping("/pessoa/{id}")
	@Transactional
	@ApiOperation(value="Atualiza uma pessoa")
	public Pessoa atualizaPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);

	}

	@DeleteMapping("/pessoa/{id}")
	@Transactional
	@ApiOperation(value="Deleta uma pessoa")
	public void deletaPessoa(@PathVariable Long id) {
		pessoaRepository.deleteById(id);

	}

}
