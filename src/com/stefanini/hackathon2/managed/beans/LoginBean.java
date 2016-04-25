package com.stefanini.hackathon2.managed.beans;

import java.util.ArrayList;
import java.util.List;

import com.stefanini.hackathon2.entidades.Funcionario;
import com.stefanini.hackathon2.entidades.Usuario;
import com.stefanini.hackathon2.repositorios.UsuarioRepositorio;


public class LoginBean {

	private Funcionario usuario;
	private Boolean autenticado = false;
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	
	public Boolean verificarLogin(String login, String senha) {
		Usuario checar = new Usuario();
		 List<Usuario> usuarios = new ArrayList<>();
		    if(checar.getEmail().isEmpty() && checar.getSenha().isEmpty()){
		    }
		    else if(login.isEmpty() && !(senha.isEmpty())) {
		    }
		    else if(!(login.isEmpty()) && senha.isEmpty()) {
		    }
		    else {
		        usuarios.iterator();
		        for(Usuario u : usuarios) {
		            if(login.equals(u.getEmail()) && senha.equals(u.getSenha())) {
		            }
		            else {
		            }
		        }
		    }
		    return Boolean.TRUE;
		
	}
	
	
	
	public Funcionario getUsuario() {
		return usuario;
	}
	public void setUsuario(Funcionario usuario) {
		this.usuario = usuario;
	}
	public Boolean getAutenticado() {
		return autenticado;
	}
	
	
	
	
}
