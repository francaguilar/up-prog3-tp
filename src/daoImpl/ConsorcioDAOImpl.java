package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBManager;

import dao.ConsorcioDAO;
import entidades.Consorcio;
import exceptions.ConexionException;
import exceptions.ConsorcioException;


public class ConsorcioDAOImpl implements ConsorcioDAO {
	
	public ConsorcioDAOImpl() {
		
	}

	@Override
	public void alta(Consorcio c) throws ConsorcioException {
		
		Connection conn;
		
		try {
			conn = DBManager.getInstance().connect();
		} catch (ConexionException e2) {
			
			String error = ConsorcioException.ERROR_ALTA + c.getNombre();
			
			error += "\n" + e2.getMessage();
			
			throw new ConsorcioException(error);
		}
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement("INSERT INTO CONSORCIOS (calle, numero, codigoPostal, provincia, localidad) VALUES (?,?,?,?,?)");
			
			pstmt.setString(1, c.getCalle());
			pstmt.setInt(2, c.getNumero());
			pstmt.setInt(3, c.getCodigoPostal());
			pstmt.setString(4, c.getProvincia());
			pstmt.setString(5, c.getLocalidad());
			
			
			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			
			String error = ConsorcioException.ERROR_ALTA + c.getNombre();
			
			error += "\n" + e.getMessage();
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				error += "\n" + e1.getMessage();
			}
			
			throw new ConsorcioException(error);
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new ConsorcioException("Error al cerrar la conexión.");
			}
		}

	}

	@Override
	public void baja(Consorcio c) throws ConsorcioException {
		
		Connection conn;
		
		try {
			conn = DBManager.getInstance().connect();
		} catch (ConexionException e2) {
			
			String error = ConsorcioException.ERROR_BAJA + c.getNombre();
			
			error += "\n" + e2.getMessage();
			
			throw new ConsorcioException(error);
		}
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement("DELETE FROM CONSORCIOS WHERE id = ?");
			
			pstmt.setInt(1, c.getId());
			
			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			
			String error = ConsorcioException.ERROR_BAJA + c.getNombre();
			
			error += "\n" + e.getMessage();
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				error += "\n" + e1.getMessage();
			}
			
			throw new ConsorcioException(error);
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new ConsorcioException("Error al cerrar la conexión.");
			}
		}

	}

	@Override
	public void modificacion(Consorcio c) throws ConsorcioException {
		
		Connection conn;
		
		try {
			conn = DBManager.getInstance().connect();
		} catch (ConexionException e2) {
			String error = ConsorcioException.ERROR_MODIFICACION + c.getNombre();
			
			error += "\n" + e2.getMessage();
			
			throw new ConsorcioException(error);
		}
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement("UPDATE CONSORCIOS SET " +
					"calle = ?," +
					"numero = ?," +
					"codigoPostal = ?," +
					"provincia = ?," +
					"localidad = ?" +
					"WHERE " +
					"id = ?");
			
			pstmt.setString(1, c.getCalle());
			pstmt.setInt(2, c.getNumero());
			pstmt.setInt(3, c.getCodigoPostal());
			pstmt.setString(4, c.getProvincia());
			pstmt.setString(5, c.getLocalidad());
			pstmt.setInt(6, c.getId());
			
			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			
			String error = ConsorcioException.ERROR_MODIFICACION + c.getNombre();
			
			error += "\n" + e.getMessage();
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				error += "\n" + e1.getMessage();
			}
			
			throw new ConsorcioException(error);
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new ConsorcioException("Error al cerrar la conexión.");
			}
		}
	}

	@Override
	public Consorcio get(int id) throws ConsorcioException {
		
		Connection conn;

		try {
			conn = DBManager.getInstance().connect();
		} catch (ConexionException e2) {

			String error = ConsorcioException.ERROR_BUSCAR_USUARIO + id;
			
			error += "\n" + e2.getMessage();
			
			throw new ConsorcioException(error);

		}
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement("SELECT * FROM CONSORCIOS WHERE id = ?");
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			conn.commit();
			
			Consorcio cs = null;
			
			if(rs.next()){
				
				cs = new Consorcio(rs.getInt("id"), rs.getString("calle"), rs.getInt("numero"),
						rs.getInt("codigoPostal"), rs.getString("provincia"), rs.getString("localidad"));
			}
			
			return cs;
			
		} catch (SQLException e) {
			
			String error = ConsorcioException.ERROR_BUSCAR_USUARIO + id;
			
			error += "\n" + e.getMessage();
			
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				error += "\n" + e1.getMessage();
			}
			
			throw new ConsorcioException(error);
		}	
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new ConsorcioException("Error al cerrar la conexión.");
			}
		}


		
	}

	@Override
	public ArrayList<Consorcio> getAll() throws ConsorcioException {
		
		Connection conn;
		
		try {
			conn = DBManager.getInstance().connect();
		} catch (ConexionException e2) {
			String error = ConsorcioException.ERROR_BUSCAR_TODOS;
			
			error += "\n" + e2.getMessage();
			
			throw new ConsorcioException(error);
		}
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement("SELECT * FROM CONSORCIOS");
			
			ResultSet rs = pstmt.executeQuery();
			
			conn.commit();
			
			ArrayList<Consorcio> consorcios = new ArrayList<Consorcio>();
			
			while(rs.next()){
				
				Consorcio c = new Consorcio(rs.getInt("id"), rs.getString("calle"), rs.getInt("numero"),
						rs.getInt("codigoPostal"), rs.getString("provincia"), rs.getString("localidad"));
				
				consorcios.add(c);
			}
			
			return consorcios;
			
		} catch (SQLException e) {
			
			String error = ConsorcioException.ERROR_BUSCAR_TODOS;
			
			error += "\n" + e.getMessage();
			
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				error += "\n" + e1.getMessage();
			}
			
			throw new ConsorcioException(error);
		}	
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new ConsorcioException("Error al cerrar la conexión.");
			}
		}

	}

}
