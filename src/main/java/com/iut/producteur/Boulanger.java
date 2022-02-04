package com.iut.producteur;

import com.iut.boulangerie.Boulangerie;
import com.iut.boulangerie.Pain;

public class Boulanger implements Runnable{

    public  void run() {

        try {
            while (!Boulangerie.ferme()) {

                // toutes les secondes un boulanger produit un pain
                Thread.sleep(1000) ;
                boolean added = Boulangerie.depose(new Pain()) ;

                if (added) {
                    System.out.println("[" + Thread.currentThread().getName() +  "]" +
                            "[" + Boulangerie.getStock() +  "] je produis un pain : " + Boulangerie.getStock()) ;
                }  else {
                    System.out.println("[" + Thread.currentThread().getName() +  "]" +
                            "[" + Boulangerie.getStock() +  "] la boulangerie est pleine :"+ Boulangerie.getStock()) ;
                }
            }
            System.out.println("Boulangerie fermée");

        }  catch (InterruptedException e) {
            System.out.println("[" + Thread.currentThread().getName() +  "] je m'arrête") ;
        }
    }
}
