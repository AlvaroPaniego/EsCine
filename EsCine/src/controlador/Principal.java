/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.ControladorDisponibles;
import modelo.DisponiblesDAO;
import modelo.PeliculaDAO;
import vista.Consola;

/**
 *
 * @author alvaro.paniego
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PeliculaDAO peliDAO = new PeliculaDAO();
        DisponiblesDAO dispDAO = new DisponiblesDAO();
        ControladorDisponibles cd = new ControladorDisponibles();
        Consola c = new Consola();
        ArrayList<Integer> listaEspectadores = new ArrayList<>();
        ArrayList<String> listaPelis = new ArrayList<>();
        String tituloPelicula, butaca;
        int pid, sid, tid , maxEspectadores = 0, i = 0;
        int opcion = -1;
        do {
            opcion = c.menu();
            switch (opcion) {
                case 1:
                    peliDAO.guardaPeliculas(c.pidePeliculas());
                    break;
                case 2:
                    pid = c.pideInt("Introduce el id de la pelicula a borrar: ");
                    peliDAO.eliminaPeliculas(peliDAO.obtenPeliculas(pid));
                    break;
                case 3:
                    pid = c.pideInt("Introduce el id de la pelicula a modificar: ");
                    peliDAO.actualizaPeliculas(c.modificaPeliculas(peliDAO.obtenPeliculas(pid)));
                    break;
                case 4:
                    c.mostrarPeliculas(peliDAO.obtenListaPeliculas());
                    break;
                case 5:
                    cd.insertarSalaSesionPelicula(2, 1, 2);
                    cd.insertarSalaSesionPelicula(15, 1, 3);
                    cd.insertarSalaSesionPelicula(15, 2, 1);
                    cd.insertarSalaSesionPelicula(15, 2, 2);
                    cd.insertarSalaSesionPelicula(1, 2, 3);
                    cd.insertarSalaSesionPelicula(2, 3, 1);
                    cd.insertarSalaSesionPelicula(1, 3, 2);
                    cd.insertarSalaSesionPelicula(2, 3, 3);
                    break;
                case 6:
                    tituloPelicula = c.pideString("Introduce la pelicula: ");
                    pid = peliDAO.obtenIdPorTitulo(tituloPelicula);
                    sid = c.pideInt("Introduce el numero de la sala: ");
                    butaca = c.pideString("Introduce la butaca: ");
                    if(dispDAO.combrobarButaca(pid, sid, butaca) == 1){
                        System.out.println("Butaca ocupada");
                    }else{
                        System.out.println("Butaca libre");
                    }
                    break;
                case 7:
                    sid = c.pideInt("Introduce el numero de la sala: ");
                    tid = c.pideInt("Introduce el numero del pase: ");
                    c.mostrarSala(dispDAO.obtenListaDisponiblesPorSalaSesion(sid, tid));
                    break;
                case 8:
                    int peliConMasEspectadores = -1;
                    listaEspectadores.add(dispDAO.cogeEspectadores(1));
                    listaEspectadores.add(dispDAO.cogeEspectadores(2));
                    listaEspectadores.add(dispDAO.cogeEspectadores(15));
                    
                    listaPelis.add(peliDAO.obtenPeliculas(1).getTitulo());
                    listaPelis.add(peliDAO.obtenPeliculas(2).getTitulo());
                    listaPelis.add(peliDAO.obtenPeliculas(15).getTitulo());
                    
                    System.out.println(listaPelis.get(0) + " tiene " + listaEspectadores.get(0) + " espectadores");
                    System.out.println(listaPelis.get(1) + " tiene " + listaEspectadores.get(1) + " espectadores");
                    System.out.println(listaPelis.get(2) + " tiene " + listaEspectadores.get(2) + " espectadores");
                    
                    for (Integer listaEspectadore : listaEspectadores) {
                        
                        if(listaEspectadore > maxEspectadores){
                            maxEspectadores = listaEspectadore;
                            peliConMasEspectadores = i;
                        }
                        i++;
                    }
                    System.out.println("La pelicula con mas espectadores es " + listaPelis.get(peliConMasEspectadores) + " con " + maxEspectadores + " especatodores.");
                    i = 0;
                    break;                        
                case 0:
                    break;

                default:
            }
        } while (opcion != 0);
    }

}
