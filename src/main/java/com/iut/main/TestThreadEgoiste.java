package com.iut.main;

import com.iut.multithread.Compte;
import com.iut.multithread.ThreadEgoiste;

public class TestThreadEgoiste {

    public static void main(String[] args) throws Exception {
        Compte compte = new Compte(0, 0, 0);
        ThreadEgoiste egoiste0, egoiste1, egoiste2;

        /* création des threads sans lancement*/

        egoiste0 = new ThreadEgoiste("riri", compte, 0);
        egoiste1 = new ThreadEgoiste("fifi", compte, 1);
        egoiste2 = new ThreadEgoiste("loulou", compte, 2);


        /*lancement des threads : */
        System.out.println("application avec 3 threads egoïstes : utilisation de run() et start()");

        egoiste0.start();
        egoiste1.start();
        egoiste2.start();

    } //main

}
