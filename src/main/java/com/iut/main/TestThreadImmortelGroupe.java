package com.iut.main;

import com.iut.multithread.Compte;
import com.iut.multithread.ThreadImmortelGroupe;

/**
 * exemples de threads qui se mettent en sommeil après leur travail  : utilisation de run(), start() et sleep()
 * ces threads sont immortels : ils s'arrêtent seulement sur une demande d'interruption :
 * utilisation aussi de isInterrupted() et de interrupt()
 * ces threads sont groupés : il est plus facile de les interrompre
 */

public class TestThreadImmortelGroupe {

    public static void main(String[] args) throws Exception {
        Compte compte = new Compte(0, 0, 0);
        ThreadImmortelGroupe immortel0, immortel1, immortel2;
        ThreadGroup groupe;

        groupe = new ThreadGroup("la bande des immortels");

        /* création des threads sans lancement*/

        immortel0 = new ThreadImmortelGroupe(groupe, "riri", compte, 0);
        immortel1 = new ThreadImmortelGroupe(groupe, "fifi", compte, 1);
        immortel2 = new ThreadImmortelGroupe(groupe, "loulou", compte, 2);


        /*lancement des threads : */
        System.out.println("application avec 3 threads immortels groupés: utilisation de run(), start(), sleep(), interrupt(), isInterrupted() et ThreadGroup");

        immortel0.start();
        immortel1.start();
        immortel2.start();


        int c = System.in.read();//dès que l'utilisateur frappe une touche + ENTREE, les threads seront interrompus

        groupe.interrupt(); //demande à tous les threads de ce groupe de s'interrompre

    } //main

}
