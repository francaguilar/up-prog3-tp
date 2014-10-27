package utils;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.ConexionException;

public class TableManager {

	public static void crearTablas(){
		crearTablaUsuarios();
		crearTablaConsorcios();
	}
	
	public static void crearTablaUsuarios() {

		
		Connection c;
		
		try {
			c = DBManager.getInstance().connect();
		} catch (ConexionException e2) {

			return;
		}
		
		String sql = "CREATE TABLE usuarios ( id INTEGER IDENTITY, nombre VARCHAR(100), password VARCHAR(10))";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
	public static void eliminarTablaUsuarios() {

		Connection c;
		try {
			c = DBManager.getInstance().connect();
		} catch (ConexionException e2) {
			return;
		}
		
		String sql = "DROP TABLE usuarios";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

	public static void crearTablaConsorcios() {

		
		Connection c;
		
		try {
			c = DBManager.getInstance().connect();
		} catch (ConexionException e2) {

			return;
		}
		
		String sql = "CREATE TABLE consorcios ( id INTEGER IDENTITY, calle VARCHAR(100), numero INTEGER, codigoPostal INTEGER, provincia VARCHAR(50), localidad VARCHAR(50) )";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
}
