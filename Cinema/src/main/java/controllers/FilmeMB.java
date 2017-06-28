package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Filme;
import negocio_bd.FilmeService;

@ManagedBean
@SessionScoped
public class FilmeMB {
	private Filme filme;
	@EJB
	private FilmeService filmeService;
	
	private List<Filme> listaFilmes;
	
	public FilmeMB(){
		filme = new Filme();
	}
	


	public Filme getFilme() {
		return filme;
	}



	public void setFilme(Filme filme) {
		this.filme = filme;
	}



	public List<Filme> getListaFilmes() {
		setListaFilmes(filmeService.listarFilmes());
		return listaFilmes;
	}

	public void setListaFilmes(List<Filme> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}

	public String cadastrar() {
		filmeService.cadastrarFilme(filme);
		filme = new Filme();
		return "redirect.jsf";
	}
	
}
