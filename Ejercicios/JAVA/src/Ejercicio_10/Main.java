package Ejercicio_10;

import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Cada cuanto quieres las capturas?");
        int seconds = s.nextInt();
        s.nextLine();


        System.out.println("Como quieres que se llame la carpeta?");
        String folder = s.nextLine();
        Capturadora c = new Capturadora(folder);

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.scheduleAtFixedRate(c::RealizaCaptura,0,seconds, TimeUnit.SECONDS);
    }
}
