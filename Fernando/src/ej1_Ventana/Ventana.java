package ej1_Ventana;
import static java.awt.Font.PLAIN;
import java.awt.BorderLayout;
import java.awt.Button;
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

public class Ventana extends Frame implements ActionListener {

	Button aceptar;
	TextField txt;
	Panel centro;
	TextArea resultado;
	 
	public Ventana () {
		aceptar= new Button("       Aceptar");
		txt = new TextField ("");
		centro= new Panel();

		resultado= new TextArea("");
		aceptar.addActionListener(this);
		centro.setLayout(new BorderLayout());
		centro.add(txt, BorderLayout.NORTH);
		centro.add(aceptar, BorderLayout.CENTER);
		this.setLayout(new BorderLayout());
		this.add(resultado, BorderLayout.CENTER);
		this.add(centro, BorderLayout.NORTH);		
	    aceptar.setFocusable(false);
		setSize(600, 400); 
        setVisible(true); 
        cerrarVentana();
	}
	
	public static void main(String args[]){
		Ventana v= new Ventana();
	}	

	public void cerrarVentana() {
		addWindowListener((WindowListener) new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

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
		}
	}	
}
