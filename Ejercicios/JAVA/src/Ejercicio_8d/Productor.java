package Ejercicio_8d;

import java.util.List;

public class Productor implements Runnable{

    private final List<Capsula> lista;
    private String variedad;
    private int intensidad;

    public Productor(String variedad, int intensidad, List<Capsula> lista){
        this.variedad = variedad;
        this.intensidad = intensidad;
        this.lista = lista;
    }

    @Override
    public void run() {
        while(true){
            while(lista.size() < 100){
                try{
                    int randomTime = (int) (Math.random() * (400 - 500 + 1)) + 500;
                    Thread.sleep(randomTime);
                    addToList(new Capsula(variedad, intensidad));
                    System.out.println("Hilo Productor " + Thread.currentThread().threadId() + " c: Se ha fabricado una cápsula. Total en contenedor: " + lista.size());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lista){
                    lista.notify();
                }
            }
        }
    }
    public void addToList(Capsula c){
        lista.add(c);
    }
}
