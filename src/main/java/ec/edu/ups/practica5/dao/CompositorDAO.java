/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.dao;

import java.util.List;
import ec.edu.ups.practica5.modelo.Compositor;
import java.util.ArrayList;
import ec.edu.ups.practica5.idao.ICompositorDAO;
import ec.edu.ups.practica5.modelo.Cancion;
import ec.edu.ups.practica5.modelo.Cantante;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

/**
 *
 * @author Administrator
 */
public class CompositorDAO implements ICompositorDAO {

    private String ruta;
    private RandomAccessFile archivoEscritura;
    private RandomAccessFile archivoLectura;
    private RandomAccessFile archivo7;

    //private List<Compositor> compositores;
    public CompositorDAO() {
        this.ruta = "C:\\Users\\Usuario\\OneDrive\\Documents\\Practica7\\Archivo7.txt";
    }

    @Override
    public void create(Compositor compositor) {
        try {
            archivoEscritura = new RandomAccessFile(ruta, "rw");
            archivoEscritura.seek(archivoEscritura.length());
            archivoEscritura.writeInt(compositor.getCodigo());
            archivoEscritura.writeUTF(compositor.getNombre());
            archivoEscritura.writeUTF(compositor.getApellido());
            archivoEscritura.writeInt(compositor.getEdad());
            archivoEscritura.writeUTF(compositor.getNacionalidad());
            archivoEscritura.writeInt(compositor.getNumeroDeComposiciones());
            archivoEscritura.writeDouble(compositor.getSalario());
            List<Cancion> listaCanc = compositor.getCancionesTop100Billboard();
            for (int i = 0; i < 10; i++) {
                archivoEscritura.writeInt(listaCanc.get(i).getCodigo());
                archivoEscritura.writeUTF(listaCanc.get(i).getTitulo());
                archivoEscritura.writeUTF(listaCanc.get(i).getLetra());
                archivoEscritura.writeDouble(listaCanc.get(i).getTiempoEnMinutos());
            }
            List<Cantante> listaCantante = compositor.getClientes();
            for (int i = 0; i < 10; i++) {
                archivoEscritura.writeInt(listaCantante.get(i).getCodigo());
                archivoEscritura.writeUTF(listaCantante.get(i).getNombre());
                archivoEscritura.writeUTF(listaCantante.get(i).getApellido());
                archivoEscritura.writeInt(listaCantante.get(i).getEdad());
                archivoEscritura.writeUTF(listaCantante.get(i).getNacionalidad());
                archivoEscritura.writeUTF(listaCantante.get(i).getNombreArtistico());
                archivoEscritura.writeUTF(listaCantante.get(i).getGeneroMusical());
                archivoEscritura.writeInt(listaCantante.get(i).getNumeroDeSencillos());
                archivoEscritura.writeInt(listaCantante.get(i).getNumeroDeConciertos());
                archivoEscritura.writeInt(listaCantante.get(i).getNumeroDeGiras());
                archivoEscritura.writeDouble(listaCantante.get(i).getSalario());
            }
            System.out.println(archivoEscritura.length());
            archivoEscritura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no ecncontrada");
        } catch (IOException e1) {
            System.out.println("Error de Escritura");
        } catch (Exception e) {
            System.out.println("Error General");
        }
    }

