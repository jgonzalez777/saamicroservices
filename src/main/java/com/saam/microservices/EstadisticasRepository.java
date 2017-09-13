package com.saam.microservices;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saam.microservices.model.Estadistica;

public interface EstadisticasRepository extends JpaRepository<Estadistica, Long>{

}
