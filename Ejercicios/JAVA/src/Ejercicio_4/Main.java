package Ejercicio_4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Random r = new Random();
        int randomNumber = r.nextInt(10,21);
        Hilo h = new Hilo(randomNumber);
        Thread t = new Thread(h);
        Scanner sc = new Scanner(System.in);
        t.start();
        System.out.println("Pulsa enter cuando creas que el numero esta en " + randomNumber);
        sc.nextLine();
        h.stop();

    }
}
