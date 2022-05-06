package es.upm.dit.isst.tfgapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VOTACION {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idvotacion;
    private String fechayhoralimite;
    private String tema;
    private Integer votos;
    

    public VOTACION () { }
    public VOTACION(String idvotacion, String tema, String fechayhoralimite, Integer votos) {
        this.idvotacion = idvotacion;
        this.tema = tema;
        this.fechayhoralimite = fechayhoralimite;
        this.votos = votos;
    
    }
    
    
    public Integer getVotos() {
        return votos;
    }
    public void setVotos(Integer votos) {
        this.votos = votos;
    }
    public String getFechayhoralimite() {
        return fechayhoralimite;
    }
    public void setFechayhoralimite(String fechayhoralimite) {
        this.fechayhoralimite = fechayhoralimite;
    }
    public String getIdvotacion() {
        return idvotacion;
    }
    public void setIdvotacion(String idvotacion) {
        this.idvotacion = idvotacion;
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    
}
