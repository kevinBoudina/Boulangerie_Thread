package com.iut.multithread;

public class ThreadEgoiste extends Thread {

    Compte compte;
    int i;  // 0 <= i <= compte.length - 1 : indique quelle case de Compte on gère

    public ThreadEgoiste(String nom, Compte compte, int i) {
        super(nom);
        this.compte = compte;
        this.i = i;
    }

    public void run() {
//------------------ run() -------------------------------------

        int j;

        j = 0;
        while (j < 5) {
            ++compte.t[i];
            ++j;
            System.out.println(" le thread egoïste courant : " + this.getName() + " accède au compte courant pour la " + j + "ème fois");
            System.out.println(" état du compte après accès : " + compte);
        }

//------------------ run() -------------------------------------
    }

    /*---------------------- ThreadEgoiste ---------------------------------*/
}