package funcionalidad;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase de gestion
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 2.0
 *
 */
public class Gestion {

	private static File fichero;
	private static boolean modificado = false;
	private static ArrayList<String> lineas = new ArrayList<String>();
	
	public static void add(LocalDate fechaInicial, LocalDate fechaFinal, String JTextField) {
		generarLinea(fechaInicial, fechaFinal, JTextField);
		setModificado(true);
	}

	private static void generarLinea(LocalDate fechaInicial,LocalDate fechaFinal,String JTextField) {
		String linea = "Fecha inicio : " + fechaInicial.toString() + "\tFecha fin : " + fechaFinal.toString() + "\t"
				+ JTextField;
		lineas.add(linea + "\n");
		setModificado(true);
	}

	public static void nuevo() {
		setModificado(false);
		setFile(null);
		lineas = new ArrayList<String>();
	}

	public static ArrayList<String> abrir(File selectedFile) throws ErrorAlLeerException {
		ArrayList<String>  lectura = Fichero.leer(selectedFile);
		setModificado(false);
		setFile(selectedFile);
		return lectura;
	}

	

	public static void guardar() throws ErrorAlEscribirException {
		Fichero.escribir(fichero,lineas);
		setModificado(false);
	}

	public static void guardar(File file) throws ErrorAlEscribirException {
		Fichero.escribir(file,lineas);
		setModificado(false);
	}

	public static boolean isModificado() {
		return modificado;
	}

	private static void setModificado(boolean modificado) {
		Gestion.modificado = modificado;
	}

	private static void setFile(File fichero) {
		Gestion.fichero = fichero;
	}

	public static File getFile() {
		return fichero;
	}
}