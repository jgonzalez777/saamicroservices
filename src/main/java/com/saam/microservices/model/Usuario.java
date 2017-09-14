package com.saam.microservices.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "usuario", catalog = "smart_crop")
public class Usuario {

	public interface Basico{}
	
	@JsonView(Basico.class)
	private Long id;

	private String username;

	private String password;

	@JsonView(Basico.class)
	private String correo;

	@JsonView(Basico.class)
	private long celular;

	@JsonView(Basico.class)
	private String nombre;

	@JsonView(Basico.class)
	private String paterno;

	@JsonView(Basico.class)
	private String materno;
	
	private Set<Estacion> estacions = new HashSet<Estacion>(0);		

	public Usuario() {
	}

	public Usuario(String username, String password, String correo, long celular, String nombre, String paterno,
			String materno) {
		this.username = username;
		this.password = password;
		this.correo = correo;
		this.celular = celular;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
	}

	public Usuario(String username, String password, String correo, long celular, String nombre, String paterno,
			String materno, Set<Estacion> estacions) {
		this.username = username;
		this.password = password;
		this.correo = correo;
		this.celular = celular;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.estacions = estacions;				
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "correo", nullable = false, length = 150)
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(name = "celular", nullable = false)
	public long getCelular() {
		return this.celular;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}

	@Column(name = "nombre", nullable = false, length = 200)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "paterno", nullable = false, length = 200)
	public String getPaterno() {
		return this.paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	@Column(name = "materno", nullable = false, length = 200)
	public String getMaterno() {
		return this.materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Estacion> getEstacions() {
		return this.estacions;
	}

	public void setEstacions(Set<Estacion> estacions) {
		this.estacions = estacions;
	}	
}
