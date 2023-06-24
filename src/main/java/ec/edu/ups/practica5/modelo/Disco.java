/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.modelo;

/**
 *
 * @author Administrator
 */
public class Disco {

    //Atributos
    private int codigo;
    private String nombre;
    private int anioDelanzamiento;

    //Constructores
    public Disco() {
    }

    public Disco(int codigo, String nombre, int anioDelanzamiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.anioDelanzamiento = anioDelanzamiento;
    }

    //Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioDelanzamiento() {
        return anioDelanzamiento;
    }

    public void setAnioDelanzamiento(int anioDelanzamiento) {
        this.anioDelanzamiento = anioDelanzamiento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disco other = (Disco) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Disco{" + "codigo=" + codigo + ", nombre=" + nombre + ", anioDelanzamiento=" + anioDelanzamiento + '}';
    }

}
