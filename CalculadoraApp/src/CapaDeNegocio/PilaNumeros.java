package CapaDeNegocio;

public class PilaNumeros {

    private NodoNumero p;

    PilaNumeros() {
        p = null;
    }

    public void push(Float x) {
        NodoNumero n = new NodoNumero(x);
        n.setEnlace(p);
        p = n;
    }

    public Float pop() {
        Float t = null;
        if (p != null) {
            t = p.getDato();
            p = p.getEnlace();
        }
        return t;
    }

    public Float topePila() {
        return p.getDato();
    }

    public boolean estaVacia() {
        return !(p != null);
    }
}
