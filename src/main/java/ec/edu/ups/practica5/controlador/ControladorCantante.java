/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.controlador;

import ec.edu.ups.practica5.idao.ICantanteDAO;
import ec.edu.ups.practica5.modelo.Cantante;
import ec.edu.ups.practica5.modelo.Disco;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ControladorCantante {

    private Cantante cantante;
    private Disco disco;
    private String folderPath;

    private ICantanteDAO cantanteDAO;

     public ControladorCantante() {
    }

    public ControladorCantante( ICantanteDAO cantanteDAO, String folderPath ) {
        this.cantanteDAO = cantanteDAO;
        this.folderPath = folderPath;
    }

    public void create(Cantante cantante) {
        String filePath = folderPath + File.separator + cantante.getCodigo() + ".dat";
        guardarDatosArchivo(filePath, cantante);
    }

    public Cantante leerCantante(int codigo) {
        String filePath = folderPath + File.separator + codigo + ".dat";
        return readDataFromFile(filePath);
    }

    public void ActualizarCantante(Cantante cantante) {
        String filePath = folderPath + File.separator + cantante.getCodigo() + ".dat";
        guardarDatosArchivo(filePath, cantante);
    }

    public void eliminarCantante(Cantante cantante) {
        String filePath = folderPath + File.separator + cantante.getCodigo() + ".dat";
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    private void guardarDatosArchivo(String filePath, Cantante cantante) {
        try {
            byte[] bytes = serialize(cantante);
            Path path = Paths.get(filePath);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Cantante leerDatosDelArchivo(String filePath) {
        Cantante cantante = null;
        try {
            Path path = Paths.get(filePath);
            byte[] bytes = Files.readAllBytes(path);
            cantante = deserialize(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCantante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantante;
    }

    private byte[] serialize(Cantante cantante) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(cantante);
        oos.flush();
        return bos.toByteArray();
    }

    private Cantante deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Cantante) ois.readObject();
    }

}
