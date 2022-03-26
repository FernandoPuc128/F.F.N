package FERNANDA.Ejercicio2;
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

public class VentanaMejorada extends Frame implements ActionListener {
	//btn 
	Button aceptar;
	Button igual;
	Button vaciar;
	//Text field
	TextField txt;
	
	//Panel
	Panel centro;
	
	//TextArea
	TextArea resultado;
	
	//Constructor 
	public VentanaMejorada () {
		//num(txt);
		//Instanciar
		aceptar= new Button("       Aceptar");
		txt = new TextField ("");
		centro= new Panel();
		
		resultado= new TextArea("");
		
		//Instanciar botones
		igual= new Button(" = ");
		vaciar= new Button("Vaciar ");
		
		//AQUI MODIFIQUE
		aceptar.addActionListener(this);
		igual.addActionListener(this);
		vaciar.addActionListener(this);
		
		centro.setLayout(new BorderLayout());
		
		//Posicion del Panel de texto
		centro.add(txt, BorderLayout.NORTH);
		//Posiones de los botones
		centro.add(aceptar, BorderLayout.CENTER);
		centro.add(igual, BorderLayout.EAST);
		centro.add(vaciar, BorderLayout.AFTER_LAST_LINE);
		
		
		this.setLayout(new BorderLayout());
		
		//Posiones de los paneles 
		this.add(centro, BorderLayout.NORTH);
		this.add(resultado, BorderLayout.CENTER);
		
		//Dise�o del TextArea
		resultado.setBackground(Color.ORANGE);
		
		//Dise�o del boton igual
		igual.setFocusable(false);
	    igual.setBackground(Color.DARK_GRAY);//Color de fondo
	    igual.setForeground(Color.WHITE); //Color de la letra
	  
	    //Dise�o del boton aceptar 
	    aceptar.setFocusable(false);
	    aceptar.setBackground(Color.GREEN); //Color de fondo
	    aceptar.setForeground(Color.BLACK); //Color de la letra
	   
	   //Dise�o del boton vaciar 
	    vaciar.setFocusable(false);
	    vaciar.setForeground(Color.BLACK);
	    
	    //Dise�o del textField
	    txt.setBackground(Color.BLUE); //Color del fondo
	    txt.setForeground(Color.WHITE);//Color de la letra
	    
	   
		setSize(600, 400); //Dimensiones del JFrame
        setVisible(true); //Mostrar JFrame
       
        cerrarVentana(); //M�todo cerrar ventana
       
	}
	
	public static void main(String args[]){
		VentanaMejorada v= new VentanaMejorada();
	}	

	//M�todo 
	//Cerrar la ventana 
	public void cerrarVentana() {
		addWindowListener((WindowListener) new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	//Aceptar solo num
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
			 //System.out.println(c );
			 resultado.append(c + "\n");
			 //System.out.println("Button aceptar");
			 //System.exit(0);
	 	}else if (e.getSource() == igual){
			 String Texto= resultado.getText();
			 Texto = Texto.trim();
			 //Asignar cada num en una posicion del arreglo
			 String[] Arreglo= Texto.split("\n");
			 
			 //Recorrer el arreglo y obtener el total de numeros
			 int n=  Arreglo.length;
			 int aux, Suma=0;
			 for(int i=0; i<n; i++) {
				 //Tomar el numero y conv a entero
				 aux = Integer.parseInt(Arreglo[i]);
				 Suma += aux;
			 }
			 //Mostrar en el cuadro
			 resultado.append("\n La suma total es de " + Suma);
			 //System.out.println("Button igual");
		 }else {
			
			 //Resetear el textArea y vaciarlo 
			 resultado.setText("");
	 }
	}	
}
