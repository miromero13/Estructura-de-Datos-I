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
public class PilaVector {

    int P[];
    int cima;
    int cantidad;

    public PilaVector(int cant) {
        P = new int[cant];
        this.cima = -1;
        cantidad = 0;
    }

    public int get() {
        return this.P[cima];
    }

    public boolean vacia() {
        return (cima == -1);
    }

    public boolean llena() {
        return (cima == P.length - 1);
    }

    public void push(int dato) {

        if (!llena()) {
            cima++;
            P[cima] = dato;
            cantidad++;
        } else {
            System.out.println("la pila esta llena");
            System.exit(1);

        }

    }

    public int pop() {
        cima--;
        cantidad--;
        return P[cima + 1];
    }

    public int getCima() {
        return this.cima;

    }

    public void eliminar() {
        if (this.cima > -1) {
            cima--;

        }

    }

    @Override
    public String toString() {
        String cad = "[cima]\n";
        if (!vacia()) {
            for (int i = cima; i >= 0; i--) {

                cad += "[" + P[i] + "]\n";
            }
        }
        return cad;
    }

    public void eliminar(int dato) {
        PilaVector aux = new PilaVector(cima + 1);
        int y;
        while (!vacia()) {
            y = pop();
            if (y != dato) {

                aux.push(dato);

            }

        }

        while (!aux.vacia()) {
            y = aux.pop();
            push(y);
        }

    }

    public void IntercambiarExtremos() {
        PilaVector aux;
        aux = new PilaVector(cima + 1);
        int x = pop();
        while (!vacia()) {
            aux.push(pop());
        }
        push(x);
        int y = aux.pop();
        while (!aux.vacia()) {
            push(aux.pop());
        }
        push(y);
    }

    public void EliminarRepetidos() {
        PilaVector aux = new PilaVector(cima + 1);
        int x;
        int j = 0;
        while (j < cima) {
            while (cima > j) {
                aux.push(pop());
            }
            System.out.println(aux.toString());
            System.out.println(toString());
            x = get();
            while (!aux.vacia()) {
                if (x != aux.get()) {
                    push(aux.pop());
                } else {
                    aux.pop();
                }
            }
            j++;
        }
    }

    public void IntercambiarMitad() {
        PilaVector aux1;
        PilaVector aux2;
        int tamaño = cantidad;
        aux1 = new PilaVector(tamaño / 2);
        aux2 = new PilaVector(tamaño / 2);
        if (!vacia()) {
            int i = 0;
            while (tamaño / 2 > i) {
                int x = pop();
                System.out.println(x);
                aux1.push(x);
                i++;
            }
            i = 0;
            while (tamaño / 2 > i) {
                int x = pop();
                aux2.push(x);
                i++;
            }
            i = 0;
            while (tamaño / 2 > i) {
                int x = aux1.pop();
                push(x);
                i++;
            }
            i = 0;
            while (tamaño / 2 > i) {
                int x = aux2.pop();
                push(x);
                i++;
            }
        }
    }

    public void Intercambiar2Pilas(PilaVector P, PilaVector Q) {
        int a = P.pop();
        int cont = 0;
        int b = Q.pop();
        while (!P.vacia()) {
            Q.push(P.pop());
        }
        int c = Q.pop();
        while (!Q.vacia()) {
            P.push(Q.pop());
        }
        int d = pop();
        Q.push(c);
        int n = P.cima / 2;
        for (int i = 0; i <= n; i++) {
            Q.push(P.pop());
        }
        Q.push(a);
        while (!P.vacia()) {
            Q.push(P.pop());
            cont++;
        }
        P.push(d);
        for (int i = 1; i <= cont; i++) {
            P.push(Q.pop());
        }
        P.push(b);
    }

    public static void main(String[] args) {
        PilaVector pila = new PilaVector(9);
        pila.push(1);
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(3);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.push(5);
        System.out.println(pila.toString());
        pila.EliminarRepetidos();
        System.out.println(pila.toString());

        /*System.out.println(pila.toString());
        System.out.println(pila2.toString());
        pila.Intercambiar2Pilas(pila, pila2);
        System.out.println(pila.toString());
        System.out.println(pila2.toString());*/
    }
}
