/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.practica5.idao;


import ec.edu.ups.practica5.modelo.Compositor;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ICompositorDAO {

    //Métodos CRUD
    public void create(Compositor compositor);

    public Compositor read(int codigo);

    public void update(Compositor compositor);

    public void delete(Compositor compositor);

    public List<Compositor> findAll();

}
