package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ingresso")
public class Ingresso {
	
	@Id
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String hora;
	
	@Column
	private String sala;
	
	@Column
	private String comprador;
	
	public Ingresso() {
		
	}
	
	public Ingresso(String name) {
		this.name = name;
		
	}
	
	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	


}