/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.controlador;

import ec.edu.ups.practica5.idao.ICompositorDAO;
import ec.edu.ups.practica5.modelo.Cancion;
import ec.edu.ups.practica5.modelo.Cantante;
import ec.edu.ups.practica5.modelo.Compositor;
import java.util.List;

/**
 *
 * @author HP
 */
public class ControladorCompositor {

    private Compositor compositor;
    private Cancion cancion;

    private ICompositorDAO compositorDAO;

    public ControladorCompositor(ICompositorDAO compositorDAO) {
        this.compositorDAO = compositorDAO;
    }

    public void crearCompositor(Compositor compositor) {
        this.compositor = compositor;
        compositorDAO.create(compositor);
    }

    public void verCompositor(int codigo) {
        compositor = compositorDAO.read(codigo);
    }

    public void actualizarCompositor() {
        compositorDAO.update(compositor);
    }

    public Compositor buscarCompositor(int codigo) {
        this.compositor = compositorDAO.read(codigo);
        return compositor;
    }

    public boolean eliminarCompositor(Compositor compositor) {
        Compositor compositorEncontrado = this.buscarCompositor(compositor.getCodigo());
        if (compositorEncontrado != null) {
            compositorDAO.delete(compositorEncontrado);
            return true;
        }
        return false;
    }

    public List<Compositor> verCompositores() {
        return compositorDAO.findAll();

    }

    //ejemplo de agregacion
    public void agregarCancion(int codigo) {
        compositor = compositorDAO.read(codigo);
        compositor.agregarCancion(cancion);
    }

    public void agregarClienteCan(Compositor compositor, Cantante cantante) {
        compositor.agregarCliente(cantante);
    }

    public void actualizarCancion(Compositor compositor, Cancion cancion) {
        compositor.actualizarCancion(cancion);
    }

    public void agregarCancion(Cancion cancion, Compositor compositor) {
        compositor.agregarCancion(cancion);
    }

    public Cancion buscarCancion(Compositor compositor, int codigo) {
        return compositor.buscarCanciones(codigo);
    }

    public void eliminarCancion(Compositor compositor, int codigo) {
        compositor.eliminarCancion(codigo);
    }
}
