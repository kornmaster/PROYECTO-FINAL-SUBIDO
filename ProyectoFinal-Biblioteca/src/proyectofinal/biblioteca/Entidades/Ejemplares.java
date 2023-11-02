package bibliotecatpfinal.Entidades;

import proyectofinal.biblioteca.Entidades.Libro;

public class Ejemplares {
    private int idCodigoEjemplar; // Cambio #1: Cambiando el tipo de idCodigoEjemplar a int
    private Libro libro;
    private String estado;
    private int cantidadDeEjemplares;

    public Ejemplares() {
    }

    // Cambio #2: Modificando el constructor para aceptar un objeto Libro y cambiar el tipo de idCodigoEjemplar
    public Ejemplares(int idCodigoEjemplar, Libro libro, String estado, int cantidadDeEjemplares) {
        this.idCodigoEjemplar = idCodigoEjemplar;
        this.libro = libro;
        this.estado = estado;
        this.cantidadDeEjemplares = cantidadDeEjemplares;
    }

    public int getCantidadEjemplares() {
        return this.cantidadDeEjemplares;
    }

    public int getIdCodigoEjemplar() {
        return this.idCodigoEjemplar;
    }

    public void setIdCodigoEjemplar(int idCodigoEjemplar) {
        this.idCodigoEjemplar = idCodigoEjemplar;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadDeEjemplares() {
        return cantidadDeEjemplares;
    }

    public void setCantidadDeEjemplares(int cantidadDeEjemplares) {
        this.cantidadDeEjemplares = cantidadDeEjemplares;
    }
}


/*public class Ejemplares {
        
    private int idCodigoEjemplar;
    private Libro libro;
    private String estado;
    private int cantidadDeEjemplares;

    public Ejemplares() {
    }

    public Ejemplares(Libro libro, String estado, int cantidadDeEjemplares) {
        this.libro = libro;
        this.estado = estado;
        this.cantidadDeEjemplares = cantidadDeEjemplares;
    }

    public Ejemplares(int idCodigoEjemplar, Libro libro, String estado, int cantidadDeEjemplares) {
        this.idCodigoEjemplar = idCodigoEjemplar;
        this.libro = libro;
        this.estado = estado;
        this.cantidadDeEjemplares = cantidadDeEjemplares;
    }
    
    public Ejemplares(int idCodigoEjemplar, int idLibro, String estado, int cantidadDeEjemplares) {
        this.idCodigoEjemplar = idCodigoEjemplar;
        this.libro = new Libro(idLibro, "ISBN-123", "titulo falopa", "autor desconocido", 0, "desconocido", "editorial desconocida", "desconocido");

        this.estado = estado;
        this.cantidadDeEjemplares = cantidadDeEjemplares;
    }

    public int getIdCodigoEjemplar() {
        return this.idCodigoEjemplar;
    }

    public void setIdCodigoEjemplar(int idCodigoEjemplar) {
        this.idCodigoEjemplar = idCodigoEjemplar;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadDeEjemplares() {
        return cantidadDeEjemplares;
    }

    public void setCantidadDeEjemplares(int cantidadDeEjemplares) {
        this.cantidadDeEjemplares = cantidadDeEjemplares;
    }
   
}*/