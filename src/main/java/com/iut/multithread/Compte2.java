package com.iut.multithread;


/**
 * compte commun accédé par différents threads
 */

public class Compte2 {

    public int[] t;
    public int tempo;


    public Compte2(int a, int b, int c, int d) {
        this.t = new int[4];
        this.t[0] = a;
        this.t[1] = b;
        this.t[2] = c;
        this.t[3] = d;
    }

    public synchronized void echange(int i, int j) throws InterruptedException {
        this.tempo = this.t[i];
        this.t[i] = this.t[j];
        Thread.sleep(5);

        this.t[j] = this.tempo;

    }


    public String toString() {
        String s;
        int i;

        for (i = 0, s = "( "; i < this.t.length; ++i)
            s += this.t[i] + ", ";

        s += ")";
        return s;
    }

}
