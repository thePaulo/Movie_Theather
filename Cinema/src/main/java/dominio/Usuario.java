package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String senha;	
	
	@Column
	private int money;
	/*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "Usu_Game",
    	joinColumns = @JoinColumn(name = "login", referencedColumnName = "login"),
    	inverseJoinColumns = @JoinColumn(name = "summoner", referencedColumnName = "summoner"))
	private List<Game> games;
	
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}*/

	public Usuario() {
		
	}
	
	public Usuario(String login, String senha,int money) {
		this.login = login;
		this.senha = senha;
		this.money = money;
	}

	
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}