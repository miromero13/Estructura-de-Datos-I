/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import java.util.EmptyStackException;

/**
 *
 * @author HP
 */
public class PilaGenerica<T> {

    private T[] elementos;
    private int capacidad;
    private int tamaño;

    public PilaGenerica(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.tamaño = 0;
    }

    public void apilar(T elemento) {
        if (tamaño == capacidad) {
            throw new StackOverflowError("La pila está llena");
        }
        elementos[tamaño] = elemento;
        tamaño++;
    }

    public T desapilar() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        T elementoDesapilado = elementos[tamaño - 1];
        elementos[tamaño - 1] = null; // Liberar la referencia alobjeto tamaño--;
        tamaño--;
        return elementoDesapilado;

    }

    public T cima() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        return elementos[tamaño - 1];
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public int tamaño() {
        return tamaño;

    }

    public static void main(String[] args) {
        PilaGenerica<Integer> pila = new PilaGenerica<>(5);
        pila.apilar(10);
        pila.apilar(30);
        pila.apilar(20);
        System.out.println("Cima de la pila: " + pila.cima());
        System.out.println("Tamaño de la pila: " + pila.tamaño());
        while (!pila.estaVacia()) {
            System.out.println("Desapilando: " + pila.desapilar());
        }

    }

}
