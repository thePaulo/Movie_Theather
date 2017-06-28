package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Usuario;

@Stateless
public class UsuarioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public Usuario buscarLogin(String login) {
		return (Usuario) em.find(Usuario.class, login);
	}
	
	public void salvar(Usuario c) {
		em.persist(c);
	}
	
	public void atualizar(Usuario c) {
		em.merge(c);
	}
	
	public void remover(Usuario c) {
		c = em.find(Usuario.class, c.getLogin());
		em.remove(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		String qs = "select c from Usuario c";
		Query q = em.createQuery(qs);
		return (List<Usuario>) q.getResultList();
	}

}