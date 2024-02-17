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
public class PilaLista {

    Nodo cima;
    int cantidad;

    public PilaLista() {
        this.cima = null;
        this.cantidad = 0;

    }

    public void push(int dato) {
        Nodo p = new Nodo();
        p.setDato(dato);
        //sacar del inicio
        p.setEnlace(cima);
        cima = p;
        cantidad++;

    }

    public int pop() {
        int dato = cima.getDato();
        cima = cima.getEnlace();
        cantidad--;
        return dato;

    }

    public int get() {
        return cima.getDato();
    }

    public String toString() {
        String S = "";
        Nodo aux = cima;
        while (aux != null) {
            S = S + "|_" + aux.getDato() + "_|\n";
            aux = aux.getEnlace();

        }

        return S;
    }

    //elimina repetidos
    public void EliminarRepetidos() {
        if (cima != null && cima.getEnlace() != null) {
            Nodo actual = cima;
            while (actual != null) {
                int datoActual = actual.getDato();
                Nodo comparador = actual;
                while (comparador.getEnlace() != null) {
                    boolean SeRepite = false;
                    while (datoActual == comparador.getEnlace().getDato()) {
                        // Elemento repetido, eliminar nodo siguiente
                        comparador.setEnlace(comparador.getEnlace().getEnlace());
                        cantidad--;
                        SeRepite = true;
                    }
                    if (SeRepite) {
                        comparador.setEnlace(comparador.getEnlace());
                        cantidad--;
                        SeRepite = false;
                    }
                    comparador = comparador.getEnlace();
                }
                actual = actual.getEnlace();
            }

            // Eliminar repeticiones del primer nodo
            Nodo primerNodo = cima;
            while (primerNodo.getEnlace() != null && primerNodo.getDato() == primerNodo.getEnlace().getDato()) {
                cima = primerNodo.getEnlace();
                cantidad--;
            }
        }
    }

    public static void main(String[] args) {
        PilaLista pilaprueba = new PilaLista();
        pilaprueba.push(4);
        pilaprueba.push(3);
        pilaprueba.push(3);
        pilaprueba.push(2);
        pilaprueba.push(2);
        pilaprueba.push(1);
        System.out.println(pilaprueba.toString());
        pilaprueba.EliminarRepetidos();
        System.out.println(pilaprueba.toString());
        System.out.println(pilaprueba.pop());
        System.out.println(pilaprueba.pop());
        System.out.println(pilaprueba.pop());
        System.out.println(pilaprueba.toString());
    }
}
