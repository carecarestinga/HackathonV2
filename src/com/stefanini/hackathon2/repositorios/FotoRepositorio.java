package com.stefanini.hackathon2.repositorios;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.hackathon2.entidades.Foto;
import com.stefanini.hackathon2.entidades.Livro;

@SuppressWarnings("all")
public class FotoRepositorio {

	@Inject
	private EntityManager entityManager;
	
	public void inserir(Foto foto) {
		entityManager.persist(foto);
	}

	public List<Foto> todosFotos() {
		return entityManager.createQuery("select l from " + Foto.class.getSimpleName() + " l").getResultList();
	}
	
	public void remover(Foto foto) {
		entityManager.remove(entityManager.merge(foto));
	}

	public void removerPorId(Integer id) {
		Livro entity = entityManager.find(Livro.class, id);
		entityManager.remove(entity);	
	}

	public void atualizar(Foto foto) {
		entityManager.merge(foto);	
	}
	
	public Foto pesquisarPorID(Integer id) {
		return entityManager.find(Foto.class, id);
	}
	
	
}
