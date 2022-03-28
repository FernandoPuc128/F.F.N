package NATIVIDAD.Ejercicio6;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
public class Ventana extends Canvas{
	//Extender de la clase canvas
	//Atributos 
	//private int x2, y2, w2, h2;
	private int x, y, w, h;
	
	int food_x;
	int food_y;
	int food_s;
	int sprite;
	//Constructor
	public Ventana() {
		sprite=1;
		x=20;
		y=28;
		w=h=60;
			food_x=(int)(Math.random() * 500);//this.getWidth());
			food_y =(int) (Math.random() * 400);//this.getHeight());
			food_s=20;
		//numGe();
		//Calcular un  rea
		//se le llama colisi n
	}
	//M todo para pintar
	public void paint(Graphics g) {
		colisio();
		g.setColor(Color.ORANGE);
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
		//g.drawRect(x, y, w, h);
		
	
		g.setColor(Color.YELLOW);
		g.fillOval(food_x, food_y,food_s,food_s);
		//g.setColor(Color.RED);
		//g.fillRect(x2,y2,20,20);	 
	}
	public void colisio() {
		//Evaluar todo el cuadro, del area de uestro diujo pricipal co la comida
		
		if(food_x>x && 
		   food_x < (x+w) &&
		   food_y> y &&
		   food_y <(y+ h))
		{
			food_x=(int)(Math.random() * 500);//this.getWidth());
			food_y =(int) (Math.random() * 400);//this.getHeight());
			food_s=20;
		}
	}

	//M todos SET - GET
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
	
	//Craar metodo set para sprite
	public void setSprite() {
		sprite ++;
		if(sprite>3){
			sprite=1;
		}
	}
}
