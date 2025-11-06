package Ejercicio_9;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        boolean exit = false;
        do{
            System.out.println("Cuantos dados hay que tirar?");
            int numDados = sc.nextInt();

            int[] numResults = new int[numDados];

            for (int o = 0; o < numDados; o++){

                System.out.println("Que resultado tiene que tener el dado " + (o+1) + "?");
                numResults[o] = sc.nextInt();
            }

            Lanzador l = new Lanzador(numResults,numDados);
            executor.execute(l);

            System.out.println("Quieres jugar otra partida a la vez?(s/n)");
            String s1 = sc.nextLine();
            if (s1.toLowerCase().equals('n')) {
                exit = !exit;
            }

        }while(true);
        //executor.shutdown();   no se porque esto me da error
    }
}
