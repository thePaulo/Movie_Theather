package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dominio.Movie;
import negocio_bd.MovieService;


@ManagedBean
@SessionScoped
public class MovieMB {
	private Movie filme;
	@EJB
	private MovieService filmeService;
	
	private List<Movie> listaMovies;
	
	public MovieMB(){
		filme = new Movie();
	}
	


	public Movie getMovie() {
		return filme;
	}



	public void setMovie(Movie filme) {
		this.filme = filme;
	}



	public List<Movie> getListaMovies() {
		setListaMovies(filmeService.listarFilmes());
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("filmes", listaMovies);
		
		return listaMovies;
	}

	public void setListaMovies(List<Movie> listaMovies) {
		this.listaMovies = listaMovies;
	}

	public String cadastrar() {
		filmeService.cadastrarFilme(filme);
		filme = new Movie();
		return "redirect.jsf";
	}
	
	public String deletarFilme(Movie movie){
		
		filmeService.deletar(movie);
		return "lista.jsf";
	}
	
}
