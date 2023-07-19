/* 
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.dao;

import ec.edu.ups.practica5.idao.ICantanteDAO;
import ec.edu.ups.practica5.modelo.Cantante;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CantanteDAO implements ICantanteDAO {

    private String folderPath;

    public CantanteDAO(String folderPath) {
        this.folderPath = folderPath;
    }

    public void create(Cantante cantante) {
        String filePath = folderPath + File.separator + cantante.getCodigo() + ".dat";
        saveDataToFile(filePath, cantante);
    }

    public Cantante read(int codigo) {
        String filePath = folderPath + File.separator + codigo + ".dat";
        return readDataFromFile(filePath);
    }

    public void update(Cantante cantante) {
        String filePath = folderPath + File.separator + cantante.getCodigo() + ".dat";
        saveDataToFile(filePath, cantante);
    }

    public void delete(Cantante cantante) {
        String filePath = folderPath + File.separator + cantante.getCodigo() + ".dat";
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    private void saveDataToFile(String filePath, Cantante cantante) {
        try (FileOutputStream fos = new FileOutputStream(filePath); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(cantante);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Cantante readDataFromFile(String filePath) {
        Cantante cantante = null;
        try (FileInputStream fis = new FileInputStream(filePath); ObjectInputStream ois = new ObjectInputStream(fis)) {
            cantante = (Cantante) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cantante;
    }
}
