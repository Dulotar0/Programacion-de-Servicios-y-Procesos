package Ejercicio_1;

import java.util.Random;

public class OpcionRunnable implements Runnable{
    private int n1;
    private int n2;

    public OpcionRunnable(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    @Override
    public void run() {
        Random r = new Random();
        try{

            for (int i = n2+1; i < n1; i++){
                System.out.println(i);
                int sleepTimer = r.nextInt(999)+1;
                Thread.sleep(sleepTimer);
            }
        } catch (InterruptedException ie) {
            System.out.println("Se ha interrumpido el hilo");
        }
    }
}
