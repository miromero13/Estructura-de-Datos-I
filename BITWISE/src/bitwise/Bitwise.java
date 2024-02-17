/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bitwise;

/**
 *
 * @author HP
 */
public class Bitwise {

    int x;

    public Bitwise() {
        this.x = 0;
    }

    public void Setbit1(int pos) {
        if (pos <= 32) {
            int mask = 1;
            mask = mask << pos - 1;
            x = x | mask;
        }
    }

    public void Setbit0(int pos) {
        if (pos <= 32) {
            int mask = 1;
            mask = mask << pos - 1;
            mask = ~mask;
            x = x & mask;
        }
    }

    public int Getbit(int pos) {
        int mask = 1;
        mask = mask << pos - 1;
        mask = mask & x;
        mask = mask >>> pos - 1;
        return (mask);
    }

    public String ToString() {
        String S = "X=";
        for (int i = 32; i >= 1; i--) {
            S = S + " " + Getbit(i);
        }
        return S;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Bitwise p = new Bitwise();
        System.out.println(p.ToString());
        p.Setbit1(1);
        p.Setbit1(2);
        p.Setbit1(3);
        p.Setbit1(4);
        System.out.println(p.ToString());
        p.Setbit0(2);
        p.Setbit0(1);
        System.out.println(p.ToString());
    }

}
