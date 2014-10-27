package entidades;

import java.sql.Date;

import utils.TiposGastos;

public class Gasto {

	private int id;
	private Liquidacion liquidacion;
	private double valor;
	private Date fecha;
	private TiposGastos tipo;
	private String descripcion;
	
	
	public Gasto(){
		
	}
	
	public Gasto(int id, Liquidacion liquidacion, double valor, Date fecha,
			TiposGastos tipo, String descripcion) {
		super();
		this.id = id;
		this.liquidacion = liquidacion;
		this.valor = valor;
		this.fecha = fecha;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Liquidacion getLiquidacion() {
		return liquidacion;
	}

	public void setLiquidacion(Liquidacion liquidacion) {
		this.liquidacion = liquidacion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TiposGastos getTipo() {
		return tipo;
	}

	public void setTipo(TiposGastos tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	 
	
}
