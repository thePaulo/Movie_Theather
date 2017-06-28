package negocio_bd;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.FilmeDAO;
import dominio.Filme;

@Stateless
public class FilmeService {
	@Inject
	private FilmeDAO filmeDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarFilme(Filme filme) {
		Filme c = filmeDAO.buscarFilme(filme.getId() );
		if (c == null) {
			filmeDAO.salvar(filme);
		} else {
			filmeDAO.atualizar(filme);
		}
	}
	
	public List<Filme> listarFilmes(){
		return filmeDAO.listar();
	}
}
