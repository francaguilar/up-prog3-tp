package dao;

import java.util.ArrayList;
import java.util.List;

import entidades.Consorcio;
import exceptions.ConsorcioException;

public interface ConsorcioDAO {
	
	public void alta(Consorcio c) throws ConsorcioException;
	
	public void baja(Consorcio c) throws ConsorcioException;
	
	public void modificacion(Consorcio c) throws ConsorcioException;
	
	public Consorcio get(int id) throws ConsorcioException;
	
	public ArrayList<Consorcio> getAll() throws ConsorcioException;

}
