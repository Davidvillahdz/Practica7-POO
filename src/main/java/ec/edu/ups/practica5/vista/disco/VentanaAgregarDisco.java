/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.practica5.vista.disco;

import ec.edu.ups.practica5.controlador.ControladorCantante;
import ec.edu.ups.practica5.modelo.Cantante;
import ec.edu.ups.practica5.modelo.Disco;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class VentanaAgregarDisco extends javax.swing.JInternalFrame {
    private ControladorCantante controladorCantante ;
    private Cantante cantanteTempo;
    private ResourceBundle mensajes;
    /**
     * Creates new form VentanaAgregarDisco
     */
    public VentanaAgregarDisco(ControladorCantante controladorCantante) {
        initComponents();
        this.controladorCantante = controladorCantante;
    }
    public void cambiarIdioma(Locale localizacion) {
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        jblCodigoAgregarDisco.setText(mensajes.getString("txtCodigo"));
        jblNombreArAgregarDisco.setText(mensajes.getString("txtNombreArtistico"));
        jblApellidoAAgregarDisco.setText(mensajes.getString("txtApellido"));
        jblEdadCAgregarDisco.setText(mensajes.getString("txtEdad"));
        jblAnioLanzamientoAgregarDisco.setText(mensajes.getString("txtAnioLanzamiento"));
        jblNombreCAgregar.setText(mensajes.getString("txtNombreArtisticoC"));
        jblNombreDiscoAgregar.setText(mensajes.getString("txtNombreDisco"));
        jblIdAgregarDisco.setText(mensajes.getString("txtIdCantante"));
        bntBuscar.setText(mensajes.getString("bntBuscar"));
        bntCancelar.setText(mensajes.getString("bntCancelar"));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jblIdAgregarDisco = new javax.swing.JLabel();
        txtIdCantante = new javax.swing.JTextField();
        bntBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jblNombreCAgregar = new javax.swing.JLabel();
        jblApellidoAAgregarDisco = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jblEdadCAgregarDisco = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jblNombreArAgregarDisco = new javax.swing.JLabel();
        txtNombreArtistico = new javax.swing.JTextField();
        jblCodigoAgregarDisco = new javax.swing.JLabel();
        jblNombreDiscoAgregar = new javax.swing.JLabel();
        jblAnioLanzamientoAgregarDisco = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombreDisco = new javax.swing.JTextField();
        txtAnioLanzamiento = new javax.swing.JTextField();
        bntAgregar = new javax.swing.JButton();
        bntCancelar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Disco"));

        jblIdAgregarDisco.setText("Buscar cantante a agregar disco : ");

        bntBuscar.setText("Buscar");
        bntBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingrese el nombre del disco");

        txtNombre.setEditable(false);
        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jblNombreCAgregar.setText("Nombre : ");

        jblApellidoAAgregarDisco.setText("Apellido :");

        txtApellido.setEditable(false);
        txtApellido.setEnabled(false);

        jblEdadCAgregarDisco.setText("Edad :");

        txtEdad.setEditable(false);
        txtEdad.setEnabled(false);

        jblNombreArAgregarDisco.setText("Nombre artistico :");

        txtNombreArtistico.setEditable(false);
        txtNombreArtistico.setEnabled(false);

        jblCodigoAgregarDisco.setText("Codigo :");

        jblNombreDiscoAgregar.setText("Nombre :");

        jblAnioLanzamientoAgregarDisco.setText("Año de lanzamiento :");

        txtCodigo.setEnabled(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtNombreDisco.setEnabled(false);

        txtAnioLanzamiento.setEnabled(false);
        txtAnioLanzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioLanzamientoActionPerformed(evt);
            }
        });

        bntAgregar.setText("Agregar");
        bntAgregar.setEnabled(false);
        bntAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAgregarActionPerformed(evt);
            }
        });

        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblNombreCAgregar)
                            .addComponent(jblEdadCAgregarDisco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblNombreArAgregarDisco)
                            .addComponent(jblApellidoAAgregarDisco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellido)
                            .addComponent(txtNombreArtistico, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jblIdAgregarDisco)
                        .addGap(44, 44, 44)
                        .addComponent(txtIdCantante, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(bntBuscar)
                        .addGap(39, 39, 39))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblCodigoAgregarDisco)
                            .addComponent(jblNombreDiscoAgregar)
                            .addComponent(jblAnioLanzamientoAgregarDisco)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(bntAgregar)))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntCancelar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCodigo)
                        .addComponent(txtNombreDisco)
                        .addComponent(txtAnioLanzamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblIdAgregarDisco)
                    .addComponent(txtIdCantante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblNombreCAgregar)
                    .addComponent(jblApellidoAAgregarDisco)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblEdadCAgregarDisco)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblNombreArAgregarDisco)
                    .addComponent(txtNombreArtistico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblCodigoAgregarDisco)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblNombreDiscoAgregar)
                    .addComponent(txtNombreDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblAnioLanzamientoAgregarDisco)
                    .addComponent(txtAnioLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntAgregar)
                    .addComponent(bntCancelar))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarActionPerformed
        // TODO add your handling code here:
        if (txtIdCantante.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No esta lleno el campo ");
        }else{
            cantanteTempo = controladorCantante.buscarCantante(Integer.parseInt(txtIdCantante.getText()));
            if (cantanteTempo!=null) {
                txtIdCantante.setEnabled(false);
                this.mostrarDatos(cantanteTempo);
                bntBuscar.setEnabled(false);
                bntAgregar.setEnabled(true);
                txtNombreDisco.setEnabled(true);
                txtCodigo.setEnabled(true);
                txtAnioLanzamiento.setEnabled(true);

            }else{
                JOptionPane.showMessageDialog(this, "No existe "+ txtIdCantante.getText()+" en cantantes. ");
            }
        }
    }//GEN-LAST:event_bntBuscarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtAnioLanzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioLanzamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioLanzamientoActionPerformed

    private void bntAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAgregarActionPerformed
        if (txtAnioLanzamiento.getText().isEmpty()||txtNombreDisco.getText().isEmpty()||txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se a llenado todos los campos correctamente");
        }else{
            int codigo = Integer.parseInt( txtCodigo.getText());
            if (cantanteTempo.buscarDisco(codigo)==null) {
                String nombre =txtNombreDisco.getText();
                int anio = Integer.parseInt( txtAnioLanzamiento.getText());
                Disco disco = new Disco(codigo, nombre, anio);
                cantanteTempo.agregarDisco(disco);
                JOptionPane.showMessageDialog(this, "Se a creado existosamente");
                txtNombreDisco.setText("");
                txtCodigo.setText("");
                txtAnioLanzamiento.setText("");
                System.out.println(cantanteTempo);
            }else{
                JOptionPane.showMessageDialog(this, "El id ya existe");
            }
        }
    }//GEN-LAST:event_bntAgregarActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        // TODO add your handling code here:
        this.limpiarCampos();
        this.setVisible(false);
        bntAgregar.setEnabled(false);
        bntBuscar.setEnabled(true);
        txtIdCantante.setEnabled(true);
        txtNombreDisco.setEnabled(false);
        txtAnioLanzamiento.setEnabled(false);
        txtCodigo.setEnabled(false);
    }//GEN-LAST:event_bntCancelarActionPerformed

    public void limpiarCampos(){
        txtIdCantante.setText("");
        txtNombreDisco.setText("");
        txtApellido.setText("");
        txtCodigo.setText("");
        txtEdad.setText("");
        txtNombreArtistico.setText("");
        txtNombreDisco.setText("");
        txtAnioLanzamiento.setText("");
        txtNombre.setText("");
    }
    public void mostrarDatos(Cantante cantante){
        txtIdCantante.setEnabled(false);
        bntBuscar.setEnabled(false);
        txtNombre.setText(cantante.getNombre());
        txtEdad.setText( String.valueOf(cantante.getEdad()));
        txtNombreArtistico.setText(cantante.getNombreArtistico());
        txtApellido.setText(cantante.getApellido());
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAgregar;
    private javax.swing.JButton bntBuscar;
    private javax.swing.JButton bntCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jblAnioLanzamientoAgregarDisco;
    private javax.swing.JLabel jblApellidoAAgregarDisco;
    private javax.swing.JLabel jblCodigoAgregarDisco;
    private javax.swing.JLabel jblEdadCAgregarDisco;
    private javax.swing.JLabel jblIdAgregarDisco;
    private javax.swing.JLabel jblNombreArAgregarDisco;
    private javax.swing.JLabel jblNombreCAgregar;
    private javax.swing.JLabel jblNombreDiscoAgregar;
    private javax.swing.JTextField txtAnioLanzamiento;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIdCantante;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreArtistico;
    private javax.swing.JTextField txtNombreDisco;
    // End of variables declaration//GEN-END:variables
}
