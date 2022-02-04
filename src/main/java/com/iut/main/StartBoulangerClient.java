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

        for (int i = 0; i < boulangers.length; i++) {
            boulangers[i] = new Thread(boulanger);
        }

        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Thread(client);
        }

        for (int i = 0; i < boulangers.length; i++) {
            boulangers[i].start();
        }

        for (int i = 0; i < clients.length; i++) {
            clients[i].start();
        }

        try {
            Thread.sleep(20000) ;
        }  catch (InterruptedException e) {
        }

        for (int i =  0 ; i < boulangers.length ; i++) {
            boulangers[i].interrupt() ;
        }

        for (int i =  0 ; i < clients.length ; i++) {
            boulangerie.deposePainEmpoisonne() ;
        }
    }
}
