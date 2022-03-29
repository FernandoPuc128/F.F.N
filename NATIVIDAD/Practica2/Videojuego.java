package NATIVIDAD.Practica2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Videojuego extends Frame implements MouseMotionListener, MouseListener{

    Label elem1;
    Label elem2;
    Label elem3;
    Label elem4;
    Reiniciar R;
    Componentes C;

    public Videojuego(){
        //Se crea el primer componente a lo que es el boton que necesitaremos mas adelante
        R = new Reiniciar("Reiniciar");
        R.setBounds(420, 470, 90, 90);
        R.setForeground(Color.BLACK);
        R.addActionListener(evt ->btnRActionPerformed(evt));
        
        //Se crean los otros componentes que en este caso seria el dos y tres
        C = new Componentes();

        //Se crean los componentes arrastables
        elem1 = new Label("   1   ");
        elem1.setBounds(775, 200, 30, 30);
        elem1.setBackground(Color.RED);
        elem1.addMouseMotionListener(this);
        elem1.addMouseListener(this);

        elem2 = new Label("   2   ");
        elem2.setBounds(775, 200, 30, 30);
        elem2.setBackground(Color.RED);
        elem2.addMouseMotionListener(this);
        elem2.addMouseListener(this);

        elem3 = new Label("   3   ");
        elem3.setBounds(725, 235, 30, 30);
        elem3.setBackground(Color.RED);
        elem3.addMouseMotionListener(this);
        elem3.addMouseListener(this);

        elem4 = new Label("   4   ");
        elem4.setBounds(775, 235, 30, 30);
        elem4.setBackground(Color.RED);
        elem4.addMouseMotionListener(this);
        elem4.addMouseListener(this);

        //Agregamos a la ventana cada uno de los elementos del programa
        this.add(elem1);
        this.add(elem2);
        this.add(elem3);
        this.add(elem4);
        this.add(R);
        this.add(C);
    
        //Propiedades de la ventana
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(900, 600);
        cerrar();

        
    }

    //Se genera la accion del boton R
    private void btnRActionPerformed(ActionEvent e){
		reiniciar();
	}

    //Metodo para cerrar la ventana
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

    //Se crea metodo para Reiniciar las posiciones
    public void reiniciar(){
        elem1.setBounds(725, 200, 30, 30);
        elem2.setBounds(775, 200, 30, 30);
        elem3.setBounds(725, 235, 30, 30);
        elem4.setBounds(775, 235, 30, 30);
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
        Videojuego v = new Videojuego();
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
        if(e.getSource() == elem1) {
			validar(elem1);
		}if(e.getSource() == elem2) {
			validar(elem2);
		}if(e.getSource() == elem3) {
			validar(elem3);
		}if(e.getSource() == elem4) {
			validar(elem4);
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
        if(e.getSource() == elem1) {
			mover(e, elem1);
		}
		if(e.getSource() == elem2) {
			mover(e, elem2);
		}
		if(e.getSource() == elem3) {
			mover(e, elem3);
		}
		if(e.getSource() == elem4) {
			mover(e, elem4);
		}
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
