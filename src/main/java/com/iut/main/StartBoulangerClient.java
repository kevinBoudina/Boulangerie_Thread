package com.iut.main;

import com.iut.boulangerie.Boulangerie;
import com.iut.consommateur.Client;
import com.iut.producteur.Boulanger;

import java.util.Random;

public class StartBoulangerClient {

    public static void main(String[] args) {

        final Boulangerie boulangerie = new Boulangerie();
        final Random rand = new Random();

        Boulanger boulanger = new Boulanger();

        Client client = new Client();

        Thread[] boulangers = new Thread[5];
        Thread[] clients = new Thread[2];

        // préparation des boulangers
        for (int i = 0; i < boulangers.length; i++) {
            boulangers[i] = new Thread(boulanger);
        }

        // préparation des clients
        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Thread(client);
        }

        // lancement des boulangers
        for (int i = 0; i < boulangers.length; i++) {
            boulangers[i].start();
        }

        // lancement des clients
        for (int i = 0; i < clients.length; i++) {
            clients[i].start();
        }

        try {
            Thread.sleep(20000) ;
        }  catch (InterruptedException e) {
        }

        // arrêt de notre système
        for (int i =  0 ; i < boulangers.length ; i++) {
            // interruption des boulangers
            boulangers[i].interrupt() ;
        }

        // dépôt des pains empoisonnées
        for (int i =  0 ; i < clients.length ; i++) {
            boulangerie.deposePainEmpoisonne() ;
        }
    }
}
