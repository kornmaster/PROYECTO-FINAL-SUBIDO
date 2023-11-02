
package proyectofinal.biblioteca.AccesoADatos;

import bibliotecatpfinal.Entidades.Ejemplares;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import proyectofinal.biblioteca.Entidades.Lectores;
import proyectofinal.biblioteca.Entidades.Prestamos;
import bibliotecatpfinal.Entidades.Ejemplares;
import bibliotecatpfinal.Entidades.Ejemplares;

/**
 *
 * @author Familia
 */
public class PrestamosDATA {
     private List<Prestamos> prestamos;
     private List<Lectores> lectores;
     private List<Ejemplares> ejemplares;
      public PrestamosDATA() {
        prestamos = new ArrayList<>();
        lectores = new ArrayList<>();
        ejemplares = new ArrayList<>();
        }  
      public boolean realizarPrestamo(Lectores lector, Ejemplares ejemplar, Date fechaPrestamo) {
        if (ejemplar.getCantidadDeEjemplares() > 0) {
            Prestamos prestamo = new Prestamos(generarIdPrestamo(), fechaPrestamo, null, ejemplar, lector, "prestado");
            ejemplar.setCantidadDeEjemplares(ejemplar.getCantidadDeEjemplares() - 1);
            prestamos.add(prestamo);
            return true;
        }
        return false;
    }

  

    public boolean devolverPrestamo(Prestamos prestamo, Date fechaDevolucion) {
        if (prestamo.getEstado().equals("prestado")) {
            prestamo.devolver(fechaDevolucion);
            prestamo.getEjemplar().setCantidadDeEjemplares(prestamo.getEjemplar().getCantidadDeEjemplares() + 1);
            return true;
        }
        return false;
    }


    // préstamos vencidos
    
    public List<Lectores> obtenerLectoresVencidos(Date fechaActual) {
        List<Lectores> lectoresVencidos = new ArrayList<>();
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getEstado().equals("prestado") && prestamo.estaVencido(fechaActual)) {
                lectoresVencidos.add(prestamo.getLector());
            }
        }
        return lectoresVencidos;
    }
    private Ejemplares obtenerEjemplarParaPrestamo() {
        
        for (Ejemplares ejemplar : ejemplares) {
            if (ejemplar.getCantidadDeEjemplares() > 0) {

                return ejemplar;
            }
        }
      
        return null;
    }
    
      public List<Ejemplares> obtenerLibrosPrestadosEnFecha(Date fecha) {
        List<Ejemplares> librosPrestados = new ArrayList<>();
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getEstado().equals("prestado") &&
                prestamo.getFechaInicio().before(fecha) &&
                (prestamo.getFechaFin() == null || prestamo.getFechaFin().after(fecha))) {
                librosPrestados.add(prestamo.getEjemplar());
            }
        }
        return librosPrestados;
    }

    
       public List<Ejemplares> listarLibrosDeAutor(String autor) {
        List<Ejemplares> librosDelAutor = new ArrayList<>();
        for (Prestamos prestamo : prestamos) {
            Ejemplares ejemplar = prestamo.getEjemplar();
            if (ejemplar.getLibro().getAutor().equals(autor)) {
                librosDelAutor.add(ejemplar);
            }
        }
        return librosDelAutor;
    }

    
     public List<String> listarLectoresYLibrosPrestados() {
        List<String> lectoresYLibros = new ArrayList<>();
        for (Prestamos prestamo : prestamos) {
            Lectores lector = prestamo.getLector();
            Ejemplares ejemplar = prestamo.getEjemplar();
            String info = "Lector: " + lector.getNombre() + ", Libro: " + ejemplar.getLibro().getTitulo();
            lectoresYLibros.add(info);
        }
        return lectoresYLibros;
    }
     public Lectores buscarLectorPorDNI(int dni) {
    for (Lectores lector : lectores) {
        if (lector.getDni() == dni) {
            return lector; 
        }
    }
    return null; 
}

    
    private int generarIdPrestamo() {
        // un ID único, por ejemplo, incrementando un contador.
        
        return prestamos.size() + 1;
    }
}
  