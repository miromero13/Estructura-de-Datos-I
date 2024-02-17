/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

/**
 *
 *
 */
public class ColaBits {
    //atributos

    VectorNBits Q; //usamos un vector
    int Frente; //usamos un vector (primero)
    int Atras;////un indice llamado Atras ultimo
    //

    public ColaBits(int cant, int nbits) {
        Q = new VectorNBits(cant, nbits);
        Frente = 0;
        Atras = 0;
    }

    public boolean vacia() {
        return Frente == 0;
    }

    public boolean llena() {
        return ((Atras + 1) % Q.cant) == Frente;
    }

    public void Encolar(int elemento) {
        if (vacia()) {
            Frente++;
            Atras++;
            Q.insertar(elemento, Atras);
        } else {
            if (!llena()) {//si tienes espacios
                Atras = (Atras + 1) % Q.cant;
                Q.insertar(elemento, Atras);
            } else {
                System.out.println("Error cola llena");
            }

        }
    }

    public int decolar() {
        int x = Q.sacar(Frente);
        if (Frente == Atras) {
            Frente = 0;
            Atras = 0;
        } else {
            Frente = (Frente + 1) % Q.CantidadBits;
        }
        return x;
    }

    public int get() {
        return Q.sacar(Frente);
    }

    @Override
    public String toString() {
        String S = "Q={";//Frente=(Frente+1)%Q.length;
        for (int i = Frente; i != Atras; i = (i + 1) % Q.CantidadBits) {
            S = S + Q.sacar(i) + " | ";
        }
        if (!vacia()) {
            S = S + Q.sacar(Atras);
        }
        return S + "}";
    }

    public static void main(String[] args) {
        ColaBits A = new ColaBits(10, 7);

        A.Encolar(23);
        A.Encolar(28);
        A.Encolar(50);
        System.out.println(A);
    }

}
