package exceptions;

public class UsuarioException extends Exception {

	public static final String ERROR_ALTA = "Error al crear el usuario ";
	public static final String ERROR_BAJA = "Error al eliminar el usuario ";
	public static final String ERROR_MODIFICACION = "Error al modificar el usuario ";
	public static final String ERROR_BUSCAR_USUARIO = "Error al buscar el usuario ";
	public static final String ERROR_BUSCAR_TODOS = "Error al buscar todos los usuarios.";
	
	public UsuarioException(String message) {
		super(message);
	}

	
}
