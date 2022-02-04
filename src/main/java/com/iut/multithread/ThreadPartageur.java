package com.iut.multithread;

public class ThreadPartageur extends Thread {

    Compte compte;
    int i;  // 0 <= i <= compte.length - 1 : indique quelle case de Compte on gère
//int j;

    public ThreadPartageur(String nom, Compte compte, int i) throws Exception {
        super(nom);
        this.compte = compte;
        if (i < 0 || i >= compte.t.length) throw new Exception(" i n'est pas dans {0..compte.t.length-1}");
        this.i = i;
    }

    public void run() {
//------------------ run() -------------------------------------
        try {
            int j;

            j = 0;
            while (j < 5) {
                ++compte.t[i];
                ++j;
                System.out.println(" le thread partageur courant : " + this.getName() + " accède au compte courant pour la " + j + "ème fois");
                System.out.println(" état du compte après accès : " + compte);
                Thread.sleep(5);
            }//while

        }//try


        catch (InterruptedException e) {
            System.err.println("le thread : " + this.getName() + " a été interrompu pendant son sommeil");
        }

//------------------ run() -------------------------------------
    }

    /*---------------------- ThreadPartageur ---------------------------------*/
}
