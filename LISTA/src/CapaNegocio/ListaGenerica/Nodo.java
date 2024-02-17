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
public class Nodo<Tipovar> implements Serializable {

    Tipovar Dato;
    Nodo<Tipovar> Enlace;

    public Nodo() {
        Enlace = null;
    }

    public Nodo(Tipovar Dato) {
        this.Dato = Dato;
        Enlace = null;
    }

    public void SetDato(Tipovar Dato) {
        this.Dato = Dato;
    }

    public Tipovar GetDato() {
        return Dato;
    }

    public void SetEnlace(Nodo<Tipovar> P) {
        Enlace = P;
    }

    public Nodo<Tipovar> GetEnlace() {
        return Enlace;
    }

    @Override
    public String toString() {
        String S = "";
        S = S + Dato;
        return S;
    }

}
