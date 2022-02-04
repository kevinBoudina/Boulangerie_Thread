package com.iut.multithread;

/**
 * exemples de threads qui se mettent en sommeil après leur travail  : utilisation de run(), start() et sleep()
 * ces threads sont immortels : ils s'arrêtent seulement sur une demande d'interruption :
 * utilisation aussi de isInterrupted() et de interrupt()
 */

public class ThreadImmortelGroupe extends Thread {


    Compte compte;
    int i;  // 0 <= i <= compte.length - 1 : indique quelle case de Compte on gère
//int j;

    public ThreadImmortelGroupe(ThreadGroup groupe, String nom, Compte compte, int i) throws Exception {
        super(groupe, nom); /* le thread est "accroché" à un groupe de threads existant */
        this.compte = compte;
        if (i < 0 || i >= compte.t.length) throw new Exception(" i n'est pas dans {0..compte.t.length-1}");
        this.i = i;
    }

    public void run() {
//------------------ run() -------------------------------------
        try {
            int j;

            j = 0;
            while (!this.isInterrupted()) // la boucle s'arrête seulement sur une demande d'interruption
            {
                ++compte.t[i];
                ++j;
                System.out.println(" le thread immortel groupé courant : " + this.getName() + " accède au compte courant pour la " + j + "ème fois");
                System.out.println(" état du compte après accès : " + compte);
                Thread.sleep(5);
            }//while

        }//try


        catch (InterruptedException e) {
            System.err.println("le thread : " + this.getName() + " a été interrompu pendant son sommeil");
        }

//------------------ run() -------------------------------------
    }

    /*---------------------- ThreadImmortelGroupe ---------------------------------*/
}
