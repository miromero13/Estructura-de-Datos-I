/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio.ListaDoble;

/**
 *
 * @author HP
 */
public class Nodo {

    Nodo anterior;
    Nodo siguiente;
    int dato;

    public Nodo() {
        this.anterior = null;
        this.siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "NodoD{" + "dato=" + getDato() + '}';
    }

//    @Override
//    public String toString() {
//        return "NodoD{" + "anterior=" + anterior + ", dato=" + dato + ", siguiente=" + siguiente +  '}';
//
//
//
//
//    }
    public static void main(String[] args) {
        Nodo nodo1 = new Nodo();
        Nodo nodo2 = new Nodo();
        Nodo nodo3 = new Nodo();

        nodo1.setDato(1);
        nodo2.setDato(2);
        nodo3.setDato(3);
        nodo1.setSiguiente(nodo2);
        nodo2.setAnterior(nodo1);
        nodo2.setSiguiente(nodo3);
        nodo3.setAnterior(nodo2);

        System.out.println(nodo1.getSiguiente().toString());

    }
}
