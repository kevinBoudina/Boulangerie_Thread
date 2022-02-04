package com.iut.main;

import com.iut.multithread.Compte2;
import com.iut.multithread.ThreadEchangeur2;

/**
 * exemples de threads qui se mettent en sommeil après leur travail  : utilisation de run(), start() et sleep()
 * ces threads ne sont plus corrompus : l'incohérence de ThreadEchangeur1 disparaît grâce à l'emploi de
 * la méthode synchronisée échange()  de l'objet partagé
 * <p>
 * ces threads échangent le contenu de 2 cases à chaque fois qu'ils ont la main :
 * <p>
 * but : mise en évidence du problème de synchronisation et de ses solutions
 */

public class TestThreadEchangeur2 {

    public static void main(String[] args) throws Exception {
        Compte2 compte = new Compte2(9, 4, 7, 10);

        ThreadEchangeur2 echangeur0, echangeur1, echangeur2, echangeur3;


        /* création des threads sans lancement*/

        echangeur0 = new ThreadEchangeur2("riri", compte, 0, 1);
        echangeur1 = new ThreadEchangeur2("fifi", compte, 0, 2);
        echangeur2 = new ThreadEchangeur2("loulou", compte, 1, 2);
        echangeur3 = new ThreadEchangeur2("coco", compte, 0, 3);


        System.out.println("application avec 4 threads mélangeurs : utilisation de run(), start() et sleep()");
        System.out.println("mise en evidence de la solution au pb de corruption : utilisation d'une méthode synchronisée ");
        System.out.println("les valeurs du compte se déplacent et ne disparaissent plus");
        System.out.println(" état du compte avant tout accès : " + compte);


        int c = System.in.read();


        /*lancement des threads : */

        echangeur0.start();
        echangeur1.start();
        echangeur2.start();
        echangeur3.start();

//....

        echangeur0.join();
        echangeur1.join();
        echangeur2.join();
        echangeur3.join();

        System.out.println(" état du compte après la fin d'exécution des threads : " + compte);

    } //main

}
