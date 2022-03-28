package Prac2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Aplicacion extends Frame implements MouseMotionListener, MouseListener{

    Label element1;
    Label element2;
    Label element3;
    Label element4;
    Reestablecer R;
    Componentes C;

    public Aplicacion(){
    
        //Componente 1: Boton
        R = new Reestablecer("Reiniciar");
        R.setBounds(420, 470, 90, 90);
        R.setForeground(Color.WHITE);
        R.addActionListener(evt ->btnRActionPerformed(evt));
        
        //Componente 2 y 3
        C = new Componentes();

        //Componentes Movibles
        element1 = new Label("   1   ");
        element1.setBounds(725, 200, 30, 30);
        element1.setBackground(Color.BLUE);
        element1.addMouseMotionListener(this);
        element1.addMouseListener(this);

        element2 = new Label("   2   ");
        element2.setBounds(775, 200, 30, 30);
        element2.setBackground(Color.BLUE);
        element2.addMouseMotionListener(this);
        element2.addMouseListener(this);

        element3 = new Label("   3   ");
        element3.setBounds(725, 235, 30, 30);
        element3.setBackground(Color.BLUE);
        element3.addMouseMotionListener(this);
        element3.addMouseListener(this);

        element4 = new Label("   4   ");
        element4.setBounds(775, 235, 30, 30);
        element4.setBackground(Color.BLUE);
        element4.addMouseMotionListener(this);
        element4.addMouseListener(this);

        //Elementos
        this.add(element1);
        this.add(element2);
        this.add(element3);
        this.add(element4);
        this.add(R);
        this.add(C);
    
        //Propiedades de la ventana
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(900, 600);
        cerrar();
        
    }
    //Accion del boton R
    private void btnRActionPerformed(ActionEvent e){
		reiniciar();
	}

    //Cerrar Ventana
    public void cerrar() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

    public void mover(MouseEvent g, Label lbl) {
		lbl.setLocation(
		        lbl.getX() + g.getX() - lbl.getWidth() / 2,
		        lbl.getY() + g.getY() - lbl.getHeight() / 2  
		    );
	}

    //Reestablecer pociciones
    public void reiniciar(){
        element1.setBounds(725, 200, 30, 30);
        element2.setBounds(775, 200, 30, 30);
        element3.setBounds(725, 235, 30, 30);
        element4.setBounds(775, 235, 30, 30);
    }

    public void validar(Label lbl) {
		int x = lbl.getX();
		int y = lbl.getY();
		if(x>=50 & x<=350 & y>50 & y<350) {
		}else {
			reiniciar();
		}
		
	}

    public static void main(String[] args) {
        Aplicacion v = new Aplicacion();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == element1) {
			validar(element1);
		}if(e.getSource() == element2) {
			validar(element2);
		}if(e.getSource() == element3) {
			validar(element3);
		}if(e.getSource() == element4) {
			validar(element4);
		}
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == element1) {
			mover(e, element1);
		}
		if(e.getSource() == element2) {
			mover(e, element2);
		}
		if(e.getSource() == element3) {
			mover(e, element3);
		}
		if(e.getSource() == element4) {
			mover(e, element4);
		}
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}

