package handler;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

import ui.FrameVentanaPrincipal;
import ui.PanelConsorcio;
import ui.PanelConsorcioAlta;

public class Handler {

	private FrameVentanaPrincipal vp;
	
	public Handler(){
		vp = new FrameVentanaPrincipal();
	}
	
	public static void test(){
		
		JFrame j = new JFrame("Administración de Consorcios");
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		j.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuAdmin = new JMenu("Administración");
		menuBar.add(menuAdmin);
		
		JMenuItem menuItemConsorcio = new JMenuItem("Consorcios");
		
		menuAdmin.add(menuItemConsorcio);
		
		j.setJMenuBar(menuBar);
		
		JPanel panel = new JPanel(new BorderLayout());
		
		Label bienvenido = new Label("Bienvenido.");
		bienvenido.setAlignment(Label.CENTER);
		
		panel.add(bienvenido, BorderLayout.CENTER);
		
		j.getContentPane().add(panel);
		
//		j.pack();
		
		j.setLocation(0,0);
		j.setSize(800,600);
		
//		ConsorcioBO cbo = new ConsorcioBO(); 
//		
//		ArrayList<Consorcio> consorcios;
//		
//		try {
//			consorcios = cbo.getAll();
//		} catch (ConsorcioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return;
//		}
//		
//		String[] columnNames = { "Id",
//				"Calle",
//                "Número",
//                "Código Postal",
//                "Provincia",
//                "Localidad"};
//		
//		
//		Object[][] consorciosTable = new Object[6][consorcios.size()];
//		
//		for(int i = 0; i < consorcios.size(); i++){
//			consorciosTable[0][i] = consorcios.get(i).getId();
//			consorciosTable[1][i] = consorcios.get(i).getCalle();
//			consorciosTable[2][i] = consorcios.get(i).getNumero();
//			consorciosTable[3][i] = consorcios.get(i).getCodigoPostal();
//			consorciosTable[4][i] = consorcios.get(i).getProvincia();
//			consorciosTable[5][i] = consorcios.get(i).getLocalidad();
//		}
//		
//		JTable table = new JTable(consorciosTable,columnNames);
//		
//		JPanel jpConsorcios = new JPanel();
//		
//		jpConsorcios.add(table);
		
//		j.getContentPane().add(jpConsorcios);
		
		j.setVisible(true);
		
		
		
	}

	public void listaConsorcio(){
		PanelConsorcio p = new PanelConsorcio();
		
		p.crearVentana();
		
		this.vp.agregar(p);
	}
	
	public void altaConsorcio(){
		PanelConsorcioAlta pAlta = new PanelConsorcioAlta();
		
		pAlta.crearVentana();
		
		this.vp.agregar(pAlta);
	}
	
	public void iniciar(){
		vp.crear();
	}
	
	public void limpiar(){
		vp.setContentPane(new Container());
	}
}
