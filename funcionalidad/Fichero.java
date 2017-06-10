package funcionalidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import funcionalidad.excepciones.ErrorAlEscribirException;
import funcionalidad.excepciones.ErrorAlLeerException;

/**
 * Clase de control de ficheros
 * 
 * @author Guillermo Boquizo Sanchez
 * @version 2.0
 *
 */
public class Fichero implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que permite la escritura de los parametros indicados en un archivo
	 * 
	 * @param fichero,
	 *            archivo en el que se escribe
	 * @param lineas
	 *            Arraylist de lineas donde se han escrito
	 * @throws ErrorAlEscribirException
	 */
	public static void escribir(File fichero, ArrayList<String> lineas) throws ErrorAlEscribirException {
		fichero = annadirExtension(fichero);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
			for (String linea : lineas) 
				bw.write(linea + "\n");
			
		} catch (IOException e) {
			throw new ErrorAlEscribirException("Error de escritura");
		}
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
	 * Añade la extension txt solo en caso de ser necesario
	 * 
	 * @param file, el fichero al que se le agrega
	 * @return Fichero con la extension ".txt"
	 */
	private static File annadirExtension(File file) {

		String path = file.getPath();

		if (!path.endsWith(".txt"))
			return new File(path + ".txt");
		return file;
	}

}