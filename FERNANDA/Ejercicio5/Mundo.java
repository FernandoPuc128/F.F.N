package FERNANDA.Ejercicio5;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Mundo extends Canvas {
	//Pintar algo 
	//Canvas es un lienzo, pitar, diujar o rayar
	//Sore escriir el m�todo 
	//public void paint(Graphics g) {
		//Graphis es como ua pluma, y co el Cavas diujamos
		//g.setColor(Color.BLACK);//Poer color a la pluma
		//g.drawString("Hola" ,20 , 20);//Hacer el diujo, dram solo lieas y el fild solo cotor
		//Estacio en x y y
		//Detro de u panel
	int x,y;
	int w,h;
	public Mundo() {
		x=20;
		y=28;
		w=h=100;
	}
	public void paint(Graphics g) {
			g.setColor(Color.black);
			g.drawRect(x, y, w, h);
			g.fillOval(x, y, w, h);
			g.setColor(Color.white);
			g.drawString("Hola mundo", x,(y+h/2));
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
}



