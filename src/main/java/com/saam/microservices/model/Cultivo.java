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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.saam.microservices.model.Usuario.Basico;

@Entity
@Table(name = "cultivo", catalog = "smart_crop")
public class Cultivo {
	
	public interface Basicos{}
	public interface TiposCultivo{}
	public interface Sensores {}
	public interface Actuadores{}

	@JsonView(Basico.class)
	private Long id;

	@JsonView(TiposCultivo.class)
	private TipoCultivo tipoCultivo;

	private Estacion estacion;
	
	private Set<Estadistica> estadisticas = new HashSet<Estadistica>(0);

	@JsonView(Sensores.class)
	private Set<CatalogoSensor> catalogoSensores = new HashSet<CatalogoSensor>(0);

	@JsonView(Actuadores.class)
	private Set<CatalogoActuador> catalogoActuadores = new HashSet<CatalogoActuador>(0);
	
	private Set<Alertas> alertases = new HashSet<Alertas>(0);
	
	public Cultivo(Long id){
		this.id = id;
	}

	public Cultivo() {
	}

	public Cultivo(TipoCultivo tipoCultivo, Estacion estacion) {
		this.tipoCultivo = tipoCultivo;
		this.estacion = estacion;
	}

	public Cultivo(TipoCultivo tipoCultivo, Estacion estacion, Set<Estadistica> estadisticas,
			Set<CatalogoSensor> catalogoSensores, Set<CatalogoActuador> catalogoActuadores, Set<Alertas> alertases) {
		this.tipoCultivo = tipoCultivo;
		this.estacion = estacion;
		this.estadisticas = estadisticas;
		this.catalogoSensores = catalogoSensores;
		this.catalogoActuadores = catalogoActuadores;
		this.alertases = alertases;
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
	@JoinColumn(name = "tipo", nullable = false)
	public TipoCultivo getTipoCultivo() {
		return this.tipoCultivo;
	}

	public void setTipoCultivo(TipoCultivo tipoCultivo) {
		this.tipoCultivo = tipoCultivo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estacion_id", nullable = false)
	public Estacion getEstacion() {
		return this.estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cultivo")
	public Set<Estadistica> getEstadisticas() {
		return this.estadisticas;
	}

	public void setEstadisticas(Set<Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rel_cultivo_sensor", catalog = "smart_crop", joinColumns = {
			@JoinColumn(name = "cultivo_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "sensor_id", nullable = false, updatable = false) })
	public Set<CatalogoSensor> getCatalogoSensores() {
		return this.catalogoSensores;
	}

	public void setCatalogoSensores(Set<CatalogoSensor> catalogoSensores) {
		this.catalogoSensores = catalogoSensores;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rel_cultivo_actuador", catalog = "smart_crop", joinColumns = {
			@JoinColumn(name = "cultivo_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "actuador_id", nullable = false, updatable = false) })
	public Set<CatalogoActuador> getCatalogoActuadores() {
		return this.catalogoActuadores;
	}

	public void setCatalogoActuadores(Set<CatalogoActuador> catalogoActuadores) {
		this.catalogoActuadores = catalogoActuadores;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cultivo")
	public Set<Alertas> getAlertases() {
		return this.alertases;
	}

	public void setAlertases(Set<Alertas> alertases) {
		this.alertases = alertases;
	}	
}
