package pojos;
// Generated 25-ene-2024 20:23:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Peliculas generated by hbm2java
 */
public class Peliculas  implements java.io.Serializable {


     private Integer pid;
     private String titulo;
     private String director;
     private String nacionalidad;
     private String genero;
     private String clasificacion;
     private String descr;
     private double duracion;
     private String actores;
     private String linkExterior;
     private String linkImagen;
     private int estado;
     private Set disponibles = new HashSet(0);
     private Set peliculaSalas = new HashSet(0);

    public Peliculas() {
    }

	
    public Peliculas(String titulo, String director, String nacionalidad, String genero, String clasificacion, String descr, double duracion, String actores, String linkExterior, String linkImagen, int estado) {
        this.titulo = titulo;
        this.director = director;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.descr = descr;
        this.duracion = duracion;
        this.actores = actores;
        this.linkExterior = linkExterior;
        this.linkImagen = linkImagen;
        this.estado = estado;
    }
    public Peliculas(String titulo, String director, String nacionalidad, String genero, String clasificacion, String descr, double duracion, String actores, String linkExterior, String linkImagen, int estado, Set disponibles, Set peliculaSalas) {
       this.titulo = titulo;
       this.director = director;
       this.nacionalidad = nacionalidad;
       this.genero = genero;
       this.clasificacion = clasificacion;
       this.descr = descr;
       this.duracion = duracion;
       this.actores = actores;
       this.linkExterior = linkExterior;
       this.linkImagen = linkImagen;
       this.estado = estado;
       this.disponibles = disponibles;
       this.peliculaSalas = peliculaSalas;
    }
   
    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDirector() {
        return this.director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getClasificacion() {
        return this.clasificacion;
    }
    
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public String getDescr() {
        return this.descr;
    }
    
    public void setDescr(String descr) {
        this.descr = descr;
    }
    public double getDuracion() {
        return this.duracion;
    }
    
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    public String getActores() {
        return this.actores;
    }
    
    public void setActores(String actores) {
        this.actores = actores;
    }
    public String getLinkExterior() {
        return this.linkExterior;
    }
    
    public void setLinkExterior(String linkExterior) {
        this.linkExterior = linkExterior;
    }
    public String getLinkImagen() {
        return this.linkImagen;
    }
    
    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }
    public int getEstado() {
        return this.estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public Set getDisponibles() {
        return this.disponibles;
    }
    
    public void setDisponibles(Set disponibles) {
        this.disponibles = disponibles;
    }
    public Set getPeliculaSalas() {
        return this.peliculaSalas;
    }
    
    public void setPeliculaSalas(Set peliculaSalas) {
        this.peliculaSalas = peliculaSalas;
    }




}


