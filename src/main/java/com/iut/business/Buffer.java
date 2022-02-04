package com.iut.business;

public class Buffer {

    private int valeur;
    private int identiteProducteur;
    private boolean available = false;

    public synchronized int prendre(int identite) {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        System.out.println(
                "Consommateur #" + identite + " prend l'élément : " + valeur + " du producteur # " + identiteProducteur);
        notifyAll();
        return valeur;
    }

    public synchronized void mettre(int val, int identiteProducteur) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        valeur = val;
        available = true;
        this.identiteProducteur = identiteProducteur;
        System.out.println("Producteur #" + identiteProducteur + " met : " + val);
        notifyAll();
    }
}
