package Ejercicio_2;

import java.util.Random;

public class Hilo implements Runnable {
    private int n1;
    public Hilo(int n1){
        this.n1 = n1;
    }
    @Override
    public void run() {
        try {
            Random r = new Random();
            int randomNumber = r.nextInt(100);
            System.out.println("Hilo" + n1 + ": Mostrando primos hasta el numero " + randomNumber);
            for (int i = 0; i < randomNumber; i++){
                int sleepTimer = r.nextInt(500,1000);
                if (esPrimo(i)) {
                    Thread.sleep(sleepTimer);
                    System.out.println("Hilo " + n1 + ": " + i);
                }
            }
        }catch (InterruptedException ie){
            System.out.println("Fallo en el hilo " + n1);
        }

    }
    private static boolean esPrimo(int num) {
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
