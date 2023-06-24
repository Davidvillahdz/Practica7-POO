/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.dao;

import java.util.List;
import ec.edu.ups.practica5.modelo.Compositor;
import java.util.ArrayList;
import ec.edu.ups.practica5.idao.ICompositorDAO;
import java.util.Iterator;

/**
 *
 * @author Administrator
 */
public class CompositorDAO implements ICompositorDAO {

    private List<Compositor> compositores;

    public CompositorDAO() {
        compositores = new ArrayList<>();
    }

    @Override
    public void create(Compositor compositor) {
        compositores.add(compositor);
    }

    @Override
    public Compositor read(int codigo) {
        for (Compositor compositor : compositores) {
            if (compositor.getCodigo() == codigo) {
                return compositor;
            }
        }
        return null;
    }

    @Override
    public void update(Compositor compositor) {
        for (int i = 0; i < compositores.size(); i++) {
            Compositor c = compositores.get(i);
            if (c.getCodigo() == compositor.getCodigo()) {
                compositores.set(i, compositor);
                break;
            }
        }

    }

    @Override
    public void delete(Compositor compositor) {
        Iterator<Compositor> it = compositores.iterator();
        while (it.hasNext()) {
            Compositor c = it.next();
            if (c.getCodigo() == compositor.getCodigo()) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Compositor> findAll() {
        return compositores;
    }

}
