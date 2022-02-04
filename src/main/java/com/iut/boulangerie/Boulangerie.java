package com.iut.boulangerie;

import com.iut.producteur.Boulanger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Ecrire le consommateur sur le même principe DP - Producteur / Consommatuer et écrire le programme qui fait tourner la boulangerie.
 * La boulangerie s'arrête quand elle a produit le nombre maximum de pain.
 * Ou quand il y a plus de consommateurs ..
 *
 * Réaliser un ou plusieurs tests unitaires prouvant que votre boulangerie fonctionne (pensez à Mockito).
 * A faire pour le 3 février ... sera peut être noté ....
 *
 * @author stephane.joyeux
 */

public class Boulangerie {

    public static final int capacity = 20;

    // La capacité de production de ma boulangerie est de 20 pains ...
    private static BlockingQueue<Pain> queue = new ArrayBlockingQueue<Pain>(20);

    // La boulangerie fabrique un pain
    public static boolean depose(Pain pain) throws InterruptedException {
        System.out.println("Un boulanger dépose un pain");
        return queue.offer(pain, 200, TimeUnit.MILLISECONDS);
    }

    // La boulangerie vend un pain
    public static Pain achete() throws InterruptedException {
        System.out.println("Un client attend un pain");
        return queue.poll(200, TimeUnit.MILLISECONDS);
    }

    public static int getStock() {
        return queue.size();
    }

    public static  boolean ferme(){
        return getStock() >= capacity;
    }

    public  void deposePainEmpoisonne() {
        queue.add(Pain.PAIN_POISON) ;
    }
}
