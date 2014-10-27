package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.ConexionException;


public class DBManager {

	private static final String DB_DRIVER = "org.hsqldb.jdbcDriver";
	private static final String DB_URL = "jdbc:hsqldb:file:sql/tpdb;shutdown=true;hsqldb.default_table_type=cached";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";
	
	private static DBManager instance;
	
	private DBManager(){
		
	}
	
	public static DBManager getInstance(){
		if(instance == null)
			instance = new DBManager();
		
		return instance;
	}

	public Connection connect() throws ConexionException{
			Connection c = null;
			try {
				
				Class.forName(DB_DRIVER);
			
			} catch (ClassNotFoundException e) {
				throw new ConexionException("Error al conectar a la base de datos." +"\n"+ e.getMessage() );
			}
			try {
				c =  DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				c.setAutoCommit(false);
			} catch (SQLException e) {
				throw new ConexionException("Error al conectar a la base de datos." +"\n"+ e.getMessage());
			}
			
			return c;
	}
	
	
}
