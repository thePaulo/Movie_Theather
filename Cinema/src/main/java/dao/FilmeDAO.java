package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Filme;

@Stateless
public class FilmeDAO {
	@PersistenceContext
	private EntityManager em;
	
	public Filme buscarFilme(int id) {
		return (Filme) em.find(Filme.class, id);
	}
	
	public void salvar(Filme c) {
		em.persist(c);
	}
	
	public void atualizar(Filme c) {
		em.merge(c);
	}
	
	public void remover(Filme c) {
		c = em.find(Filme.class, c.getName());
		em.remove(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Filme> listar() {
		String qs = "select c from Filme c";
		Query q = em.createQuery(qs);
		return (List<Filme>) q.getResultList();
	}
	

	
}
