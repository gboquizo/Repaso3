package funcionalidad.excepciones;

public class ErrorAlEscribirException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ErrorAlEscribirException(String mensaje) {
		super(mensaje);
	}

}