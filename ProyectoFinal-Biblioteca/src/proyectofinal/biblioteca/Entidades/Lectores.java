
package proyectofinal.biblioteca.Entidades;


public class Lectores {
     private int idSocio;
    private String nombre;
    private String domicilio;
    private String mail;
    private boolean estado;
    private int dni;

    public Lectores() {
    }

    public Lectores(int idSocio, String nombre, String domicilio, String mail, boolean estado, int dni) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.estado = estado;
        this.dni = dni;
    }

    public Lectores(String nombre, String domicilio, String mail, boolean estado, int dni) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.estado = estado;
        this.dni = dni;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
  

    @Override
    public String toString() {
        return "Lectores{" + "idSocio=" + idSocio + ", nombre=" + nombre + ", domicilio=" + domicilio + ", mail=" + mail + ", estado=" + estado + '}';
    }
    
    
}
