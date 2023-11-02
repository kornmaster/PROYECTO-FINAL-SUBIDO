/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyectofinal.biblioteca.Vistas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinal.biblioteca.AccesoADatos.LectoresData;
import proyectofinal.biblioteca.Entidades.Lectores;


public class GestionDeLectores extends javax.swing.JInternalFrame {
    // DEJAMOS PREPARADOS UNAS COSAS:

    private List<Lectores> listaL;// en ves de usar ArrayList, podemos usar List, asi abajo no lo casteamos. // son las materias que usaremos en la Tabla
    // esta lista sera para guardar las lista que obtenemos a llamar los metodos de listar
    private LectoresData lectorData = new LectoresData();// desde este formulario vamos a trabajar con alumnoData por eso creamos la variable y la instanciamos (llamaremos metodos de esta clase)
    private Lectores lectorActual = null; //sera nuestro variable lector y aqui guardaremos el lector que recibiremos al llamar metodos de busqueda,eliminacion, etc

    private DefaultTableModel modelo; // un atributo para el modelo de la tabla

    public GestionDeLectores() {
        initComponents();
        modelo = new DefaultTableModel(); // instanciamos nuestro DefaultTableModel 
        armarCabeceraTabla(); // llamamos el metodo para armar la cabecera

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtSocio = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtDomicilio = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        jrEstado = new javax.swing.JCheckBox();
        jlEstado = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jrActivos = new javax.swing.JRadioButton();
        jrInactivos = new javax.swing.JRadioButton();
        jrTodos = new javax.swing.JRadioButton();
        jbBuscar = new javax.swing.JButton();
        jlEstadoo = new javax.swing.JLabel();
        jlBuscar = new javax.swing.JLabel();
        jtBuscar = new javax.swing.JTextField();
        jrID = new javax.swing.JRadioButton();
        jrDni = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion de Lectores");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(882, 656));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("ID SOCIO");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("DOMICILIO");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("DNI *");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("EMAIL");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("NOMBRE *");

        jtSocio.setEnabled(false);
        jtSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtSocioActionPerformed(evt);
            }
        });

        jtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDniActionPerformed(evt);
            }
        });

        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });

        jrEstado.setSelected(true);
        jrEstado.setEnabled(false);
        jrEstado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrEstadoStateChanged(evt);
            }
        });
        jrEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEstadoActionPerformed(evt);
            }
        });

        jlEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlEstado.setText("ESTADO");

        jbNuevo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbGuardar.setText("Registrar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idSocio", "nombre", "dni", "domicilio", "email", "estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTabla);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("LISTADO DE SOCIOS");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("GESTION DE SOCIOS");

        jrActivos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrActivos.setText("Socios ACTIVOS");
        jrActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrActivosActionPerformed(evt);
            }
        });

        jrInactivos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrInactivos.setText("Socios INACTIVOS");
        jrInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrInactivosActionPerformed(evt);
            }
        });

        jrTodos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrTodos.setText("TODOS");
        jrTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrTodosActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jlEstadoo.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N

        jlBuscar.setText("Buscar");

        jtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscarActionPerformed(evt);
            }
        });

        jrID.setSelected(true);
        jrID.setText("ID");
        jrID.setEnabled(false);
        jrID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrIDActionPerformed(evt);
            }
        });

        jrDni.setText("DNI");
        jrDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrDniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrInactivos, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jrActivos)
                                    .addComponent(jrTodos)
                                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jrEstado)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(138, 138, 138)))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jrID)
                                        .addGap(18, 18, 18)
                                        .addComponent(jrDni)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                        .addComponent(jlEstadoo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 102, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrEstado, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlEstadoo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jrID)
                                    .addComponent(jrDni))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jrActivos)
                        .addGap(18, 18, 18)
                        .addComponent(jrInactivos)
                        .addGap(18, 18, 18)
                        .addComponent(jrTodos)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // BOTON NUEVO
        limpiarCampos();

    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        //BOTON ELIMINAR
        if (lectorActual != null) {
            lectorData.eliminarLectores(lectorActual.getIdSocio());// cambia el estado del libro, no lo elimina
            lectorActual = null; // vacia el lectorActual
            limpiarCampos();
            // cargarLibrosEnTabla(true); // vuelve a cargar la tabla 
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No hay Libro seleccionado");
        }
        // casi lo mismo que con el BOTON NUEVO
        limpiarCampos();
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jrActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrActivosActionPerformed
        // RADIO SOCIOS ACTIVOS
        if (jrActivos.isSelected()) {

            /*borrarFilaTabla();// borramos las filas de la tabla
            cargarSociosActivos(true, false); // se encarga de llenar la tabla con las materias inscriptas*/
            jrInactivos.setSelected(false);
            jrTodos.setSelected(false);
            actualizarTabla();
        } else {
            borrarFilaTabla();
        }
    }//GEN-LAST:event_jrActivosActionPerformed

    private void jrInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrInactivosActionPerformed
        // RADIO SOCIOS NO ACTIVOS
        if (jrInactivos.isSelected()) {

            /* borrarFilaTabla();// borramos las filas de la tabla
            cargarSociosActivos(false, false); // se encarga de llenar la tabla con las materias inscriptas*/
            jrActivos.setSelected(false);
            jrTodos.setSelected(false);
            actualizarTabla();
        } else {
            borrarFilaTabla();
        }
    }//GEN-LAST:event_jrInactivosActionPerformed

    private void jrTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrTodosActionPerformed
        // RADIO TODOS LOS SOCIOS
        if (jrTodos.isSelected()) {

            /*borrarFilaTabla();// borramos las filas de la tabla
            cargarSociosActivos(false, true); // se encarga de llenar la tabla con las materias inscriptas*/
            jrInactivos.setSelected(false);
            jrActivos.setSelected(false);
            actualizarTabla();
        } else {
            borrarFilaTabla();
        }
    }//GEN-LAST:event_jrTodosActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // BOTON SALIR
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
//BOTON BUSCAR POR ID
if (jrID.isSelected()) {
        try {
            Integer id = Integer.parseInt(jtBuscar.getText()); // obtengo y parseo el dni del text field y lo adigno a una variable dni
            lectorActual = lectorData.buscarLectoresId(id);
            if (lectorActual != null) { // si existe el lector entonces
                jtDni.setText(String.valueOf(lectorActual.getDni()));
                jtNombre.setText(lectorActual.getNombre());
                jtDomicilio.setText(lectorActual.getDomicilio());
                jtEmail.setText(lectorActual.getMail());
                jrEstado.setSelected(lectorActual.isEstado());//setSelected es para setear un booleano y  los booleanos se obtiene con is
                jtSocio.setText(String.valueOf(lectorActual.getIdSocio()));
                // activar y desactivar botones,etc 
                jrEstado.setEnabled(true);
                jtSocio.setEditable(false);
                jtSocio.setEnabled(false);
                jbGuardar.setText("Guardar");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresa run ID valido");
        }
}else if( jrDni.isSelected() ){
  try {
            Integer dni = Integer.parseInt(jtBuscar.getText()); // obtengo y parseo el dni del text field y lo adigno a una variable dni
            lectorActual = lectorData.buscarLectoresDni(dni);
            if (lectorActual != null) { // si existe el lector entonces
                jtDni.setText(String.valueOf(lectorActual.getDni()));
                jtSocio.setText(String.valueOf(lectorActual.getIdSocio()));
                jtNombre.setText(lectorActual.getNombre());
                jtDomicilio.setText(lectorActual.getDomicilio());
                jtEmail.setText(lectorActual.getMail());
                jrEstado.setSelected(lectorActual.isEstado());//setSelected es para setear un booleano y  los booleanos se obtiene con is
                // activar y desactivar botones,etc 
                jrEstado.setEnabled(true);
                jtSocio.setEditable(false);
                jtSocio.setEnabled(false);
                jbGuardar.setText("Guardar");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI valido");
        }
}
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jrEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEstadoActionPerformed
        // SELECCIONAR ESTADO

        if (jrEstado.isSelected()) {
            JOptionPane.showMessageDialog(null, "haz cambiado el estado de baja a ALTA");
            jlEstadoo.setText("ALTA");
            jlEstadoo.setForeground(Color.GREEN);
        } else {
            JOptionPane.showMessageDialog(null, " haz cambiado el estadp de alta a BAJA");
            jlEstadoo.setText("BAJA");
            jlEstadoo.setForeground(Color.RED);
        }
    }//GEN-LAST:event_jrEstadoActionPerformed

    private void jrEstadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrEstadoStateChanged
        // CAMBIOS EN EL ESTADO
        if (jrEstado.isSelected()) {
            jlEstadoo.setText("ALTA");
            jlEstadoo.setForeground(Color.GREEN);
        } else {
            jlEstadoo.setText("BAJA");
            jlEstadoo.setForeground(Color.RED);
        }
    }//GEN-LAST:event_jrEstadoStateChanged

    private void jtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDniActionPerformed

    private void jtSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtSocioActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // BOTON GUARDAR/REGISTRAR

        try {

            // obtener los datos del formulario
            Integer dni = Integer.parseInt(jtDni.getText());
            String nombre = jtNombre.getText();
            String domicilio = jtDomicilio.getText();
            String email = jtEmail.getText();
            Boolean estado = jrEstado.isSelected();
            if (nombre.isEmpty() || dni == 0) {
                JOptionPane.showMessageDialog(this, "Los campos con (*) no pueden estar vacios");
                return;
            }
            // Verificar si el DNI ya existe en la base de datos

// si al alumno NO lo busque y lo guardo, lo hara como un nuevoalumno
            if (lectorActual == null) {// si alumnoActual es nuevo hara lo siguiente
                if (lectorData.buscarLectoresDni2(dni)) {// este if es para ver si el dni ya existe
                    JOptionPane.showMessageDialog(this, "El DNI ya existe en la base de datos y no se puede usar.");
                    return;
                }
                lectorActual = new Lectores(nombre, domicilio, email, estado, dni); //si es null, creamos el alumno
                lectorData.guardarLectores(lectorActual); // entonces le pasamos el alumno actual

                actualizarTabla();

            } else {// lectorActual ya existe , si hago un cambio, guardara todo como modificaciones
                if (lectorData.buscarLectoresDni2(dni)&& dni!=lectorActual.getDni()) {
                    JOptionPane.showMessageDialog(this, "El DNI ya existe en la base de datos y no se puede usar.");
                    return;
                }
                lectorActual.setDni(dni);//al lectorActual le agrego los valores de cada textfield a cada atributo del lectoractual
                lectorActual.setDomicilio(domicilio);
                lectorActual.setNombre(nombre);
                lectorActual.setMail(email);
                lectorActual.setEstado(estado);
                // el estado lo cambiamos cuando lo borremos
                lectorData.modificarLectores(lectorActual);// hace la modificaciones, porq lectorActual no es nuevo
                actualizarTabla();

            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un dni valido");

        }

        limpiarCampos();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jrDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrDniActionPerformed
        // RADIO BOTON DNI
        jrID.setSelected(false);
        jrID.setEnabled(true);
        jrDni.setEnabled(false);
    }//GEN-LAST:event_jrDniActionPerformed

    private void jrIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrIDActionPerformed
