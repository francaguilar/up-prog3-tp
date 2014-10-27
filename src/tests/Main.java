package tests;

import handler.Handler;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import bo.ConsorcioBO;

import daoImpl.UsuarioDAOImpl;
import entidades.Consorcio;
import entidades.Usuario;
import exceptions.ConsorcioException;
import exceptions.UsuarioException;
import utils.Dentre;
import utils.TableManager;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Crea las tablas e ignora el error si ya existen
		TableManager.crearTablas();
		
//		TestConsorcio();
		
		TestUI();

	}
	
	public static void TestUI(){
		Handler h = new Handler();
		
		h.iniciar();
		
//		h.altaConsorcio();
//		
//		try {
//			System.in.read();
//		} catch (IOException e) {
//			
//		}
//		
//		h.limpiar();
//		
		h.listaConsorcio();
	}
	
	public static void TestConsorcio(){
		ConsorcioBO cbo = new ConsorcioBO();
		
		Consorcio c = new Consorcio();
		
		c.setCalle(Dentre.texto("Calle: "));
		
		c.setNumero(Dentre.entero("Numero: "));
		
		c.setCodigoPostal(Dentre.entero("Cod. Postal: "));
		
		c.setProvincia(Dentre.texto("Provincia: "));
		
		c.setLocalidad(Dentre.texto("Localidad: "));
		
		try {
			cbo.alta(c);
		} catch (ConsorcioException e) {
			
			e.printStackTrace();
		}
		
		try {
			ArrayList<Consorcio> list = cbo.getAll();
			
			for(int i = 0; i < list.size(); i++){
				System.out.println(list.get(i).getId());
				System.out.println(list.get(i).getNombre());
			}
			
		} catch (ConsorcioException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void TestUsuarios(){
		
		UsuarioDAOImpl udao = new UsuarioDAOImpl();
		
		Usuario u = new Usuario();
		
		u.setNombre(Dentre.texto("Ingrese nombre de usuario: "));
		
		u.setPassword(Dentre.texto("Ingrese contraseña: "));
		
		try {
			udao.alta(u);
		} catch (UsuarioException e) {
			
			e.printStackTrace();
		}
		
		try {
			ArrayList<Usuario> list = udao.getAll();
			
			for(int i = 0; i < list.size(); i++){
				System.out.println(list.get(i).getId());
				System.out.println(list.get(i).getNombre());
				System.out.println(list.get(i).getPassword());
			}
			
		} catch (UsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
