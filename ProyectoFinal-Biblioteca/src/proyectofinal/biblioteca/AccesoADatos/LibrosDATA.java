package proyectofinal.biblioteca.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectofinal.biblioteca.Entidades.Libro;

public class LibrosDATA {
    private Connection conexion;

    public LibrosDATA() {
        conexion = Conexion.Getconexion();
    }
    ////////////////////// Buscar libros para mostrar en tabla"No es necesario solo es algo estetico"/////////////////////////////////
    public List<Libro> buscarLibrosPorISBN(String ISBN) {
    String sql = "SELECT * FROM Libros WHERE ISBN = ?";
    List<Libro> libros = new ArrayList<>();

    try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setString(1, ISBN);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Libro libro = new Libro();
            libro.setIdLibro(resultSet.getInt("idLibro"));
            libro.setISBN(resultSet.getString("ISBN"));
            libro.setTitulo(resultSet.getString("titulo"));
            libro.setAutor(resultSet.getString("autor"));
            libro.setAnio(resultSet.getInt("anio"));
            libro.setTipo(resultSet.getString("tipo"));
            libro.setEditorial(resultSet.getString("editorial"));
            libro.setEstado(resultSet.getString("estado"));

            libros.add(libro);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar libros en la base de datos por ISBN");
        e.printStackTrace();
    }

    return libros;
}
////////////////////////////////////////////////////////////////////////////

    // Método para insertar un nuevo libro en la base de datos
    public void insertarLibro(Libro libro) {
        String sql = "INSERT INTO Libros (ISBN, titulo, autor, anio, tipo, editorial, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try 
            (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, libro.getISBN());
            preparedStatement.setString(2, libro.getTitulo());
            preparedStatement.setString(3, libro.getAutor());
            preparedStatement.setInt(4, libro.getAnio());
            preparedStatement.setString(5, libro.getTipo());
            preparedStatement.setString(6, libro.getEditorial());
            preparedStatement.setString(7, libro.getEstado());

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Libro cargado correctamente");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el libro en la base de datos");
            e.printStackTrace();
        }
    }

    // Método para listar todos los libros en la base de datos
    public List<Libro> listarLibros() {
        String sql = "SELECT * FROM Libros";
        List<Libro> libros = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Libro libro = new Libro();
                libro.setIdLibro(resultSet.getInt("idLibro"));
                libro.setISBN(resultSet.getString("ISBN"));
                libro.setTitulo(resultSet.getString("titulo"));
                libro.setAutor(resultSet.getString("autor"));
                libro.setAnio(resultSet.getInt("anio"));
                libro.setTipo(resultSet.getString("tipo"));
                libro.setEditorial(resultSet.getString("editorial"));
                libro.setEstado(resultSet.getString("estado"));

                libros.add(libro);                                                      
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los libros en la base de datos");
            e.printStackTrace();
        }

        return libros;
    }
    //////////////////////completemento para gime//////////////////////////////////
    public Libro buscarLibroPorId(int idLibro) {
    String sql = "SELECT * FROM Libros WHERE idLibro = ?";
    Libro libro = null;

    try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setInt(1, idLibro);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            libro = new Libro();
            libro.setIdLibro(resultSet.getInt("idLibro"));
            libro.setISBN(resultSet.getString("ISBN"));
            libro.setTitulo(resultSet.getString("titulo"));
            libro.setAutor(resultSet.getString("autor"));
            libro.setAnio(resultSet.getInt("anio"));
            libro.setTipo(resultSet.getString("tipo"));
            libro.setEditorial(resultSet.getString("editorial"));
            libro.setEstado(resultSet.getString("estado"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar el libro en la base de datos por ID");
        e.printStackTrace();
    }

    return libro;
}

    // Método para actualizar un libro en la base de datos
    public void actualizarLibro(Libro libro) {
        String sql = "UPDATE Libros SET ISBN=?, titulo=?, autor=?, anio=?, tipo=?, editorial=?, estado=? WHERE idLibro=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, libro.getISBN());
            preparedStatement.setString(2, libro.getTitulo());
            preparedStatement.setString(3, libro.getAutor());
            preparedStatement.setInt(4, libro.getAnio());
            preparedStatement.setString(5, libro.getTipo());
            preparedStatement.setString(6, libro.getEditorial());
            preparedStatement.setString(7, libro.getEstado());
            preparedStatement.setInt(8, libro.getIdLibro());

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Libro actualizado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el libro en la base de datos");
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public boolean eliminarLibro(int idLibro) {
        String sql = "UPDATE Libros SET estado = false WHERE idLibro = ?";

    try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setInt(1, idLibro);

        int filasAfectadas = preparedStatement.executeUpdate();

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Libro marcado como inactivo correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se pudo encontrar el libro con ID " + idLibro + " para cambiar el estado.");
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cambiar el estado del libro en la base de datos");
        e.printStackTrace();
        return false;
    /*String sql = "DELETE FROM Libros WHERE idLibro=?";

    try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setInt(1, idLibro);

        int filasAfectadas = preparedStatement.executeUpdate();

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Libro eliminado correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se pudo encontrar el libro con ID " + idLibro + " para eliminar.");
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el libro de la base de datos");
        e.printStackTrace();
        return false;*/
    }
    
}

}
