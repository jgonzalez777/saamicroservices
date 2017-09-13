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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "catalogo_sensor", catalog = "smart_crop")
public class CatalogoSensor {
	
	public interface Basico{}

	@JsonView(Basico.class)
	private Long id;

	@JsonView(Basico.class)
	private String nombre;

	@JsonView(Basico.class)
	private String tipo;

	private Set<Cultivo> cultivos = new HashSet<Cultivo>(0);

	public CatalogoSensor() {
	}

	public CatalogoSensor(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public CatalogoSensor(String nombre, String tipo, Set<Cultivo> cultivos) {
		this.nombre = nombre;
		this.tipo = tipo;
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

	@Column(name = "nombre", nullable = false, length = 150)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "tipo", nullable = false, length = 150)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rel_cultivo_sensor", catalog = "smart_crop", joinColumns = {
			@JoinColumn(name = "sensor_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "cultivo_id", nullable = false, updatable = false) })
	public Set<Cultivo> getCultivos() {
		return this.cultivos;
	}

	public void setCultivos(Set<Cultivo> cultivos) {
		this.cultivos = cultivos;
	}
}
