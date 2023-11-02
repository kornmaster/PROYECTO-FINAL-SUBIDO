
package bibliotecatpfinal.Vistas;

import bibliotecatpfinal.AccesoADatos.EjemplaresData;
import bibliotecatpfinal.Entidades.Ejemplares;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import bibliotecatpfinal.Vistas.FormularioEjemplares;
import proyectofinal.biblioteca.AccesoADatos.LibrosDATA;
import proyectofinal.biblioteca.Entidades.Libro;


public class FormularioEjemplares extends javax.swing.JInternalFrame {
    
    private EjemplaresData ejeData= new EjemplaresData();
    private LibrosDATA librosData;
    public FormularioEjemplares() {
        initComponents();
        librosData = new LibrosDATA();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CodDeEjemplar = new javax.swing.JLabel();
        jTextCod = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        IdLibro = new javax.swing.JLabel();
        Estado = new javax.swing.JLabel();
        jTextEstado = new javax.swing.JTextField();
        CantidadEjemplares = new javax.swing.JLabel();
        jTextCantidadEjemplares = new javax.swing.JTextField();
        Eliminar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        jTextId = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Ejemplar");

        CodDeEjemplar.setText("Código del Ejemplar:");

        jTextCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        IdLibro.setText("ISBN del Libro:");

        Estado.setText("Estado:");

        CantidadEjemplares.setText("Cantidad de Ejemplares:");

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar ");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CodDeEjemplar)
                                    .addComponent(IdLibro)
                                    .addComponent(CantidadEjemplares)
                                    .addComponent(Estado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextCod)
                                    .addComponent(jTextEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jTextCantidadEjemplares)
                                    .addComponent(jTextId)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Nuevo)
                                .addGap(31, 31, 31)
                                .addComponent(Eliminar)
                                .addGap(27, 27, 27)
                                .addComponent(Guardar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodDeEjemplar)
                            .addComponent(jTextCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Buscar))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdLibro)
                            .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(Estado))
                    .addComponent(jTextEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CantidadEjemplares)
                    .addComponent(jTextCantidadEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nuevo)
                    .addComponent(Eliminar)
                    .addComponent(Guardar)
                    .addComponent(Salir))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodActionPerformed
         
             
               
        
    }//GEN-LAST:event_jTextCodActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
     String codigo = jTextCod.getText();
        try {
            Ejemplares ejemplarEncontrado = ejeData.buscarEjemplarByID(codigo);
            jTextCod.setText(String.valueOf(ejemplarEncontrado.getIdCodigoEjemplar()));
            jTextId.setText(String.valueOf(ejemplarEncontrado.getLibro().getIdLibro()));
            jTextEstado.setText(ejemplarEncontrado.getEstado());
            jTextCantidadEjemplares.setText(String.valueOf(ejemplarEncontrado.getCantidadDeEjemplares()));
        } catch (SQLException ex) {
            Logger.getLogger(FormularioEjemplares.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al buscar el ejemplar: " + ex.getMessage());
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        /*int idEjemplar = Integer.valueOf(jTextCod.getText());
        int idLibro = Integer.valueOf(jTextId.getText());
        String estado = jTextEstado.getText();
        int cantidadEjemplares = Integer.valueOf(jTextCantidadEjemplares.getText());

        // Crear una instancia de Ejemplares con el libro asociado
        Ejemplares ejemplarAGuardar = new Ejemplares(0, jTextId.getText(), estado, cantidadEjemplares);


        try {
            // Guardar o actualizar el ejemplar
            if (idEjemplar > 0) {
                // Si el id del ejemplar es mayor que 0, significa que ya existe, entonces actualizamos
                this.ejeData.actualizarEjemplares(ejemplarAGuardar);
                JOptionPane.showMessageDialog(null, "Ejemplar actualizado con éxito");
            } else {
                // Si el id del ejemplar es igual a 0, significa que es un nuevo ejemplar, entonces guardamos
                this.ejeData.guardarEjemplares(ejemplarAGuardar);
                JOptionPane.showMessageDialog(null, "Ejemplar guardado con éxito");
            }

            // Actualizar interfaz si es necesario
            Ejemplares ejemplarEncontrado = ejeData.buscarEjemplarByID(jTextCod.getText());
            jTextCod.setText(String.valueOf(ejemplarEncontrado.getIdCodigoEjemplar()));
            jTextId.setText(String.valueOf(ejemplarEncontrado.getLibro().getIdLibro()));
            jTextEstado.setText(ejemplarEncontrado.getEstado());
            jTextCantidadEjemplares.setText(String.valueOf(ejemplarEncontrado.getCantidadDeEjemplares()));
        } catch (SQLException ex) {
            Logger.getLogger(FormularioEjemplares.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al guardar o actualizar el ejemplar: " + ex.getMessage());
        }*/
        
    }//GEN-LAST:event_GuardarActionPerformed
        
    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        /*int idEjemplarEliminar = Integer.valueOf(jTextCod.getText());
        this.ejeData.borrarEjemplares(idEjemplarEliminar);
        limpiarCampos();*/
    }//GEN-LAST:event_EliminarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        
      dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
             int idLibro = Integer.parseInt(jTextId.getText());
    String estado = jTextEstado.getText();
    int cantidadEjemplares = Integer.parseInt(jTextCantidadEjemplares.getText());

    // Utiliza el método buscarLibroPorId para obtener el objeto Libro
    Libro libro = librosData.buscarLibroPorId(idLibro);

    if (libro != null) {
                 int idCodigoEjemplar = 0;
        Ejemplares ejemplarAGuardar = new Ejemplares(idCodigoEjemplar, libro, estado, cantidadEjemplares);

        try {
            // Guardar el nuevo ejemplar
            this.ejeData.guardarEjemplares(ejemplarAGuardar);
            JOptionPane.showMessageDialog(null, "Nuevo ejemplar guardado con éxito");
            limpiarCampos();
        } catch (SQLException ex) {
            Logger.getLogger(FormularioEjemplares.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al guardar el nuevo ejemplar: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se pudo encontrar el libro con ID " + idLibro);
        /* int idLibro = Integer.valueOf(jTextId.getText());
            String estado = jTextEstado.getText();
            int cantidadEjemplares = Integer.valueOf(jTextCantidadEjemplares.getText());

            // Crear una instancia de Ejemplares con el libro asociado
            Ejemplares ejemplarAGuardar = new Ejemplares(0, idLibro, estado, cantidadEjemplares); // Usar 0 como ID para un nuevo ejemplar

            try {
                // Guardar el nuevo ejemplar
                this.ejeData.guardarEjemplares(ejemplarAGuardar);
                JOptionPane.showMessageDialog(null, "Nuevo ejemplar guardado con éxito");
                limpiarCampos();
            } catch (SQLException ex) {
                Logger.getLogger(FormularioEjemplares.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al guardar el nuevo ejemplar: " + ex.getMessage());*/
        }

    }//GEN-LAST:event_NuevoActionPerformed

       
       
  
       
    private void limpiarCampos(){
       jTextCod.setText("");
       jTextId.setText("");
       jTextEstado.setText("");
       jTextCantidadEjemplares.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JLabel CantidadEjemplares;
    private javax.swing.JLabel CodDeEjemplar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JLabel Estado;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel IdLibro;
    private javax.swing.JButton Nuevo;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextCantidadEjemplares;
    private javax.swing.JTextField jTextCod;
    private javax.swing.JTextField jTextEstado;
    private javax.swing.JTextField jTextId;
    // End of variables declaration//GEN-END:variables
}
