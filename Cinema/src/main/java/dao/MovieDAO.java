package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Movie;

@Stateless
public class MovieDAO {
	@PersistenceContext
	private EntityManager em;
	
	public Movie buscarMovie(int id) {
		return (Movie) em.find(Movie.class, id);
	}
	
	public void salvar(Movie c) {
		em.persist(c);
	}
	
	public void atualizar(Movie c) {
		em.merge(c);
	}
	
	public void remover(Movie c) {
		c = em.find(Movie.class, c.getId());
		em.remove(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> listar() {
		
		String qs = "select c from Movie c ORDER BY c.nota DESC";		
		Query q = em.createQuery(qs);		
		return (List<Movie>) q.getResultList();
	}
}