    @Override
    public Compositor read(int codigo) {

        try {
            archivoLectura = new RandomAccessFile(ruta, "r");
            int bytesPorCantante = 2241;
            long numCantantes = archivoLectura.length() / bytesPorCantante;

            for (int i = 0; i < numCantantes; i++) {
                archivoLectura.seek(i * bytesPorCantante);
                int codigoCantante = archivoLectura.readInt();

                if (codigoCantante == codigo) {
                    String nombre = archivoLectura.readUTF();
                    String apellido = archivoLectura.readUTF();
                    int edad = archivoLectura.readInt();
                    String nacionalidad = archivoLectura.readUTF();
                    int numeroComposiciones = archivoLectura.readInt();
                    double salario = archivoLectura.readDouble();
                    Compositor compositor = new Compositor(numeroComposiciones, codigo, nombre, apellido, edad, nacionalidad, salario);
                    for (int j = 0; j < 10; j++) {
                        int codigoComp = archivoLectura.readInt();
                        String titulo = archivoLectura.readUTF();
                        String letra = archivoLectura.readUTF();
                        double tiempo = archivoLectura.readDouble();
                        Cancion cancion = new Cancion(codigoComp, titulo, letra, tiempo);
                        compositor.agregarCancion(cancion);

                    }

                    for (int j = 0; j < 10; j++) {
                        int codigoCnt = archivoEscritura.readInt();
                        String nombreCnt = archivoLectura.readUTF();
                        String apellidoCnt = archivoLectura.readUTF();
                        int edadCnt = archivoLectura.readInt();
                        String nacionalidadCnt = archivoLectura.readUTF();
                        String nombreArtisticoCnt = archivoLectura.readUTF();
                        String generoMusical = archivoLectura.readUTF();
                        int numeroSencillos = archivoLectura.readInt();
                        int numeroConciertos = archivoLectura.readInt();
                        int numeroGiras = archivoLectura.readInt();
                        double salarioCnt = archivoLectura.readDouble();
                        Cantante cantante = new Cantante(nombreArtisticoCnt, generoMusical, numeroSencillos, numeroConciertos, numeroGiras, codigoCnt, nombreCnt, apellidoCnt, edadCnt, nacionalidadCnt, salarioCnt);
                        compositor.agregarCliente(cantante);
                    }

                    archivoLectura.close();

                    return compositor;
                }
            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e1) {
            System.out.println("Error de Lectura");
        } catch (Exception e) {
            System.out.println("Error General");
        }

        return null;
    }

    @Override
    public void update(Compositor compositor) {
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            int bytesPorCompositor = 2241;
            long numCompositores = archivo.length() / bytesPorCompositor;
            for (int i = 0; i < numCompositores; i++) {
                archivo.seek(i * bytesPorCompositor);
                int codigoCompositor = archivo.readInt();
                if (codigoCompositor == compositor.getCodigo()) {
                    //archivo.writeInt(cantante.getCodigo());
                    archivo.writeUTF(compositor.getNombre());
                    archivo.writeUTF(compositor.getApellido());
                    archivo.writeInt(compositor.getEdad());
                    archivo.writeUTF(compositor.getNacionalidad());
                    archivo.writeInt(compositor.getNumeroDeComposiciones());
                    archivo.writeDouble(compositor.getSalario());
                    List<Cancion> listaCanc = compositor.getCancionesTop100Billboard();
                    System.out.println("Lista crear = " + listaCanc.toString());
                    for (int j = 0; i < listaCanc.size(); j++) {
                        archivo.writeInt(listaCanc.get(j).getCodigo());
                        archivo.writeUTF(listaCanc.get(j).getTitulo());
                        archivo.writeUTF(listaCanc.get(j).getLetra());
                        archivo.writeDouble(listaCanc.get(j).getTiempoEnMinutos());

                    }

                    List<Cantante> listaCantante = compositor.getClientes();
                    for (int j = 0; j < 10; j++) {
                        archivo.writeInt(listaCantante.get(i).getCodigo());
                        archivo.writeUTF(listaCantante.get(i).getNombre());
                        archivo.writeUTF(listaCantante.get(i).getApellido());
                        archivo.writeInt(listaCantante.get(i).getEdad());
                        archivo.writeUTF(listaCantante.get(i).getNacionalidad());
                        archivo.writeUTF(listaCantante.get(i).getNombreArtistico());
                        archivo.writeUTF(listaCantante.get(i).getGeneroMusical());
                        archivo.writeInt(listaCantante.get(i).getNumeroDeSencillos());
                        archivo.writeInt(listaCantante.get(i).getNumeroDeConciertos());
                        archivo.writeInt(listaCantante.get(i).getNumeroDeGiras());
                        archivo.writeDouble(listaCantante.get(i).getSalario());
                    }

                    archivo.close();
                    return;
                }
            }

            archivo.close();
            //System.out.println("No ser encontr cantante");
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada: ");
        } catch (IOException e1) {
            System.out.println("Error de Lectura: ");
        } catch (Exception e) {
            System.out.println("Error General: ");
        }
    }

