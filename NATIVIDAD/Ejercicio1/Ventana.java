package NATIVIDAD.Ejercicio1;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.*;


public class Ventana extends Frame implements ActionListener {
	//boton 
	Button aceptar;
	//Text field
	TextField txt;
	//Panel
	Panel centro;
	//Constructor 
	TextArea txt1;
	Button igual;
	Button cerrar;
	
	
	public Ventana () {
		//Instanciar
		aceptar= new Button("Aceptar");
		aceptar.addActionListener(this);
		txt = new TextField ("");
		centro= new Panel();
		txt1=new TextArea("");
		igual= new Button(" = ");
		cerrar=new Button("Cerrar");
		
		aceptar.addActionListener(this);
		  igual.addActionListener(this);
			
		  centro.setLayout(new BorderLayout());
		  
		  centro.add(txt, BorderLayout.NORTH);
		  centro.add(aceptar, BorderLayout.CENTER);
		  centro.add(igual, BorderLayout.EAST);
		  
		  
		  this.setLayout(new BorderLayout());
		  
		  
		  this.add(centro, BorderLayout.NORTH);
		  this.add(txt1, BorderLayout.CENTER);
		    
		  setSize(800, 800); 
		        setVisible(true); 
		       
		        cerrar();
		
		
	}
	
	public static void main(String args[]){
		Ventana v= new Ventana();
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		   String t= txt.getText();
		   if (e.getSource() == aceptar) {
			   txt1.append(t + "\n");
		   }else{
		    String Texto= txt1.getText();
		    Texto = Texto.trim();
		    String[] Cadena= Texto.split("\n");
		    int c= Cadena.length;
		    int aux, Sum=0;
		    for(int i=0; i<c; i++) {
		     aux = Integer.parseInt(Cadena[i]);
		     Sum += aux;
		    }
		    txt1.append("Total suma " + Sum);
		   }
		  
		 }
	public void cerrar() {
		  addWindowListener((WindowListener) new WindowAdapter() {
		   public void windowClosing(WindowEvent e) {
		    System.exit(0);
		   }
        });
	}
}