package com.iut.consommateur;

import com.iut.boulangerie.Boulangerie;
import com.iut.boulangerie.Pain;
import java.util.*;

public class Client implements Runnable {

    public  void run() {

        try {

            while (true) {
                Random rand = new Random();
                Thread.sleep(rand.nextInt(1000)) ;
                Pain pain = Boulangerie.achete() ;
                if (pain != null) {

                    if (pain == Pain.PAIN_POISON) {
                        System.out.println("Le client s'en va !") ;
                        Thread.currentThread().interrupt() ;
                    } else {

                        System.out.println("[" + Thread.currentThread().getName() + "]" +
                                "[" + Boulangerie.getStock() + "] j'achete un pain : " + Boulangerie.getStock());
                    }
                }  else {
                    System.out.println("[" + Thread.currentThread().getName() +  "]" +
                            "[" + Boulangerie.getStock() +  "] j'attend un pain") ;
                }
            }
        }  catch (InterruptedException e) {
            System.out.println("[" + Thread.currentThread().getName() +  "] je m'arrête") ;
        }
        System.out.println("Boulangerie fermée");
    }
}
