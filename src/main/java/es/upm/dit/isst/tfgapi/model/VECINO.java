/*package es.upm.dit.isst.tfgapi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class VECINO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String dni;
    private String nombre;
    private String piso;
    private String clave;
    
//HACE FALTA????

    //private Boolean enabled;

    /*@ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "comunidad_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private COMUNIDAD comunidad;

    public VECINO () { }

    public VECINO(String dni, String nombre, String piso, String clave) {
        this.dni = dni;
        this.nombre = nombre;
        this.piso = piso;
        this.clave = clave;
        //this.comunidad = comunidad;

    }
    
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPiso() {
        return piso;
    }
    public void setPiso(String piso) {
        this.piso = piso;
    }
    
    
}
*/