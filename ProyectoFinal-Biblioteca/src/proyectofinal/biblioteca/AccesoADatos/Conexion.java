
package proyectofinal.biblioteca.AccesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DB = "sistemadebiblioteca";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    
    private Conexion() {}
    
    public static Connection Getconexion() {
        if (connection ==null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
                JOptionPane.showMessageDialog(null, "Conectado:");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar el driver:");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Conectar a la BD:");
            }
        }
        
        return connection;
    }
}