//RADIO BOTON ID
    jrDni.setSelected(false);
    jrDni.setEnabled(true);
        jrID.setEnabled(false);
    }//GEN-LAST:event_jrIDActionPerformed

    private void jtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTabla;
    public javax.swing.JButton jbBuscar;
    public javax.swing.JButton jbEliminar;
    public javax.swing.JButton jbGuardar;
    public javax.swing.JButton jbNuevo;
    public javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlBuscar;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlEstadoo;
    private javax.swing.JRadioButton jrActivos;
    private javax.swing.JRadioButton jrDni;
    public javax.swing.JCheckBox jrEstado;
    private javax.swing.JRadioButton jrID;
    private javax.swing.JRadioButton jrInactivos;
    private javax.swing.JRadioButton jrTodos;
    private javax.swing.JTextField jtBuscar;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtDomicilio;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtSocio;
    // End of variables declaration//GEN-END:variables
private void limpiarCampos() { //metodo para limpiar 
        jtBuscar.setText("");
        jtSocio.setText("");
        jtDni.setText("");
        jtNombre.setText("");
        jtDomicilio.setText("");
        jtEmail.setText("");
        jrEstado.setSelected(true);
        jlEstadoo.setText("");
        // editos textfield y botones
        lectorActual = null;
        jrEstado.setEnabled(false);

       /* jtSocio.setEditable(true);
        jtSocio.setEnabled(true);*/
        //abilitar y desabilitar botones 
        jlEstadoo.setText("");
        jbGuardar.setText("Registrar");

    }

    private void armarCabeceraTabla() {
        ArrayList<Object> cabecera = new ArrayList<>(); // creamos un ArrayList de objetos llamado cabecera
        cabecera.add("idSocio");// agragamos los titulos de las columnas en la lista del cabecera
        cabecera.add("Nombre");// de esta menera tenesmo todos los nombres en una lista
        cabecera.add("Dni");
        cabecera.add("Domicilio");
        cabecera.add("Email");
        cabecera.add("Estado");
        for (Object it : cabecera) {//recorremos el arraylist de objetos (cabecera) con el objeto it (es decir recorremos cada titulo de la lista)
            modelo.addColumn(it);// y al modelo agregamos en cada columna, uno por uno, los titulos que estan en la lista cabecera
        }
        jTabla.setModel(modelo);// y a la tabla le seteamos el modelo
    }

    private void borrarFilaTabla() {
        int indice = modelo.getRowCount() - 1;// obtenemos del modelo la cantidad de filas
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void cargarSociosActivos(boolean activos, boolean todos) {// parece que aca usamos list y no ArrayList como abajo

        List<Lectores> lista = lectorData.listarLectores();// nos devuelve una lista con todos los lectores en la BD

        for (Lectores l : lista) {// recorremos esta lista de lectores
            if (((activos && l.isEstado()) || (!activos && !l.isEstado())) || (todos)) {
                modelo.addRow(new Object[]{l.getIdSocio(), l.getNombre(), l.getDni(), l.getDomicilio(), l.getMail(), l.isEstado()});//al modelo de vamos agregando filas
            }

        }
    }

    private void actualizarTabla() {
        if (jrTodos.isSelected()) {

            borrarFilaTabla();// borramos las filas de la tabla
            cargarSociosActivos(false, true); // se encarga de llenar la tabla con las materias inscriptas

        } else if (jrActivos.isSelected()) {
            borrarFilaTabla();// borramos las filas de la tabla
            cargarSociosActivos(true, false); // se encarga de llenar la tabla con las materias inscriptas
        } else if (jrInactivos.isSelected()) {
            borrarFilaTabla();// borramos las filas de la tabla
            cargarSociosActivos(false, false); // se encarga de llenar la tabla con las materias inscriptas
        }

    }

}
