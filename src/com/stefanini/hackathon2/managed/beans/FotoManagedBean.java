package com.stefanini.hackathon2.managed.beans;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;

import com.stefanini.hackathon2.entidades.Foto;
import com.stefanini.hackathon2.servicos.FotoServico;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class FotoManagedBean {
	
	private Foto foto;
	private List<Foto> listaDeFotosCadastrados;
	@Inject
	private FotoServico servico;
	
	public FotoManagedBean() {
	}
	
	public void salvar() {
		servico.salvar(getFoto());
		Mensageiro.notificaInformacao("Parabéns!", "Foto salvo com sucesso!");
		carregaListaDeFotos();
		limpar();
	}
	
	public void deletar(Foto foto) {
		servico.deletar(getFoto());
		Mensageiro.notificaInformacao("Parabéns!", "Foto deletado com sucesso!");
		carregaListaDeFotos();
		limpar();
	}
	
	public void limpar() {
		setFoto(new Foto());
	}
	
	private void carregaListaDeFotos() {
		setListaDeFotosCadastrados(servico.carregaTodosFotosDoBanco());
	}
	
	public List<Foto> getListaDeFotosCadastrados() {
		if (listaDeFotosCadastrados == null) {
			carregaListaDeFotos();
		}
		return listaDeFotosCadastrados;
	}
	
	public void setListaDeFotosCadastrados(List<Foto> listaDeFotosCadastrados) {
		this.listaDeFotosCadastrados = listaDeFotosCadastrados;
	}
	
	public Foto getFoto() {
		if (foto == null) {
			limpar();
		}
		return foto;
	}
	
	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	
	public void uploadFoto(FileUploadEvent event) {
		Integer dados = null;
		this.foto.setIdFoto(dados);
	}
	
	
	public String getFoto(byte[] fotoArray) throws Exception {
		String localSave = ("C:\\TesteFotos\\");
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
