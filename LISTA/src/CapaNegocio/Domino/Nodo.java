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
public class Nodo {

    Nodo EnlaceDerecho;
    Nodo EnlaceIzquierdo;
    int dato1;
    int dato2;

    public Nodo() {
        this.EnlaceDerecho = null;
        this.EnlaceIzquierdo = null;
        this.dato1 = 0;
        this.dato2 = 0;
    }

    public int getDato1() {
        return dato1;
    }

    public void setDato1(int dato) {
        this.dato1 = dato;
    }

    public int getDato2() {
        return dato2;
    }

    public void setDato2(int dato2) {
        this.dato2 = dato2;
    }

    public Nodo getEnlaceIzquierdo() {
        return EnlaceIzquierdo;
    }

    public void setEnlaceIzquierdo(Nodo EnlaceIzquierdo) {
        this.EnlaceIzquierdo = EnlaceIzquierdo;
    }

    public Nodo getEnlaceDerecho() {
        return EnlaceDerecho;
    }

    public void setEnlaceDerecho(Nodo EnlaceDerecho) {
        this.EnlaceDerecho = EnlaceDerecho;
    }

    public void volcar() {
        int x = getDato2();
        this.dato2 = getDato1();
        this.dato1 = x;
    }

    /*    @Override
    public String toString() {
        return "NodoD{" + "dato=" + getDato1() + '}';
    }*/
 /*@Override
    public String toString() {
        return "NodoD{" + "EnlaceDerecho=" + EnlaceDerecho + ", dato=" + dato1 + ", EnlaceIzquierdo=" + EnlaceIzquierdo + '}';
    }*/
    public static void main(String[] args) {
        Nodo nodo1 = new Nodo();
        nodo1.setDato1(1);
        nodo1.setDato2(2);
        System.out.println(nodo1.toString());

    }
}
