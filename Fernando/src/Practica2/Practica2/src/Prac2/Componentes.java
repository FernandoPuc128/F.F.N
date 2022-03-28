package Prac2;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;


public class Componentes extends Canvas{

    public Componentes() {

	}
	public void paint(Graphics g) {

		//Componente 2 Contenedor 1
		g.setColor(Color.YELLOW);
		g.fillRect(50, 50, 300, 300);
		
		//Componente 3 Contenedor temporal
		g.setColor(Color.BLACK);
		g.drawLine(650, 200, 750, 300);
		g.drawLine(650, 200, 750, 100);
		g.drawLine(850, 200, 750, 300);
		g.drawLine(850, 200, 750, 100);	
	}
}