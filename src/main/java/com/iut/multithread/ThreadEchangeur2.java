package com.iut.multithread;

/**
 * thread dont la tâche consiste, à chaque fois qu'il a la "main", à échanger le contenu des cases i et j du compte.
 * utilise run(), start(), sleep()
 * <p>
 * ces threads règlent le pb de ThreadEchangeur1 : l'incohérence disparaît grâce à l'emploi de la méthode
 * synchronisée échange() de  l'objet partagé
 * <p>
 * ces threads échangent le contenu de 2 cases à chaque fois qu'ils ont la main :
 * <p>
 * but : mise en évidence du problème de synchronisation et de ses solutions
 **/

public class ThreadEchangeur2 extends Thread {

    Compte2 compte;
    int i, j;

    public ThreadEchangeur2(String nom, Compte2 compte, int i, int j) {
        super(nom);
        this.compte = compte;

        if (!(0 <= i && i < compte.t.length)) throw new IndexOutOfBoundsException();
        if (!(0 <= j && j < compte.t.length)) throw new IndexOutOfBoundsException();
        this.i = i;
        this.j = j;
    }//ThreadEchangeur2(...)


    public void run() {
        int k;
        try {
            k = 0;

            while (k < 10) {
                /* échange des cases i et j */
                this.compte.echange(i, j);
                k++;
                System.out.println(" le thread échangeur courant : " + this.getName() + " accède au compte courant pour la " + k + "ème fois");
                System.out.println(" état du compte après accès : " + compte);

                //Thread.sleep(this.période);
            }//while

        }//try
        catch (InterruptedException e) {
        }


    }//run

}
