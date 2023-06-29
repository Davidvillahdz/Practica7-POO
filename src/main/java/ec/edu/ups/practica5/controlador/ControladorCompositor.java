/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.controlador;

import ec.edu.ups.practica5.idao.ICompositorDAO;
import ec.edu.ups.practica5.modelo.Cancion;
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

    public ControladorCompositor() {
    }

    public ControladorCompositor(Compositor compositor, Cancion cancion, ICompositorDAO compositorDAO) {
        this.compositor = compositor;
        this.cancion = cancion;
        this.compositorDAO = compositorDAO;
    }

    //llama al DAO para guardar un cliente
    public void registrar() {
        compositorDAO.create(compositor);
    }

    //llama al DAO para obtener un cliente por el id y luego los muestra en la vista
    public void verCantante(int codigo) {
        compositor = compositorDAO.read(codigo);
    }

    //llama al DAO para actualizar un cliente
    public void actualizar() {
        compositorDAO.update(compositor);
    }

    //llama al DAO para eliminar un cliente
    public void eliminar() {
        compositorDAO.delete(compositor);
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public List<Compositor> verCompositores() {
        return compositorDAO.findAll();

    }

    //ejemplo de agregacion
    public void agregarCancion(int codigo) {
        compositor = compositorDAO.read(codigo);
        compositor.agregarCancion(cancion);
    }

}
