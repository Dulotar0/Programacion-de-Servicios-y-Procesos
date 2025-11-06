package Ejercicio_5;

import java.io.FileWriter;
import java.io.IOException;


public class Hilo implements Runnable {
    private boolean start = true;
    private final int waitTimer;

    Hilo(int waitTimer){
        this.waitTimer = waitTimer;
    }

    public void stop(){
        this.start = false;
    }

    @Override
    public void run() {
        String writtingText = "!Hola mundo!";
        Thread t = Thread.currentThread();

        try(FileWriter writer = new FileWriter("text.txt",true)){
            while(start){
                t.sleep((waitTimer*1000));
                writer.write(writtingText + '\n');
                writer.flush();
                System.out.println("escrito");
            }
        }
        catch (IOException | InterruptedException e) {
            System.out.println(e);
        }
    }
}
