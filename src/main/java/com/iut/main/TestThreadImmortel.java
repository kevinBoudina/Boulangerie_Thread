package com.iut.main;

import com.iut.multithread.Compte;
import com.iut.multithread.ThreadImmortel;

/**
 * exemples de threads qui se mettent en sommeil après leur travail  : utilisation de run(), start() et sleep()
 * ces threads sont immortels : ils s'arrêtent seulement sur une demande d'interruption :
 * utilisation aussi de isInterrupted() et de interrupt()
 */


public class TestThreadImmortel {

    public static void main(String[] args) throws Exception {
        Compte compte = new Compte(0, 0, 0);
        ThreadImmortel immortel0, immortel1, immortel2;

        /* création des threads sans lancement*/

        immortel0 = new ThreadImmortel("riri", compte, 0);
        immortel1 = new ThreadImmortel("fifi", compte, 1);
        immortel2 = new ThreadImmortel("loulou", compte, 2);


        /*lancement des threads : */
        System.out.println("application avec 3 threads immortels : utilisation de run(), start(), sleep(), interrupt() et isInterrupted()");

        immortel0.start();
        immortel1.start();
        immortel2.start();

        int c = System.in.read();//dès que l'utilisateur frappe une touche + ENTREE, les threads seront interrompus

// la répétition d'instructions qui suit est maladroite : elle pourrait être évitée grâce à un groupe de threads
        immortel0.interrupt(); //demande au thread immortel0 de s'interrompre
        immortel1.interrupt(); //demande au thread immortel1 de s'interrompre
        immortel2.interrupt(); //demande au thread immortel2 de s'interrompre

    } //main

}