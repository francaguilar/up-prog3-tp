package exceptions;

public class ConsorcioException extends Exception {

	public static final String ERROR_ALTA = "Error al crear el consorcio ";
	public static final String ERROR_BAJA = "Error al eliminar el consorcio ";
	public static final String ERROR_MODIFICACION = "Error al modificar el consorcio ";
	public static final String ERROR_BUSCAR_USUARIO = "Error al buscar el consorcio ";
	public static final String ERROR_BUSCAR_TODOS = "Error al buscar todos los consorcios.";
	
	public ConsorcioException(String message) {
		super(message);
	}

	
}
