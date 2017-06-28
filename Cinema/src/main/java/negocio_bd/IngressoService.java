package negocio_bd;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.IngressoDAO;
import dominio.Ingresso;

@Stateless
public class IngressoService {
	@Inject
	private IngressoDAO ingDAO;
	
	
	public List<Ingresso> listarUsers(){
		return ingDAO.listar();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarIngresso(Ingresso ing,String hora,String user) {
		//Ingresso c = ingDAO.buscarLogin(ing.getId());
		ing.setComprador(user);
		ing.setHora(hora);
		ing.setName("senha");
		
		ingDAO.salvar(ing);
	}
	
	
}