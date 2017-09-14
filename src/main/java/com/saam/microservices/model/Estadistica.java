package com.saam.microservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estadistica", catalog = "smart_crop")
public class Estadistica {

	private Long id;

	private Cultivo cultivo;	

	private String ip;

	private int temperaturaAmbiente;
	
	private int temperaturaSuelo;

	private int humedadAmbiente;
	
	private int humedadSuelo;

	public Estadistica() {
	}

	public Estadistica(Cultivo cultivo, String ip, int temperaturaAmbiente, int temperaturaSuelo, int humedadAmbiente, int humedadSuelo) {
		this.cultivo = cultivo;		
		this.ip = ip;
		this.temperaturaAmbiente = temperaturaAmbiente;
		this.temperaturaSuelo = temperaturaSuelo;
		this.humedadAmbiente = humedadAmbiente;
		this.humedadSuelo = humedadSuelo;
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
	@JoinColumn(name = "cultivo_id", nullable = false)
	public Cultivo getCultivo() {
		return this.cultivo;
	}

	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}	

	@Column(name = "ip", nullable = false, length = 20)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "temperatura_ambiente", nullable = false)
	public int getTemperaturaAmbiente() {
		return this.temperaturaAmbiente;
	}

	public void setTemperaturaAmbiente(int temperaturaAmbiente) {
		this.temperaturaAmbiente = temperaturaAmbiente;
	}
	
	@Column(name = "temperatura_suelo", nullable = false)
	public int getTemperaturaSuelo(){
		return this.temperaturaSuelo;
	}
	
	public void setTemperaturaSuelo(int temperaturaSuelo) {
		this.temperaturaSuelo = temperaturaSuelo;
	}

	@Column(name = "humedad_ambiente", nullable = false)
	public int getHumedadAmbiente() {
		return this.humedadAmbiente;
	}

	public void setHumedadAmbiente(int humedadAmbiente) {
		this.humedadAmbiente = humedadAmbiente;
	}
	
	@Column(name = "humedad_suelo", nullable = false)
	public int getHumedadSuelo() {
		return this.humedadSuelo;
	}
	
	public void setHumedadSuelo(int humedadSuelo) {
		this.humedadSuelo = humedadSuelo;
	}
}
