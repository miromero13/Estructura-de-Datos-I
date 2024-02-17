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
public class Lista {

    Nodo Primero;
    Nodo Ultimo;
    int cant;

    public Lista() {
        this.Primero = null;
        this.Ultimo = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (Primero == null);

    }

    // Inserta un dato ordenadamente
    public void insertar(int dato) {
        if (vacia()) {
            insertarPrimero(dato);
        } else {
            Nodo aux = Primero;
            while ((aux != null) && (aux.getDato() < dato)) {
                aux = aux.getSiguiente();
            }
            if (aux == Primero) {
                if (aux.getDato() != dato) {

                    insertarPrimero(dato);
                }

            } else if (aux == null) {
                insertarUltimo(dato);
            } else if (aux.getDato() != dato) {
                Nodo nodo = new Nodo();
                nodo.setDato(dato);
                aux.getAnterior().setSiguiente(nodo);
                nodo.setAnterior(aux.getAnterior());
                aux.setAnterior(nodo);
                nodo.setSiguiente(aux);
                cant++;

            }
        }

    }

    /*funcion que devuelva el numero en dicha posicion*/
    public int buscarPos(int dato) {
        int p = 1;
        Nodo N = this.Primero;
        if (!vacia()) {
            while ((dato != N.getDato()) && (N
                    != this.Ultimo)) {
                N = N.getSiguiente();
                p++;
            }
            if ((N == Ultimo) && (dato != N.getDato())) {
                p = 0;
            }
        }
        return p;
    }

    public void insertarUltimo(int dato) {
        Nodo nodo = new Nodo();
        nodo.setDato(dato);
        if (vacia()) {

            Primero = nodo;
            Ultimo = nodo;

        } else { // > 0

            Ultimo.setSiguiente(nodo);
            nodo.setAnterior(Ultimo);
            Ultimo = nodo;
        }
        cant++;
    }

    // Inserta un dato a la lista en la ultima posicion
    public void insertarPrimero(int dato) {
        Nodo nodo = new Nodo();
        nodo.setDato(dato);
        if (vacia()) {

            Primero = nodo;
            Ultimo = nodo;

        } else { // > 0

            nodo.setSiguiente(Primero);
            Primero.setAnterior(nodo);
            Primero = nodo;

        }
        cant++;
    }

    @Override
    public String toString() {
        Nodo aux = Primero;
        String S = "Lista-> [ " + Primero.getAnterior() + "<-->";
        while (aux != null) {
            S = S + aux.getDato() + "<-->";
            aux = aux.getSiguiente();
        }
        S = S + "]";
        return S;
    }

    public static void main(String[] args) {
        Lista listadoble = new Lista();
        listadoble.insertar(7);
        listadoble.insertar(2);
        listadoble.insertar(66);
        listadoble.insertar(10);
        System.out.println(listadoble.toString());
        listadoble.insertar(3);
        listadoble.insertar(5);
        System.out.println(listadoble.toString());

        listadoble.insertarPrimero(5);
        listadoble.insertarPrimero(5);
        System.out.println(listadoble.toString());
    }

}
