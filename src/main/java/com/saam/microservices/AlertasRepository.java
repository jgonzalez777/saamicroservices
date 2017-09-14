package com.saam.microservices;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saam.microservices.model.Alertas;

public interface AlertasRepository extends JpaRepository<Alertas, Long>{

}