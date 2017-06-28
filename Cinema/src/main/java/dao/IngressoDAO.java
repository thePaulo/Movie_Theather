package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Ingresso;

@Stateless
public class IngressoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public Ingresso buscarLogin(int login) {
		return (Ingresso) em.find(Ingresso.class, login);
	}
	
	public void salvar(Ingresso c) {
		em.persist(c);
	}
	
	public void atualizar(Ingresso c) {
		em.merge(c);
	}
	
	public void remover(Ingresso c) {
		c = em.find(Ingresso.class, c.getId());
		em.remove(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ingresso> listar() {
		String qs = "select c from Ingresso c";
		Query q = em.createQuery(qs);
		return (List<Ingresso>) q.getResultList();
	}
	
	
}