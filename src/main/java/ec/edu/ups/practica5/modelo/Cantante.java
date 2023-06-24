/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 */
public class Cantante extends Persona {

    //Atributos
    private String nombreArtistico;
    private String generoMusical;
    private int numeroDeSencillos;
    private int numeroDeConciertos;
    private int numeroDeGiras;
    private List<Disco> discografia;

    //Constructores
    public Cantante() {
        this.discografia = new ArrayList<>();
    }

    public Cantante(String nombreArtistico, String generoMusical, int numeroDeSencillos, int numeroDeConciertos, int numeroDeGiras, int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.numeroDeSencillos = numeroDeSencillos;
        this.numeroDeConciertos = numeroDeConciertos;
        this.numeroDeGiras = numeroDeGiras;
        this.discografia = new ArrayList<>();
    }

    //Getters y Setters
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getNumeroDeSencillos() {
        return numeroDeSencillos;
    }

    public void setNumeroDeSencillos(int numeroDeSencillos) {
        this.numeroDeSencillos = numeroDeSencillos;
    }

    public int getNumeroDeConciertos() {
        return numeroDeConciertos;
    }

    public void setNumeroDeConciertos(int numeroDeConciertos) {
        this.numeroDeConciertos = numeroDeConciertos;
    }

    public int getNumeroDeGiras() {
        return numeroDeGiras;
    }

    public void setNumeroDeGiras(int numeroDeGiras) {
        this.numeroDeGiras = numeroDeGiras;
    }

    //Metodos
    @Override
    public double calcularSalario() {
        if (numeroDeSencillos >= 10 && numeroDeGiras > 3) {
            double salarioFinal = super.getSalario() + 1000;
            return salarioFinal;
        } else if (numeroDeSencillos > 0 && numeroDeSencillos < 11) {
            double porcentaje = super.getSalario() * 0.05;
            double salarioFinal = super.getSalario() + porcentaje;
            return salarioFinal;

        } else if (numeroDeGiras > 0 && numeroDeGiras < 4) {
            double porcentaje = super.getSalario() * 0.03;
            double salarioFinal = super.getSalario() + porcentaje;
            return salarioFinal;
        } else if (discografia.size() >= 5) {
            double salarioFinal = super.getSalario() + 2000;
            return salarioFinal;
        } else {
            return super.getSalario();

        }

    }

    public void agregarDisco(Disco disco) {
        discografia.add(disco);

    }

    public void actualizarDisco(Disco disco) {
        if (discografia.contains(disco)) {
            int index = discografia.indexOf(disco);
            discografia.set(index, disco);
        }
    }

    public void eliminarDisco(Disco disco) {
        if (discografia.contains(disco)) {
            int index = discografia.indexOf(disco);
            discografia.remove(index);
        }
    }

    public List<Disco> listar() {
        return discografia;
    }

    public Disco buscar(int id) {
        return discografia.get(id);

    }

    public List<Disco> buscarNombreDeCancion(String titulo) {
        return discografia.stream().filter(e -> e.getNombre().startsWith(titulo)).collect(Collectors.toList());
    }

    


    @Override
    public String toString() {
        return "Cantante{" + "nombreArtistico=" + nombreArtistico + ", generoMusical=" + generoMusical + ", numeroDeSencillos=" + numeroDeSencillos + ", numeroDeConciertos=" + numeroDeConciertos + ", numeroDeGiras=" + numeroDeGiras + ", discografia=" + discografia + '}';
    }

}
