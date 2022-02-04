package com.iut.multithread;

public class Compte {

    public int []t;

    public Compte (int a, int b, int c){
        this.t = new int[3];
        this.t[0] = a;
        this.t[1] = b;
        this.t[2] = c;
    }

    public String toString(){
        String s;
        int i;

        for (i=0,s="("; i < this.t.length; ++i){
            s += this.t[i]+", ";
        }
        s+=")";
        return s;
    }
}
