package CapaDeNegocio;

public class PilaOperador {

    private NodoOperador p;

    PilaOperador() {
        p = null;
    }

    public void push(char x) {
        NodoOperador n;
        n = new NodoOperador(x);
        n.setEnlace(p);
        p = n;
    }

    public char pop() {
        char t = p.getDato();
        p = p.getEnlace();
        return t;
    }

    public char topePila() {
        return p.getDato();
    }

    public boolean estaVacia() {
        return !(p != null);
    }
}
