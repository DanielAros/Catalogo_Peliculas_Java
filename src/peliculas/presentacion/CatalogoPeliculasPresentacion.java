package peliculas.presentacion;

import java.util.Scanner;
import peliculas.servicio.*;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        int opcion = -1;
        Scanner consola = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
        while(opcion != 0){
            System.out.println("Elige una opcion: \n"
                + "1. Iniciar catalogo de peliculas \n"
                + "2. Agregar pelicula \n"
                + "3. Listar peliculas \n"
                + "4. Buscar pelicula \n"
                + "0. Salir");
            opcion = Integer.parseInt(consola.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Proporciona el nombre de la pelicula");
                    String nombrePelicula = consola.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:    
                    System.out.println("Proporciona el nombre de la pelicula a buscar");
                    String buscar = consola.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }
        }
    }
}
