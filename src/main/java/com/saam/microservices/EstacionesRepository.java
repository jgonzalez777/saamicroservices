package com.saam.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saam.microservices.model.Estacion;

public interface EstacionesRepository extends JpaRepository<Estacion, Long>{

}
