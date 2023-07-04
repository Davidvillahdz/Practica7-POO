/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.controlador;

import ec.edu.ups.practica5.idao.ICantanteDAO;
import ec.edu.ups.practica5.modelo.Cantante;
import ec.edu.ups.practica5.modelo.Disco;
import java.util.List;

/**
 *
 * @author HP
 */
public class ControladorCantante {

    private Cantante cantante;
    private Disco disco;

    private ICantanteDAO cantanteDAO;

     public ControladorCantante() {
    }

    public ControladorCantante(Cantante cantante, Disco disco, ICantanteDAO cantanteDAO) {
        this.cantante = cantante;
        this.disco = disco;
        this.cantanteDAO = cantanteDAO;
    }

    //llama al DAO para guardar un cliente
    public void crearCantante(Cantante cantante) {
        cantanteDAO.create(cantante);
    }

    //llama al DAO para obtener un cliente por el id y luego los muestra en la vista
    public void verCantante(int codigo) {
        cantante = cantanteDAO.read(codigo);

    }

    //llama al DAO para actualizar un cliente
    public boolean actualizar(Cantante cantante) {
        Cantante cantanteEncontrado = this.buscarCantante(cantante.getCodigo());
        if (cantanteEncontrado != null) {
            cantanteDAO.update(cantanteEncontrado);
            return true;
        }
        return false;

    }

    //llama al DAO para eliminar un cliente
    public boolean eliminarCantante(Cantante cantante) {
        Cantante cantanteEncontrado = this.buscarCantante(cantante.getCodigo());
        if (cantanteEncontrado != null) {
            cantanteDAO.delete(cantanteEncontrado);
            return true;
        }
        return false;
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public List<Cantante> verCantantes() {
        return cantanteDAO.findAll();
    }

    public Cantante buscarCantante(int codigo) {
        return cantanteDAO.read(codigo);
    }

 public void eliminarDisco(Cantante cantante,int codigo){
        List<Disco> listarDiscos=cantante.getDiscografia();
        for (Disco listaDisco : listarDiscos) {
            if (listaDisco.getCodigo()==codigo) {
                cantante.eliminarDisco(codigo);
                cantanteDAO.update(cantante);
            }
        }
    }
    
    public void actualizarDisco(Cantante cantante,Disco disco){
        cantante.actualizarDisco(disco);
        cantanteDAO.update(cantante); 
    }

}
