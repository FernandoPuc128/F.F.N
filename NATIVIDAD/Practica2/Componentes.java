package NATIVIDAD.Practica2;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;


public class Componentes extends Canvas{

    public Componentes() {

	}

	public void paint(Graphics g) {

		//Se dibuja el segundo componente que es el contenedor
		g.setColor(Color.ORANGE);
		g.fillRect(50, 50, 300, 300);
		
		//Se dibuja el tercer componente que es el contenedor temporal
		g.setColor(Color.black);
		g.drawLine(650, 200, 750, 300);
		g.drawLine(650, 200, 750, 100);
		g.drawLine(850, 200, 750, 300);
		g.drawLine(850, 200, 750, 100);	
	}
}