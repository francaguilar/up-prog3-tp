package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Consorcio;

public class PanelConsorcio extends JPanel implements ActionListener {

	private JTable tabla;
	
	public PanelConsorcio(){
		
	}
	
	public void insertarTabla(ArrayList<Consorcio> consorcios){
		
		String[] columnNames = { "Id",
				"Calle",
                "Número",
                "Código Postal",
                "Provincia",
                "Localidad"};
		
		
		Object[][] consorciosTable = new Object[consorcios.size()][6];
		
		for(int i = 0; i < consorcios.size(); i++){
			consorciosTable[i][0] = consorcios.get(i).getId();
			consorciosTable[i][1] = consorcios.get(i).getCalle();
			consorciosTable[i][2] = consorcios.get(i).getNumero();
			consorciosTable[i][3] = consorcios.get(i).getCodigoPostal();
			consorciosTable[i][4] = consorcios.get(i).getProvincia();
			consorciosTable[i][5] = consorcios.get(i).getLocalidad();
		}
		
		tabla = new JTable(consorciosTable,columnNames);
		
		add(tabla, BorderLayout.CENTER);
	}
	
	public void crear(){
		setLayout(new BorderLayout());
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setActionCommand("editar");
		btnEditar.addActionListener(this);
		JPanel p = new JPanel(new GridLayout(1,3));
		p.add(btnEditar);
		
		add(p,BorderLayout.PAGE_END);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int indRow = tabla.getSelectedRow();
		 
		Object id = tabla.getModel().getValueAt(indRow, 0);
		
	}
	
}
