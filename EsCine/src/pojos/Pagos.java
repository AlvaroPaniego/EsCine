package pojos;
// Generated 25-ene-2024 20:23:40 by Hibernate Tools 4.3.1



/**
 * Pagos generated by hbm2java
 */
public class Pagos  implements java.io.Serializable {


     private Integer id;
     private String tarjeta;
     private String mes;
     private String ano;
     private String tel;

    public Pagos() {
    }

    public Pagos(String tarjeta, String mes, String ano, String tel) {
       this.tarjeta = tarjeta;
       this.mes = mes;
       this.ano = ano;
       this.tel = tel;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTarjeta() {
        return this.tarjeta;
    }
    
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    public String getMes() {
        return this.mes;
    }
    
    public void setMes(String mes) {
        this.mes = mes;
    }
    public String getAno() {
        return this.ano;
    }
    
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }




}


