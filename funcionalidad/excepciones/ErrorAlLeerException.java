package funcionalidad.excepciones;

public class ErrorAlLeerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ErrorAlLeerException(String mensaje) {
		super(mensaje);
	}
}