package CapaNegocio.ListaEnlazada;

/**
 *
 * @author Luis
 */
public class Lista {

    Nodo L;
    int cant;

    public Lista() {
        this.L = null;
        this.cant = 0;
    }

    public int getCant() {
        return cant;
    }

    public boolean vacia() {
        return (L == null);
    }

//insertar varios datos iguales ordenados
    public void insertarv(int ele) {
        if (vacia()) {
            Nodo p = new Nodo();
            p.setDato(ele);
            L = p;
            cant++;
        } else {
            Nodo aux = L;
            Nodo ant = null;
            while ((aux != null) && (aux.getDato() <= ele)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) {
                Nodo p = new Nodo();
                p.setDato(ele);
                p.setEnlace(L);
                L = p;
                cant++;
            } else {
                Nodo p = new Nodo();
                p.setDato(ele);
                ant.setEnlace(p);
                p.setEnlace(aux);
                cant++;
            }
        }
    }

    //insertar cualquier dato
    public void insertarc(int ele) {
        if (vacia()) {
            Nodo p = new Nodo();
            p.setDato(ele);
            L = p;
            cant++;
        } else {
            Nodo aux = L;
            Nodo ant = null;
            while (aux != null) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) {
                Nodo p = new Nodo();
                p.setDato(ele);
                p.setEnlace(L);
                L = p;
                cant++;
            } else {
                Nodo p = new Nodo();
                p.setDato(ele);
                ant.setEnlace(p);
                p.setEnlace(aux);
                cant++;
            }
        }
    }

    // Inserta ordenado, en la cabeza, en el cuerpo, el la cola
    public void insertar(int ele) {
        if (vacia()) {
            Nodo p = new Nodo();
            p.setDato(ele);
            L = p;
            cant++;

        } else {
            Nodo aux = L;
            Nodo ant = null; //nodo anterior
            while ((aux != null) && (aux.getDato() <= ele)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) {
                Nodo p = new Nodo();
                p.setDato(ele);
                p.setEnlace(L);
                L = p;
                cant++;

            } else {
                if (ant.getDato() != ele) {
                    Nodo p = new Nodo();
                    p.setDato(ele);
                    ant.setEnlace(p);
                    p.setEnlace(aux);
                    cant++;

                }
            }
        }
    }

    public void eliminar(int ele) {
        if (!vacia()) {
            Nodo aux = L;
            Nodo ant = null;
            while ((aux != null) && (aux.getDato() != ele)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (aux != null) { // Si encontro el elemento que queremos eliminar en la lista
                if (ant == null) { // Si es el primero
                    L = L.getEnlace();
                    cant--;
                } else { // Si esta en cualquier otra parte
                    ant.setEnlace(aux.getEnlace());
                    cant--;
                }
            }
        }
    }

    public boolean existe(int ele) {
        boolean x = false;
        if (!vacia()) {
            Nodo aux = L;
            while ((aux != null) && (aux.getDato() != ele)) {
                aux = aux.getEnlace();
            }
            if (aux != null) {
                x = true;
            }
        }
        return x;
    }

    public int getDato(int pos) { // pos 1
        // la posicion se debe verificar en el form
        Nodo aux = L;
        for (int i = 1; i < pos; i++) {
            aux = aux.getEnlace();
        }
        return (aux.getDato());
    }

    @Override
    public String toString() {
        String S = "L-> <";
        Nodo aux = L;
        while (aux != null) {
            S = S + aux.getDato() + ",";
            aux = aux.getEnlace();
        }
        S = S + ">";
        return S;
    }

    public void invertirIterativo() {

        if (cant > 1) {
            Nodo ant = null;
            Nodo act = L;
            Nodo pos = L.getEnlace();
            while (act != null) {
                act.setEnlace(ant);
                ant = act;
                act = pos;
                if (pos != null) {
                    pos = pos.getEnlace();
                }
            }
            L = ant;
        }
    }

    public void invertirT() {

        if (L == null) {

        } else {
            Nodo ant = null;
            Nodo aux = L;
            Nodo pos = L.getEnlace();
            while (pos != null) {
                aux.setEnlace(ant);
                ant = aux;
                aux = pos;
                pos = pos.getEnlace();

            }
            aux.setEnlace(ant);
            L = aux;

        }
    }

    public void invertir() {
        invertirR(L);
    }

    private void invertirR(Nodo P) {
        if (L == null) {

        } else if (P.getEnlace() == null) {
            L = P;
        } else {
            invertirR(P.getEnlace());
            P.getEnlace().setEnlace(P);
            P.setEnlace(null);

        }

    }

    public boolean par() {
        boolean flag = false;
        if (cant % 2 == 0) {
            flag = true;

        }
        return flag;
    }

//    public void intercambiar(){
//        if (cant > 1) {
//            intercambiarRecursivo(L);
//        }
//
//
//    }
    public void intercambiar() {
        if (cant > 1) {
            Nodo aux;
            Nodo ant;
            Nodo sig;
            if (cant % 2 != 0) {
                aux = L.getEnlace();
                ant = L;

            } else {
                aux = L;
                ant = null;
            }

            while (aux != null) {

                sig = aux.getEnlace();
                if (sig != null) {
                    aux.setEnlace(sig.getEnlace());
                    sig.setEnlace(aux);
                    if (ant == null) {
                        L = sig;
                    } else {
                        ant.setEnlace(sig);
                    }
                }
                ant = aux;
                aux = aux.getEnlace();
            }
        }
    }

    // Metodo recursivo No finalizado
    public void intercambiarRecursivo(Nodo p) {
        if (vacia()) {

        } else if (L.getEnlace() == null) {
            L = p;

        } else {
            if (cant % 2 == 0) {
                intercambiarRecursivo(p.getEnlace().getEnlace());
                Nodo aux = p.getEnlace();
                p.setEnlace(aux.getEnlace());
                aux.setEnlace(p);

            } else {
                intercambiarRecursivo(p.getEnlace());

            }

        }

    }

    public void VolcarDea2() {
        Nodo Nodoauxiliar = L;
        Nodo pos = L.getEnlace();
        Nodo ant = null;
        //recorrmos con pos
        while (pos != null) {
            Nodo val = pos.getEnlace();
            Nodoauxiliar.setEnlace(val);
            pos.setEnlace(Nodoauxiliar);
            if (Nodoauxiliar != L) {
                ant.setEnlace(pos);
                // System.out.println(ant.toString());
            } else {

                L = pos;
            }
            //cambio de punteros
            ant = Nodoauxiliar;
            Nodoauxiliar = Nodoauxiliar.getEnlace();

            if (Nodoauxiliar != null) {
                pos = Nodoauxiliar.getEnlace();
            } else {
                pos = Nodoauxiliar;
            }
        }
    }

    public void eliminarNumero(int ele) {
        if (!vacia()) {
            Nodo aux = L;
            Nodo ant = null;
            while ((aux != null) && (aux.getDato() != ele)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            while (aux != null && aux.getDato() == ele) {
                // Eliminar todas las ocurrencias del número
                if (ant == null) {
                    L = L.getEnlace();
                } else {
                    ant.setEnlace(aux.getEnlace());
                }
                aux = aux.getEnlace();
                cant--;
            }
        }
    }

    public void EliminarUnicos() {
        if (L != null && L.getEnlace() != null) {
            Nodo ant = null;
            Nodo aux = L;
            while (aux != null) {
                boolean seRepite = false;
                Nodo temp = L;
                while (temp != null) {
                    if (temp != aux && temp.getDato() == aux.getDato()) {
                        seRepite = true;
                        break;
                    }
                    temp = temp.getEnlace();
                }
                if (!seRepite) {
                    if (ant == null) {
                        L = aux.getEnlace();
                    } else {
                        ant.setEnlace(aux.getEnlace());
                    }
                    cant--;
                } else {
                    ant = aux;
                }
                aux = aux.getEnlace();
            }
        }
    }

    public void ElimRepIncMism() {
        if (L != null && L.getEnlace() != null) {
            Nodo ant = null;
            Nodo aux = L;
            while (aux != null) {
                boolean seRepite = false;
                Nodo temp = L;
                while (temp != null) {
                    if (temp != aux && temp.getDato() == aux.getDato()) {
                        seRepite = true;
                        break;
                    }
                    temp = temp.getEnlace();
                }
                if (seRepite) {
                    eliminarNumero(aux.getDato());
                } else {
                    ant = aux;
                }
                aux = aux.getEnlace();
            }
        }
    }

    public void EliminarRepetidos0() {
        if (L != null && L.getEnlace() != null) {
            Nodo ant = null;
            Nodo aux = L;
            while (aux != null) {
                boolean seRepite = false;
                Nodo temp = L;
                while (temp != null) {
                    if (temp != aux && temp.getDato() == aux.getDato()) {
                        seRepite = true;
                        break;
                    }
                    temp = temp.getEnlace();
                }
                if (seRepite) {
                    if (ant == null) {
                        L = aux.getEnlace();
                    } else {
                        ant.setEnlace(aux.getEnlace());
                    }
                    cant--;
                } else {
                    ant = aux;
                }
                aux = aux.getEnlace();
            }
        }
    }

    public void EliminarRepetidos() {
        if (L != null && L.getEnlace() != null) {
            Nodo actual = L;
            while (actual != null) {
                int datoActual = actual.getDato();
                Nodo comparador = actual;
                boolean SeRepite = false;
                while (comparador.getEnlace() != null) {
                    while (comparador.getEnlace() != null && datoActual == comparador.getEnlace().getDato()) {
                        // Elemento repetido, eliminar nodo siguiente
                        comparador.setEnlace(comparador.getEnlace().getEnlace());
                        cant--;
                        SeRepite = true;
                    }
                    if (SeRepite) {
                        comparador.setEnlace(comparador.getEnlace().getEnlace());
                        cant--;
                    }
                    comparador = comparador.getEnlace();
                }

                actual = actual.getEnlace();
            }
        }
    }

    public void Enroque2() {
        if (cant > 2) {
            Nodo ant = L;
            Nodo A = L.getEnlace();
            Nodo B = L.getEnlace().getEnlace();
            while (A.getEnlace() != null) {
                ant.setEnlace(B);
                A.setEnlace(B.getEnlace());
                B.setEnlace(A);
                if (A.getEnlace() != null) {
                    ant = ant.getEnlace().getEnlace();
                    A = A.getEnlace();
                    B = A.getEnlace();
                }
            }
        }
    }

    public void Intercalar() {
        if (cant > 1) {
            Nodo aux, ant;
            if (cant % 2 == 0) {
                aux = L;
                ant = null;
            } else {
                ant = L;
                aux = ant.getEnlace();
            }
            while (aux != null) {
                Nodo sig = aux.getEnlace();
                aux.setEnlace(sig.getEnlace());
                sig.setEnlace(aux);
                if (L == aux) {
                    L = sig;
                } else {
                    ant.setEnlace(sig);
                }
                ant = aux;
                aux = aux.getEnlace();
            }
        }
    }

    public static void main(String[] args) {
        Lista LI = new Lista();
        LI.insertarv(1);
        LI.insertarv(2);
        LI.insertarv(3);
        LI.insertarv(4);
        LI.insertarv(5);
        LI.insertarv(8);
        LI.insertarv(8);
        LI.insertarv(8);
        LI.insertarv(10);
        LI.insertarv(10);
        LI.insertarv(11);
        System.out.println(LI.toString());
        LI.VolcarDea2();
        //LI.EliminarRepetidos0();
        //System.out.println(LI.toString());
        //LI.Intercalar();
        System.out.println(LI.toString());

//        LI.insertar(3);
//        LI.insertar(2);
//        LI.insertar(11);
//         LI.insertar(13);
//         LI.insertar(14);
        //System.out.println(LI.toString());
//        System.out.println(LI.getDato(7));
//        LI.invertir();
//        System.out.println(LI.toString());
    }

}
