package ui;

import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelConsorcioAlta extends JPanel {

	public PanelConsorcioAlta(){
		
	}
	
	public void crearVentana(){
		setLayout(new GridLayout(5,2));
		
		//Calle
		add(new Label("Calle: "));
		JTextField txtCalle = new JTextField();
		add(txtCalle);
		
		//Número
		add(new Label("Número: "));
		JTextField txtNum = new JTextField();
		add(txtNum);
		
		//Cod. Postal
		add(new Label("Cod. Postal: "));
		JTextField txtCodPostal = new JTextField();
		add(txtCodPostal);
		
		//Provincia
		add(new Label("Provincia: "));
		JTextField txtProv = new JTextField();
		add(txtProv);
		
		//Localidad
		add(new Label("Localidad: "));
		JTextField txtLoc = new JTextField();
		add(txtLoc);
		
	}
	
}
