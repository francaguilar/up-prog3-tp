package ui;

import java.awt.Component;

import javax.swing.JFrame;

public class FrameVentanaPrincipal extends JFrame {

	public FrameVentanaPrincipal(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void crear(){
		pack();
		
		setVisible(true);
	}
	
	public void agregar(Component comp){
		getContentPane().add(comp);
		pack();
	}
	
}
