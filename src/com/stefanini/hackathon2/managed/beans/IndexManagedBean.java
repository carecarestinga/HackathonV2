package com.stefanini.hackathon2.managed.beans;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@ViewScoped
public class IndexManagedBean {
 
private StreamedContent imagemEnviada = new DefaultStreamedContent();
private String imagemTemporaria;
private CroppedImage croppedImage;
private boolean exibeBotao = false;
 
/* getters e setters */
public StreamedContent getImagemEnviada() {
	return imagemEnviada;
}

public void setImagemEnviada(StreamedContent imagemEnviada) {
	this.imagemEnviada = imagemEnviada;
}

public String getImagemTemporaria() {
	return imagemTemporaria;
}

public void setImagemTemporaria(String imagemTemporaria) {
	this.imagemTemporaria = imagemTemporaria;
}

public CroppedImage getCroppedImage() {
	return croppedImage;
}

public void setCroppedImage(CroppedImage croppedImage) {
	this.croppedImage = croppedImage;
}

public boolean isExibeBotao() {
	return exibeBotao;
}

public void setExibeBotao(boolean exibeBotao) {
	this.exibeBotao = exibeBotao;
}
   public void criaArquivo(byte[] bytes, String arquivo) {
      FileOutputStream fos;
      try {
         fos = new FileOutputStream(arquivo);
         fos.write(bytes);
         fos.close();
      } catch (FileNotFoundException ex) {
//         Logger.getLogger(IndexManagedBean.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
//         Logger.getLogger(IndexManagedBean.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
 
   public void enviarImagem(FileUploadEvent event) {
      byte[] img = event.getFile().getContents();
      imagemTemporaria = event.getFile().getFileName();
      FacesContext facesContext = FacesContext.getCurrentInstance();
      ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
      String arquivo = scontext.getRealPath("/upload/" + imagemTemporaria);
      criaArquivo(img, arquivo);
      setExibeBotao(true);
   }
 
   public void crop() {
      setImagemEnviada(new DefaultStreamedContent(new ByteArrayInputStream(croppedImage.getBytes())));
   }
}