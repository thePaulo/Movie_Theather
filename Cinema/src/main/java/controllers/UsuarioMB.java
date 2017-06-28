package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import dominio.Usuario;
import negocio_bd.UserService;

@ManagedBean
@SessionScoped
public class UsuarioMB {
	private Usuario usuario;
	
	@EJB
	private UserService loginService;
	
	private List<Usuario> listaUsers;
	

	public UsuarioMB() {
		usuario = new Usuario();
	}
	

	
	public List<Usuario> getListaUsers() {
		setListaUsers(loginService.listarUsers());
		return listaUsers;
	}



	public void setListaUsers(List<Usuario> listaUsers) {
		this.listaUsers = listaUsers;
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	@SuppressWarnings("unchecked")
	public String login() {
		int res = loginService.login(usuario.getLogin(), usuario.getSenha());
		if (res == 1) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("login", usuario.getLogin());
			context.getExternalContext().getSessionMap().put("senha", usuario.getSenha());
			
			context.getExternalContext().getSessionMap().put("money", usuario.getMoney());
			context.getExternalContext().getSessionMap().put("user", usuario);
			
			ArrayList<Usuario> users = new ArrayList<Usuario>();
			ServletContext srvletcontext = (ServletContext) FacesContext.
					getCurrentInstance().getExternalContext().getContext();
						
			if(srvletcontext.getAttribute("connected") != null ){
				users = (ArrayList<Usuario>) srvletcontext.getAttribute("connected");
			}
			users.add(usuario);
			srvletcontext.setAttribute("connected", users);
			
			return "/userpage.jsf";
		} else if (res == 0) {
			FacesMessage msg = new FacesMessage("Usuario e/ou senha incorretos");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else {
			FacesMessage msg = new FacesMessage("Usuario nao encontrado");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
	}
	
	public String cadastrar() {
		loginService.cadastrarUsuario(usuario);
		usuario = new Usuario();
		return "page.jsf";
	}
	
	public String remover(Usuario user){
		loginService.removerContato(user);
		//loginService.removerContato(usuario.getLogin());
		return "users.jsf";
	}

}