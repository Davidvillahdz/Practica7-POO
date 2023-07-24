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


    public ControladorCantante(ICantanteDAO cantanteDAO) {
        this.cantanteDAO = cantanteDAO;
    }

    public void crearCantante(Cantante cantante,String ruta) {
        cantanteDAO.create(cantante,ruta);
    }

    public Cantante buscarCantante(int codigo) {
        return cantanteDAO.read(codigo);
    }

    public boolean actualizarCantante(Cantante cantante) {
        Cantante cantanteEncontrado = buscarCantante(cantante.getCodigo());
        if (cantanteEncontrado != null) {
            cantanteDAO.update(cantante);
            return true;
        }
        return false;
    }

    public boolean eliminarCantante(int codigo) {
        Cantante cantanteEncontrado = buscarCantante(codigo);
        if (cantanteEncontrado != null) {
            cantanteDAO.delete(cantanteEncontrado);
            return true;
        }
        return false;
    }

    public List<Cantante> verCantantes() {
        return cantanteDAO.findAll();
    }

    public void eliminarDiscoPorCodigo(int codigo) {
        List<Disco> listarDiscos = cantante.getDiscografia();
        for (Disco listaDisco : listarDiscos) {
            if (listaDisco.getCodigo() == codigo) {
                cantante.eliminarDisco(codigo);
                cantanteDAO.update(cantante);
            }
        }
    }

    public void actualizarDiscoPorCodigo(int codigo, Disco disco) {
        cantante.actualizarDisco(disco);
        cantanteDAO.update(cantante);
    }
    public void registroCliente(Cantante cantante, String ruta) {
        cantanteDAO.create(cantante,ruta);
    }

}
