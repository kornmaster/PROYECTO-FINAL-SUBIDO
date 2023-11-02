
package proyectofinal.biblioteca.Entidades;

public class Libro {
    private int idLibro;
    private String ISBN;
    private String titulo;
    private String autor;
    private int anio;
    private String tipo;
    private String editorial;
    private int ejemplares; // Cambio: Cambiado el nombre del campo de "Ejemplares" a "ejemplares"
    private String estado;

    public Libro() {
    }
    private static int contadorId = 1;

    // Cambio: Añadido constructor para inicializar ejemplares
    public Libro(String ISBN, String titulo, String autor, int anio, String tipo, String editorial, String estado) {
        this.idLibro = contadorId++;
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.tipo = tipo;
        this.editorial = editorial;
        this.ejemplares = 0; // Inicializa la cantidad de ejemplares a 0
        this.estado = estado;
    }
    
    // Cambio: Añadido constructor que toma la cantidad de ejemplares como parámetro
    public Libro(String ISBN, String titulo, String autor, int anio, String tipo, String editorial, int ejemplares, String estado) {
        this.idLibro = contadorId++;
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.tipo = tipo;
        this.editorial = editorial;
        this.ejemplares = ejemplares; // Inicializa la cantidad de ejemplares con el valor proporcionado
        this.estado = estado;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio >= 0) {
            this.anio = anio;
        } else {
            // Puedes manejar el error de alguna manera apropiada, como lanzar una excepción.
            System.out.println("El año no puede ser negativo");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio=" + anio +
                ", tipo='" + tipo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", estado=" + estado +
                '}';
    }
}
