package negocio_bd;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.UsuarioDAO;
import dominio.Usuario;

@Stateless
public class UserService {
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int login(String l, String s) {
		Usuario u = usuarioDAO.buscarLogin(l);
		if (u != null) {
			if (u.getSenha().equals(s))
				return 1;
			else return 0;
		} else return -1;
	}
	
	public List<Usuario> listarUsers(){
		return usuarioDAO.listar();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarUsuario(Usuario usuario) {
		Usuario c = usuarioDAO.buscarLogin(usuario.getLogin() );
		if (c == null) {
			usuarioDAO.salvar(usuario);
		} else {
			usuarioDAO.atualizar(usuario);
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removerContato(Usuario user) {
		Usuario c = usuarioDAO.buscarLogin(user.getLogin());
		//if (c != null) {
			usuarioDAO.remover(c);
		//}
	}
	
}