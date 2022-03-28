package NATIVIDAD.Ejercicio7;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
public class Ventana extends Canvas{
	//Extender de la clase canvas
	//Atributos 
	//private int x2, y2, w2, h2;
	private BufferedImage img;
	private BufferedImage i1,i2,i3;
	private int x, y, w, h;
	int food_x;
	int food_y;
	int food_s;
	int sprite;
	//Constructor
	public Ventana() {
		try {
			img= ImageIO.read(getClass().getResourceAsStream("/Rabb.png"));
			i1= ImageIO.read(getClass().getResourceAsStream("/Spide1.png"));
			i2= ImageIO.read(getClass().getResourceAsStream("/Spide2.png"));
			i3= ImageIO.read(getClass().getResourceAsStream("/Spide3.png"));
		}catch(IOException e) {
			e.getMessage();
		}
		sprite=1;
		x=20;
		y=28;
		w=h=120;
			food_x=(int)(Math.random() * 500);//this.getWidth());
			food_y =(int) (Math.random() * 400);//this.getHeight());
			food_s=40;
		//numGe();
		//Calcular un �rea
		//se le llama colisi�n
	}
	//M�todo para pintar
	public void paint(Graphics g) {
		colisio();
		switch(sprite) {
		case  1:
			g.drawImage(i1, x, y,w,h, null);			
			break;
		case 2:
			g.drawImage(i2, x, y,w,h, null);
			break;
		case 3:
			g.drawImage(i3, x, y,w,h, null);
			break;
		}
		
		//Comida 
		g.drawImage(img, food_x, food_y, food_s, food_s,null);
		//g.fillOval(food_x, food_y,food_s,food_s);
		//g.setColor(Color.BLUE);
		//g.fillRect(x2,y2,20,20);	 
	}
	public void colisio() {
		//Evaluar todo el cuadro, del area de uestro diujo pricipal co la comida
		//La posicio de x de la pricipal es meor que la posici� de la secudaria m�s el acho 
		//La posici� de y es mayor que la posic� de y de la secudaria 
		//Aimaci� diujar o la m�s f�cil es utilizar u img
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

	//M�todos SET - GET
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
