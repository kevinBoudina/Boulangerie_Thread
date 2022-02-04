package com.iut.main;

import com.iut.multithread.Compte;
import com.iut.multithread.ThreadPartageur;

public class TestThreadPartageur {

    public static void main(String[] args) throws Exception {
        Compte compte = new Compte(0, 0, 0);
        ThreadPartageur partageur0, partageur1, partageur2;

        /* création des threads sans lancement*/

        partageur0 = new ThreadPartageur("riri", compte, 0);
        partageur1 = new ThreadPartageur("fifi", compte, 1);
        partageur2 = new ThreadPartageur("loulou", compte, 2);


        /*lancement des threads : */
        System.out.println("application avec 3 threads partageurs : utilisation de run(), start() et sleep()");

        partageur0.start();
        partageur1.start();
        partageur2.start();

    } //main

}
