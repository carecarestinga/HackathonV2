package com.stefanini.hackathon2.managed.beans;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;

import com.stefanini.hackathon2.entidades.Funcionario;
import com.stefanini.hackathon2.servicos.FuncionarioServico;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class FuncionarioManagedBean {

	
	private Funcionario funcionario;
	private List<Funcionario> listaDeFuncionariosCadastrados;
	@Inject
	private FuncionarioServico servico;
	
	public FuncionarioManagedBean() {
	}
	
	public void salvar() {
		servico.salvar(getFuncionario());
		Mensageiro.notificaInformacao("Parabéns!", "Funcionario salvo com sucesso!");
		carregaListaDeFuncionarios();
		limpar();
	}
	
	public void deletar(Funcionario funcionario) {
		servico.deletar(funcionario);
		Mensageiro.notificaInformacao("Parabéns!", "Funcionario deletado com sucesso!");
		carregaListaDeFuncionarios();
		limpar();
	}
	
	public void limpar() {
		setFuncionario(new Funcionario());
	}
	
	private void carregaListaDeFuncionarios() {
		setListaDeFuncionariosCadastrados(servico.carregaTodosFuncionariosDoBanco());
	}
	
	public List<Funcionario> getListaDeFuncionariosCadastrados() {
		if (listaDeFuncionariosCadastrados == null) {
			carregaListaDeFuncionarios();
		}
		return listaDeFuncionariosCadastrados;
	}
	
	public void setListaDeFuncionariosCadastrados(List<Funcionario> listaDeFuncionariosCadastrados) {
		this.listaDeFuncionariosCadastrados = listaDeFuncionariosCadastrados;
	}
	
	public Funcionario getFuncionario() {
		if (funcionario == null) {
			limpar();
		}
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void uploadFoto(FileUploadEvent event) {
		byte[] foto = event.getFile().getContents();
		this.funcionario.setFoto(foto);
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
