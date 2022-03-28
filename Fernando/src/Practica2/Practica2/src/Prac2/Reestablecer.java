package Prac2;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Graphics;

public class Reestablecer extends JButton{

	public Reestablecer(String nombre) {
		super(nombre);
		setContentAreaFilled(false);
	}
	
@Override
protected void paintComponent(Graphics g) {
	g.setColor(Color.GREEN);
	g.fillOval(0, 0, getSize().width-1, getSize().height-1);
	super.paintComponent(g);
}
@Override
protected void paintBorder(Graphics g) {
	// TODO Auto-generated method stub
	g.setColor(Color.RED);
	g.drawOval(0, 0, getSize().width-1, getSize().height-1);
}

}
