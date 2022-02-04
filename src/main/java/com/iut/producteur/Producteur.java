package com.iut.producteur;

import com.iut.business.Buffer;

public class Producteur extends Thread {

    private Buffer buf;
    private int identite;

    public Producteur(Buffer c, int n) {
        buf = c;
        this.identite = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            buf.mettre(i, identite);
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
