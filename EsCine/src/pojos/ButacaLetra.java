package pojos;
// Generated 25-ene-2024 20:23:40 by Hibernate Tools 4.3.1



/**
 * ButacaLetra generated by hbm2java
 */
public class ButacaLetra  implements java.io.Serializable {


     private int pos;
     private String letra;
     private int fila;
     private String butaca;

    public ButacaLetra() {
    }

    public ButacaLetra(int pos, String letra, int fila, String butaca) {
       this.pos = pos;
       this.letra = letra;
       this.fila = fila;
       this.butaca = butaca;
    }
   
    public int getPos() {
        return this.pos;
    }
    
    public void setPos(int pos) {
        this.pos = pos;
    }
    public String getLetra() {
        return this.letra;
    }
    
    public void setLetra(String letra) {
        this.letra = letra;
    }
    public int getFila() {
        return this.fila;
    }
    
    public void setFila(int fila) {
        this.fila = fila;
    }
    public String getButaca() {
        return this.butaca;
    }
    
    public void setButaca(String butaca) {
        this.butaca = butaca;
    }




}


