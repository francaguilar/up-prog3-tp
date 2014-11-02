package ui;

import handler.Handler;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


import entidades.Consorcio;
import exceptions.ConsorcioException;

import utils.ModoEdicion;

public class PanelConsorcioEdicion extends JPanel implements ActionListener {

	private ModoEdicion modo;
	private Consorcio consorcio;
	
	//Componentes
	private JPanel panelTextos;
	private JTextField txtCalle;
	private JTextField txtNum;
	private JTextField txtCodPostal;
	private JTextField txtProv;
	private JTextField txtLoc;
	private JButton btnAceptar;
	
	public PanelConsorcioEdicion(){
		
	}
	
	public PanelConsorcioEdicion(ModoEdicion m){
		
		this.modo = m;
	}
	
	public Consorcio getConsorcio() {
		return consorcio;
	}

	public void setConsorcio(Consorcio consorcio) {
		this.consorcio = consorcio;
	}

	public ModoEdicion getModo() {
		return modo;
	}

	public void setModo(ModoEdicion modo) {
		this.modo = modo;
	}

	//Métodos pùblicos
	public void crear(){
		setLayout(new BorderLayout());
		
		panelTextos = new JPanel();
		panelTextos.setLayout(new GridLayout(5,2));
		add(panelTextos, BorderLayout.CENTER);
		
		
		//Calle
		panelTextos.add(new Label("Calle: "));
		txtCalle = new JTextField();
		panelTextos.add(txtCalle);
		
		//Número
		panelTextos.add(new Label("Número: "));
		txtNum = new JTextField();
		panelTextos.add(txtNum);
		
		//Cod. Postal
		panelTextos.add(new Label("Cod. Postal: "));
		txtCodPostal = new JTextField();
		panelTextos.add(txtCodPostal);
		
		//Provincia
		panelTextos.add(new Label("Provincia: "));
		txtProv = new JTextField();
		panelTextos.add(txtProv);
		
		//Localidad
		panelTextos.add(new Label("Localidad: "));
		txtLoc = new JTextField();
		panelTextos.add(txtLoc);
		
		btnAceptar = new JButton("Aceptar");
		JPanel pBtn = new JPanel();
		pBtn.setLayout(new GridLayout(1,3));
		pBtn.add(btnAceptar);
		add(pBtn, BorderLayout.PAGE_END);
		
		btnAceptar.setActionCommand("aceptar");
		
		btnAceptar.addActionListener(this);
		
		if(this.modo == ModoEdicion.MODIFICACION){
			llenarDatos();
		}
	}
	
	private void llenarDatos(){
		if(this.consorcio == null){
			//TODO: excepcion?
			return;
		}
		
		txtCalle.setText(consorcio.getCalle());
		int numero = consorcio.getNumero();
		txtNum.setText(String.valueOf(numero));
		int codigoPostal = consorcio.getCodigoPostal();
		txtCodPostal.setText(String.valueOf(codigoPostal));
		txtProv.setText(consorcio.getProvincia());
		txtLoc.setText(consorcio.getLocalidad());
	}

	private Consorcio getDatos() throws NumberFormatException{
		Consorcio c = new Consorcio();
		
		if(this.consorcio != null){
			c.setId(this.consorcio.getId());
		}
		
		c.setCalle(txtCalle.getText());
		c.setNumero(Integer.parseInt(txtNum.getText()));
		c.setCodigoPostal(Integer.parseInt(txtCodPostal.getText()));
		c.setLocalidad(txtLoc.getText());
		c.setProvincia(txtProv.getText());
		
		return c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if ("aceptar".equals(e.getActionCommand())){
			 
			 boolean bError = false;
			 
			 try {
				 
				 this.consorcio = getDatos();
				 Handler h = new Handler();
				 h.grabarConsorcio(this.consorcio, this.modo);
			
			 } catch (Exception e1) {
				bError = true;
				
				JOptionPane.showMessageDialog(this,"Error al grabar.\n" + e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
			
			if(!bError){
				JOptionPane.showMessageDialog(this,"Guardado.");
				
				this.setVisible(false);	
			}

		 }	
	}
}
