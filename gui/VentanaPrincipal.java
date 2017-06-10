package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


import funcionalidad.*;
import funcionalidad.excepciones.ErrorAlEscribirException;
import funcionalidad.excepciones.ErrorAlLeerException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase para la ventana principal
 * 
 * @author Guillermo Boquizo Sanchez
 * @version 2.0
 *
 */
public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String SIN_TITULO = "Sin título";
	private static JFileChooser jfilechooser = new JFileChooser();
	static FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de texto", "txt");
	private JPanel contentPane;
	private JTextArea textPane;
	static {
		jfilechooser.setFileFilter(filter);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setTitle(SIN_TITULO);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/resources/favicon.png")));
		setBounds(100, 100, 524, 347);
		controlarSalida();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFichero = new JMenu("Fichero");
		mnFichero.setMnemonic('f');
		menuBar.add(mnFichero);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.setMnemonic('n');
		mnFichero.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAbrir.setMnemonic('a');
		mnFichero.add(mntmAbrir);

		JSeparator separador1 = new JSeparator();
		mnFichero.add(separador1);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmGuardar.setMnemonic('g');
		mnFichero.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mntmGuardarComo.setMnemonic('u');
		mnFichero.add(mntmGuardarComo);

		JSeparator separator2 = new JSeparator();
		mnFichero.add(separator2);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmSalir.setMnemonic('s');
		mnFichero.add(mntmSalir);

		JMenu mnFecha = new JMenu("Fecha");
		mnFecha.setMnemonic('e');
		menuBar.add(mnFecha);

		JMenuItem mntmLocaldate = new JMenuItem("LocalDate");
		mntmLocaldate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LocalDateGUI localdate = new LocalDateGUI();
				localdate.setVisible(true);
			}
		});

		mntmLocaldate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmLocaldate.setMnemonic('l');
		mnFecha.add(mntmLocaldate);

		JMenuItem mntmPeriod = new JMenuItem("Period");
		mntmPeriod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeriodGUI period = new PeriodGUI();
				period.setVisible(true);
			}
		});

		mntmPeriod.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmPeriod.setMnemonic('p');
		mnFecha.add(mntmPeriod);

		JMenuItem mntmChronoUnit = new JMenuItem("ChronoUnit");
		mntmChronoUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChronoUnitGUI chrono = new ChronoUnitGUI();
				chrono.setVisible(true);
			}
		});

		mntmChronoUnit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmChronoUnit.setMnemonic('c');
		mnFecha.add(mntmChronoUnit);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('a');
		menuBar.add(mnAyuda);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmAyuda.addActionListener(new ActionListener() {

			private Ayuda ayuda;

			public void actionPerformed(ActionEvent arg0) {
				ayuda = Ayuda.getInstance();
				ayuda.setVisible(true);
			}
		});

		mntmAyuda.setMnemonic('y');
		mnAyuda.add(mntmAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});

		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		mntmAcercaDe.setMnemonic('c');
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 518, 297);
		contentPane.add(scrollPane);

		textPane = new JTextArea();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		textPane.setForeground(Color.BLACK);
		textPane.setBackground(Color.WHITE);

	}

	/**
	 * Resetea los JSpinner a las fechas por defecto si se habian modificado
	 */
	private void nuevo() {
		if (guardarSiModificado() == ContinuarAbortar.ABORTAR) {
			return;
		}
		Gestion.nuevo();
		actualizarTitulo();
		textPane.setText(null);

	}
	
	/**
	 * Metodo encargado de actualizar el titulo
	 */
	private void actualizarTitulo() {
		if (Gestion.getFile() == null)
			setTitle(SIN_TITULO);
		else
			setTitle(Gestion.getFile().getName());
	}

	/**
	 * Lee el fichero y vuelca su contenido en un textArea
	 */
	private ContinuarAbortar abrir() {
		if (jfilechooser.showOpenDialog(contentPane) != JFileChooser.APPROVE_OPTION) {
			return ContinuarAbortar.ABORTAR;
		}

		try {
			File file = jfilechooser.getSelectedFile();
			ArrayList<String> fecha = Gestion.abrir(file);
			String cadena = "";
			for (String string : fecha) {
				cadena += string + "\n";
			}
			actualizarTitulo();
			textPane.setText(cadena);
			return ContinuarAbortar.CONTINUAR;

		} catch (ErrorAlLeerException e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return ContinuarAbortar.ABORTAR;
	}

	/**
	 * Guarda los datos en un fichero
	 */
	private ContinuarAbortar guardar() {
		try {
			if (Gestion.getFile() == null) {
				return guardarComo();
			}
			Gestion.guardar();
			return ContinuarAbortar.CONTINUAR;
		} catch (ErrorAlEscribirException e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return ContinuarAbortar.ABORTAR;
		}
	}
	
	/**
	 * Guarda los datos en un fichero, si hay modificaciones
	 */
	private ContinuarAbortar guardarComo() {
		File file;
		do {
			try {
				switch (jfilechooser.showSaveDialog(contentPane)) {
				case JFileChooser.CANCEL_OPTION:
				case JFileChooser.ERROR_OPTION:
					return ContinuarAbortar.ABORTAR;
				}
				file = jfilechooser.getSelectedFile();
				if (!file.exists() || deseaReemplazarlo(file)) {
					Gestion.guardar(file);
					actualizarTitulo();
					JOptionPane.showMessageDialog(contentPane, "Guardado con éxito", "Guardar",
							JOptionPane.INFORMATION_MESSAGE);
					return ContinuarAbortar.CONTINUAR;
				}
			} catch (ErrorAlEscribirException e) {
				JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Error escritura",
						JOptionPane.ERROR_MESSAGE);
			}
		} while (true);
	}

	
	/**
	 * Metodo que comprueba si existen cambios sin guardar antes de salir
	 */
	private ContinuarAbortar guardarSiModificado() {
		if (Gestion.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(contentPane, "Hay cambios sin guardar ¿Quieres guardarlos?",
					"Fecha", JOptionPane.YES_NO_CANCEL_OPTION);
			switch (opcion) {
			case JOptionPane.YES_OPTION:
				return guardarComo();
			case JOptionPane.NO_OPTION:
				break;
			default:
				return ContinuarAbortar.ABORTAR;
			}
		}
		return ContinuarAbortar.CONTINUAR;
	}
	
	/**
	 * Indica si se desea reemplazar el fichero existente en caso de existir
	 * previamente.
	 * 
	 * @param file
	 *            Fichero que va a reemplazarse
	 * @return true si el fichero existe y se desea reemplazar. false si no se
	 *         desea reemplazar o el fichero no existe
	 */
	private boolean deseaReemplazarlo(File file) {
		if (file.exists()) {
			switch (JOptionPane.showConfirmDialog(contentPane, file.getName() + " ya existe. ¿Desea reemplazarlo?",
					"Confirmar Guardar Como", JOptionPane.YES_NO_OPTION)) {
			case JOptionPane.YES_OPTION:
				return true;
			case JOptionPane.NO_OPTION:
			case JOptionPane.CLOSED_OPTION:
				return false;
			}
		}

		return false;
	}
	
	/**
	 * Controla los cambios antes de cerrar el programa
	 */
	private void controlarSalida() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				salir();
			}
		});
	}
	
	/**
	 * Metodo encargado de controlar la salida del programa
	 */
	private void salir() {
		if (guardarSiModificado() == ContinuarAbortar.ABORTAR)
			return;
		System.exit(0);
	}
}
