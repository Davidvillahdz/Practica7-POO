/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.practica5.idao;


import ec.edu.ups.practica5.modelo.Cantante;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ICantanteDAO {

    //Métodos CRUD
    public void create(Cantante cantante);

    public Cantante read(int codigo);

    public void update(Cantante cantante);

    public void delete(Cantante cantante);

    public List<Cantante> findAll();

}
