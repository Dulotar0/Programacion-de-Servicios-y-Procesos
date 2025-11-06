package Ejercicio_10;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Capturadora {
    private String directorio;
    private int numCaptura = 0;

    public Capturadora(){
        this.directorio = "./";
    }
    public Capturadora(String directorio){
        this.directorio = directorio;
    }

    public void RealizaCaptura(){
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        try {
            BufferedImage capture = new Robot().createScreenCapture(screenRect);
            ImageIO.write(capture, "bmp", new File(directorio + "/captura"+ numCaptura +".bmp"));
            numCaptura++;
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}