    @Override
    public void delete(Compositor compositor) {
        try {
            archivo7 = new RandomAccessFile(ruta, "rw");

            int bytesPorCompositor = 2241;
            long numCantantes = archivo7.length() / bytesPorCompositor;

            for (int i = 0; i < numCantantes; i++) {
                archivo7.seek(i * bytesPorCompositor);
                int codigoCantante = archivo7.readInt();
                if (codigoCantante == compositor.getCodigo()) {
                    long posicionActual = i * bytesPorCompositor;
                    long posicionSiguiente = (i + 1) * bytesPorCompositor;
                    long bytesRestantes = archivo7.length() - posicionSiguiente;

                    byte[] buffer = new byte[(int) bytesRestantes];
                    archivo7.read(buffer);

                    archivo7.seek(posicionActual);
                    archivo7.write(buffer);
                    archivo7.setLength(archivo7.length() - bytesPorCompositor);
                    archivo7.close();
                    return;
                }
            }
            archivo7.close();
            //System.out.println("No Existe el codgo");
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e1) {
            System.out.println("Error de Lectura/Escritura");
        } catch (Exception e) {
            System.out.println("Error General");
        }
    }

    @Override
    public List<Compositor> findAll() {
        List<Compositor> listaCompositores = new ArrayList<>();
        try {
            RandomAccessFile archivoLectura = new RandomAccessFile(ruta, "r");
            int bytesPorCompositor = 2241;
            long numCantantes = archivoLectura.length() / bytesPorCompositor;
            System.out.println(numCantantes);
            for (int i = 0; i < numCantantes; i++) {
                archivoLectura.seek(i * bytesPorCompositor);
                int codigo = archivoLectura.readInt();

                String nombre = archivoLectura.readUTF();
                String apellido = archivoLectura.readUTF();
                int edad = archivoLectura.readInt();
                String nacionalidad = archivoLectura.readUTF();
                int numeroComposiciones = archivoLectura.readInt();
                double salario = archivoLectura.readDouble();
                Compositor compositor = new Compositor(numeroComposiciones, codigo, nombre, apellido, edad, nacionalidad, salario);
                for (int j = 0; j < 10; j++) {
                    int codigoc = archivoLectura.readInt();
                    String titulo = archivoLectura.readUTF();
                    String letra = archivoLectura.readUTF();
                    double timepo = archivoLectura.readDouble();
                    Cancion cancion = new Cancion(codigoc, titulo, letra, timepo);
                    compositor.agregarCancion(cancion);
                }

                for (int j = 0; j < 10; j++) {
                    int codigoCan = archivoEscritura.readInt();
                    String nombreCan = archivoLectura.readUTF();
                    String apellidoCan = archivoLectura.readUTF();
                    int edadCan = archivoLectura.readInt();
                    String nacionalidadCan = archivoLectura.readUTF();
                    String nombreARCan = archivoLectura.readUTF();
                    String generoMusical = archivoLectura.readUTF();
                    int numeroSencillos = archivoLectura.readInt();
                    int numeroConciertos = archivoLectura.readInt();
                    int numeroGiras = archivoLectura.readInt();
                    double salarioCan = archivoLectura.readDouble();
                    Cantante cantante = new Cantante(nombreARCan, generoMusical, numeroSencillos, numeroConciertos, numeroGiras, codigoCan, nombreCan, apellidoCan, edadCan, nacionalidadCan, salarioCan);
                    compositor.agregarCliente(cantante);
                }
                listaCompositores.add(compositor);
            }

            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e1) {
            System.out.println("Error de Lectura");
        } catch (Exception e) {
            System.out.println("Error General");
        }

        return listaCompositores;
    }
}
