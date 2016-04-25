package com.stefanini.hackathon2.servicos;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Foto;
import com.stefanini.hackathon2.repositorios.FotoRepositorio;
import com.stefanini.hackathon2.transacao.Transacional;

public class FotoServico {

	
	@Inject
	private FotoRepositorio repositorio;
	
	@Transacional
	public void salvar(Foto foto) {
		if (foto.getIdFoto() == null) {
			repositorio.inserir(foto);
		} else {
			repositorio.atualizar(foto);
		}
	}

	@Transacional
	public List<Foto> carregaTodosFotosDoBanco() {
		return repositorio.todosFotos();
	}

	@Transacional
	public void deletar(Foto foto) {
		repositorio.remover(foto);;
	}
	
	
}
