package Ejercicio_4;

public class Hilo implements Runnable{
    private boolean ejecutar = true;
    public int randomNumber;

    Hilo(int randomNumber){
        this.randomNumber = randomNumber;
    }

    public void stop(){
        ejecutar = false;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        int iterator = 0;
        try{
            for (iterator = 1; iterator < 20 && ejecutar; iterator++){
                t.sleep(1000);
                if(iterator<=5){
                    System.out.println(iterator);
                }
            }
        }
        catch (InterruptedException ie){
            System.out.println(ie);
        }
        if (iterator == randomNumber){
            System.out.println("¡Lo has conseguido!");
        }
        else{
            System.out.println("Vuelve a intentarlo, has detenido el contador en " + iterator);
        }
    }
}

