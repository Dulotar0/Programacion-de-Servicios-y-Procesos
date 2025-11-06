package Ejercicio_8b;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Capsula> listaCompartida = new ArrayList<>();
        Thread tp = new Thread(new Productor("Spresso", 1,listaCompartida));
        Thread tc = new Thread(new Consumidor(listaCompartida));

        tp.start();
        tc.start();
    }
}
