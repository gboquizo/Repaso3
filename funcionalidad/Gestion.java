package funcionalidad;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import funcionalidad.excepciones.ErrorAlEscribirException;
import funcionalidad.excepciones.ErrorAlLeerException;

/**
 * Clase de gestion
 * 
 * @author Guillermo Boquizo Sanchez
 * @version 2.0
 *
 */
public class Gestion {

	private static File fichero;
	private static boolean modificado = false;
	private static ArrayList<String> fechas = new ArrayList<String>();

	/**
	 * Metodo que se encarga de agregar una nueva fecha al arrayList
	 * 
	 * @param fechaInicial
	 *            La fecha inicial
	 * @param fechaFinal
	 *            La fecha final
	 * @param jTextFieldFechas
	 *            Campo donde se mostraran las fechas
	 */
	public static void add(LocalDate fechaInicial, LocalDate fechaFinal, String jTextFieldFechas) {
		generarLinea(fechaInicial, fechaFinal, jTextFieldFechas);
		setModificado(true);
	}

	/**
	 * Metodo que se encarga de generar una nueva linea que contenga la
	 * informacion a agregar
	 * 
	 * @param fechaInicial,
	 *            la fecha inicial, de tipo LocalDate
	 * @param fechaFinal,
	 *            la fecha final
	 * @param jTextFieldFechas,
	 *            el campo que contiene el periodo calculado
	 */
	private static void generarLinea(LocalDate fechaInicial, LocalDate fechaFinal, String jTextFieldFechas) {
		String linea = "Fecha inicio : " + formatear(fechaInicial) + "\tFecha fin : " + formatear(fechaFinal)
				+ "\tPeríodo transcurrido : " + jTextFieldFechas + "\nAutor: Guillermo Boquizo Sánchez";
		fechas.add(linea + "\n");
		setModificado(true);
	}

	/**
	 * Metodo encargado del formateo de fechas segun un patron de
	 * DateTimeFormatter
	 * 
	 * @param fecha,fecha
	 *            a formatear
	 * @return formato, cadena con la fecha formateada
	 */
	private static String formatear(LocalDate fecha) {
		DateTimeFormatter formatear = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy",
				new Locale("es", "ES"));
		String formato = fecha.format(formatear);
		return formato;
	}

	/**
	 * Metodo que se encarga de establecer los valores para la opcion nuevo
	 */
	public static void nuevo() {
		setModificado(false);
		setFile(null);
		fechas = new ArrayList<String>();
	}

	/**
	 * Metodo que se encarga de establecer los valores para la opcion abrir
	 *
	 * @param selectedFile
	 *            fichero seleccionado
	 * @return lectura, la lectura que efectua
	 * @throws ErrorAlLeerException,
	 *             en caso de error de lectura
	 */
	public static ArrayList<String> abrir(File selectedFile) throws ErrorAlLeerException {
		ArrayList<String> lectura = Fichero.leer(selectedFile);
		setModificado(false);
		setFile(selectedFile);
		return lectura;
	}

	/**
	 * Metodo que se encarga de establecer los valores para la opcion guardar
	 */
	public static void guardar() throws ErrorAlEscribirException {
		Fichero.escribir(fichero, fechas);
		setModificado(false);
	}

	/**
	 * Metodo que se encarga de establecer los valores para la opcion guardar,
	 * con un fichero como argumento
	 */
	public static void guardar(File file) throws ErrorAlEscribirException {
		Fichero.escribir(file, fechas);
		setModificado(false);
	}

	/**
	 * Metodo encargado de establecer el valor para modificado, en funcion del
	 * campo de la clase
	 * 
	 * @param modificado,
	 *            true o false
	 */
	private static void setModificado(boolean modificado) {
		Gestion.modificado = modificado;
	}

	/**
	 * Metodo encargado de la obtencion de un valor de verdad para modificado
	 * 
	 * @return modificado, que puede ser true o false
	 */
	public static boolean isModificado() {
		return modificado;
	}

	/**
	 * Metodo que establece el fichero parametrizado en relacion al campo de la
	 * clase
	 * 
	 * @param fichero, fichero que actua como argumento
	 */
	private static void setFile(File fichero) {
		Gestion.fichero = fichero;
	}
	
	/**
	 * Metodo que permite obtener un fichero
	 * @return fichero, el fichero obtenido
	 */
	public static File getFile() {
		return fichero;
	}
}