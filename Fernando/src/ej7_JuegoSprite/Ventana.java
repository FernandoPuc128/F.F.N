package ej7_JuegoSprite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
public class Ventana extends Canvas{
	
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
			img= ImageIO.read(getClass().getResourceAsStream("/Heno.png"));
			i1= ImageIO.read(getClass().getResourceAsStream("/C1.png"));
			i2= ImageIO.read(getClass().getResourceAsStream("/C2.png"));
			i3= ImageIO.read(getClass().getResourceAsStream("/C3.png"));
		}catch(IOException e) {
			e.getMessage();
		}
		sprite=1;
		x=20;
		y=28;
		w=h=120;
			food_x=(int)(Math.random() * 500);
			food_y =(int) (Math.random() * 400);
			food_s=40;
	
	}

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
		
		
		g.drawImage(img, food_x, food_y, food_s, food_s,null);
		 
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
