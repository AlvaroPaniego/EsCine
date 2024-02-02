package pojos;
// Generated 25-ene-2024 20:23:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Pases generated by hbm2java
 */
public class Pases  implements java.io.Serializable {


     private Integer tid;
     private String hora;
     private Set disponibles = new HashSet(0);
     private Set paseSalas = new HashSet(0);

    public Pases() {
    }

	
    public Pases(String hora) {
        this.hora = hora;
    }
    public Pases(String hora, Set disponibles, Set paseSalas) {
       this.hora = hora;
       this.disponibles = disponibles;
       this.paseSalas = paseSalas;
    }
   
    public Integer getTid() {
        return this.tid;
    }
    
    public void setTid(Integer tid) {
        this.tid = tid;
    }
    public String getHora() {
        return this.hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    public Set getDisponibles() {
        return this.disponibles;
    }
    
    public void setDisponibles(Set disponibles) {
        this.disponibles = disponibles;
    }
    public Set getPaseSalas() {
        return this.paseSalas;
    }
    
    public void setPaseSalas(Set paseSalas) {
        this.paseSalas = paseSalas;
    }




}


