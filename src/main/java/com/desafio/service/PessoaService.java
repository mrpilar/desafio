package com.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.models.Pessoa;
import com.desafio.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	public Pessoa atualizaPessoa(Long id, Pessoa obj) {

		Pessoa entity = pessoaRepository.getOne(id);
		updateData(entity, obj);
		return pessoaRepository.save(entity);
	}

	private void updateData(Pessoa entity, Pessoa obj) {
		entity.setCep(obj.getCep());
		entity.setCidade(obj.getCidade());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setLogradouro(obj.getLogradouro());
		entity.setNome(obj.getNome());
		entity.setNumero(obj.getNumero());
	}
}
