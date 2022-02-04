package com.iut.consommateur;

import com.iut.business.Buffer;


public class Consommateur extends Thread {

    private Buffer buf;
    private int identite;

    public Consommateur(Buffer c, int n) {
        buf = c;
        this.identite = n;
    }

    @Override
    public void run() {
        int val = 0;
        for (int i = 0; i < 10; i++) {
            val = buf.prendre(identite);
        }
    }
}
