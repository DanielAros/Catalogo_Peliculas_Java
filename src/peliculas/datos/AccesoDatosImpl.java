package peliculas.datos;

import java.util.List;
import peliculas.domain.Pelicula;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        return true;
    }

    @Override
    public List<Pelicula> listar(String nombre) {
        
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        return "prueba";
    }

    @Override
    public void crear(String nombreArchivo) {
        
    }

    @Override
    public void borrar(String nombreArchivo) {
        
    }
    
}
