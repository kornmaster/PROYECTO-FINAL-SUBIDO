package bibliotecatpfinal.AccesoADatos;

import bibliotecatpfinal.Entidades.Ejemplares;
import proyectofinal.biblioteca.Entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectofinal.biblioteca.AccesoADatos.Conexion;

public class EjemplaresData {

    private Connection con = null;

    public EjemplaresData() {
        this.con = Conexion.Getconexion();
    }

    public Ejemplares buscarEjemplarByID(String idEjemplar) throws SQLException {
           Ejemplares ejemplar = null;
    try {
        String query = "SELECT * FROM ejemplares WHERE idCodigoEjemplar = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, idEjemplar);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            // Procede a crear una instancia de Ejemplares
            // Ejemplares ejemplar = new Ejemplares();
             /*Ejemplares ejemplar = null;
        try {
            String query = "SELECT * FROM ejemplares WHERE idCodigoEjemplar = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, idCodigoEjemplar);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idLibro = resultSet.getInt("idLibro");
                String estado = resultSet.getString("estado");
                int cantidadDeEjemplares = resultSet.getInt("cantidadDeEjemplares");
                Libro libro = buscarLibroPorID(idLibro);
                ejemplar = new Ejemplares(idCodigoEjemplar, libro, estado, cantidadDeEjemplares);*/
        }
    } catch (SQLException ex) {
     
    }
    return ejemplar;
        
    }
    public int obtenerUltimoIdCodigoEjemplar() {
    int ultimoId = 0;
    try {
        String query = "SELECT MAX(idCodigoEjemplar) AS ultimoId FROM ejemplares";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            ultimoId = resultSet.getInt("ultimoId");
        }
    } catch (SQLException ex) {
        // Manejar las excepciones apropiadamente
    }
    return ultimoId;
}

    public void guardarEjemplares(Ejemplares ejemplares) throws SQLException {
        String sql = "INSERT INTO ejemplares (libro, estado, cantidadDeEjemplares) VALUES(?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ejemplares.getLibro().getIdLibro());
            ps.setString(2, ejemplares.getEstado());
            ps.setInt(3, ejemplares.getCantidadDeEjemplares());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ejemplares.setIdCodigoEjemplar(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ejemplar Guardado");
            }
            ps.close();
        } catch (SQLException ex) {
            // Manejo adecuado de excepciones
            throw new SQLException("Error al guardar ejemplar: " + ex.getMessage());
        }
    }

    public void actualizarEjemplares(Ejemplares ejemplares) throws SQLException {
        String sql = "UPDATE ejemplares SET libro = ?, cantidadDeEjemplares = ?, estado = ? WHERE idCodigoEjemplar = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ejemplares.getLibro().getIdLibro());
            ps.setInt(2, ejemplares.getCantidadDeEjemplares());
            ps.setString(3, ejemplares.getEstado());
            ps.setInt(4, ejemplares.getIdCodigoEjemplar());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ejemplar modificado");
            }
            ps.close();
        } catch (SQLException ex) {
            // Manejo adecuado de excepciones
            throw new SQLException("Error al actualizar ejemplar: " + ex.getMessage());
        }
    }

    public void borrarEjemplares(int idCodigoEjemplar) throws SQLException {
        String sql = "UPDATE ejemplares SET isEliminado = 1 WHERE idCodigoEjemplar = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCodigoEjemplar);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ejemplar borrado");
            }
            ps.close();
        } catch (SQLException ex) {
            // Manejo adecuado de excepciones
            throw new SQLException("Error al borrar ejemplar: " + ex.getMessage());
        }
    }

    public ArrayList<Ejemplares> listarEjemplaresActivos() throws SQLException {
        ArrayList<Ejemplares> ejemplaresLista = new ArrayList<Ejemplares>();
    String sql = "SELECT * FROM ejemplares WHERE estado != 0";

    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idCodigoEjemplar = rs.getInt(1);
            int idLibro = rs.getInt(2); // Esto es correcto, no se debe cambiar aquí
            String estado = rs.getString(3);
            int cantidadDeEjemplares = rs.getInt(4);
            Libro libro = buscarLibroPorID(idLibro); // Buscar el libro asociado al ejemplar
            Ejemplares ejemplar = new Ejemplares(idCodigoEjemplar, libro, estado, cantidadDeEjemplares);
            ejemplaresLista.add(ejemplar);
        }
        ps.close();
        return ejemplaresLista;
    } catch (SQLException ex) {
        throw new SQLException("Error al listar ejemplares activos: " + ex.getMessage());
        }
    }

    public ArrayList<Ejemplares> listarEjemplaresInactivos() throws SQLException {
          ArrayList<Ejemplares> ejemplaresLista = new ArrayList<Ejemplares>();
    String sql = "SELECT * FROM ejemplares WHERE estado = 0";

    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idCodigoEjemplar = rs.getInt(1);
            int idLibro = rs.getInt(2);
            String estado = rs.getString(3);
            int cantidadDeEjemplares = rs.getInt(4);
            Libro libro = new Libro(); // Crear una instancia de Libro antes de usarla
            libro.setIdLibro(idLibro);
            Ejemplares ejemplar = new Ejemplares(idCodigoEjemplar, libro, estado, cantidadDeEjemplares);
            ejemplaresLista.add(ejemplar);
        }
        ps.close();
        return ejemplaresLista;
    } catch (SQLException ex) {
        throw new SQLException("Error al listar ejemplares inactivos: " + ex.getMessage());
        }
    }

    private Libro buscarLibroPorID(int idLibro) throws SQLException {
        Libro libro = null;
        String sql = "SELECT * FROM libro WHERE idLibro = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLibro);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String ISBN = rs.getString("ISBN");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anio = rs.getInt("anio");
                String tipo = rs.getString("tipo");
                String editorial = rs.getString("editorial");
                String estadoLibro = rs.getString("estado");

                libro.setIdLibro(idLibro);
                libro.setISBN(ISBN);
                libro.setTitulo(titulo);
                libro.setAutor(autor);
                libro.setAnio(anio);
                libro.setTipo(tipo);
                libro.setEditorial(editorial);
                libro.setEstado(estadoLibro);
            }
            ps.close();
            return libro;
        } catch (SQLException ex) {
            // Manejo adecuado de excepciones
            throw new SQLException("Error al buscar libro por ID: " + ex.getMessage());
        }
    }
}


