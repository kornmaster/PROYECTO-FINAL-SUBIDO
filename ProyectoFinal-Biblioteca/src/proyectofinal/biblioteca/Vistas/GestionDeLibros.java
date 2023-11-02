package proyectofinal.biblioteca.Vistas;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinal.biblioteca.AccesoADatos.LibrosDATA;
import proyectofinal.biblioteca.Entidades.Libro;


/**
 *
 * @author Familia
 */
public class GestionDeLibros extends javax.swing.JInternalFrame {
  private LibrosDATA libDATA=new LibrosDATA();
  private Libro libroActual=null;
  private DefaultTableModel modeloTabla;
  public GestionDeLibros() {
        initComponents();
        configurarComboEstados();
        
        
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("ISBN");
        modeloTabla.addColumn("Título");
        modeloTabla.addColumn("Autor");
        modeloTabla.addColumn("Año");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Editorial");
        modeloTabla.addColumn("Estado");

        jTabla.setModel(modeloTabla);
        
        
    }
 
  private void actualizarTablaCategorias() {

    DefaultTableModel model = (DefaultTableModel) jTabla.getModel();

    
    model.setRowCount(0);

  
    List<Libro> libros = libDATA.listarLibros();

    for (Libro libro : libros) {
        if (libro.getEstado().equals("Activo")) {
            model.addRow(new Object[]{libro.getIdLibro(), libro.getISBN(), libro.getTitulo(), libro.getAutor(), libro.getAnio(), libro.getTipo(), libro.getEditorial(), libro.getEstado()});
        }
    }

    for (Libro libro : libros) {
        if (libro.getEstado().equals("Inactivo")) {
            model.addRow(new Object[]{libro.getIdLibro(), libro.getISBN(), libro.getTitulo(), libro.getAutor(), libro.getAnio(), libro.getTipo(), libro.getEditorial(), libro.getEstado()});
        }
    }
    for (Libro libro : libros) {
        if (libro.getEstado().equals("En Prestamo")) {
            model.addRow(new Object[]{libro.getIdLibro(), libro.getISBN(), libro.getTitulo(), libro.getAutor(), libro.getAnio(), libro.getTipo(), libro.getEditorial(), libro.getEstado()});
        }
    }

    for (Libro libro : libros) {
        if (libro.getEstado().equals("Prestamo con retraso")) {
            model.addRow(new Object[]{libro.getIdLibro(), libro.getISBN(), libro.getTitulo(), libro.getAutor(), libro.getAnio(), libro.getTipo(), libro.getEditorial(), libro.getEstado()});

        
    }
}
  }
  
