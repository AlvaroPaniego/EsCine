/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import pojos.Disponible;

/**
 *
 * @author alvaro.paniego
 */
public class ControladorDisponibles {

    public void insertarSalaSesionPelicula(int pid, int sid, int tid) {
        DisponiblesDAO d = new DisponiblesDAO();
        SalaDAO s = new SalaDAO();
        PasesDAO p = new PasesDAO();
        PeliculaDAO peli = new PeliculaDAO();
        Disponible disponible;
        int pos = d.obtenPosicion();
        for (int fila = 1; fila < 10; fila++) {
            for (char letra = 'A'; letra < 'Y'; letra++) {
                pos++;
                if(letra == 'P'){
                    disponible = new Disponible(p.obtenPases(tid), peli.obtenPeliculas(pid), s.obtenSalas(sid), fila, "PP", fila + letra + "P", (int) Math.floor(Math.random()*2), pos);
                }else{
                    disponible = new Disponible(p.obtenPases(tid), peli.obtenPeliculas(pid), s.obtenSalas(sid), fila, String.valueOf(letra), fila + letra + "", (int) Math.floor(Math.random()*2), pos);  
                }
                d.guardaDisponible(disponible);
                if(letra == 'N'){
                    d.guardaDisponible(new Disponible(p.obtenPases(tid), peli.obtenPeliculas(pid), s.obtenSalas(sid), fila, "Ñ", fila + "Ñ", (int) Math.floor(Math.random()*2), pos));
                    d.guardaDisponible(disponible);
                }
            }
        }
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            disponible = new Disponible(p.obtenPases(tid), peli.obtenPeliculas(pid), s.obtenSalas(sid), 10, String.valueOf(letra), 10 + letra + "", (int) Math.floor(Math.random()*2), pos);
            d.guardaDisponible(disponible);
        }
        d.guardaDisponible(new Disponible(p.obtenPases(tid), peli.obtenPeliculas(pid), s.obtenSalas(sid), 10, "AA", 10 + "AA", (int) Math.floor(Math.random()*2), pos));
        d.guardaDisponible(new Disponible(p.obtenPases(tid), peli.obtenPeliculas(pid), s.obtenSalas(sid), 10, "AB", 10 + "AB", (int) Math.floor(Math.random()*2), pos));
    }
}
