/* 
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.dao;

import ec.edu.ups.practica5.idao.ICantanteDAO;
import ec.edu.ups.practica5.modelo.Cantante;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CantanteDAO implements ICantanteDAO {

    private List<Cantante> cantantes;

    public CantanteDAO() {
        cantantes = new ArrayList<>();
    }

    @Override
    public void create(Cantante cantante) {
        cantantes.add(cantante);
    }

    @Override
    public Cantante read(int codigo) {
        for (Cantante cantante : cantantes) {
            if (cantante.getCodigo() == codigo) {
                return cantante;
            }
        }
        return null;
    }

    @Override
    public void update(Cantante cantante) {
        for (int i = 0; i < cantantes.size(); i++) {
            Cantante c = cantantes.get(i);
            if (c.getCodigo() == cantante.getCodigo()) {
                cantantes.set(i, cantante);
                break;
            }
        }
    }

    @Override
    public void delete(Cantante cantante) {
        Iterator<Cantante> it = cantantes.iterator();
        while (it.hasNext()) {
            Cantante c = it.next();
            if (c.getCodigo() == cantante.getCodigo()) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Cantante> findAll() {
        return cantantes;
    }
}
