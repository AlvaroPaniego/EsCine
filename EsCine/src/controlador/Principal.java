/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
        String tituloPelicula, butaca;
        int pid, sid, tid;
        int opcion = -1;
        do {
            opcion = c.menu();
            switch (opcion) {
                case 1:
                    peliDAO.guardaPeliculas(c.pidePeliculas());
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
                    break;
                case 0:
                    break;

                default:
            }
        } while (opcion != 0);
    }

}
