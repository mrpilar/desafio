package com.desafio.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/api")
@Api(value = "API REST cadastro de Pessoas e seu Endereco")
@CrossOrigin(origins = "*")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/pessoas")
	@ApiOperation(value = "Retorna uma lista de pessoas")
	public List<Pessoa> listaPessoa() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/pessoa/{id}")
	@ApiOperation(value = "Retorna uma pessoa especifica")
	public ResponseEntity<Pessoa> pessoaUnica(@PathVariable Long id) {

		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if (pessoa.isPresent()) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/pessoa")
	@Transactional
	@ApiOperation(value = "Salva uma pessoa e seu endereco")
	public ResponseEntity<Pessoa> salvaPessoa(@RequestBody @Valid Pessoa pessoa, UriComponentsBuilder uriBuilder) {
		pessoaRepository.save(pessoa);

		URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(pessoa);

	}

	@PutMapping("/pessoa/{id}")
	@Transactional
	@ApiOperation(value = "Atualiza uma pessoa")
	public ResponseEntity<Pessoa> atualizaPessoa(@PathVariable Long id, @RequestBody @Valid Pessoa pessoa) {
		pessoaRepository.save(pessoa);

		return ResponseEntity.ok(pessoa);

	}

	@DeleteMapping("/pessoa/{id}")
	@Transactional
	@ApiOperation(value = "Deleta uma pessoa")
	public ResponseEntity<?> deletaPessoa(@PathVariable Long id) {
		pessoaRepository.deleteById(id);

		return ResponseEntity.ok().build();

	}

}
