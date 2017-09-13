package com.saam.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.saam.microservices.model.Estadistica;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticaController {
	
	@Autowired
	private EstadisticasRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Estadistica nuevaEstadistica(@RequestBody Estadistica estadistica) {
		System.out.println("LLega");
		repository.save(estadistica);
		return estadistica;
	}

}
