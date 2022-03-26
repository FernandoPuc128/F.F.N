package FERNANDA.Ejercicio5;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Mundo extends Canvas {
	
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



