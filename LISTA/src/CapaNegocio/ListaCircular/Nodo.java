/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio.ListaCircular;

/**
 *
 * @author HP
 */
public class Nodo {

    private Object Elemento;
    private Nodo Enlace;

    //constructor sin parametros
    public Nodo() {
        //Elemento=0;
        Enlace = null;
    }

    // Constructor parametrizado
    public Nodo(int Elemento, Nodo p) {
        this.Elemento = Elemento;
        this.Enlace = p;
    }

    public Nodo(int Elemento) {
        this.Elemento = Elemento;
        this.Enlace = null;
    }

    public void setElem(Object Elemento) {
        this.Elemento = Elemento;
    }

    public void setEnlace(Nodo p) {
        this.Enlace = p;
    }

    public Object getElem() {
        return Elemento;
    }

    public Nodo getEnlace() {
        return Enlace;
    }

    @Override
    public String toString() {
        String s = "[";
        s = s + getElem();
        return s + " | ]->";
    }

    public static void main(String[] args) {
        Nodo p = new Nodo();
        p.setElem(2);
        System.out.println(p.toString());
        System.out.println(p.toString() + "->" + p.getEnlace());
        Nodo q = new Nodo();
        q.setElem(1);
        System.out.println(q.toString());
        Nodo r = new Nodo();
        r.setElem(3);
        System.out.println(r.toString());
        //-------------------------------------------------
        //Enlazando nodos setEnlace
        q.setEnlace(p);// aqui enlazamos dos nodos q apunta a p
        System.out.println(q.toString() + "->" + q.getEnlace());
        p.setEnlace(r);// aqui enlazamos dos nodos p apunta a r
        System.out.println(q.toString() + "->" + q.getEnlace() + "->" + q.getEnlace().getEnlace());

    }
}
