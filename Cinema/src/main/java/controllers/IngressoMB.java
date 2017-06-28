package controllers;

import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dominio.Ingresso;
import negocio_bd.IngressoService;


@ManagedBean
@SessionScoped
public class IngressoMB {
	private Ingresso filme;
	@EJB
	private IngressoService filmeService;
	
	private List<Ingresso> listaIngressos;
	
	public IngressoMB(){
		filme = new Ingresso();
	}
	


	public Ingresso getIngresso() {
		return filme;
	}



	public void setIngresso(Ingresso filme) {
		this.filme = filme;
	}



	public List<Ingresso> getListaIngressos() {
		setListaIngressos(filmeService.listarUsers());
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("filmes", listaIngressos);
		
		return listaIngressos;
	}

	public void setListaIngressos(List<Ingresso> listaIngressos) {
		this.listaIngressos = listaIngressos;
	}

	public String cadastrar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		String sala = (String)context.getExternalContext().getSessionMap().get("sala");
		String hora = (String)context.getExternalContext().getSessionMap().get("hora");
		String user = (String)context.getExternalContext().getSessionMap().get("login");
		
		
		Random rn = new Random();
		filme.setId(rn.nextInt(1000));
		//filme.setId(37);
		filme.setComprador(user);
		filme.setHora(hora);
		filme.setSala(sala);
		
		System.out.println(sala+" " +hora+" "+user);
		
		filmeService.cadastrarIngresso(filme,hora,user);
		filme = new Ingresso();
		return "userpage.jsf";
	}
	
}
