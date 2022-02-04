package com.iut.threads;

public class RunThread {

    public static void main(String[] args) {
        TestThread monPremierThread = new TestThread("MonPRemierThread");
        TestThread monDeuxiemeThread = new TestThread("MonDeuxiemeThread", monPremierThread);
        try {
            System.out.println("Temps before");
            Thread.sleep(1000); // Temps d'arrêt de une seconde ..
            System.out.println("Temps after");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("statut du thread " + monPremierThread.getName() + " = " + monPremierThread.getState());
        System.out.println("statut du thread " + monDeuxiemeThread.getName() + " = " + monDeuxiemeThread.getState());
    }

}
