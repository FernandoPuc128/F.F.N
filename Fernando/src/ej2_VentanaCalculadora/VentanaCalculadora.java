package ej2_VentanaCalculadora;
import static java.awt.Font.PLAIN;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class VentanaCalculadora extends Frame implements ActionListener{

	Button aceptar;
	Button igual;
	Button vaciar;
	TextField txt;
	Panel centro;
	TextArea resultado;
	 
	public VentanaCalculadora(){

		aceptar= new Button("       Aceptar");
		txt = new TextField ("");
		centro= new Panel();
		resultado= new TextArea("");
		igual= new Button(" = ");
		vaciar= new Button("Vaciar ");
		aceptar.addActionListener(this);
		igual.addActionListener(this);
		vaciar.addActionListener(this);

		centro.setLayout(new BorderLayout());
		centro.add(txt, BorderLayout.NORTH);
		centro.add(aceptar, BorderLayout.CENTER);
		centro.add(igual, BorderLayout.EAST);
		centro.add(vaciar, BorderLayout.AFTER_LAST_LINE);

		this.setLayout(new BorderLayout());
		this.add(centro, BorderLayout.NORTH);
		this.add(resultado, BorderLayout.CENTER);

		resultado.setBackground(Color.WHITE);
		igual.setFocusable(false);
	    igual.setBackground(Color.DARK_GRAY);
	    igual.setForeground(Color.WHITE); 
	    aceptar.setFocusable(false);

	    aceptar.setBackground(Color.YELLOW);
	    aceptar.setForeground(Color.BLACK);
	   
	    vaciar.setFocusable(false);
	    vaciar.setForeground(Color.BLACK);
	    
	    txt.setBackground(Color.RED); 
	    txt.setForeground(Color.WHITE);
	   
		setSize(600, 400); 
        setVisible(true);
       
        cerrarVentana(); 
       
	}
	
	public static void main(String args[]){
		VentanaCalculadora v= new VentanaCalculadora();
	}	


	public void cerrarVentana() {
		addWindowListener((WindowListener) new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	//Aceptar numeros
	private void num(TextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void KeyTyped (KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c) && c!='.') {
					e.consume();
				}
				if(c== '.' && txt.getText().contains(".")) {
					e.consume();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	 	String c= txt.getText();
	 	if (e.getSource() == aceptar) {
			
			 resultado.append(c + "\n");
		
	 	}else if (e.getSource() == igual){
			 String Texto= resultado.getText();
			 Texto = Texto.trim();
		
			 String[] Arreglo= Texto.split("\n");
			 
			
			 int n=  Arreglo.length;
			 int aux, Suma=0;
			 for(int i=0; i<n; i++) {
		
				 aux = Integer.parseInt(Arreglo[i]);
				 Suma += aux;
			 }
			
			 resultado.append("\n La suma total es de " + Suma);
			
		 }else {
			
			 resultado.setText("");
	 }
	}	
}
