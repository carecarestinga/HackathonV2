package com.stefanini.hackathon2.servicos;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Usuario;
import com.stefanini.hackathon2.repositorios.UsuarioRepositorio;
import com.stefanini.hackathon2.transacao.Transacional;

public class UsuarioServico {

	@Inject
	private UsuarioRepositorio repositorio;
	
	@Transacional
	public void salvar(Usuario usuario) {
		if (usuario.getIdUsuario() == null) {
			repositorio.inserir(usuario);
		} else {
			repositorio.atualizar(usuario);
		}
	}

	@Transacional
	public List<Usuario> carregaTodosUsuariosDoBanco() {
		return repositorio.todosUsuarios();
	}

	@Transacional
	public void deletar(Usuario usuario) {
		repositorio.remover(usuario);;
	}	
		
}
