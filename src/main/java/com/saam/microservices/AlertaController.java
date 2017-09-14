package com.saam.microservices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.saam.microservices.model.Alertas;


@RestController
@RequestMapping("/saamicroservices/alertas")
public class AlertaController {
	
	@Autowired
	private AlertasRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public List<Alertas> nuevasAlertas(@RequestBody List<Alertas> alertas){
		for(Alertas alerta : alertas)
			repository.save(alerta);
		return alertas;
	}
}
