package negocio_bd;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.MovieDAO;
import dominio.Movie;


@Stateless
public class MovieService {
	@Inject
	private MovieDAO filmeDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarFilme(Movie filme) {
		Movie c = filmeDAO.buscarMovie(filme.getId() );
		if (c == null) {
			filmeDAO.salvar(filme);
		} else {
			filmeDAO.atualizar(filme);
		}
	}
	
	public List<Movie> listarFilmes(){
		return filmeDAO.listar();
	}
	
	public void deletar(Movie movie){
		filmeDAO.remover(movie);
	}
}
