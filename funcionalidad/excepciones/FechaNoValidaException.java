package funcionalidad.excepciones;

public class FechaNoValidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public FechaNoValidaException(String mensaje) {
		super(mensaje);
	}
}