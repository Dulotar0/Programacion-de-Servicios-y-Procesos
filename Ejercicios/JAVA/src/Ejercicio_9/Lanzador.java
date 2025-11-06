package Ejercicio_9;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Lanzador implements Runnable {

    int[] numResultados;
    int numDados;


    public Lanzador(int[] numResultados, int numDados){
        this.numDados = numDados;
        this.numResultados = numResultados;

    }

    @Override
    public void run() {
        Random r = new Random();
        int[] tirada = new int[numDados];
        boolean coincide = true;

        do {
            coincide = true;
            for (int i = 0; i < numDados; i++) {
                tirada[i] = r.nextInt(1, 7);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (tirada[i] != numResultados[i]) {
                    coincide = false;
                }
            }

        } while (!coincide);
        System.out.println("Hilo " + currentThread().threadId() + " ha conseguido la combinación deseada!");
    }
}
