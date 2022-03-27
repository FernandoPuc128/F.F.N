package ej4_Canvas;
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
public class Main extends Frame {
	Panel p;
	Mundo mundo;
	public Main() {
		p= new Panel();
		mundo = new Mundo();
		p.setLayout(new BorderLayout());
		p.add(mundo,BorderLayout.CENTER);

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

}
