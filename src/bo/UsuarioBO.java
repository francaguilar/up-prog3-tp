package bo;

import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import entidades.Usuario;
import exceptions.UsuarioException;

public class UsuarioBO {

	private UsuarioDAO dao;
	
	public void alta(Usuario u) throws UsuarioException{
		dao.alta(u);
	}
	
	public void baja(Usuario u) throws UsuarioException{
		dao.baja(u);
	}
	
	public void modificacion(Usuario u) throws UsuarioException{
		dao.modificacion(u);
	}
	
	public Usuario get(Usuario u) throws UsuarioException{
		return dao.get(u);
	}
	
	public ArrayList<Usuario> getAll() throws UsuarioException{
		return dao.getAll();
	}
	
}
