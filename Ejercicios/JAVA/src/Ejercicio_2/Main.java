package Ejercicio_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Escribe el numero de hilos que quieres:");
        int n1 = s.nextInt();
        for (int i = 1; i <= n1; i++){
            Thread t = new Thread(new Hilo(i));
            t.start();
        }
    }
}
