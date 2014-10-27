package entidades;

import java.util.Date;

import utils.Meses;

public class Expensa {

	private Departamento departamento;
	private Meses mes;
	
	private double valorA;
	private double valorB;
	private double pago;
	private Date fechaVencimiento;
	private Date fechaPago;
	
	
	public Expensa(){
		
	}
			

	public Expensa(Departamento departamento, Meses mes, double valorA,
			double valorB, double pago, Date fechaVencimiento, Date fechaPago) {
		super();
		this.departamento = departamento;
		this.mes = mes;
		this.valorA = valorA;
		this.valorB = valorB;
		this.pago = pago;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaPago = fechaPago;
	}





	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public double getValorA() {
		return valorA;
	}


	public void setValorA(double valorA) {
		this.valorA = valorA;
	}


	public double getValorB() {
		return valorB;
	}


	public void setValorB(double valorB) {
		this.valorB = valorB;
	}


	public double getPago() {
		return pago;
	}


	public void setPago(double pago) {
		this.pago = pago;
	}


	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public Date getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}


	public Meses getMes() {
		return mes;
	}


	public void setMes(Meses mes) {
		this.mes = mes;
	}


	
	
}
