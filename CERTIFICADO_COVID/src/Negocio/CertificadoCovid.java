/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Negocio;

/**
 *
 * @author HP
 */
public class CertificadoCovid {

    VectorNBits c[];
    int i;
    public int bus;
    String vnombre[];

    public CertificadoCovid(int ele) {
        c = new VectorNBits[3];
        c[0] = new VectorNBits(ele, 24);
        c[1] = new VectorNBits(ele, 31);
        c[2] = new VectorNBits(ele, 15);
        vnombre = new String[ele];
        i = 0;
    }

    public void insertar(int ci, int d, int m, int a, int s, int mun, int lug, int vac, int p, int dv, int mv, int lot, int av, String Nombre) {
        i++;
        c[0].insertar(ci, i);
        vac <<= 3;
        vac |= p;
        lug <<= 6;
        lug |= vac;
        mun <<= 9;
        lug |= mun;
        s <<= 11;
        lug |= s;
        d <<= 4;
        d |= m;
        a <<= 9;
        d |= a;
        d <<= 15;
        lug |= d;
        c[1].insertar(lug, i);
        lot <<= 3;
        lot |= av;
        mv <<= 6;
        lot |= mv;
        dv <<= 10;
        lot |= dv;
        c[2].insertar(lot, i);
        vnombre[i - 1] = Nombre;
    }

    public int getCi(int p) {
        return c[0].sacar(p);
    }

    public String GetProveedor(int n) {
        int mask = (int) Math.pow(2, 3) - 1;
        int x = c[1].sacar(n);
        mask |= x;
        String S = "";
        switch (mask) {
            case 0:
                S = "AstraZeneca";
                break;
            case 1:
                S = "Sputnik V";
                break;
            case 2:
                S = "Pfizer";
                break;
            case 3:
                S = "Moderna";
                break;
            case 4:
                S = "Jhonson&Jhonson";
                break;
            case 5:
                S = "Sinopharm";
                break;
            case 6:
                S = "Sinovac";
                break;
        }
        return S;

    }

    public String GetVacuna(int n) {
        int mask = (int) Math.pow(2, 3) - 1;
        mask <<= 3;
        int x = c[1].sacar(n);
        mask &= x;
        mask >>>= 3;
        String S = "";
        switch (mask) {
            case 0:
                S = "Covid19";
                break;
            case 1:
                S = "FiebreAmarrilla";
                break;
            case 2:
                S = "Sarampion";
                break;
        }
        return S;
    }

    public String GetLugar(int n) {
        int mask = (int) Math.pow(2, 3) - 1;
        mask <<= 6;
        int x = c[1].sacar(n);
        mask &= x;
        mask >>>= 6;
        String S = "";
        switch (mask) {
            case 0:
                S = "UPDS";
                break;
            case 1:
                S = "EMI";
                break;
            case 2:
                S = "C.S. VIRGEN DE COTOCA";
                break;
            case 3:
                S = "C.S. PLAN 4000";
                break;
            case 4:
                S = "FEXPOCRUZ";
                break;
            case 5:
                S = "C.S. EL RECREO";
                break;
            case 6:
                S = "C.S. LAS AMERICAS";
                break;
        }
        return S;
    }

    public String GetMunicipio(int n) {
        int mask = (int) Math.pow(2, 2) - 1;
        mask <<= 9;
        int x = c[1].sacar(n);
        mask &= x;
        mask >>>= 9;
        String S = "";
        switch (mask) {
            case 0:
                S = "Santa Cruz";
                break;
            case 1:
                S = "Cotoca";
                break;
            case 2:
                S = "La Guardia";
                break;
        }
        return S;
    }

    public String GetSede(int n) {
        int mask = (int) Math.pow(2, 4);
        mask <<= 11;
        int x = c[1].sacar(n);
        mask &= x;
        mask >>>= 11;
        String S = "";
        switch (mask) {
            case 0:
                S = "Santa Cruz";
                break;
            case 1:
                S = "Beni";
                break;
            case 2:
                S = "Pando";
                break;
            case 3:
                S = "La Paz";
                break;
            case 4:
                S = "Cochabamba";
                break;
            case 5:
                S = "Chuquisaca";
                break;
            case 6:
                S = "Potosi";
                break;
            case 7:
                S = "Oruro";
                break;
            case 8:
                S = "Tarija";
                break;
        }
        return S;
    }

    public int GetMes(int n) {
        int mask = (int) Math.pow(2, 4) - 1;
        mask <<= 15;
        //   int x = c[]
        return 0;
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
