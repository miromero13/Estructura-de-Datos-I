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
public class ColaArray {

    int Cola[];
    int Frente;
    int Atras;
    boolean flag;

    public ColaArray(int cant) {
        // la cola esta camuflada, en realidad es un vector
        this.Cola = new int[cant];
        this.Frente = -1;
        this.Atras = -1;
        this.flag = true;
    }

    public boolean vacia() {
        return (Frente == -1);
    }

    public boolean llena() {
        return ((Atras + 1) % Cola.length == Frente);
    }

    public void Encolar(int elemento) {
        if (vacia()) {
            Frente = 0;
            Atras = 0;
            Cola[Atras] = elemento;
        } else {
            if (!llena()) {
                Atras = (Atras + 1) % Cola.length;
                Cola[Atras] = elemento;
            }
        }
    }

    public int Decolar() {
        int x = Cola[Frente];
        if (Frente == Atras) {
            Frente = -1;
            Atras = -1;
        } else {
            Frente = (Frente + 1) % Cola.length;
        }
        return x;
    }

    public int longitud() {
        int b = 0;
        if (Atras >= Frente) {
            b = (Atras - Frente + 1);
        } else {
            b = (Cola.length - Frente + (Atras + 1));
        }
        return b;
    }

    public int Get() {
        return Cola[Frente];
    }

    public void encolarbi(int dato) {
        if (vacia()) {
            Frente++;
            Atras++;
            Cola[Atras] = dato;

        } else {
            if ((Atras + 1) % Cola.length != Frente) {
                if (flag) {
                    Atras = (Atras + 1) % Cola.length;
                    Cola[Atras] = dato;
                    flag = false;

                } else {
                    if (Frente == 0) {
                        Frente = Cola.length - 1;

                    } else {
                        Frente--;
                    }
                    Cola[Frente] = dato;
                    flag = true;
                }

            }
        }

    }

    /*Pila q = new Pila(Pila.length);
        for (int i = 0; i < longitud() / 2; i++) {
            int pivote = pop();
            while (!vacia()) {
                q.push(pop());
            }
            push(pivote);
            while (!q.vacia()) {
                push(q.pop());
            }
        }
    }*/
    public void CambiarMitad(ColaArray Q, ColaArray P) {
        int cantidadQ = Q.longitud();
        int aux = 0;
        while (aux < cantidadQ / 2) {
            System.out.println(aux);
            System.out.println(Q.Cola[aux]);
            int pivote = Q.Cola[aux];
            Q.Cola[aux] = P.Cola[aux];
            P.Cola[aux] = pivote;
            aux = (aux + 1) % Q.Cola.length;
        }
    }

// ==================================================================================
// ==============================  METODOS RECURSIVOS  ==============================
// ==================================================================================
    public void invertir() {
        if (vacia()) { // caso base

        } else {
            if (Atras == Frente) {
                // nada
            } else {  // caso general
                int x = Decolar();
                invertir();
                Encolar(x);
            }
        }
    }

    // Invierte y saca el menor
    public int Menor() {
        int menor;

        if (Atras == Frente) {
            menor = Cola[Frente];
        } else {
            int x = Decolar();
            menor = Menor();
            Encolar(x);
            if (x < menor) {
                menor = x;
            }
        }
        return menor;
    }

    //sacar solo el menor
    public int menor(int indice) {
        int menor;
        if (indice == Atras) {
            return Cola[indice];
        } else {
            menor = menor(indice + 1);
            if (menor > Cola[indice]) {
                menor = Cola[indice];
            }
        }
        return menor;
    }

    public void EliminarRepetidos() {
        int aux1 = 1;
        int cant = Cantidad();
        while (aux1 <= cant) {
            int x = Decolar();
            int y = 1;
            int z = Cantidad();
            boolean sw = false;
            while (y <= z) {
                int num = Decolar();
                if (x != num) {
                    Encolar(num);
                } else {
                    sw = true;
                    cant--;
                }
                y++;
            }
            if (!sw) {
                Encolar(x);
            }
            aux1++;
        }
    }

    public int Cantidad() {
        int b = 0;
        if (Atras >= Frente) {
            b = (Atras - Frente + 1);
        } else {
            b = (Cola.length - Frente + (Atras + 1));
        }
        return b;
    }

    // ==================================================================================
    // ==================================================================================
    @Override
    public String toString() {
        String s = "[ ";
        int aux = Frente;
        while (aux != Atras) {
            s = s + Cola[aux] + ", ";
            aux = (aux + 1) % Cola.length;
        }
        s = s + Cola[aux] + " ]";
        return s;
    }

    public static void main(String[] args) {
//        Cola cola = new Cola(7);
//        cola.Encolar(10);
//        cola.Encolar(2);
//        cola.Encolar(6);
//        cola.Encolar(11);
//        cola.Encolar(20);
//        cola.Encolar(8);
//        cola.Encolar(4);
//
//        System.out.println(cola.toString());
        ColaArray colaa = new ColaArray(9);
        ColaArray colab = new ColaArray(9);
        colab.Encolar(1);
        colab.Encolar(2);
        colab.Encolar(3);
        colab.Encolar(4);
        colab.Encolar(5);
        colab.Encolar(6);
        colab.Encolar(7);
        colab.Encolar(8);
        ColaArray colac = new ColaArray(9);
        colac.Encolar(9);
        colac.Encolar(10);
        colac.Encolar(11);
        colac.Encolar(12);
        colac.Encolar(13);
        colac.Encolar(14);
        colac.Encolar(15);
        colac.Encolar(16);
        System.out.println(colab.toString());
        System.out.println(colac.toString());
        colaa.CambiarMitad(colab, colac);
        System.out.println(colab.toString());
        System.out.println(colac.toString());
        //colab.EliminarRepetidos();
        //System.out.println(colab.toString());

        // System.out.println(colab.toString());
        //  System.out.println(colab.menor(0));
//        colab.invertir();
//       System.out.println(colab.Menor());
        //   System.out.println(colab.toString());
//        ColaArray cola2 = new ColaArray(7);
//        cola2.Encolar(10);
//       cola2.Encolar(2);
//        cola2.Encolar(6);
//        cola2.Encolar(11);
//        cola2.Encolar(20);
//        cola2.Encolar(2);
//        cola2.Encolar(1);
//        System.out.println(cola2.toString());
//        cola2.invertir();
//        System.out.println(cola2.toString());
    }
}
