package CapaDeNegocio;

public class NodoNumero {

    private Float dato;
    private NodoNumero Enlace;

    NodoNumero(Float i) {
        dato = i;
        Enlace = null;
    }

    public void setDato(Float dato) {
        this.dato = dato;
    }

    public void setEnlace(NodoNumero p) {
        this.Enlace = p;
    }

    public Float getDato() {
        return dato;
    }

    public NodoNumero getEnlace() {
        return Enlace;
    }
}
