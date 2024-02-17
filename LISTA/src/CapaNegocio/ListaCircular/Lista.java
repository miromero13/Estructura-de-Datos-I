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
public class Lista {

    Nodo primero;
    int cant;

    public Lista() {
        primero = new Nodo();
        primero = null;
        cant = 0;
    }

    public boolean vacia() {
        return primero == null;
    }

    public void insertarInicio(Object elemento) {
        Nodo nuevo = new Nodo();
        nuevo.setElem(elemento);
        if (vacia()) {
            primero = nuevo;
            nuevo.setEnlace(primero);

        } else {
            Nodo aux = new Nodo();
            aux = primero;

            while (aux.getEnlace() != primero) {
                aux = aux.getEnlace();
            }
            nuevo.setEnlace(primero);
            primero = nuevo;
            aux.setEnlace(primero);
        }
        cant++;

    }

    public void insertarUltimo(Object elemento) {
        Nodo nuevo = new Nodo();
        nuevo.setElem(elemento);
        if (vacia()) {
            primero = nuevo;
            nuevo.setEnlace(primero);

        } else {
            Nodo aux = primero;
            while (aux.getEnlace() != primero) {
                aux = aux.getEnlace();
            }
            aux.setEnlace(nuevo);
            nuevo.setEnlace(primero);
        }
        cant++;

    }

    public void insertar(Object elemento, int posicion) {
        Nodo nuevo = new Nodo();
        nuevo.setElem(elemento);
        if (vacia() || posicion == 0) {
            insertarInicio(elemento);
        } else {
            if (posicion >= cant - 1) {
                insertarUltimo(elemento);

            } else {
                Nodo aux = primero;
                posicion--;
                while (posicion > 0) {
                    aux = aux.getEnlace();
                    posicion--;
                }
                nuevo.setEnlace(aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        cant++;
    }

    //consultar
    public Object consultarInicio() {
        return primero.getElem();

    }

    public Object consultar() {

        Nodo aux = new Nodo();
        aux = primero;
        while (aux.getEnlace() != primero) {
            aux = aux.getEnlace();
        }
        return aux.getElem();

    }

    //consultar con posicion
    public Object consultar(int pos) {
        Nodo aux = new Nodo();
        aux = primero;
        if (pos >= cant - 1) {
            return consultar();

        } else {
            if (pos <= 0) {
                return consultarInicio();

            } else {

                while (pos > 0) {
                    aux = aux.getEnlace();
                    pos--;

                }
                return aux.getElem();
            }
        }
    }

    //eliminarinicio
    public void eliminarInicio() {
        if (cant == 1) {
            primero = null;

        } else {
            Nodo aux = new Nodo();
            aux = primero;
            while (aux.getEnlace() != primero) {
                aux = aux.getEnlace();

            }
            aux.setEnlace(primero.getEnlace());
            primero = aux.getEnlace();

        }
        cant--;
    }

    //eliminar
    public void eliminar() {
        if (cant == 1) {
            primero = null;

        } else {
            Nodo aux = new Nodo();
            aux = primero;
            int i = cant - 2;
            while (i > 0) {
                aux = aux.getEnlace();
                i--;

            }
            aux.setEnlace(aux.getEnlace().getEnlace());
        }
        cant--;
    }

    //eliminar con posicion
    public void eliminar(int pos) {
        if ((pos <= 0) || (cant == 1)) {
            eliminarInicio();

        } else {
            if (pos >= cant - 1) {
                eliminar();

            } else {
                Nodo aux = new Nodo();
                aux = primero;
                pos--;
                while (pos > 0) {
                    aux = aux.getEnlace();
                    pos--;

                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        cant--;
    }

    // getlongitud
    public int getLongitud() {
        return cant;
    }

    @Override
    public String toString() {
        if (vacia()) {
            System.out.println("La lista se encuentra vacia");
            return "C->null";
        } else {
            String S = "C->";
            Nodo p = primero;
            do {
                S = S + p.getElem() + "->";
                p = p.getEnlace();
            } while (p != primero);

            return S;
        }
    }

//    @Override
//    public String toString() {
//        String s= "";
//        //mostra la lista circular
//        //recorrer la lista
//            if (!vacia()) {
//
//                CNodoS aux = primero;
//
//
//                while (aux.getEnlace() != primero){
//                    s = s + aux.getElem()+ " ";
//                    aux = aux.getEnlace();
//
//
//                }
//                s = s + aux.getElem();
//            }
//                else{
//                s = "La lista esta vacia";
//
//
//            }
//        return s;
//    }
    public static void main(String[] args) {
        Lista L = new Lista();
        L.insertarInicio(2);
        L.insertarUltimo(5);
        L.insertarUltimo(9);
        L.insertar(4, 1);
        System.out.println(L.toString());

        L.eliminarInicio();
        System.out.println(L);
        L.insertarUltimo(3);
        System.out.println(L);

        L.eliminar(3);
        System.out.println(L);

        System.out.println(L.consultar(1)); //tendria que retornar el 5

    }

}
