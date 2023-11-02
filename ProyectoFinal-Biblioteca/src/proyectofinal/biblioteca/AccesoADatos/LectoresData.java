/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.biblioteca.AccesoADatos;

import proyectofinal.biblioteca.Entidades.Lectores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author kornm
 */
public class LectoresData {

    private Connection con = null;

    public LectoresData() {

        //con=Conexion.getConexion();   
        con = Conexion.Getconexion();// aca puse como lo tiene mi compañero
    }

    // CARGAR LECTORES
    public void guardarLectores(Lectores lectores) {

        String sql = "INSERT INTO lectores (nombre,domicilio,mail,estado,dni)"
                + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, lectores.getNombre());
            ps.setString(2, lectores.getDomicilio());
            ps.setString(3, lectores.getMail());
            ps.setBoolean(4, lectores.isEstado());
            ps.setInt(5, lectores.getDni());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                lectores.setIdSocio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, " Socio Registrado");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia");
        }

    }

    public void modificarLectores(Lectores lectores) {
        /* String sql = "UPDATE lectores SET nombre= ?, domicilio= ?, mail = ?, dni = ?" 
                + "WHERE idSocio = ?";*/
        String sql = "UPDATE lectores SET nombre = ?, domicilio = ?, mail = ?,estado = ?, dni = ? WHERE idSocio = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lectores.getNombre());
            ps.setString(2, lectores.getDomicilio());
            ps.setString(3, lectores.getMail());
            ps.setBoolean(4, lectores.isEstado());
            ps.setInt(5, lectores.getDni());
            ps.setInt(6, lectores.getIdSocio()); // se va a modificar segun este ID
            int exito = ps.executeUpdate();// devuelve un entero con la cantidad de filas afectadas, en este casi es 1
            if (exito == 1) {// si pudo modificar el alumno

                JOptionPane.showMessageDialog(null, "Se guardaron los cambios");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lectores");
        }

    }

    public void eliminarLectores(int id) {
        String sql = " UPDATE lectores SET estado = 0  WHERE idSocio = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, " Socio dado de BAJA");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }

    }
// BUSCAR SOCIO POR ID
    public Lectores buscarLectoresId(int id) {

        String sql = "SELECT * FROM lectores  WHERE idSocio = ? ";// AND estado = 1 ";
        Lectores lectores = null;// creo esta variable porq tenes que devolver el alumno que encontremos
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);// aca modigica ? por el id q recibimos como parametro
            ResultSet rs = ps.executeQuery();// execute.. es un metodo que ejectura una consulta sql en una BD y devuelve un objeto ResultSet que contiene los resultados de la consulta
            if (rs.next()) {// si hay un elemenot ?
                lectores = new Lectores();// a la variable lectores, le asigno un lector vacio
                lectores.setIdSocio(id);// ahora le empiezo a setear, en el lector vacio creado,  los datos que me devolvio el rs, en este caso el id lo saco de parametro porq es lo mismo
                lectores.setNombre(rs.getString("nombre"));
                lectores.setDomicilio(rs.getString("domicilio"));
                lectores.setMail(rs.getString("mail"));
                lectores.setDni(rs.getInt("dni"));// agregue esta fila, para obtener el año
                lectores.setEstado(rs.getBoolean("estado"));

            } else {// en caso de que no exista el alumno
                JOptionPane.showMessageDialog(null, "No existe el id del socio");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lectores");

        }
        return lectores;

    }
//BUSCAR SOCIO POR DNI
  
   public Lectores buscarLectoresDni(int dni){
        String sql = "SELECT * FROM lectores  WHERE dni = ? ";// AND estado = 1 ";
        Lectores lectores = null;// creo esta variable porq tenes que devolver el alumno que encontremos
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);// aca modigica ? por el id q recibimos como parametro
            ResultSet rs = ps.executeQuery();// execute.. es un metodo que ejectura una consulta sql en una BD y devuelve un objeto ResultSet que contiene los resultados de la consulta
            if (rs.next()) {// si hay un elemenot ?
                lectores = new Lectores();// a la variable lectores, le asigno un lector vacio
                lectores.setIdSocio(rs.getInt("idSocio"));// ahora le empiezo a setear, en el lector vacio creado,  los datos que me devolvio el rs, en este caso el id lo saco de parametro porq es lo mismo
                lectores.setNombre(rs.getString("nombre"));
                lectores.setDomicilio(rs.getString("domicilio"));
                lectores.setMail(rs.getString("mail"));
                lectores.setDni(rs.getInt("dni"));//el dni lo puedo sacar tambien del parametro directamente, pero aca lo saco del rs q obtuve
                lectores.setEstado(rs.getBoolean("estado"));

            } else {// en caso de que no exista el alumno
                JOptionPane.showMessageDialog(null, "No existe el DNI del socio");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lectores");

        }
        return lectores;

    }
   // BUSCAR SOCIO POR DNI DEVOLVIENDO UN BOOLEANO
    public Boolean buscarLectoresDni2(int dni){
        String sql = "SELECT * FROM lectores  WHERE dni = ? ";// AND estado = 1 ";
        Boolean resultado = null;// creo esta variable porq tenes que devolver el alumno que encontremos
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);// aca modigica ? por el id q recibimos como parametro
            ResultSet rs = ps.executeQuery();// execute.. es un metodo que ejectura una consulta sql en una BD y devuelve un objeto ResultSet que contiene los resultados de la consulta
            if (rs.next()) {// si hay un elemenot ?
                resultado= true;

            } else {// en caso de que no exista el alumno
                resultado=false;
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lectores");

        }
        return resultado;

    }
   // LISTAR TODOS LOS LECTORES DE LA BASE DE DATOS
    public List<Lectores> listarLectores() {// luego lo filtramos por aparte los activos e inactivos
        String sql = "SELECT * FROM lectores";
        ArrayList<Lectores> lectores = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);//Se utiliza para preparar una consulta SQL en Java
             ResultSet rs = ps.executeQuery()) {  // hace una consulta a nuestra base de datos y devuelve un resultSet ( como una matriz)

            while (rs.next()) {//hago un recorrido de ese ResultSEt, next() mueve el cursos a la siguiente fila de datos y devuelve true si hay una fila disponible

                Lectores lector = new Lectores();// creo un materia vacia
                lector.setIdSocio(rs.getInt("idSocio"));// le seteo al idSocio, lo que obtengo de ResultSet
                lector.setNombre(rs.getString("nombre"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setMail(rs.getString("mail"));
                lector.setDni(rs.getInt("dni"));
                lector.setEstado(rs.getBoolean("estado"));

                lectores.add(lector);  // aca usamos la lista llamada lectores y le agregamos el lector creado                                           
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los libros en la base de datos");
            //e.printStackTrace(); // concateno esto para que me muestre mejor el error
        }

        return lectores;// retorno el ArrayList con los lectores agregados

    }

   
}
