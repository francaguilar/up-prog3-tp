package dao;

import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;
import exceptions.UsuarioException;

public interface UsuarioDAO {
	
	public void alta(Usuario u) throws UsuarioException;
	
	public void baja(Usuario u) throws UsuarioException;
	
	public void modificacion(Usuario u) throws UsuarioException;
	
	public Usuario get(Usuario u) throws UsuarioException;
	
	public ArrayList<Usuario> getAll() throws UsuarioException;

}
