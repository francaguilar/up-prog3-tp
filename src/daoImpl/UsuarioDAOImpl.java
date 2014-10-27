package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DBManager;

import dao.UsuarioDAO;
import entidades.Usuario;
import exceptions.ConexionException;
import exceptions.UsuarioException;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	public UsuarioDAOImpl() {
		
	}

	@Override
	public void alta(Usuario u) throws UsuarioException {
		
		Connection conn;
		
		try {
			conn = DBManager.getInstance().connect();
		} catch (ConexionException e2) {
			
			String error = UsuarioException.ERROR_ALTA + u.getNombre();
			
			error += "\n" + e2.getMessage();
			
			throw new UsuarioException(error);
		}
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement("INSERT INTO USUARIOS (nombre, password) VALUES (?,?)");
			
			pstmt.setString(1, u.getNombre());
			pstmt.setString(2, u.getPassword());
			
			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			
			String error = UsuarioException.ERROR_ALTA + u.getNombre();
			
			error += "\n" + e.getMessage();
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				error += "\n" + e1.getMessage();
			}
			
			throw new UsuarioException(error);
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new UsuarioException("Error al cerrar la conexión.");
			}
		}

	}

	@Override
	public void baja(Usuario u) throws UsuarioException {
		
		Connection conn;
		
		try {
			conn = DBManager.getInstance().connect();
		} catch (ConexionException e2) {
			
			String error = UsuarioException.ERROR_BAJA + u.getNombre();
			
			error += "\n" + e2.getMessage();
			
			throw new UsuarioException(error);
		}
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement("DELETE FROM USUARIOS WHERE id = ?");
			
			pstmt.setInt(1, u.getId());
			
			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			
			String error = UsuarioException.ERROR_BAJA + u.getNombre();
			
			error += "\n" + e.getMessage();
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				error += "\n" + e1.getMessage();
			}
			
			throw new UsuarioException(error);
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new UsuarioException("Error al cerrar la conexión.");
			}
		}

	}

	@Override
	public void modificacion(Usuario u) throws UsuarioException {
		
		Connection conn;
		
		try {
			conn = DBManager.getInstance().connect();
		} catch (ConexionException e2) {
			String error = UsuarioException.ERROR_MODIFICACION + u.getNombre();
			
			error += "\n" + e2.getMessage();
			
			throw new UsuarioException(error);
		}
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement("UPDATE USUARIOS SET " +
					"nombre = ?," +
					"password = ?" +
					"WHERE" +
					"id = ?");
			
			pstmt.setString(1, u.getNombre());
			pstmt.setString(2, u.getPassword());
			pstmt.setInt(3, u.getId());
			
			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			
			String error = UsuarioException.ERROR_MODIFICACION + u.getNombre();
			
			error += "\n" + e.getMessage();
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				error += "\n" + e1.getMessage();
			}
			
			throw new UsuarioException(error);
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new UsuarioException("Error al cerrar la conexión.");
			}
		}
	}

	@Override
	public Usuario get(Usuario u) throws UsuarioException {
		
		Connection conn;

		try {
			conn = DBManager.getInstance().connect();
		} catch (ConexionException e2) {

			String error = UsuarioException.ERROR_BUSCAR_USUARIO + u.getNombre();
			
			error += "\n" + e2.getMessage();
			
			throw new UsuarioException(error);

		}
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement("SELECT * FROM USUARIOS WHERE id = ?");
			
			pstmt.setInt(1, u.getId());
			
			ResultSet rs = pstmt.executeQuery();
			
			conn.commit();
			
			Usuario usuario = null;
			
			if(rs.next()){
				
				usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("password"));
			}
			
			return usuario;
			
		} catch (SQLException e) {
			
			String error = UsuarioException.ERROR_BUSCAR_USUARIO + u.getNombre();
			
			error += "\n" + e.getMessage();
			
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				error += "\n" + e1.getMessage();
			}
			
			throw new UsuarioException(error);
		}	
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new UsuarioException("Error al cerrar la conexión.");
			}
		}


		
	}

	@Override
	public ArrayList<Usuario> getAll() throws UsuarioException {
		
		Connection conn;
		
		try {
			conn = DBManager.getInstance().connect();
		} catch (ConexionException e2) {
			String error = UsuarioException.ERROR_BUSCAR_TODOS;
			
			error += "\n" + e2.getMessage();
			
			throw new UsuarioException(error);
		}
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement("SELECT * FROM USUARIOS");
			
			ResultSet rs = pstmt.executeQuery();
			
			conn.commit();
			
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			while(rs.next()){
				
				Usuario u = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("password"));
				
				usuarios.add(u);
			}
			
			return usuarios;
			
		} catch (SQLException e) {
			
			String error = UsuarioException.ERROR_BUSCAR_TODOS;
			
			error += "\n" + e.getMessage();
			
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				error += "\n" + e1.getMessage();
			}
			
			throw new UsuarioException(error);
		}	
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new UsuarioException("Error al cerrar la conexión.");
			}
		}

	}

}
