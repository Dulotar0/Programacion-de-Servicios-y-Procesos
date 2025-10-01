package Ejercicio_3;

import java.util.Random;

public class Hilo implements Runnable {
    private final int n1;
    private final Random r = new Random();

    public Hilo(int n1){
        this.n1 = n1;
    }
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        try {
            t.setName("Hilo " + n1);
            int randomNumber = r.nextInt(100);
            System.out.println("Hilo " + n1 + ": Mostrando primos hasta el numero " + randomNumber);
            for (int i = 0; i <= randomNumber; i++) {
                int sleepTimer = r.nextInt(500, 1000);
                if (esPrimo(i)) {
                    Thread.sleep(sleepTimer);
                    System.out.println("Hilo " + n1 + ": " + i);
                }
                if(t.isAlive()){
                    Thread.sleep(1000);
                    System.out.println(t.getId() + " " +t.getName()+": "+t.getState());
                }
            }
        } catch (InterruptedException ie) {
            System.out.println("Fallo en el hilo " + n1);
        }
        System.out.println("--- FIN " + t.getId() + " - " + t.getName() + ": TERMINADO ---");
    }
    private boolean esPrimo(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
