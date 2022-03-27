package ej6_JuegoC;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
public class Ventana extends Canvas{
	
	private int x, y, w, h;
	
	int food_x;
	int food_y;
	int food_s;
	int sprite;
	
	public Ventana() {
		sprite=1;
		x=20;
		y=28;
		w=h=60;
			food_x=(int)(Math.random() * 500);
			food_y =(int) (Math.random() * 400);
			food_s=20;
		
	}

	public void paint(Graphics g) {
		colisio();
		g.setColor(Color.YELLOW);
		switch(sprite) {
		case  1:
			g.fillOval(x, y, w, h);
			break;
		case 2:

			g.fillArc(x, y, w, h, 0, 270);
			break;
		case 3:
			g.fillArc(x, y, w, h, 0, 200);
			break;
		}
	
		
		g.setColor(Color.RED);
		g.fillOval(food_x, food_y,food_s,food_s);
		 
	}
	public void colisio() {
		
		if(food_x>x && 
		   food_x < (x+w) &&
		   food_y> y &&
		   food_y <(y+ h))
		{
			food_x=(int)(Math.random() * 500);
			food_y =(int) (Math.random() * 400);
			food_s=20;
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
	
	public void setSprite() {
		sprite ++;
		if(sprite>3){
			sprite=1;
		}
	}
}
