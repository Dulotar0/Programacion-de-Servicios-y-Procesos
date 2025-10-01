package Ejercicio_1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("Que opcion del ejercicio quieres ver: A(Runnable), B(Abstracta), C(Lambda) o E para salir");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("a")) { //Iterfaz Runable
                int n1 = pedirNumeros();
                int n2 = pedirNumeros();
                int max = Math.max(n1, n2);
                int min = Math.min(n1, n2);
                Thread t = new Thread(new OpcionRunnable(max,min));
                t.start();
            }
            else if (option.equalsIgnoreCase("b")) {
                int n1 = pedirNumeros();
                int n2 = pedirNumeros();
                int max = Math.max(n1, n2);
                int min = Math.min(n1, n2);
                Thread t = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        Random r = new Random();
                        try{
                            for (int i = min+1; i < max; i++){
                                System.out.println(i);
                                int sleepTimer = r.nextInt(999)+1;
                                Thread.sleep(sleepTimer);
                            }
                        } catch (InterruptedException ie) {
                            System.out.println("Se ha interrumpido el hilo");
                        }
                    }
                });
                t.start();
            }
            else if (option.equalsIgnoreCase("c")) {
                int n1 = pedirNumeros();
                int n2 = pedirNumeros();
                int max = Math.max(n1, n2);
                int min = Math.min(n1, n2);
                Thread t = new Thread(()->{
                        Random r = new Random();
                        try{
                            for (int i = min+1; i < max; i++){
                                System.out.println(i);
                                int sleepTimer = r.nextInt(999)+1;
                                Thread.sleep(sleepTimer);
                            }
                        } catch (InterruptedException ie) {
                            System.out.println("Se ha interrumpido el hilo");
                        }

                });
                t.start();
            }
            else if (option.equalsIgnoreCase("e")) {
                System.out.println("Fin del programa");
                exit = true;
            }
            else {
                System.out.println("Opcion no valida");
            }
            System.out.println("El hilo se ha lanzado");
        } while (!exit);
    }
    public static int pedirNumeros(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe un numero:");
        return scanner.nextInt();
    }
}
