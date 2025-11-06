package Ejercicio_8b;

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
            synchronized (lista){
                while(lista.size() <= 5){
                    try {
                        int randomTime = (int) (Math.random() * (1000 - 500 + 1)) + 500;
                        Thread.sleep(randomTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    addToList(new Capsula(variedad, intensidad));
                    System.out.println("Hilo Productor b: Se ha fabricado una cápsula. Total en contenedor: " + lista.size());
                }
                lista.notify();
            }
        }
    }
    public void addToList(Capsula c){
        lista.add(c);
    }
}
