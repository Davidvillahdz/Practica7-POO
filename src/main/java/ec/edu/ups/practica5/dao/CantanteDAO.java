/* 
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.dao;

import ec.edu.ups.practica5.idao.ICantanteDAO;
import ec.edu.ups.practica5.modelo.Cantante;
import ec.edu.ups.practica5.modelo.Disco;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CantanteDAO implements ICantanteDAO {

    private String ruta;

    public CantanteDAO(String folderPath) {
        this.ruta = "C:\\Users\\HP\\Documents\\Archivito.txt";
    }

    public void create(Cantante cantante, String ruta) {
        try (RandomAccessFile archivoEscritura = new RandomAccessFile(ruta, "rt")) {
            archivoEscritura.seek(archivoEscritura.length());
            archivoEscritura.writeInt(cantante.getCodigo());
            archivoEscritura.writeUTF(cantante.getNombre());
            archivoEscritura.writeUTF(cantante.getApellido());
            archivoEscritura.writeInt(cantante.getEdad());
            archivoEscritura.writeUTF(cantante.getNacionalidad());
            archivoEscritura.writeUTF(cantante.getNombreArtistico());
            archivoEscritura.writeUTF(cantante.getGeneroMusical());
            archivoEscritura.writeInt(cantante.getNumeroDeSencillos());
            archivoEscritura.writeInt(cantante.getNumeroDeConciertos());
            archivoEscritura.writeInt(cantante.getNumeroDeGiras());
            archivoEscritura.writeDouble(cantante.getSalario());
            List<Disco> listaDisc = cantante.getDiscografia();
            for (Disco disco : listaDisc) {
                archivoEscritura.writeInt(disco.getCodigo());
                archivoEscritura.writeUTF(disco.getNombre());
                archivoEscritura.writeInt(disco.getAnioDelanzamiento());
            }
              archivoEscritura.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Ruta del folder no encontrada");
        } catch (IOException e2) {
            System.out.println("Error de Escritura de la ruta");
        } catch (Exception e3) {
            System.out.println("Error General");
        }
    }

    public Cantante read(int codigo, String ruta) {
        try (RandomAccessFile archivoLecturaDAO = new RandomAccessFile(ruta, "r")) {
            int bytesPorCantante = 365;

            while (archivoLecturaDAO.getFilePointer() < archivoLecturaDAO.length()) {
                int codigoCantante = archivoLecturaDAO.readInt();

                if (codigoCantante == codigo) {
                    String nombre = archivoLecturaDAO.readUTF();
                    String apellido = archivoLecturaDAO.readUTF();
                    int edad = archivoLecturaDAO.readInt();
                    String nacionalidad = archivoLecturaDAO.readUTF();
                    String nombreArtistico = archivoLecturaDAO.readUTF();
                    String generoMusical = archivoLecturaDAO.readUTF();
                    int numeroDeSencillos = archivoLecturaDAO.readInt();
                    int numeroDeConciertos = archivoLecturaDAO.readInt();
                    int numeroDeGiras = archivoLecturaDAO.readInt();
                    double salario = archivoLecturaDAO.readDouble();
                    Cantante cantante = new Cantante(nombreArtistico, generoMusical, numeroDeSencillos, numeroDeConciertos, numeroDeGiras, codigo, nombre, apellido, edad, nacionalidad, salario);
                    for (int j = 0; j < 10; j++) {
                        int codigoCant = archivoLecturaDAO.readInt();
                        String nombreCAntante = archivoLecturaDAO.readUTF();
                        int anio = archivoLecturaDAO.readInt();
                        Disco disco = new Disco(codigoCant, nombreCAntante, anio);
                        cantante.agregarDisco(disco);
                    }

                    return cantante;
                }
            }
            archivoLecturaDAO.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Ruta del folder no encontrado " + e1);
        } catch (IOException e2) {
            System.out.println("Error de lectura de la ruta " + e2 + e2.getMessage());
        } catch (Exception e3) {
            System.out.println("Eror General " + e3);
        }
        return null;
    }

    public void update(Cantante cantante) {
        try (RandomAccessFile file = new RandomAccessFile(ruta, "r")) {
            int bytesPerSinger = 365;
            long numSingers = file.length() / bytesPerSinger;
            for (int i = 0; i < numSingers; i++) {
                file.seek(i * bytesPerSinger);
                int singerCode = file.readInt();
                if (singerCode == cantante.getCodigo()) {
                    file.writeUTF(cantante.getNombre());
                    file.writeUTF(cantante.getApellido());
                    file.writeInt(cantante.getEdad());
                    file.writeUTF(cantante.getNacionalidad());
                    file.writeUTF(cantante.getNombreArtistico());
                    file.writeUTF(cantante.getGeneroMusical());
                    file.writeInt(cantante.getNumeroDeSencillos());
                    file.writeInt(cantante.getNumeroDeConciertos());
                    file.writeInt(cantante.getNumeroDeGiras());
                    file.writeDouble(cantante.getSalario());
                    List<Disco> discList = cantante.getDiscografia();
                    for (Disco disco : discList) {
                        file.writeInt(disco.getCodigo());
                        file.writeUTF(disco.getNombre());
                        file.writeInt(disco.getAnioDelanzamiento());
                    }
                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar el cantante");
        }
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
