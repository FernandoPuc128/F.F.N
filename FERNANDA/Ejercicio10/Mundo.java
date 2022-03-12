package FERNANDA.Ejercicio10;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
public class Mundo extends Canvas{
    int x,y;
    int w,h;
    public Mundo(){
        x=20;
        y=28;
        w=h=100;
    }
    public void paint (Graphics g){

   
        g.setColor(Color.BLACK);
        g.drawRect(x,y,w,h);
        g.fillOval(x,y,w,h);
        g.setColor(Color.WHITE);
        g.drawString ("Holaaaaaa enfermer!!!!!",x,y + h/2);

    



    }



}