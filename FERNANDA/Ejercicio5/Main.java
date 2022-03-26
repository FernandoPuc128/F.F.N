package FERNANDA.Ejercicio5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;
public class Main extends Frame implements MouseMotionListener, MouseListener, KeyListener{
	Panel p;
	Mundo mundo;
	public Main() {
		p= new Panel();
		mundo = new Mundo();
		p.setLayout(new BorderLayout());
		p.add(mundo,BorderLayout.CENTER);
		
		mundo.addMouseListener(this);
		
		mundo.addMouseMotionListener(this); //Tato como al pael como afuera
		p.addKeyListener(this);    //Estos dos
		
		mundo.addKeyListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.CENTER);
		this.setSize(500,400);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
	}
	
	public static void main(String args[]) {
		Main canvasi= new Main();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click");
		//E dode le dio click 
		mundo.setX(e.getX());
		mundo.setY(e.getY());
		mundo.repaint();//Repintar
		//mundo.setBackground(Color.YELLOW);
		//no usar los m�todos descotiuados 
		//mundo.move(mundo.getX(), mundo.getY());
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Presed");
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Released");
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Entered");
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Exit");
		
	}
	@Override
	public void mouseDragged(MouseEvent e) { //Arrastrar y soltar
		System.out.println("Dragged");
		mundo.setX(e.getX());
		mundo.setY(e.getY());
		mundo.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) { ///dejar presioar
		//if(e.getKeyCode()== KeyEvent.VK_ENTER) {
			//mundo.setY(mundo.getY()+1);
			//mundo.repaint();
		//}
		switch(e.getKeyCode()){
		//A MAYUS Y MIUS
		case 'a':
		case KeyEvent.VK_A:
			mundo.setX(mundo.getX()-1);//A MAYUS Y MIUSdo.g);
			break;
		case 's':
		case KeyEvent.VK_S: 
			mundo.setY(mundo.getY()+1);
			break; 
		case 'd':
		case KeyEvent.VK_D:
			mundo.setX(mundo.getX()+1);
			break; 
		case 'w':
		case KeyEvent.VK_W:
			mundo.setY(mundo.getY()-1);
			break; 
		default:
				break; 
		}
		// TODO Auto-generated method stub
		mundo.repaint();	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
