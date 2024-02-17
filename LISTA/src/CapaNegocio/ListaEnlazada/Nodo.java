/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio.ListaEnlazada;

/**
 *  Esta es una clase autoreferenciada
    @author HP
    
 */
public class Nodo {

    int Dato;
    Nodo Enlace;

    public Nodo() {
        Enlace = null;
    }

    public Nodo(int Dato, Nodo P) {
        this.Dato = Dato;
        Enlace = P;
    }

    public void setEnlace(Nodo P) {
        this.Enlace = P;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public int getDato() {
        return Dato;
    }

    public Nodo getEnlace() {
        return Enlace;
    }
    
    public String ToString() {
        String S = "->" + Dato;
        return S;
    }
    

    public static void main(String[] args) {
        // TODO code application logic here
        Nodo A = new Nodo();
        A.setDato(5);
        Nodo B = new Nodo(7, null);
        Nodo C = new Nodo();
        C.setDato(1);
        C.setEnlace(A);
        A.setEnlace(B); //enlazar desde A
        C.getEnlace().setEnlace(B); //enlazar desde C
        System.out.println(C.ToString());
    }

}
