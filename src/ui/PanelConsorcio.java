package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Consorcio;

public class PanelConsorcio extends JPanel {

	private JTable tabla;
	
	public PanelConsorcio(){
		
	}
	
	public void crearTabla(ArrayList<Consorcio> consorcios){
		
		String[] columnNames = { "Id",
				"Calle",
                "Número",
                "Código Postal",
                "Provincia",
                "Localidad"};
		
		
		Object[][] consorciosTable = new Object[6][consorcios.size()];
		
		for(int i = 0; i < consorcios.size(); i++){
			consorciosTable[0][i] = consorcios.get(i).getId();
			consorciosTable[1][i] = consorcios.get(i).getCalle();
			consorciosTable[2][i] = consorcios.get(i).getNumero();
			consorciosTable[3][i] = consorcios.get(i).getCodigoPostal();
			consorciosTable[4][i] = consorcios.get(i).getProvincia();
			consorciosTable[5][i] = consorcios.get(i).getLocalidad();
		}
		
		tabla = new JTable(consorciosTable,columnNames);
	}
	
	public void crearVentana(){
		setLayout(new BorderLayout());
		
		add(tabla);
	}
	
}
