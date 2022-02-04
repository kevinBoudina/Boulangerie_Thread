package com.iut.main;

import com.iut.business.CompteEnBanque;
import com.iut.runnable.RunImpl;

/***
 * Bonus : faire synchroniser le retrait avec le solde du compte !
 * @author stephane.joyeux
 *
 */

public class StartThread {

    public static void main(String[] args) {
        CompteEnBanque cb = new CompteEnBanque(100, "cp1");
        CompteEnBanque cb2 = new CompteEnBanque(200, "cp2");

        // Un thread pour g�rer le premier compte en banque ...
        Thread t = new Thread(new RunImpl(cb, "Delta"));
        // Un autre thread pour g�rer le deuxi�me compte en banque ..
        Thread t2 = new Thread(new RunImpl(cb2, "Omicron"));
        t.start();
        t2.start();
    }
}
