
package proyectofinal.biblioteca;

import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import proyectofinal.biblioteca.AccesoADatos.Conexion;
import proyectofinal.biblioteca.AccesoADatos.LibrosDATA;
import proyectofinal.biblioteca.Entidades.Libro;


public class ProyectoFinalBiblioteca {

   
    public static void main(String[] args) {
        LibrosDATA librosData = new LibrosDATA();// Crear un objeto LibrosDATA
        Connection con=Conexion.Getconexion();
        ////////////////////////insertar libro//////////////////////////
        /*Libro lb = new Libro();
        lb.setISBN("12345678901");
        lb.setTitulo("Mi Libro de Ejemplo");
        lb.setAutor("Autor de Ejemplo");
        lb.setAnio(2023);
        lb.setTipo("Ficción");
        lb.setEditorial("Editorial Ejemplo");
        lb.setEstado(true);                   
        // Cargar el libro en la base de datos
        librosData.insertarLibro(lb);*/
               
        //////////////////////////////////listar///////////////////////////
        /*List<Libro> listaDeLibros = librosData.listarLibros();

        if (!listaDeLibros.isEmpty()) {
            // Mostrar la lista de libros
            System.out.println("Lista de Libros:");

            for (Libro libro : listaDeLibros) {
                System.out.println(libro); // Esto utilizará el método toString de la clase Libro
            }
        } else {
            System.out.println("No se encontraron libros en la base de datos.");}*/
            ////////////////////////////Listar con cartelito///////////////////////////////////////
               /*List<Libro> listaDeLibros = librosData.listarLibros();

        if (listaDeLibros != null) {
            if (!listaDeLibros.isEmpty()) {
                // Mostrar la lista de libros en un cuadro de diálogo
                StringBuilder mensaje = new StringBuilder("Lista de Libros:\n");

                for (Libro libro : listaDeLibros) {
                    mensaje.append(libro).append("\n");
                }

                JOptionPane.showMessageDialog(null, mensaje.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron libros en la base de datos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se pudo listar los libros en la base de datos.");
        }*/
            
            ///////////////////////////////////////fin listar//////////////////////////////////////////////////
        
       
        // ID del libro que deseas actualizar (cámbialo al ID que necesites)
        /*int idLibroAActualizar = 2;

        // Obtener el libro por su ID (utiliza tu método obtenerLibroPorId)
        Libro libroAActualizar = obtenerLibroPorId(idLibroAActualizar);

        if (libroAActualizar != null) {
            // Modificar los atributos del libro con los nuevos valores
            libroAActualizar.setISBN("1111");
            libroAActualizar.setTitulo("Nuevo Título");
            libroAActualizar.setAutor("Nuevo Autor");
            libroAActualizar.setAnio(2022); // Nuevo año
            libroAActualizar.setTipo("Nuevo Tipo");
            libroAActualizar.setEditorial("Nueva Editorial");
            libroAActualizar.setEstado(true); // Nuevo estado

            // Llamar al método para actualizar el libro en la base de datos
            librosData.actualizarLibro(libroAActualizar);

            // Imprimir un mensaje para confirmar la actualización
            System.out.println("Libro actualizado correctamente");
        } else {
            System.out.println("No se encontró el libro con ID " + idLibroAActualizar);
        }
    }

    // Método ficticio para obtener un libro por su ID (debes implementarlo)
    private static Libro obtenerLibroPorId(int idLibro) {
        // Implementa la lógica para buscar un libro por su ID en la base de datos o en una lista de libros
        // y devuelve el objeto Libro correspondiente.
        // Si no se encuentra el libro, devuelve null.
        // Este método depende de cómo esté implementado tu sistema de gestión de datos.
        // Aquí proporciono un ejemplo ficticio:

        // Supongamos que tienes una lista de libros ficticia
        Libro libro1 = new Libro(9, "1234567890", "Mi Libro De Ejemplo", "Autor De Ejemplo", 2021, "Ficción", "Editorial Ejemplo", true);
        Libro libro2 = new Libro(2, "0987654321", "Otro Título", "Otro Autor", 2019, "No Ficción", "Editorial ABC", true);

        // Verificar si el libro con el ID deseado está en la lista
        if (libro1.getIdLibro() == idLibro) {
            return libro1;
        } else if (libro2.getIdLibro() == idLibro) {
            return libro2;
        } else {
            return null; // El libro no se encontró en la lista
        }*/
           
        
        // ID del libro que deseas eliminar (cámbialo al ID que necesites)
        /*int idLibroAEliminar = 12;

        // Llamar al método para eliminar el libro en la base de datos
        librosData.eliminarLibro(idLibroAEliminar);

        // Imprimir un mensaje para confirmar la eliminación
        System.out.println("Libro eliminado correctamente");*/
        
        //////////////////////////////metodo de eliminacion ////////////////////
       /*int idLibroAEliminar = 10;

// Llamar al método para eliminar el libro en la base de datos
boolean eliminacionExitosa = librosData.eliminarLibro(idLibroAEliminar);

if (eliminacionExitosa) {
    // Imprimir un mensaje si la eliminación fue exitosa
    System.out.println("Libro eliminado correctamente");
} else {
    // Imprimir un mensaje si la eliminación no fue exitosa (no se encontró el libro)
    System.out.println("Error: No se pudo encontrar el libro con ID " + idLibroAEliminar + " para eliminar.");
         }*/
    }
      
   } 
    
  

