package com.stefanini.hackathon2.managed.beans;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.mobile.component.page.Page;

import com.stefanini.hackathon2.entidades.Usuario;
import com.stefanini.hackathon2.servicos.UsuarioServico;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean {

	private Usuario usuario;
	private List<Usuario> listaDeUsuariosCadastrados;
	@Inject
	private UsuarioServico servico;
	
	public UsuarioManagedBean() {
	}
	
	public void salvar() {
		servico.salvar(getUsuario());
		Mensageiro.notificaInformacao("Parabéns!", "Usuario salvo com sucesso!");
		carregaListaDeUsuarios();
		limpar();
	}
	
	public void deletar(Usuario usuario) {
		servico.deletar(usuario);
		Mensageiro.notificaInformacao("Parabéns!", "Usuario deletado com sucesso!");
		carregaListaDeUsuarios();
		limpar();
	}
	
	public void limpar() {
		setUsuario(new Usuario());
	}

	private void carregaListaDeUsuarios() {
		setListaDeUsuariosCadastrados(servico.carregaTodosUsuariosDoBanco());
	}
	
	public List<Usuario> getListaDeUsuariosCadastrados() {
		if (listaDeUsuariosCadastrados == null) {
			carregaListaDeUsuarios();
		}
		return listaDeUsuariosCadastrados;
	}
	
	public void setListaDeUsuariosCadastrados(List<Usuario> listaDeUsuariosCadastrados) {
		this.listaDeUsuariosCadastrados = listaDeUsuariosCadastrados;
	}

	public Usuario getUsuario() {
		if (usuario == null) {
			limpar();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Boolean verificarLogin(String email, String senha) {
		Usuario checar = new Usuario();
		 List<Usuario> usuarios = new ArrayList<>();
		    if(checar.getEmail().isEmpty() && checar.getSenha().isEmpty()){
		    }
		    else if(email.isEmpty() && !(senha.isEmpty())) {
		    }
		    else if(!(email.isEmpty()) && senha.isEmpty()) {
		    }
		    else {
		        usuarios.iterator();
		        for(Usuario u : usuarios) {
		            if(email.equals(u.getEmail()) && senha.equals(u.getSenha())) {
		            }
		            else {
		            }
		        }
		    }
		    
		    //return "principal.xhtml";
		    return Boolean.TRUE;
		
	}
	
	public void uploadFoto(FileUploadEvent event) {
		byte[] foto = event.getFile().getContents();
		this.usuario.setFoto(foto);
	}

	public String getFoto(byte[] fotoArray) throws Exception {
		String localSave = ("C:\\TesteFotos");
		File file = new File(localSave + fotoArray + ".jpg");
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			outputStream.write(fotoArray);
			FileDescriptor fd = outputStream.getFD();
			outputStream.flush();
			fd.sync();
			outputStream.close();
		} catch (Exception e) {
			throw new Exception("Erro ao converter os bytes recebidos para imagem");

		}
		return file.getPath();
	}

}
