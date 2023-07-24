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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CantanteDAO implements ICantanteDAO {

    private String ruta;

    public CantanteDAO() {
        this.ruta = "C:\\Users\\HP\\Documents\\NetBeansProjects\\Practica7-POO\\src\\main\\resources\\Archivito";
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

    public Cantante read(int codigo) {
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
        } catch (FileNotFoundException e1) {
            System.out.println("Ruta del folder no encontrado " + e1);
        } catch (IOException e2) {
            System.out.println("Error de lectura de la ruta " + e2 + e2.getMessage());
        } catch (Exception e3) {
            System.out.println("Eror General " + e3);
        }
    }

    public void delete(Cantante cantante) {
        boolean found = false;
        int bytesPorCantante = 363;

        try (RandomAccessFile archivito = new RandomAccessFile(ruta, "rw")) {
            long numCantantes = archivito.length() / bytesPorCantante;

            for (int i = 0; i < numCantantes; i++) {
                archivito.seek(i * bytesPorCantante);
                int codigoCantante = archivito.readInt();

                if (codigoCantante == cantante.getCodigo()) {
                    long posicionActual = i * bytesPorCantante;
                    long posicionSiguiente = (i + 1) * bytesPorCantante;
                    long bytesRestantes = archivito.length() - posicionSiguiente;

                    byte[] buffer = new byte[(int) bytesRestantes];
                    archivito.read(buffer);

                    archivito.seek(posicionActual);
                    archivito.write(buffer);
                    archivito.setLength(archivito.length() - bytesPorCantante);

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No existe el código");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e1) {
            System.out.println("Error de Lectura/Escritura");
        } catch (Exception e) {
            System.out.println("Error General");
        }
    }

    public List<Cantante> findAll() {
        List<Cantante> listaCantantes = new ArrayList<>();
        int bytesPorCantante = 363;

        try (RandomAccessFile archivoLectura = new RandomAccessFile(ruta, "r")) {
            long numCantantes = archivoLectura.length() / bytesPorCantante;

            for (int i = 0; i < numCantantes; i++) {
                archivoLectura.seek(i * bytesPorCantante);
                int codigo = archivoLectura.readInt();
                String nombre = archivoLectura.readUTF();
                String apellido = archivoLectura.readUTF();
                int edad = archivoLectura.readInt();
                String nacionalidad = archivoLectura.readUTF();
                String nombreArtistico = archivoLectura.readUTF();
                String generoMusical = archivoLectura.readUTF();
                int numeroDeSencillos = archivoLectura.readInt();
                int numeroDeConciertos = archivoLectura.readInt();
                int numeroDeGiras = archivoLectura.readInt();
                double salario = archivoLectura.readDouble();
                Cantante cantante = new Cantante(nombreArtistico, generoMusical, numeroDeSencillos, numeroDeConciertos, numeroDeGiras, codigo, nombre, apellido, edad, nacionalidad, salario);

                int numDiscos = archivoLectura.readInt();
                for (int j = 0; j < numDiscos; j++) {
                    int codigoCan = archivoLectura.readInt();
                    String nombreCAn = archivoLectura.readUTF();
                    int anio = archivoLectura.readInt();
                    Disco dis = new Disco(codigoCan, nombreCAn, anio);
                    cantante.agregarDisco(dis);
                }

                listaCantantes.add(cantante);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e1) {
            System.out.println("Error de Lectura");
        } catch (Exception e) {
            System.out.println("Error General");
        }

        return listaCantantes;
    }
}
