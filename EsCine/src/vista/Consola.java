/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import pojos.Peliculas;

/**
 *
 * @author alvaro.paniego
 */
public class Consola {

    public int menu() {
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************Menu**************************");
        System.out.println("1. Insertar película.");
        System.out.println("2. Borrar película.");
        System.out.println("3. Modificar pelicula.");
        System.out.println("4. Mostrar películas.");
        System.out.println("5. Insertar disponibles.");
        System.out.println("6. Comprobar butaca.");
        System.out.println("7. Mostrar sala.");
        System.out.println("0. Salir");
        System.out.println("********************************************************");
        
        opcion = scanner.nextInt();
        
        return opcion;
    }
    
    public Peliculas pidePeliculas(){
        Scanner scanner = new Scanner(System.in);
        double duracion;
        String titulo, director, nacionalidad, genero, clasificacion, decr, actores, linkExterior, linkImagen;
        System.out.print("Inserta el titulo de la pelicula: ");
        titulo = scanner.nextLine();
        System.out.print("Inserta el director de la película: ");
        director = scanner.nextLine();
        System.out.print("Introduce la nacionalodad: ");
        nacionalidad = scanner.nextLine();
        System.out.print("Introduce el genero: ");
        genero = scanner.nextLine();
        System.out.print("Introduce la clasificacion: ");
        clasificacion = scanner.nextLine();
        System.out.print("Introduce la descripcion: ");
        decr = scanner.nextLine();
        System.out.println("Introduce la duracion de la pelicula");
        duracion = scanner.nextDouble();
        System.out.print("Introduce los actores: ");
        actores = scanner.nextLine();
        System.out.print("Introduce el link de la pelicula: ");
        linkExterior = scanner.nextLine();
        System.out.print("Introduce el link de la imagen: ");
        linkImagen = scanner.nextLine();
        
        
        return new Peliculas(titulo, director, nacionalidad, genero, clasificacion, decr, duracion, actores, linkExterior, linkImagen, 0);
    }
    public Peliculas modificaPeliculas(Peliculas peli){
        Scanner scanner = new Scanner(System.in);
        peli.setTitulo(scanner.nextLine());
        return peli;
    }
    
    public String pideString(String texto){
        Scanner scanner = new Scanner(System.in);
        System.out.print(texto);
        return scanner.nextLine();
    }
    
    public int pideInt(String texto){
        Scanner scanner = new Scanner(System.in);
        System.out.print(texto);
        return scanner.nextInt();
    }
}
