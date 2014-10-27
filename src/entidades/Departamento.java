package entidades;

public class Departamento {

	private int id;
	private Propietario propietario;
	private Consorcio consorcio;
	private int piso;
	private char letra;
	private double porcentaje;
	
	public Departamento(){
		
	}
	
	public Departamento(Propietario propietario, Consorcio consorcio, int piso,
			char letra, double porcentaje) {
		super();
		this.propietario = propietario;
		this.consorcio = consorcio;
		this.piso = piso;
		this.letra = letra;
		this.porcentaje = porcentaje;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Consorcio getConsorcio() {
		return consorcio;
	}

	public void setConsorcio(Consorcio consorcio) {
		this.consorcio = consorcio;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
	
}
