/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import java.util.Arrays;

/**
 *
 * @author HP
 * @param <T>
 */
public class ColaGenerica<T> {

    private T[] elementos;

    private int capacidad;
    private int frente;

    private int fin;
    private int tamaño;

    @SuppressWarnings("unchecked")
    public ColaGenerica(int capacidad) {

        this.capacidad = capacidad;

        this.frente = 0;

        this.elementos = (T[]) new Object[capacidad];
        this.fin = -1;
        this.tamaño = 0;
    }

    public void encolar(T elemento) {
        if (tamaño == capacidad) {
            throw new IllegalStateException("La cola está llena");
        }
        fin = (fin + 1) % capacidad;
        elementos[fin] = elemento;
        tamaño++;
    }

    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T elementoDesencolado = elementos[frente];
        elementos[frente] = null;
        frente = (frente + 1);
        tamaño--;
        return elementoDesencolado;
    }

    public T frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos[frente];
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public T getFrente() {
        return elementos[frente];
    }

    public int getTamaño() {
        return tamaño;
    }

    public T getFin() {
        return elementos[fin];
    }

    @Override

    public String toString() {
        return "ColaGenerica("
                + "elementos=" + Arrays.toString(elementos)
                + ", capacidad=" + capacidad + ", frente=" + frente
                + ", fin=" + fin
                + ", tamaño=" + tamaño
                + '}';

    }

    public String toString2() {
        return Arrays.toString(elementos);
    }

    public static void main(String[] args) {
        ColaGenerica<String> cola = new ColaGenerica<>(5);
        cola.encolar("A");
        cola.encolar("B");
        cola.encolar("C");
        System.out.println(cola.toString2());
        while (!cola.estaVacia()) {
            cola.desencolar();
        }
        System.out.println(cola.toString2());
    }
}
