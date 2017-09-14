package com.saam.microservices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.saam.microservices.model.CatalogoActuador;
import com.saam.microservices.model.CatalogoSensor;
import com.saam.microservices.model.Cultivo;
import com.saam.microservices.model.Estacion;
import com.saam.microservices.model.TipoCultivo;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/saamicroservices/estacion")
public class EstacionController {
	
	@Autowired
	private EstacionesRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Estacion> estaciones(){
		List<Estacion> estaciones = repository.findAll();
		return estaciones;
	}
	
	interface EstacionDetalle extends Estacion.Basico, Estacion.Cultivos, Cultivo.Basicos, Cultivo.TiposCultivo, TipoCultivo.Basicos, Cultivo.Sensores ,CatalogoSensor.Basico, Cultivo.Actuadores, CatalogoActuador.Basico{}
	@JsonView(EstacionDetalle.class)
	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public Estacion estacion(@PathVariable long id){
		Estacion estacion = repository.getOne(id);
		if(estacion != null){
			return estacion;
		}
		else
			return null;
	}
}