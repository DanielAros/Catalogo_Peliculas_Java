package peliculas.datos;

import java.io.*;
import java.util.*;
import peliculas.domain.Pelicula;
import peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {
    
    @Override
    public boolean existe(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        return archivo.isFile();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx{
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while(linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());//Propagamos la excepcion
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());//Propagamos la excepcion
        }
        
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx{
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha anexado la pelicula al archivo " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al listar peliculas: " + ex.getMessage());//Propagamos la excepcion
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while(linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula " + linea + "encontada en el indice: " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar la pelicula: " + ex.getMessage());//Propagamos la excepcion
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar la pelicula: " + ex.getMessage());//Propagamos la excepcion
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx{
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo: " + nombreArchivo);
        }catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear el archivo: " + ex.getMessage());//Propagamos la excepcion
        }
    }

    @Override
    public void borrar(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        if(archivo.exists()){
            archivo.delete();
            System.out.println("Se ha borrado el archivo");
        }
    }
    
}
