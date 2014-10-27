package entidades;

public class Consorcio {

	private int id;
	private String calle;
	private int numero;
	private int codigoPostal;
	private String provincia;
	private String localidad;
	
	public Consorcio(){
		
	}

	public Consorcio(int id, String calle, int numero, int codigoPostal,
			String provincia, String localidad) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.localidad = localidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre(){
		return calle + " " + numero;
	}
	
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
}
