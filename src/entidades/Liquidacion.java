package entidades;

import java.sql.Date;

import utils.Meses;

public class Liquidacion {

	private int id;
	private Meses mes;
	private Date fechaInicio;
	private Date fechaCierre;
	private Date fechaVencimiento;
	
	
	public Liquidacion(){
		
	}
	
	public Liquidacion(int id, Meses mes, Date fechaInicio, Date fechaCierre,
			Date fechaVencimiento) {
		super();
		this.id = id;
		this.mes = mes;
		this.fechaInicio = fechaInicio;
		this.fechaCierre = fechaCierre;
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Meses getMes() {
		return mes;
	}

	public void setMes(Meses mes) {
		this.mes = mes;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
}
