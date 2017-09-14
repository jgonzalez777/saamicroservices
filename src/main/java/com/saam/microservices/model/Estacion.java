package com.saam.microservices.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "estacion", catalog = "smart_crop")
public class Estacion {

	public interface Basico{}	
	public interface Cultivos{}
	
	@JsonView(Basico.class)
	private Long id;
		
	private Usuario usuario;

	@JsonView(Basico.class)
	private String ip;

	@JsonView(Basico.class)
	private String nombre;

	@JsonView(Basico.class)
	private float latitud;

	@JsonView(Basico.class)
	private float longitud;
	
	@JsonView(Cultivos.class)
	private Set<Cultivo> cultivos = new HashSet<Cultivo>(0);	

	public Estacion() {
	}	

	public Estacion(Usuario usuario, String ip, String nombre, float latitud, float longitud) {
		this.usuario = usuario;
		this.ip = ip;
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Estacion(Usuario usuario, String ip, String nombre, float latitud, float longitud, Set<Cultivo> cultivos) {
		this.usuario = usuario;
		this.ip = ip;
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.cultivos = cultivos;		
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "ip", nullable = false, length = 20)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "nombre", nullable = false, length = 150)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "latitud", nullable = false, precision = 12, scale = 0)
	public float getLatitud() {
		return this.latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	@Column(name = "longitud", nullable = false, precision = 12, scale = 0)
	public float getLongitud() {
		return this.longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estacion")
	public Set<Cultivo> getCultivos() {
		return this.cultivos;
	}

	public void setCultivos(Set<Cultivo> cultivos) {
		this.cultivos = cultivos;
	}	

}
