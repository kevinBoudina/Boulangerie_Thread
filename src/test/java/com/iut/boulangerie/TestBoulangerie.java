package com.iut.boulangerie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TestBoulangerie {

    private Boulangerie boulangerie;

    @BeforeEach
    public void setUp() {
        boulangerie = Mockito.spy(Boulangerie.class);
    }

    @Test
    public void create_pain() {
        Pain pain = new Pain();
        assertNotNull(pain);
    }


    @Test
    public void depose_pain() throws InterruptedException {
        assertTrue(Boulangerie.depose(new Pain()));
    }

    @Test
    public void Test_Achat() throws InterruptedException {
        int a = Boulangerie.getStock();
        System.out.println("Boulangerie.getStock avant achat : " + Boulangerie.getStock());
        Boulangerie.achete();
        int b = Boulangerie.getStock();
        System.out.println("Boulangerie.getStock après achat: " + Boulangerie.getStock());
        assertEquals(a-1,b);

    }

    @Test
    public void Stock() throws InterruptedException {
        int i = 0;
        while(i<5){
            Boulangerie.depose(new Pain());
            i++;
        }
        System.out.println("Boulangerie.getStock :" + Boulangerie.getStock() + " et i : " +i);
        assertEquals(Boulangerie.getStock(),i);
    }



    @Test
    public void Test_Boulangerie_Ouverte() {
        System.out.println("getStock : " + Boulangerie.getStock());
        assertFalse(Boulangerie.ferme());
    }

    @Test
    public void Test_Boulangerie_Ferme() throws InterruptedException {
        while(Boulangerie.getStock()<20){
            Boulangerie.depose(new Pain());
        }
        System.out.println("getStock : " + Boulangerie.getStock());
        assertTrue(Boulangerie.ferme());
    }







}
