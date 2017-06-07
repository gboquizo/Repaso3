package funcionalidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Fichero {

	private static ArrayList<String> lineas = new ArrayList<String>();

	/**
	 * Metodo que permite la escritura de los parametros indicados en un archivo
	 * 
	 * @param fichero,
	 *            archivo en el que se escribe
	 * @param fechaInicial,
	 *            la fecha inicial
	 * @param JTextField,
	 *            campo de texto donde se muestra el calculo del Period
	 * @param fechaFinal,
	 *            la fecha final
	 * @throws ErrorAlEscribirException
	 */
	public static void escritura(File fichero, LocalDate fechaInicial, String JTextField, LocalDate fechaFinal)
			throws ErrorAlEscribirException {

		try {
			fichero = annadirExtension(fichero);
			FileWriter out = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(out);

			for (String linea : lineas) {
				bw.write(linea + "\n");
			}

			bw.close();

		} catch (IOException e) {
			throw new ErrorAlEscribirException("Error de escritura");
		}
	}

	/**
	 * Método que permite escribir la fecha en forma de línea en el archivo
	 * 
	 * @param fechaInicial,
	 *            la fecha inicial obtenida del spinner
	 * @param JTextField,
	 *            el valor del período mostrado en el JTextField correspondiente
	 * @param fechaFinal,
	 *            la fecha final obtenida del spinner
	 */
	public static void escribirLinea(LocalDate fechaInicial, String JTextField, LocalDate fechaFinal) {
		String linea = "Fecha inicio : " + fechaInicial.toString() + ", Fecha fin : " + fechaFinal.toString() + ", "
				+ JTextField;
		lineas.add(linea + "\n");
	}

	/**
	 * Lee desde un fichero un ArrayList de cadenas de texto de fecha
	 * 
	 * @param fichero,
	 *            el fichero a leer
	 * @return fechas, la lectura desde el archivo
	 * @throws ErrorAlLeerException
	 */
	public static ArrayList<String> leer(File fichero) throws ErrorAlLeerException {

		String fecha;
		ArrayList<String> fechas = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			while ((fecha = br.readLine()) != null) {
				fechas.add(fecha);
			}
			return fechas;

		} catch (IOException e) {
			throw new ErrorAlLeerException("Error de lectura");
		}
	}

	/**
	 * Añade la extensión txt sólo en caso de ser necesario
	 * 
	 * @param file
	 * @return Fichero con la extensión ".txt"
	 */
	private static File annadirExtension(File file) {

		String path = file.getPath();

		if (!path.endsWith(".txt"))
			return new File(path + ".txt");
		return file;
	}

}