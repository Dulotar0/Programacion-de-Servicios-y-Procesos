package Ejercicio_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Indica cada cuantos segundos debe escribir el mensaje: ");
        int waitTimer = s.nextInt();
        s.nextLine();
        Hilo h = new Hilo(waitTimer);
        Thread t = new Thread(h);
        t.start();
        System.out.println("Pulsa enter para parar el hilo: ");
        s.nextLine();
        h.stop();
    }
}
