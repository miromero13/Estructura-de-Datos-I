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
public class PilaBits {

    VectorNBits P;
    int cima;

    public PilaBits(int cant, int nbits) {
        P = new VectorNBits(cant, nbits);
        cima = 0; // ua no puede ser -1

    }

    public boolean vacia() {
        return cima == 0;
    }

    public boolean llena() {
        return P.cant == cima;
    }

    public void push(int ele) {
        if (llena()) {
            System.out.println("la pila se encuentra llena");
            System.exit(1);

        } else {
            cima++;
            P.insertar(ele, cima);
        }

    }

    public int pop() {
        cima--;
        return P.sacar(cima + 1);
    }

    public int get() {
        return P.sacar(cima);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = cima; i >= 1; i--) {
            s = s + "|_" + P.sacar(i) + "_|\n";

        }

        return s;
    }

    public static void main(String[] args) {
        PilaBits pilab = new PilaBits(5, 4);
        pilab.push(1);
        pilab.push(2);
        pilab.push(3);
        pilab.push(4);
        pilab.push(5);
        System.out.println(pilab.toString());
    }

}
