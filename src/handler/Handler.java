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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import entidades.Consorcio;
import exceptions.ConsorcioException;

import bo.ConsorcioBO;

import ui.FrameVentanaPrincipal;
import ui.PanelConsorcio;
import ui.PanelConsorcioEdicion;
import utils.ModoEdicion;

public class Handler {

	private FrameVentanaPrincipal vp;
	
	public Handler(){
		vp = new FrameVentanaPrincipal();
	}

	public void listaConsorcio(){
		PanelConsorcio p = new PanelConsorcio();
		
		ConsorcioBO cbo = new ConsorcioBO();
		
		ArrayList<Consorcio> consorcios;
		
		try {
			consorcios = cbo.getAll();
		} catch (ConsorcioException e) {
			
			e.printStackTrace();
			return;
		}
		
		p.crear();
		
		p.insertarTabla(consorcios);
		
		this.vp.agregar(p);
	}
	
	public void altaConsorcio(){
		PanelConsorcioEdicion pAlta = new PanelConsorcioEdicion(ModoEdicion.ALTA);
		
		pAlta.crear();
		
		this.vp.agregar(pAlta);
	}
	
	public void edicionConsorcio(int id){
		PanelConsorcioEdicion pMod = new PanelConsorcioEdicion(ModoEdicion.MODIFICACION);
		
		ConsorcioBO cbo = new ConsorcioBO();
		
		try {
			pMod.setConsorcio(cbo.get(id));
		} catch (ConsorcioException e) {
			
			e.printStackTrace();
		}
		
		pMod.crear();
		
		this.vp.agregar(pMod);
	}

	public void grabarConsorcio(Consorcio c, ModoEdicion m) throws ConsorcioException{
		ConsorcioBO cbo = new ConsorcioBO();

		if(m == ModoEdicion.ALTA){
			cbo.alta(c);
		}
		else{
			cbo.modificacion(c);
		}
	}
	
	public void iniciar(){
		vp.crear();
	}
	
	public void limpiar(){
		vp.setContentPane(new Container());
	}
}
