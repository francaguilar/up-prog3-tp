package bo;

import java.util.ArrayList;

import dao.ConsorcioDAO;
import daoImpl.ConsorcioDAOImpl;
import entidades.Consorcio;
import exceptions.ConsorcioException;

public class ConsorcioBO {

	private ConsorcioDAO dao;
	
	public ConsorcioBO(){
		this.dao = new ConsorcioDAOImpl();
	}
	
	public void alta(Consorcio c) throws ConsorcioException{
		dao.alta(c);
	}
	
	public void baja(Consorcio c) throws ConsorcioException{
		dao.baja(c);
	}
	
	public void modificacion(Consorcio c) throws ConsorcioException{
		dao.modificacion(c);
	}
	
	public Consorcio get(Consorcio c) throws ConsorcioException{
		return dao.get(c);
	}
	
	public ArrayList<Consorcio> getAll() throws ConsorcioException{
		return dao.getAll();
	}
	
}
