/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio.Domino;

/**
 *
 * @author HP
 */
public class Lista {

    Nodo Izquierda;
    Nodo Derecha;
    int cant;

    public Lista() {
        this.Izquierda = null;
        this.Derecha = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (Izquierda == null);
    }

    /*    public void insertar(int dato1, int dato2) {
        Nodo nodo = new Nodo();
        nodo.setDato1(dato1);
        nodo.setDato2(dato2);
        if (vacia()) {
            Izquierda = nodo;
            Derecha = nodo;
        } else { // > 0
            Nodo aux = Izquierda;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            nodo.setSiguiente(Izquierda);
            Izquierda.setAnterior(Derecha);
            Izquierda = nodo;
            nodo.setAnterior(Derecha);
            Derecha = nodo;

            cant = cant + 2;
        }
    }*/

 /* public String toString() {
        Nodo aux = Izquierda;
        String S = "Lista-> [ " + Izquierda.getAnterior() + "<-->";
        while (aux != null) {
            S =  S + aux.getDato2() + "<-->";
            aux = aux.getSiguiente();
        }
        S = S + "]";
        return S;
    }*/
    @Override
    public String toString() {
        String S = "L -> ";
        Nodo aux = Izquierda;
        while (aux != null) {
            S = S + "[" + aux.getDato1() + "|" + aux.getDato2() + "]->";
            aux = aux.getEnlaceDerecho();
        }
        return S;
    }

    public void insertar(int dato1, int dato2) {
        if (cant == 0) {//P==null
            Nodo p = new Nodo();
            p.setDato1(dato1);
            p.setDato2(dato2);
            Izquierda = p;
            Derecha = p;
            cant++;
        } else {
            Nodo aux = Izquierda;
            while (aux.getEnlaceDerecho() != null) {
                aux = aux.getEnlaceDerecho();
            }
            if ((aux.getDato2() == dato1) || (aux.getDato2() == dato2)) {
                if (aux.getDato2() == dato2) {
                    Nodo p = new Nodo();
                    p.setDato1(dato1);
                    p.setDato2(dato2);
                    p.volcar();
                    p.setEnlaceIzquierdo(aux); //enlazamos
                    aux.setEnlaceDerecho(p);
                    Derecha = p;
                    cant++;
                } else {
                    Nodo p = new Nodo();
                    p.setDato1(dato1);
                    p.setDato2(dato2);
                    p.setEnlaceIzquierdo(aux); //enlazamos
                    aux.setEnlaceDerecho(p);
                    Derecha = p;
                    cant++;
                }
            } else {
                if (Izquierda.getDato1() == dato2) {
                    Nodo p = new Nodo();
                    p.setDato1(dato1);
                    p.setDato2(dato2);
                    p.setEnlaceDerecho(Izquierda);
                    Izquierda.setEnlaceIzquierdo(p);
                    Izquierda = p;
                    cant++;
                } else {
                    if (Izquierda.getDato1() == dato1) {
                        Nodo p = new Nodo();
                        p.setDato1(dato1);
                        p.setDato2(dato2);
                        p.volcar();
                        p.setEnlaceDerecho(Izquierda);
                        Izquierda.setEnlaceIzquierdo(p);
                        Izquierda = p;
                        cant++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Lista listadoble = new Lista();
        listadoble.insertar(7, 2);
        listadoble.insertar(3, 2);
        listadoble.insertar(3, 9);
        listadoble.insertar(9, 2);
        System.out.println(listadoble.toString());
    }
}
