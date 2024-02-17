/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

/**
 *
 * @author HP
 */
public class ColaLista {

    Nodo Frente;
    Nodo Atras;
    int cant;

    public ColaLista() {
        this.Frente = null;
        this.Atras = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (Frente == null);
    }

    public void Encolar(int elemento) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(elemento);
        if (vacia()) {
            Frente = nuevo;
            Atras = nuevo;
            cant++;
        } else {
            Atras.setEnlace(nuevo);
            Atras = nuevo;
            cant++;
        }
    }

    public int Decolar() {
        int x = Frente.getDato();
        if (Frente == Atras) {
            Frente = null;
            Atras = null;
            cant--;
        } else {
            Frente = Frente.getEnlace();
            cant--;
        }
        return x;
    }

    public int longitud() {
        return cant;
    }

    public int Get() {
        return (Frente.getDato());
    }

    @Override
    public String toString() {
        String lista = "[ ";
        Nodo aux = Frente;
        while (aux != null) {
            lista = lista + aux.getDato() + ", ";
            aux = aux.getEnlace();
        }
        if (lista.length() > 2) {
            lista = lista.substring(0, lista.length() - 2);
        }
        lista = lista + " ]";
        return lista;
    }

    public static void main(String[] args) {
        ColaLista x = new ColaLista();
        x.Encolar(1);
        x.Encolar(2);
        x.Encolar(3);
        x.Encolar(4);
        x.Encolar(5);
        x.Encolar(6);
        System.out.println(x.toString());
    }
}
