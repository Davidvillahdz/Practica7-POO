/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.ups.practica5.vista;

import ec.edu.ups.practica5.controlador.ControladorCantante;
import ec.edu.ups.practica5.controlador.ControladorCompositor;
import ec.edu.ups.practica5.dao.CantanteDAO;
import ec.edu.ups.practica5.dao.CompositorDAO;
import ec.edu.ups.practica5.idao.ICantanteDAO;
import ec.edu.ups.practica5.idao.ICompositorDAO;
import ec.edu.ups.practica5.vista.cantante.VentanaActualizarCantante;
import ec.edu.ups.practica5.vista.cantante.VentanaAgregarCantante;
import ec.edu.ups.practica5.vista.cantante.VentanaBuscarCantante;
import ec.edu.ups.practica5.vista.cantante.VentanaEliminarCantante;
import ec.edu.ups.practica5.vista.cantante.VentanaListarCantante;
import ec.edu.ups.practica5.vista.compositor.VentanaActualizarCompositor;
import ec.edu.ups.practica5.vista.compositor.VentanaAgregarCompositor;
import ec.edu.ups.practica5.vista.compositor.VentanaBuscarCompositor;
import ec.edu.ups.practica5.vista.compositor.VentanaEliminarCompositor;
import ec.edu.ups.practica5.vista.compositor.VentanaListarCompositor;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 *
 * @author Usuario
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    //ventanas Cantante
    private VentanaAgregarCantante ventanaAgregarCantante;
    private VentanaActualizarCantante ventanaActualizarCantante;
    private VentanaBuscarCantante ventanaBuscarCantante;
    private VentanaEliminarCantante ventanaEliminarCantante;
    private VentanaListarCantante ventanaListarCantante;
    //Ventanas compositor
    private VentanaAgregarCompositor ventanaAgregarCompositor;
    private VentanaActualizarCompositor ventanaActualizarCompositor;
    private VentanaBuscarCompositor ventanaBuscarCompositor;
    private VentanaEliminarCompositor ventanaEliminarCompositor;
    private VentanaListarCompositor ventanaListarCompositor;

    //Controladores
    private ControladorCompositor controladorCompositor;
    private ControladorCantante controladorCantante;

    //DAOs
    private ICantanteDAO cantanteDAO;
    private ICompositorDAO compositorDAO;

    //Internacionalización
    private Locale localizacion;
    private ResourceBundle mensajes;
    //imagen de fondo 
    private EscritorioPersonalizado escritorio;
    
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        escritorio = new EscritorioPersonalizado();
        this.setContentPane(escritorio);
        cantanteDAO = new CantanteDAO();
        controladorCantante = new ControladorCantante();
        compositorDAO = new CompositorDAO();
        controladorCompositor = new ControladorCompositor();
        localizacion = Locale.getDefault();                
        cambiarIdioma();
        
    }

    public void cambiarIdioma(){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        MenuCompositor.setText(mensajes.getString("Menu.Compositor"));
        MenuCantante.setText(mensajes.getString("Menu.Cantante"));
        MenuCliente.setText(mensajes.getString("Menu.Cliente"));
        menuOpciones.setText(mensajes.getString("menu.Opciones"));
        MenuIdiomas.setText(mensajes.getString("Menu.Idiomas"));
        
        if(ventanaAgregarCompositor != null){
            ventanaAgregarCompositor.cambiarIdioma(localizacion);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        MenuCompositor = new javax.swing.JMenu();
        MenuAgregarCompositor = new javax.swing.JMenuItem();
        MenuBuscarCompositor = new javax.swing.JMenuItem();
        MenuActualizarCompositor = new javax.swing.JMenuItem();
        MenuEliminarCompositor = new javax.swing.JMenuItem();
        MenuListarCompositor = new javax.swing.JMenuItem();
        MenuCantante = new javax.swing.JMenu();
        MenuAgregarCantante = new javax.swing.JMenuItem();
        MenuBuscarCantante = new javax.swing.JMenuItem();
        MenuActualizarCantante = new javax.swing.JMenuItem();
        MenuEliminarCantante = new javax.swing.JMenuItem();
        MenuListarCantante = new javax.swing.JMenuItem();
        MenuCliente = new javax.swing.JMenu();
        MenuIdiomas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuOpciones = new javax.swing.JMenu();
        menuItemSalirOpciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        MenuCompositor.setText("Compositor");

        MenuAgregarCompositor.setText("Agregar");
        MenuAgregarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAgregarCompositorActionPerformed(evt);
            }
        });
        MenuCompositor.add(MenuAgregarCompositor);

        MenuBuscarCompositor.setText("Buscar");
        MenuBuscarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBuscarCompositorActionPerformed(evt);
            }
        });
        MenuCompositor.add(MenuBuscarCompositor);

        MenuActualizarCompositor.setText("Actualizar");
        MenuActualizarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActualizarCompositorActionPerformed(evt);
            }
        });
        MenuCompositor.add(MenuActualizarCompositor);

        MenuEliminarCompositor.setText("Eliminar");
        MenuEliminarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEliminarCompositorActionPerformed(evt);
            }
        });
        MenuCompositor.add(MenuEliminarCompositor);

        MenuListarCompositor.setText("Listar");
        MenuListarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListarCompositorActionPerformed(evt);
            }
        });
        MenuCompositor.add(MenuListarCompositor);

        jMenuBar2.add(MenuCompositor);

        MenuCantante.setText("Cantante");

        MenuAgregarCantante.setText("Agregar");
        MenuCantante.add(MenuAgregarCantante);

        MenuBuscarCantante.setText("Buscar");
        MenuCantante.add(MenuBuscarCantante);

        MenuActualizarCantante.setText("Actualizar");
        MenuCantante.add(MenuActualizarCantante);

        MenuEliminarCantante.setText("Eliminar");
        MenuCantante.add(MenuEliminarCantante);

        MenuListarCantante.setText("Listar");
        MenuListarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListarCantanteActionPerformed(evt);
            }
        });
        MenuCantante.add(MenuListarCantante);

        jMenuBar2.add(MenuCantante);

        MenuCliente.setText("Cliente");
        jMenuBar2.add(MenuCliente);

        MenuIdiomas.setText("Idiomas");

        jMenuItem1.setText("Español");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuIdiomas.add(jMenuItem1);

        jMenuItem2.setText("Ingles");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuIdiomas.add(jMenuItem2);

        jMenuItem3.setText("Frances");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MenuIdiomas.add(jMenuItem3);

        jMenuBar2.add(MenuIdiomas);

        menuOpciones.setText("Opciones");

        menuItemSalirOpciones.setText("Salir");
        menuItemSalirOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirOpcionesActionPerformed(evt);
            }
        });
        menuOpciones.add(menuItemSalirOpciones);

        jMenuBar2.add(menuOpciones);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuListarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListarCompositorActionPerformed
        if (ventanaListarCompositor == null) {
            ventanaListarCompositor = new VentanaListarCompositor(controladorCompositor);
            desktopPane.add(ventanaListarCompositor);
        }

        ventanaListarCompositor.setVisible(true);
    }//GEN-LAST:event_MenuListarCompositorActionPerformed

    private void MenuListarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListarCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuListarCantanteActionPerformed

    private void MenuAgregarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAgregarCompositorActionPerformed
        // TODO add your handling code here:
        if(ventanaAgregarCompositor == null){
            ventanaAgregarCompositor = new VentanaAgregarCompositor(controladorCompositor);
            desktopPane.add(ventanaAgregarCompositor);
            
        }
        ventanaAgregarCompositor.setVisible(true);
    }//GEN-LAST:event_MenuAgregarCompositorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        localizacion= new Locale("es","EC");
        cambiarIdioma();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       localizacion= new Locale("en","US");
        cambiarIdioma();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        localizacion= new Locale("fr","FR");
        cambiarIdioma();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuItemSalirOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirOpcionesActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirOpcionesActionPerformed

    private void MenuBuscarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBuscarCompositorActionPerformed
        if(ventanaBuscarCompositor == null){
            ventanaBuscarCompositor = new VentanaBuscarCompositor(controladorCompositor);
            desktopPane.add(ventanaBuscarCompositor);
            
        }
        ventanaBuscarCompositor.setVisible(true);
    }//GEN-LAST:event_MenuBuscarCompositorActionPerformed

    private void MenuActualizarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActualizarCompositorActionPerformed
        if(ventanaActualizarCompositor == null){
            ventanaActualizarCompositor = new VentanaActualizarCompositor(controladorCompositor);
            desktopPane.add(ventanaActualizarCompositor);
            
        }
        ventanaActualizarCompositor.setVisible(true);
    }//GEN-LAST:event_MenuActualizarCompositorActionPerformed

    private void MenuEliminarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEliminarCompositorActionPerformed
        if(ventanaEliminarCompositor == null){
            ventanaEliminarCompositor = new VentanaEliminarCompositor(controladorCompositor);
            desktopPane.add(ventanaAgregarCompositor);
            
        }
        ventanaEliminarCompositor.setVisible(true);
    }//GEN-LAST:event_MenuEliminarCompositorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuActualizarCantante;
    private javax.swing.JMenuItem MenuActualizarCompositor;
    private javax.swing.JMenuItem MenuAgregarCantante;
    private javax.swing.JMenuItem MenuAgregarCompositor;
    private javax.swing.JMenuItem MenuBuscarCantante;
    private javax.swing.JMenuItem MenuBuscarCompositor;
    private javax.swing.JMenu MenuCantante;
    private javax.swing.JMenu MenuCliente;
    private javax.swing.JMenu MenuCompositor;
    private javax.swing.JMenuItem MenuEliminarCantante;
    private javax.swing.JMenuItem MenuEliminarCompositor;
    private javax.swing.JMenu MenuIdiomas;
    private javax.swing.JMenuItem MenuListarCantante;
    private javax.swing.JMenuItem MenuListarCompositor;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem menuItemSalirOpciones;
    private javax.swing.JMenu menuOpciones;
    // End of variables declaration//GEN-END:variables
}