   private void configurarComboEstados() {
        String[] estados = {"Activo", "Inactivo", "En Prestamo", "Prestamo con retraso"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(estados);
        jrEstado.setModel(model);
   }
   private void cargarLibrosEnTabla(boolean mostrarLibrosActivos) {
  
    LibrosDATA librosData = new LibrosDATA();
    List<Libro> libros = librosData.listarLibros();

    
    while (modeloTabla.getRowCount() > 0) {
        modeloTabla.removeRow(0);
    }

    for (Libro libro : libros) {
        
        if ((mostrarLibrosActivos && "activo".equals(libro.getEstado())) ||
            (!mostrarLibrosActivos && !"activo".equals(libro.getEstado())) ||
            (mostrarLibrosActivos && "prestamo".equals(libro.getEstado())) ||
            (mostrarLibrosActivos && "prestamo_retraso".equals(libro.getEstado()))) {
            
            modeloTabla.addRow(new Object[] {
                libro.getIdLibro(),
                libro.getISBN(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnio(),
                libro.getTipo(),
                libro.getEditorial(),
                libro.getEstado()
            });
        }
    }
   }
   private void cargarLibrosEnTablaPrestamos() {
    // Crear una instancia de LibrosDATA para acceder a los datos de libros
    LibrosDATA librosData = new LibrosDATA();
    List<Libro> libros = librosData.listarLibros();

    // Limpiar la tabla antes de cargar los libros
    while (modeloTabla.getRowCount() > 0) {
        modeloTabla.removeRow(0);
    }

    for (Libro libro : libros) {
        String estado = libro.getEstado();

       
        if ("En Prestamo".equals(estado) || "Prestamo con retraso".equals(estado)) {
            
            modeloTabla.addRow(new Object[] {
                libro.getIdLibro(),
                libro.getISBN(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnio(),
                libro.getTipo(),
                libro.getEditorial(),
                libro.getEstado()
            });
        }
    }
}
    private void LimpiarCampos(){
            jtISBN.setText("");
            jtTitulo.setText("");
            jtTipo.setText("");
            jtEditorial.setText("");
            jtAutor.setText("");
            jtAnio.setText(""); 
            jrEstado.setSelectedItem(""); // Establece el estado a "no seleccionado" (false)
            
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtISBN = new javax.swing.JTextField();
        jtTitulo = new javax.swing.JTextField();
        jtTipo = new javax.swing.JTextField();
        jtEditorial = new javax.swing.JTextField();
        jtAutor = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtAnio = new javax.swing.JTextField();
        jMostrarlibrosI = new javax.swing.JButton();
        jrEstado = new javax.swing.JComboBox<>();
        jbLimpiarc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion de Libros");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("ISBN");

        jLabel2.setText("Titulo");

        jLabel3.setText("Tipo");

        jLabel4.setText("Editorial");

        jLabel5.setText("Autor");

        jLabel6.setText("Estado");

        jtISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtISBNActionPerformed(evt);
            }
        });

        jtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTipoActionPerformed(evt);
            }
        });

        jbGuardar.setText("Actualizar Libro");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar Libro por ISBN");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel7.setText("Año");

        jMostrarlibrosI.setText("Estado de los Libros");
        jMostrarlibrosI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMostrarlibrosIActionPerformed(evt);
            }
        });

        jrEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "En Prestamo", "En Prestamo con retraso" }));
        jrEstado.setToolTipText("");
        jrEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEstadoActionPerformed(evt);
            }
        });

        jbLimpiarc.setText("Limpiar Campos");
        jbLimpiarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtISBN)
                    .addComponent(jtTitulo)
                    .addComponent(jtTipo))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(61, 61, 61)
                                .addComponent(jtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jbLimpiarc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMostrarlibrosI, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jbBuscar)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jrEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiarc)
                    .addComponent(jMostrarlibrosI))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar)
                    .addComponent(jbSalir))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idLibro", "ISBN", "titulo", "autor", "anio", "tipo", "editorial", "estado"
            }
        ));
        jScrollPane3.setViewportView(jTabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtISBNActionPerformed

    private void jtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTipoActionPerformed

    private void jbLimpiarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarcActionPerformed
        LimpiarCampos();
        libroActual=null;
    }//GEN-LAST:event_jbLimpiarcActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        
        LibrosDATA librosData = new LibrosDATA();
            try {
        String ISBN = jtISBN.getText(); // Obtener el ISBN como una cadena
        List<Libro> librosEncontrados = libDATA.buscarLibrosPorISBN(ISBN);

        if (!librosEncontrados.isEmpty()) {
            
            libroActual = librosEncontrados.get(0);
            

            jtTitulo.setText(libroActual.getTitulo());
            jtTipo.setText(libroActual.getTipo());
            jtEditorial.setText(libroActual.getEditorial());
            jtAutor.setText(libroActual.getAutor());
            jtAnio.setText(String.valueOf(libroActual.getAnio()));
            jrEstado.setSelectedItem(libroActual.getEstado());
   
        } else {
           
            JOptionPane.showMessageDialog(this, "No se encontraron libros con el ISBN especificado");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Usted debe ingresar un número válido");   
        }
        
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
        
        
        LibrosDATA librosData = new LibrosDATA();
        try {
       
        String ISBN = jtISBN.getText();
        String titulo = jtTitulo.getText();
        String tipo = jtTipo.getText();

        
        if (ISBN.isEmpty() || titulo.isEmpty() || tipo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos");
            return; 
        }

        
        int anio = 0; 
        String anioStr = jtAnio.getText();
        if (!anioStr.isEmpty()) {
            try {
                anio = Integer.parseInt(anioStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El año debe ser un número válido");
                return; 
            }
        }

        
        String editorial = jtEditorial.getText();
        String autor = jtAutor.getText();

        if (libroActual == null) {
            
            libroActual = new Libro();
            libroActual.setISBN(ISBN);
            libroActual.setTitulo(titulo);
            libroActual.setTipo(tipo);
            libroActual.setAnio(anio);
            libroActual.setEditorial(editorial);
            libroActual.setAutor(autor);
            libroActual.setEstado("Activo"); 
           
            librosData.insertarLibro(libroActual);
        } else {
            
            libroActual.setISBN(ISBN);
            libroActual.setTitulo(titulo);
            libroActual.setTipo(tipo);
            libroActual.setAnio(anio);
            libroActual.setEditorial(editorial);
            libroActual.setAutor(autor);
            if (!"activo".equals(libroActual.getEstado())) {
            libroActual.setEstado("Inactivo"); 
          }
         
            librosData.actualizarLibro(libroActual);
            
           }

       
            } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Usted debe ingresar un ISBN válido");
        }
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    
    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (libroActual != null) {
        
        libroActual.setEstado("Inactivo");

      
        LibrosDATA librosData = new LibrosDATA();
        librosData.actualizarLibro(libroActual);

        libroActual = null; 
        LimpiarCampos();
        cargarLibrosEnTabla(true);
    } else {
        JOptionPane.showMessageDialog(this, "No hay Libro seleccionado");
   
    }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jMostrarlibrosIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMostrarlibrosIActionPerformed
        cargarLibrosEnTabla(false); // Muestra solo los libros inactivos
    }//GEN-LAST:event_jMostrarlibrosIActionPerformed

    private void jrEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEstadoActionPerformed
   
         String estadoSeleccionado = (String) jrEstado.getSelectedItem();

    if (libroActual != null) {
        libroActual.setEstado(estadoSeleccionado);

        LibrosDATA librosData = new LibrosDATA();
        librosData.actualizarLibro(libroActual);

        
        DefaultTableModel model = (DefaultTableModel) jTabla.getModel();
        int filaSeleccionada = jTabla.getSelectedRow();

        
        if (filaSeleccionada != -1) {
            model.setValueAt(estadoSeleccionado, filaSeleccionada, 7);

           
            actualizarTablaCategorias();
         
            
     
        }
    }
   
    }//GEN-LAST:event_jrEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jMostrarlibrosI;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTabla;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public javax.swing.JButton jbBuscar;
    public javax.swing.JButton jbEliminar;
    public javax.swing.JButton jbGuardar;
    public javax.swing.JButton jbLimpiarc;
    public javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jrEstado;
    private javax.swing.JTextField jtAnio;
    public javax.swing.JTextField jtAutor;
    public javax.swing.JTextField jtEditorial;
    public javax.swing.JTextField jtISBN;
    public javax.swing.JTextField jtTipo;
    public javax.swing.JTextField jtTitulo;
    // End of variables declaration//GEN-END:variables
}
