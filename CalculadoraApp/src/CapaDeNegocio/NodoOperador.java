package CapaDeNegocio;

public class NodoOperador {

    private char dato;
    private NodoOperador Enlace;

    NodoOperador(char i) {
        dato = i;
        Enlace = null;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public void setEnlace(NodoOperador p) {
        this.Enlace = p;
    }

    public char getDato() {
        return dato;
    }

    public NodoOperador getEnlace() {
        return Enlace;
    }
}
