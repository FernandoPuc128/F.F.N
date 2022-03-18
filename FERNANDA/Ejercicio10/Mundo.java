package FERNANDA.Ejercicio10;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
public class Mundo extends Canvas{
    int x,y;
    int w,h;

    int sprite;

    int food_x;
    int food_y;
    int food_s;

    public Mundo(){
        sprite =1;
        x=20;
        y=28;
        w=h=100;

        food_x = (int)(Math.random()*this.getWidth());
        food_y = (int)(Math.random()*this.getHeight());
       
        food_s = 20;

    }
    public void paint (Graphics g){
        colision();

   
        g.setColor(Color.BLACK);
        //g.drawRect(x,y,w,h);
        switch(sprite){
            case 1:
            g.fillOval(x,y,w,h);
            break;
            case 2:
            g.fillArc(x, y, w,h,0,270);
            break;
            case 3:
            g.fillArc(x, y, w,h,0,200);
            break;
        }
        g.fillOval(x,y,w,h);
        g.setColor(Color.WHITE);
        g.drawString ("Holaaaaaa enfermer!!!!!",x,y + h/2);
        g.setColor(Color.YELLOW);
        g.fillOval(food_x,food_y,food_s,food_s);

    



    }
    private void colision() {
        if( food_x > x && food_x < (x+w) && food_y > y && food_y < (y+h))
        {
        
            food_x=(int)(Math.random()*this.getWidth());
            food_y =(int)(Math.random()*this.getHeight());
        }
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void getSprite(){
        sprite++;
        if (sprite>3)
    }



}