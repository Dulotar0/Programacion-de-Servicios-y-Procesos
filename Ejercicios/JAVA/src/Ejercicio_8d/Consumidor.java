package Ejercicio_8d;

import java.util.List;

public class Consumidor implements Runnable{
    private final List<Capsula> lista;

    public Consumidor(List<Capsula> lista) {
        this.lista = lista;
    }


    @Override
    public void run() {
        while(true) {
            synchronized(lista) {
                while (lista.size() < 6) { // espera hasta tener 6 cápsulas
                    try {
                        lista.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Hilo Consumidor: Creando caja con 6 cápsulas");
                for (int i = 0; i < 6; i++) {
                    lista.removeFirst();
                }
                lista.notify();
            }
            try {
                int randomTime = (int) (Math.random() * (3000 - 1000 + 1)) + 1000;
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hilo Consumidor: Caja creada");

        }
    }
}
