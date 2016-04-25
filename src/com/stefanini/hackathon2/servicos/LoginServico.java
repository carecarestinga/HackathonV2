package com.stefanini.hackathon2.servicos;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//
//import com.stefanini.hackathon2.entidades.Usuario;
//import com.stefanini.hackathon2.transacao.Login;
//
//public class LoginServico implements Login {
//
//	private String idLogin;
//	private List<Usuario> usuarios;
//
//	public LoginServico() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public LoginServico (String idLogin, String email, String senha) {
//		
//	}
//	
//
//	@Override
//	public String getIdLogin() {
//		return idLogin;
//	}
//	
//	public List<Usuario> getUsuarios() {
//		return usuarios;
//	}
//	
//	
//	@Override
//	public Boolean autentica(String idLogin, String email, String senha) {
//		Usuario usuarioLogin = new Usuario();
//		if (usuarioLogin.getEmail() == null && usuarioLogin.getSenha() ==  null){
//			
//		}
//			
//			return true;
//	}
//	
// 
//}