/*package bibliotecatpfinal.AccesoADatos;

import bibliotecatpfinal.Entidades.Ejemplares;
import proyectofinal.biblioteca.Entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectofinal.biblioteca.AccesoADatos.Conexion;

public class EjemplaresData {

    private Connection con = null;

    public EjemplaresData() {

        this.con = Conexion.Getconexion();

    }
    
    public Ejemplares buscarEjemplarByID(String idEjemplar) throws SQLException {
    Ejemplares ejemplar = null;
    String sql = "SELECT e.idCodigoEjemplar, e.estado, e.cantidadDeEjemplares, l.idLibro, l.ISBN, l.titulo, l.autor, l.anio, l.tipo, l.editorial, l.CantidadDeEjemplares, l.estado AS estadoLibro " +
                 "FROM ejemplares AS e " +
                 "INNER JOIN libro AS l ON e.libro = l.idLibro " +
                 "WHERE e.idCodigoEjemplar = ? AND e.isEliminado = 0";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, idEjemplar);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int idCodigoEjemplar = rs.getInt("idCodigoEjemplar");
            String estado = rs.getString("estado");
            int cantidadDeEjemplares = rs.getInt("cantidadDeEjemplares");
            int idLibro = rs.getInt("idLibro");
            String ISBN = rs.getString("ISBN");
            String titulo = rs.getString("titulo");
            String autor = rs.getString("autor");
            int anio = rs.getInt("anio");
            String tipo = rs.getString("tipo");
            String editorial = rs.getString("editorial");
            int cantidadDeEjemplaresLibro = rs.getInt("CantidadDeEjemplares");
            String estadoLibro = rs.getString("estadoLibro");

            // Ahora puedes crear un objeto Libro con los datos recuperados
            Libro libro = new Libro(idLibro, ISBN, titulo, autor, anio, tipo, editorial, estadoLibro);
            
            // Luego, crea un objeto Ejemplares con los valores recuperados.
            ejemplar = new Ejemplares(idCodigoEjemplar, libro, estado, cantidadDeEjemplares);
        }
        ps.close();
        return ejemplar;
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplares");
        return ejemplar;
        
       
        }
    }

    public void guardarEjemplares(Ejemplares ejemplares) throws SQLException {

        String sql = "INSERT INTO ejemplares ( libro, estado, cantidadDeEjemplares )"
                + "VALUES(?,?,?) ";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ejemplares.getLibro().getIdLibro());
            ps.setString(2, ejemplares.getEstado());
            ps.setInt(3, ejemplares.getCantidadDeEjemplares());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ejemplares.setIdCodigoEjemplar(rs.getInt(1));
                JOptionPane.showMessageDialog(null, " Ejemplar Guardado");
            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplares");
        }

    }

    public void actualizarEjemplares(Ejemplares ejemplares) {

        String sql = "UPDATE ejemplares SET libro = ?, cantidadDeEjemplares = ?, estado = ?" + " WHERE idCodigoEjemplar = ?";
        System.out.println(sql);

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ejemplares.getLibro().getIdLibro());
            ps.setInt(2, ejemplares.getCantidadDeEjemplares());
            ps.setString(3, ejemplares.getEstado());
            ps.setInt(4, ejemplares.getIdCodigoEjemplar());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, " Ejemplar modificado");

            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplares");

        }

    }

    public void borrarEjemplares(int idCodigoEjemplar) {

        String sql = "UPDATE ejemplares SET isEliminado = 1 WHERE idCodigoEjemplar = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCodigoEjemplar);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ejemplar borrado");

            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplares");

        }

    }
    
    public ArrayList<Ejemplares> listarEjemplaresActivos() {
        
        
        ArrayList<Ejemplares> ejemplaresLista = new ArrayList<Ejemplares>();
        String sql = "SELECT * from ejemplares WHERE estado != 0";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Libro libro = new Libro(1, "ISBN123", "Título del Libro", "Autor del Libro", 2023, "Tipo del Libro", "Editorial del Libro", "Disponible");
                 Ejemplares ejemplar = new Ejemplares(rs.getInt(1), libro, rs.getString(3), rs.getInt(4));
                ejemplaresLista.add(ejemplar);
            }
            ps.close();
            return ejemplaresLista;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplares");
            return ejemplaresLista;
        }
    }
    
    public ArrayList<Ejemplares> listarEjemplaresInactivos() {
        
        
        ArrayList<Ejemplares> ejemplaresLista = new ArrayList<Ejemplares>();
        String sql = "SELECT * from ejemplares WHERE estado = 0";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro(1, "ISBN123", "Título del Libro", "Autor del Libro", 2023, "Tipo del Libro", "Editorial del Libro", "Disponible");

                Ejemplares ejemplar = new Ejemplares(rs.getInt(1), libro, rs.getString(3), rs.getInt(4));
                ejemplaresLista.add(ejemplar);
            }
            ps.close();
            return ejemplaresLista;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplares");
            return ejemplaresLista;
        }
    }
   
   
    
    
}*/
