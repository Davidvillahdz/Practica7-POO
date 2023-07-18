/* 
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.dao;

import ec.edu.ups.practica5.idao.ICantanteDAO;
import ec.edu.ups.practica5.modelo.Cantante;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CantanteDAO implements ICantanteDAO {

    private List<Cantante> cantantes;
    private String filePath;

    public CantanteDAO(String filePath) {
        cantantes = new ArrayList<>();
        this.filePath = filePath;
    }

    @Override
    public void create(Cantante cantante) {
        cantantes.add(cantante);
        saveDataToFile();
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
                saveDataToFile();
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
                saveDataToFile();
                break;
            }
        }
    }

    @Override
    public List<Cantante> findAll() {
        return cantantes;
    }

    private void saveDataToFile() {
        try (FileOutputStream fos = new FileOutputStream(filePath); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(cantantes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
