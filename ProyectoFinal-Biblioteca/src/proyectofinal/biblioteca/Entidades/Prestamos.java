
package proyectofinal.biblioteca.Entidades;
import bibliotecatpfinal.Entidades.Ejemplares;
import java.util.Date;
/**
 *
 * @author Familia
 */
public class Prestamos {
    private int idPrestamo;
    private Date fechaInicio;
    private Date fechaFin;
    private Ejemplares ejemplar;
    private Lectores lector;
    private String estado;
    
    public Ejemplares getEjemplar() {
    return ejemplar;
}

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
   
    public void setEjemplar(Ejemplares ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Lectores getLector() {
        return lector;
    }

    public void setLector(Lectores lector) {
        this.lector = lector;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Prestamos(int idPrestamo, Date fechaInicio, Date fechaFin, Ejemplares ejemplar, Lectores lector, String estado) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.estado = estado;
    }

    public void devolver(Date fechaDevolucion) {
        if (estado.equals("prestado")) {
            fechaFin = fechaDevolucion;
            estado = "devuelto";
        } else {
            System.out.println("El libro ya ha sido devuelto anteriormente.");
        }
    }

    public boolean estaVencido() {
        Date fechaActual = new Date();
        return fechaFin.before(fechaActual);
    }

    @Override
    public String toString() {
        return "Prestamo ID: " + idPrestamo + ", Estado: " + estado + ", Fecha de inicio: " + fechaInicio + ", Fecha de fin: " + fechaFin;
    }

    public boolean estaVencido(Date fechaActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

