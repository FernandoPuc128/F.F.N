package FERNANDA.Ejercicio2;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class VentanaConLayout extends Frame implements ActionListener  {
 Button btn;
 Panel  P1;
Panel P2;
Panel P3;
TextArea txt;

Public VentanaConLayout(){
    btn = new Button("");
    P1 = new Panel();
    P2 = new Panel();
    P3 = new Panel();
    txt = new TextArea("");
    this.setLayout(new BorderLayout());

    P1.setLayout(new GridLayout(3,2));
    for


    P2.setLayout(new FlowLayout());
    P3.setLayout(new CardLayout());
    this.add(P1,BorderLayout.NORTH);
    this.add(P2,BorderLayout.SOUTH);
    this.add(P3,BorderLayout.CENTER);
    this.add(btn,BorderLayout.WEST);
    this.add(P4,BorderLayout.EAST);
    bnt1.setse



    



}
public static void main(String args()){
    VentanaConLayouts vcl = new VentanaConLayout();

}
Public void actionPerformed ActionEvent e ){
    if (e.getSource()==btn)System.exit(0);
    else{
        System
    }
}

}
