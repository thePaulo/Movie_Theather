package controllers;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import dominio.Usuario;

/**
 * Bean que guarda em sessão todos os usuarios conectados ao sistema
 * 
 *
 */

@ManagedBean
@ApplicationScoped
public class UsersConnected {


	@SuppressWarnings("unchecked")
	public ArrayList<Usuario> getUsers() {
		ArrayList<Usuario> userz = new ArrayList<Usuario>();
		ServletContext srvletcontext = (ServletContext) FacesContext.
				getCurrentInstance().getExternalContext().getContext();
					
		if(srvletcontext.getAttribute("connected") != null ){
			userz = (ArrayList<Usuario>) srvletcontext.getAttribute("connected");
			
		}
		users = userz;
		return users;
	}

	public void setUsers(ArrayList<Usuario> users) {
		this.users = users;
	}

	public ArrayList<Usuario> users;
}
