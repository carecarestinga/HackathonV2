package com.stefanini.hackathon2.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEmprestimo;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idLivro")
	private Livro livro;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@Column
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataemprestimo;
	@Column
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date datadevolucao;
	
	public Emprestimo() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataemprestimo() {
		return dataemprestimo;
	}

	public void setDataemprestimo(Date dataemprestimo) {
		this.dataemprestimo = dataemprestimo;
	}

	public Date getDatadevolucao() {
		return datadevolucao;
	}

	public void setDatadevolucao(Date datadevolucao) {
		this.datadevolucao = datadevolucao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datadevolucao == null) ? 0 : datadevolucao.hashCode());
		result = prime * result + ((dataemprestimo == null) ? 0 : dataemprestimo.hashCode());
		result = prime * result + ((idEmprestimo == null) ? 0 : idEmprestimo.hashCode());
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (datadevolucao == null) {
			if (other.datadevolucao != null)
				return false;
		} else if (!datadevolucao.equals(other.datadevolucao))
			return false;
		if (dataemprestimo == null) {
			if (other.dataemprestimo != null)
				return false;
		} else if (!dataemprestimo.equals(other.dataemprestimo))
			return false;
		if (idEmprestimo == null) {
			if (other.idEmprestimo != null)
				return false;
		} else if (!idEmprestimo.equals(other.idEmprestimo))
			return false;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}

