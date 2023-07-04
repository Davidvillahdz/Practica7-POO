/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.ups.practica5.vista.Principal;

import ec.edu.ups.practica5.controlador.ControladorCantante;
import ec.edu.ups.practica5.controlador.ControladorCompositor;
import ec.edu.ups.practica5.dao.CantanteDAO;
import ec.edu.ups.practica5.dao.CompositorDAO;
import ec.edu.ups.practica5.idao.ICantanteDAO;
import ec.edu.ups.practica5.idao.ICompositorDAO;
import ec.edu.ups.practica5.vista.cancion.VentanaActualizarCancion;
import ec.edu.ups.practica5.vista.cancion.VentanaAgregarCancion;
import ec.edu.ups.practica5.vista.cancion.VentanaBuscarCancion;
import ec.edu.ups.practica5.vista.cancion.VentanaEliminarCancion;
import ec.edu.ups.practica5.vista.cancion.VentanaListarCancion;
import ec.edu.ups.practica5.vista.cantante.VentanaActualizarCantante;
import ec.edu.ups.practica5.vista.cantante.VentanaAgregarCantante;
import ec.edu.ups.practica5.vista.cantante.VentanaBuscarCantante;
import ec.edu.ups.practica5.vista.cantante.VentanaEliminarCantante;
import ec.edu.ups.practica5.vista.cantante.VentanaListarCantante;
import ec.edu.ups.practica5.vista.cliente.VentanaActualizarCliente;
import ec.edu.ups.practica5.vista.cliente.VentanaAgregarCliente;
import ec.edu.ups.practica5.vista.cliente.VentanaBuscarCliente;
import ec.edu.ups.practica5.vista.cliente.VentanaEliminarCliente;
import ec.edu.ups.practica5.vista.cliente.VentanaListarCliente;
import ec.edu.ups.practica5.vista.compositor.VentanaActualizarCompositor;
import ec.edu.ups.practica5.vista.compositor.VentanaAgregarCompositor;
import ec.edu.ups.practica5.vista.compositor.VentanaBuscarCompositor;
import ec.edu.ups.practica5.vista.compositor.VentanaEliminarCompositor;
import ec.edu.ups.practica5.vista.compositor.VentanaListarCompositor;
import ec.edu.ups.practica5.vista.disco.VentanaActualizarDisco;
import ec.edu.ups.practica5.vista.disco.VentanaAgregarDisco;
import ec.edu.ups.practica5.vista.disco.VentanaBuscarDisco;
import ec.edu.ups.practica5.vista.disco.VentanaEliminarDisco;
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
    //Ventanas cancion
    private VentanaAgregarCancion ventanaAgregarCancion;
    private VentanaActualizarCancion ventanaActualizarCancion;
    private VentanaEliminarCancion ventanaEliminarCancion;
    private VentanaBuscarCancion ventanaBuscarCancion;
    private VentanaListarCancion ventanaListarCancion;
    //Ventanas Disco
    private VentanaActualizarDisco ventanaActualizarDisco;
    private VentanaAgregarDisco ventanaAgregarDisco;
    private VentanaBuscarDisco ventanaBuscarDisco;
    private VentanaEliminarDisco ventanaEliminarDisco;
    //Ventanas Cliente
    private VentanaActualizarCliente ventanaActualizarCliente;
    private VentanaAgregarCliente ventanaAgregarCliente;
    private VentanaBuscarCliente ventanaBuscarCliente;
    private VentanaEliminarCliente ventanaEliminarCliente;
    private VentanaListarCliente ventanaListarCliente;
    //Controladores
    private ControladorCompositor controladorCompositor;
    private ControladorCantante controladorCantante;
    //DAOs
    private ICantanteDAO cantanteDAO;
    private ICompositorDAO compositorDAO;

    //Internacionalización
    private Locale localizacion;
    private ResourceBundle mensajes;
    
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        cantanteDAO = new CantanteDAO();
        controladorCantante = new ControladorCantante(cantanteDAO);
        compositorDAO = new CompositorDAO();
        controladorCompositor = new ControladorCompositor(compositorDAO);
        localizacion = Locale.getDefault();               
        cambiarIdioma();
        
    }

    public void cambiarIdioma(){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        MenuCompositor.setText(mensajes.getString("Menu.Compositor"));
        MenuCantante.setText(mensajes.getString("Menu.Cantante"));
        MenuCliente.setText(mensajes.getString("Menu.Cliente"));
        MenuIdiomas.setText(mensajes.getString("Menu.Idiomas"));
        menuOpciones.setText(mensajes.getString("menu.Opciones"));
        MenuActualizarC.setText(mensajes.getString("Menu.ActualizarC"));
        MenuAgregarC.setText(mensajes.getString("Menu.AgregarC"));
        MenuEliminarC.setText(mensajes.getString("Menu.EliminarC"));
        MenuBuscarC.setText(mensajes.getString("Menu.BuscarC"));
        MenuListarC.setText(mensajes.getString("Menu.ListarC"));
        MenuMostrarC.setText(mensajes.getString("Menu.MostrarC"));
        MenuCancion.setText(mensajes.getString("Menu.Cancion"));
        if (ventanaAgregarCompositor != null) {
            ventanaAgregarCompositor.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarCompositor != null) {
            ventanaBuscarCompositor.cambiarIdioma(localizacion);
        }
        if (ventanaListarCompositor != null) {
            ventanaListarCompositor.cambiarIdioma(localizacion);
        }
        if (ventanaActualizarCompositor != null) {
            ventanaActualizarCompositor.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarCompositor != null) {
            ventanaEliminarCompositor.cambiarIdioma(localizacion);
        }
        if (ventanaAgregarCantante != null) {
            ventanaAgregarCantante.cambiarIdioma(localizacion);
        }
        if (ventanaActualizarCantante != null) {
            ventanaActualizarCantante.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarCantante != null) {
            ventanaBuscarCantante.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarCantante != null) {
            ventanaEliminarCantante.cambiarIdioma(localizacion);
        }
        if (ventanaListarCantante != null) {
            ventanaListarCantante.cambiarIdioma(localizacion);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        lblimagen = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        MenuCompositor = new javax.swing.JMenu();
        MenuAgregarC = new javax.swing.JMenuItem();
        MenuBuscarC = new javax.swing.JMenuItem();
        MenuActualizarC = new javax.swing.JMenuItem();
        MenuEliminarC = new javax.swing.JMenuItem();
        MenuListarC = new javax.swing.JMenuItem();
        MenuMostrarC = new javax.swing.JMenuItem();
        MenuCancion = new javax.swing.JMenu();
        MenuItemAgregar = new javax.swing.JMenuItem();
        MenuItemBuscar = new javax.swing.JMenuItem();
        MenuItemActualizar = new javax.swing.JMenuItem();
        MenuItemEliminar = new javax.swing.JMenuItem();
        MenuItemListar = new javax.swing.JMenuItem();
        MenuCantante = new javax.swing.JMenu();
        MenuAgregar = new javax.swing.JMenuItem();
        MenuBuscarCantante = new javax.swing.JMenuItem();
        MenuActualizarCantante = new javax.swing.JMenuItem();
        MenuEliminarCantante = new javax.swing.JMenuItem();
        MenuListarCantante = new javax.swing.JMenuItem();
        MenuItemMostrar1 = new javax.swing.JMenuItem();
        menuDisco = new javax.swing.JMenu();
        MenuItemAgregar1 = new javax.swing.JMenuItem();
        MenuItemBuscar1 = new javax.swing.JMenuItem();
        MenuItemActualizar1 = new javax.swing.JMenuItem();
        MenuItemEliminar1 = new javax.swing.JMenuItem();
        MenuItemListar1 = new javax.swing.JMenuItem();
        MenuCliente = new javax.swing.JMenu();
        MenuIdiomas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuOpciones = new javax.swing.JMenu();
        menuItemSalirOpciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monstercat-music-logo.jpg"))); // NOI18N

        desktopPane.setLayer(lblimagen, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MenuCompositor.setText("Compositor");

        MenuAgregarC.setText("Agregar");
        MenuAgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAgregarCActionPerformed(evt);
            }
        });
        MenuCompositor.add(MenuAgregarC);

        MenuBuscarC.setText("Buscar");
        MenuBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBuscarCActionPerformed(evt);
            }
        });
        MenuCompositor.add(MenuBuscarC);

        MenuActualizarC.setText("Actualizar");
        MenuActualizarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActualizarCActionPerformed(evt);
            }
        });
        MenuCompositor.add(MenuActualizarC);

        MenuEliminarC.setText("Eliminar");
        MenuEliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEliminarCActionPerformed(evt);
            }
        });
        MenuCompositor.add(MenuEliminarC);

        MenuListarC.setText("Listar");
        MenuListarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListarCActionPerformed(evt);
            }
        });
        MenuCompositor.add(MenuListarC);

        MenuMostrarC.setText("Mostrar");
        MenuCompositor.add(MenuMostrarC);

        MenuCancion.setText("Cancion");

        MenuItemAgregar.setText("Agregar");
        MenuItemAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAgregarActionPerformed(evt);
            }
        });
        MenuCancion.add(MenuItemAgregar);

        MenuItemBuscar.setText("Buscar");
        MenuCancion.add(MenuItemBuscar);

        MenuItemActualizar.setText("Actualizar");
        MenuCancion.add(MenuItemActualizar);

        MenuItemEliminar.setText("Eliminar");
        MenuCancion.add(MenuItemEliminar);

        MenuItemListar.setText("Listar");
        MenuCancion.add(MenuItemListar);

        MenuCompositor.add(MenuCancion);

        jMenuBar2.add(MenuCompositor);

        MenuCantante.setText("Cantante");

        MenuAgregar.setText("Agregar");
        MenuAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAgregarActionPerformed(evt);
            }
        });
        MenuCantante.add(MenuAgregar);

        MenuBuscarCantante.setText("Buscar");
        MenuBuscarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBuscarCantanteActionPerformed(evt);
            }
        });
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

        MenuItemMostrar1.setText("Mostrar");
        MenuCantante.add(MenuItemMostrar1);

        menuDisco.setText("Disco");

        MenuItemAgregar1.setText("Agregar");
        menuDisco.add(MenuItemAgregar1);

        MenuItemBuscar1.setText("Buscar");
        menuDisco.add(MenuItemBuscar1);

        MenuItemActualizar1.setText("Actualizar");
        menuDisco.add(MenuItemActualizar1);

        MenuItemEliminar1.setText("Eliminar");
        menuDisco.add(MenuItemEliminar1);

        MenuItemListar1.setText("Listar");
        menuDisco.add(MenuItemListar1);

        MenuCantante.add(menuDisco);

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

    private void MenuListarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListarCActionPerformed
        if (ventanaListarCompositor == null) {
            ventanaListarCompositor = new VentanaListarCompositor(controladorCompositor);
            desktopPane.add(ventanaListarCompositor);
        }
        ventanaListarCompositor.setVisible(true);
    }//GEN-LAST:event_MenuListarCActionPerformed

    private void MenuListarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListarCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuListarCantanteActionPerformed

    private void MenuAgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAgregarCActionPerformed
        if (ventanaAgregarCompositor == null) {
            ventanaAgregarCompositor = new VentanaAgregarCompositor(controladorCompositor);
            desktopPane.add(ventanaAgregarCompositor);
        }
        ventanaAgregarCompositor.setVisible(true);
    }//GEN-LAST:event_MenuAgregarCActionPerformed

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

    private void MenuBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBuscarCActionPerformed
        if(ventanaBuscarCompositor == null){
            ventanaBuscarCompositor = new VentanaBuscarCompositor(controladorCompositor);
            desktopPane.add(ventanaBuscarCompositor);
            
        }
        ventanaBuscarCompositor.setVisible(true);
    }//GEN-LAST:event_MenuBuscarCActionPerformed

    private void MenuActualizarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActualizarCActionPerformed
        if(ventanaActualizarCompositor == null){
            ventanaActualizarCompositor = new VentanaActualizarCompositor(controladorCompositor);
            desktopPane.add(ventanaActualizarCompositor);
            
        }
        ventanaActualizarCompositor.setVisible(true);
    }//GEN-LAST:event_MenuActualizarCActionPerformed

    private void MenuEliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEliminarCActionPerformed
        if(ventanaEliminarCompositor == null){
            ventanaEliminarCompositor = new VentanaEliminarCompositor(controladorCompositor);
            desktopPane.add(ventanaEliminarCompositor);
            
        }
        ventanaEliminarCompositor.setVisible(true);
    }//GEN-LAST:event_MenuEliminarCActionPerformed

    private void MenuAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAgregarActionPerformed
        if(ventanaAgregarCantante == null){
            ventanaAgregarCantante = new VentanaAgregarCantante(controladorCantante);
            desktopPane.add(ventanaAgregarCantante);
            
        }
        ventanaAgregarCantante.setVisible(true);
    }//GEN-LAST:event_MenuAgregarActionPerformed

    private void MenuBuscarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBuscarCantanteActionPerformed
        if(ventanaBuscarCantante == null){
            ventanaBuscarCantante = new VentanaBuscarCantante(controladorCantante);
            desktopPane.add(ventanaBuscarCantante);
            
        }
        ventanaBuscarCantante.setVisible(true);
    }//GEN-LAST:event_MenuBuscarCantanteActionPerformed

    private void MenuItemAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAgregarActionPerformed
        if(ventanaAgregarCancion == null){
            ventanaAgregarCancion = new VentanaAgregarCancion();
            desktopPane.add(ventanaAgregarCancion);
            
        }
        ventanaAgregarCancion.setVisible(true);
    }//GEN-LAST:event_MenuItemAgregarActionPerformed

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
    private javax.swing.JMenuItem MenuActualizarC;
    private javax.swing.JMenuItem MenuActualizarCantante;
    private javax.swing.JMenuItem MenuAgregar;
    private javax.swing.JMenuItem MenuAgregarC;
    private javax.swing.JMenuItem MenuBuscarC;
    private javax.swing.JMenuItem MenuBuscarCantante;
    private javax.swing.JMenu MenuCancion;
    private javax.swing.JMenu MenuCantante;
    private javax.swing.JMenu MenuCliente;
    private javax.swing.JMenu MenuCompositor;
    private javax.swing.JMenuItem MenuEliminarC;
    private javax.swing.JMenuItem MenuEliminarCantante;
    private javax.swing.JMenu MenuIdiomas;
    private javax.swing.JMenuItem MenuItemActualizar;
    private javax.swing.JMenuItem MenuItemActualizar1;
    private javax.swing.JMenuItem MenuItemAgregar;
    private javax.swing.JMenuItem MenuItemAgregar1;
    private javax.swing.JMenuItem MenuItemBuscar;
    private javax.swing.JMenuItem MenuItemBuscar1;
    private javax.swing.JMenuItem MenuItemEliminar;
    private javax.swing.JMenuItem MenuItemEliminar1;
    private javax.swing.JMenuItem MenuItemListar;
    private javax.swing.JMenuItem MenuItemListar1;
    private javax.swing.JMenuItem MenuItemMostrar1;
    private javax.swing.JMenuItem MenuListarC;
    private javax.swing.JMenuItem MenuListarCantante;
    private javax.swing.JMenuItem MenuMostrarC;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JMenu menuDisco;
    private javax.swing.JMenuItem menuItemSalirOpciones;
    private javax.swing.JMenu menuOpciones;
    // End of variables declaration//GEN-END:variables
}
