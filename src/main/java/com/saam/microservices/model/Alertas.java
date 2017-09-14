package com.saam.microservices.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="alertas"
    ,catalog="smart_crop"
)
public class Alertas {


     private Long id;
     
     private Cultivo cultivo;
     
     private boolean leido;
     
     private String contenido;
     
     private Date fechaCreacion;
     
     private Date fechaLeido;
     

    public Alertas() {
    }

    public Alertas(Cultivo cultivo, boolean leido, String contenido, Date fechaCreacion, Date fechaLeido) {
       this.cultivo = cultivo;
       this.leido = leido;
       this.contenido = contenido;
       this.fechaCreacion = fechaCreacion;
       this.fechaLeido = fechaLeido;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cultivo_id", nullable=false)
    public Cultivo getCultivo() {
        return this.cultivo;
    }
    
    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }

    
    @Column(name="leido", nullable=false)
    public boolean isLeido() {
        return this.leido;
    }
    
    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    
    @Column(name="contenido", nullable=false, length=500)
    public String getContenido() {
        return this.contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_creacion", nullable=false, length=10)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_leido", nullable=false, length=10)
    public Date getFechaLeido() {
        return this.fechaLeido;
    }
    
    public void setFechaLeido(Date fechaLeido) {
        this.fechaLeido = fechaLeido;
    }

}


