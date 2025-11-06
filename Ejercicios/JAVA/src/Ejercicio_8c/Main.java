package Ejercicio_8c;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Capsula> listaCompartida = new ArrayList<>();
        Thread tc = new Thread(new Consumidor(listaCompartida));
        for (int i = 0; i < 4;i++){
            Thread tp = new Thread(new Productor("Spresso", 1,listaCompartida));
            tp.start();
        }
        tc.start();
    }
}
