/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio.ListaGenerica;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Alumno implements Comparable, Serializable {

    int CI;
    int Registro;
    String Nombre;
    boolean sexo;
    int edad;

    public Alumno() {
    }

    public Alumno(int CI, int Registro, String Nombre, boolean sexo, int edad) {
        this.CI = CI;
        this.Registro = Registro;
        this.Nombre = Nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setRegistro(int Registro) {
        this.Registro = Registro;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCI() {
        return CI;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getRegistro() {
        return Registro;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Registro=" + Registro + '\n' + "CI=" + CI + '\n' + "Nombre=" + Nombre + '\n' + "sexo=" + sexo + '\n' + "edad=" + edad + '\n';
    }

    @Override
    public int compareTo(Object o) {
        Alumno A = (Alumno) o;
        return ((getRegistro() < A.getRegistro()) ? -1 : (getRegistro() > A.getRegistro()) ? 1 : 0);

    }
}
