package com.stefanini.hackathon2.entidades;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer idFoto;

	@Column
	public String nome;

	@Column
	@Lob
	public Byte[] dados;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idLivro")
	private Livro livro;

	public Foto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Integer idFoto) {
		this.idFoto = idFoto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Byte[] getDados() {
		return dados;
	}

	public void setDados(Byte[] dados) {
		this.dados = dados;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(dados);
		result = prime * result + ((idFoto == null) ? 0 : idFoto.hashCode());
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foto other = (Foto) obj;
		if (!Arrays.equals(dados, other.dados))
			return false;
		if (idFoto == null) {
			if (other.idFoto != null)
				return false;
		} else if (!idFoto.equals(other.idFoto))
			return false;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Foto [idFoto=" + idFoto + ", nome=" + nome + ", dados=" + Arrays.toString(dados) + ", livro=" + livro
				+ ", getIdFoto()=" + getIdFoto() + ", getNome()=" + getNome() + ", getDados()="
				+ Arrays.toString(getDados()) + ", getLivro()=" + getLivro() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	
	

}
