package com.iut.business;

public class CompteEnBanque {

    private int solde;
    private String nom;

    public int getSolde() {
        return solde;
    }

    public String getNom() {
        return nom;
    }

    public CompteEnBanque(int solde, String nom) {
        this.solde = solde;
        this.nom = nom;
    }

    public synchronized void retraitArgent(int montant) {
        solde = solde - montant;
        System.out.println("-------> Le solde du compte " + nom + " est de " + solde);
    }
}
