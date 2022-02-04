package com.iut.runnable;

import com.iut.business.CompteEnBanque;

public class RunImpl implements Runnable {

    private CompteEnBanque cb;
    private String name;

    public RunImpl(CompteEnBanque cb, String name) {
        this.cb = cb;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (cb.getSolde() > 0) {
                cb.retraitArgent(2);
                System.out.println("Retrait sur compte " + cb.getNom() + " effectué par " + this.name);
            }
        }
    }
}
