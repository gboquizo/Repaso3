package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import funcionalidad.FechaNoValidaException;
import funcionalidad.Fichero;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase padre de todas las ventanas de tipo JDialog
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class FechasGUI extends JDialog implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String PERIODO = "Período transcurrido: ";
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final static LocalDate FECHA_ACTUAL = LocalDate.now();
	private static boolean modificado = false;
	static JSpinner spinnerInicial;
	static JSpinner spinnerFinal;
	static JTextField txtfldTiempoTranscurrido;
	static LocalDate fechaFin;
	JRadioButton rdbtnMeses;
	static JRadioButton rdbtnAnnos;
	JRadioButton rdbtnDia;
	JLabel lblFechaInicial;
	JLabel lblFechaFinal;
	JLabel lblTiempoTranscurrido;

	JPanel buttonPane;
	JButton buttonSalir;

	static {
		Locale.setDefault(new Locale("es", "ES"));
	}

	/**
	 * Create the dialog.
	 */
	public FechasGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				salir();
			}
		});
		setTitle("Fechas");
		setResizable(false);
		setModal(true);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FechasGUI.class.getResource("/resources/favicon.png")));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setBounds(10, 11, 422, 221);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);

		lblTiempoTranscurrido = new JLabel("Tiempo transcurrido");
		lblTiempoTranscurrido.setToolTipText("Muestra un per\u00EDodo de tiempo calculado");
		lblTiempoTranscurrido.setBounds(10, 35, 137, 14);

		contentPanel.add(lblTiempoTranscurrido);

		txtfldTiempoTranscurrido = new JTextField();
		txtfldTiempoTranscurrido.setToolTipText(
				"Muestra el per\u00EDodo transcurrido en d\u00EDas, meses o a\u00F1os, en funci\u00F3n de la opci\u00F3n escogida");
		txtfldTiempoTranscurrido.setEditable(false);
//		try {
//			txtfldTiempoTranscurrido.setText(PERIODO
//					+ obtenerPeriodoAnnos(obtenerFechaSpinner(spinnerInicial), obtenerFechaSpinner(spinnerFinal)));
//		} catch (FechaNoValidaException e2) {
//			e2.getMessage();
//		}
		txtfldTiempoTranscurrido.setBounds(169, 32, 197, 20);
		contentPanel.add(txtfldTiempoTranscurrido);
		txtfldTiempoTranscurrido.setColumns(10);

		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setToolTipText("Escoge una fecha");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Fecha",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 157, 243, 45);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			rdbtnDia = new JRadioButton("D\u00EDas");
			rdbtnDia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controlarSeleccion(spinnerInicial, spinnerFinal);
					modificado = true;
				}
			});
			rdbtnDia.setToolTipText("Permite escoger d\u00EDas");
			rdbtnDia.setForeground(Color.BLACK);
			rdbtnDia.setBackground(new Color(240, 248, 255));
			rdbtnDia.setBackground(new Color(240, 248, 255));
			rdbtnDia.setBounds(6, 16, 60, 23);
			panel.add(rdbtnDia);
			buttonGroup.add(rdbtnDia);
			rdbtnDia.setHorizontalAlignment(SwingConstants.LEFT);
		}
		{
			rdbtnMeses = new JRadioButton("Meses");
			rdbtnMeses.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlarSeleccion(spinnerInicial, spinnerFinal);
					modificado = true;
				}
			});
			rdbtnMeses.setToolTipText("Permite escoger meses");
			rdbtnMeses.setForeground(Color.BLACK);
			rdbtnMeses.setBackground(new Color(240, 248, 255));
			rdbtnMeses.setBounds(71, 16, 82, 23);
			panel.add(rdbtnMeses);
			buttonGroup.add(rdbtnMeses);
			rdbtnMeses.setHorizontalAlignment(SwingConstants.LEFT);
		}
		{
			rdbtnAnnos = new JRadioButton("A\u00F1os");
			rdbtnAnnos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlarSeleccion(spinnerInicial, spinnerFinal);
					modificado = false;
				}
			});
			rdbtnAnnos.setToolTipText("Permite escoger a\u00F1os");
			rdbtnAnnos.setForeground(Color.BLACK);
			rdbtnAnnos.setBackground(new Color(240, 248, 255));
			rdbtnAnnos.setBounds(155, 16, 82, 23);
			panel.add(rdbtnAnnos);
			rdbtnAnnos.setHorizontalAlignment(SwingConstants.LEFT);
			buttonGroup.add(rdbtnAnnos);
		}

		

		spinnerInicial = new JSpinner();
		spinnerInicial.setForeground(Color.WHITE);
		spinnerInicial.setBackground(Color.DARK_GRAY);
		spinnerInicial.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				try {
					isFechaValida();
					modificado = true;
					controlarSeleccion(spinnerInicial, spinnerFinal);
				} catch (HeadlessException | FechaNoValidaException e) {
					e.getMessage();
				}

			}
		});
		spinnerInicialPred();
		spinnerInicial.setBounds(10, 114, 203, 18);
		contentPanel.add(spinnerInicial);

		spinnerFinal = new JSpinner();
		fechaFin = LocalDate.of(FECHA_ACTUAL.plusYears(3).getYear(), FECHA_ACTUAL.getMonth(),
				FECHA_ACTUAL.getDayOfMonth());
		spinnerFinal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					isFechaValida();
					modificado = true;
					controlarSeleccion(spinnerInicial, spinnerFinal);
				} catch (HeadlessException | FechaNoValidaException | DateTimeException e1) {
					e1.getMessage();
				}

			}
		});
		spinnerFinalPred();
		spinnerFinal.setBounds(223, 114, 175, 18);
		contentPanel.add(spinnerFinal);

		lblFechaInicial = new JLabel("Fecha Inicial");
		lblFechaInicial.setToolTipText("Fecha inicial del per\u00EDodo, por defecto la fecha inicial");
		lblFechaInicial.setBounds(10, 89, 71, 14);
		contentPanel.add(lblFechaInicial);

		lblFechaFinal = new JLabel("Fecha Final");
		lblFechaFinal.setToolTipText("Fecha final del per\u00EDodo, por defecto suma 3 a\u00F1os");
		lblFechaFinal.setBounds(223, 89, 71, 14);
		contentPanel.add(lblFechaFinal);

		buttonSalir = new JButton("Salir");
		buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}

		});
		buttonSalir.setBounds(285, 175, 102, 23);
		contentPanel.add(buttonSalir);
		buttonSalir.setToolTipText("Pulsar para salir");
		buttonSalir.setActionCommand("OK");

		rdbtnAnnos.setSelected(true);
		txtfldTiempoTranscurrido.setText(obtenerPeriodoAnnos(getFechaSpinnerInicial(), getFechaSpinnerFinal()));
	}

	/**
	 * Metodo que establece los valores predeterminados del JSpinner para las
	 * fechas iniciales
	 */
	public static void spinnerInicialPred() {
		spinnerInicial.setModel(new SpinnerDateModel(java.sql.Date.valueOf(FECHA_ACTUAL), null, null, Calendar.MONTH));
		spinnerInicial.setEditor(new JSpinner.DateEditor(spinnerInicial, "dd 'de' MMMM 'de' yyyy', 'EEEE"));
	}

	/**
	 * Metodo que establece los valores predeterminados del JSpinner para las
	 * fechas finales
	 */
	public static void spinnerFinalPred() {
		fechaFin = LocalDate.of(FECHA_ACTUAL.plusYears(3).getYear(), FECHA_ACTUAL.getMonth(),
				FECHA_ACTUAL.getDayOfMonth());
		spinnerFinal.setModel(new SpinnerDateModel(java.sql.Date.valueOf(fechaFin), null, null, Calendar.MONTH));
		spinnerFinal.setEditor(new JSpinner.DateEditor(spinnerFinal, "dd 'de' MMMM 'de' yyyy', 'EEEE"));
	}

	/**
	 * Obtiene la fecha de un JSpinner generico
	 * 
	 * @param jspinner,
	 *            el JSpinner generico
	 * @return fecha, un LocalDate con la fecha del JSpinner
	 */
	protected LocalDate obtenerFechaSpinner(JSpinner jspinner) throws FechaNoValidaException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) jspinner.getModel().getValue());
		LocalDate fecha = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
		return fecha;

	}

	/**
	 * Metodo que permite obtener la fecha del spinner inicial
	 * 
	 * @return fecha, la fecha obtenida de tipo LocalDate
	 */
	public static LocalDate getFechaSpinnerInicial() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) spinnerInicial.getModel().getValue());
		LocalDate fecha = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
		return fecha;
	}

	/**
	 * Metodo que permite obtener la fecha del spinner final
	 * 
	 * @return fecha, la fecha obtenida de tipo LocalDate
	 */
	public static LocalDate getFechaSpinnerFinal() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) spinnerFinal.getModel().getValue());
		LocalDate fecha = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
		return fecha;
	}

	/**
	 * Controla la selección de los radioButtons en dias, meses y annos
	 * 
	 * @param spinnerInicial
	 *            el JSpinner para la fecha inicial
	 * @param spinnerFinal
	 *            el JSpinner para la fecha final
	 * 
	 */
	private void controlarSeleccion(JSpinner spinnerInicial, JSpinner spinnerFinal) {
		try {
			if (rdbtnAnnos.isSelected()) {

				txtfldTiempoTranscurrido.setText(PERIODO
						+ obtenerPeriodoAnnos(obtenerFechaSpinner(spinnerInicial), obtenerFechaSpinner(spinnerFinal)));

			} else if (rdbtnMeses.isSelected()) {
				txtfldTiempoTranscurrido.setText(PERIODO
						+ obtenerPeriodoMeses(obtenerFechaSpinner(spinnerInicial), obtenerFechaSpinner(spinnerFinal)));
			} else
				txtfldTiempoTranscurrido.setText(PERIODO
						+ obtenerPeriodoDias(obtenerFechaSpinner(spinnerInicial), obtenerFechaSpinner(spinnerFinal)));

		} catch (FechaNoValidaException e) {
			e.getMessage();
		}
	}

	/**
	 * Método que permite obtener un período en dias
	 * 
	 * @param fechaInicial
	 *            la fecha inicial, de tipo LocalDate
	 * @param fechaFinal,
	 *            la fecha inicial, de tipo LocalDate
	 * @return la fecha en días, pasada a cadena
	 */
	private String obtenerPeriodoDias(LocalDate fechaInicial, LocalDate fechaFinal) {
		long dias = ChronoUnit.DAYS.between(fechaInicial, fechaFinal);
		return dias + " días";
	}

	/**
	 * Metodo que permite obtener un periodo en meses
	 * 
	 * @param fechaInicial
	 *            la fecha inicial, de tipo LocalDate
	 * @param fechaFinal,
	 *            la fecha inicial, de tipo LocalDate
	 * @return la fecha en meses, pasada a cadena
	 */
	private String obtenerPeriodoMeses(LocalDate fechaInicial, LocalDate fechaFinal) {
		long meses = ChronoUnit.MONTHS.between(fechaInicial, fechaFinal);
		return meses + " meses";
	}

	/**
	 * Metodo que permite obtener un periodo en annos
	 * 
	 * @param fechaInicial
	 *            la fecha inicial, de tipo LocalDate
	 * @param fechaFinal,
	 *            la fecha inicial, de tipo LocalDate
	 * @return la fecha en annos, pasada a cadena
	 */
	public static String obtenerPeriodoAnnos(LocalDate fechaInicial, LocalDate fechaFinal) {
		Period period = Period.between(fechaInicial, fechaFinal);
		return period.getYears() + " años";
	}

	/**
	 * Permite comprobar que la fecha final del periodo a calcular no sea menor
	 * que la fecha inicial. Si lo es, lanza un error y resetea los valores de
	 * los JSpinner a sus valores por defecto
	 * 
	 * @throws HeadlessException
	 * @throws FechaNoValidaException
	 */
	private void isFechaValida() throws HeadlessException, FechaNoValidaException {
		if (obtenerFechaSpinner(spinnerFinal).isBefore(obtenerFechaSpinner(spinnerInicial))) {
			JOptionPane.showMessageDialog(contentPanel, "Error, la fecha no es válida", "Error en la fecha",
					JOptionPane.ERROR_MESSAGE);
			spinnerInicialPred();
			spinnerFinalPred();
		}

	}

	/**
	 * Metodo que permite controlar la salida, escribiendo una linea cada vez
	 * que sale
	 */
	private void salir() {
		Fichero.escribirLinea(getFechaSpinnerInicial(), txtfldTiempoTranscurrido.getText(), getFechaSpinnerFinal());
		JOptionPane.showMessageDialog(null, "Linea añadida correctamente");
		modificado = true;
		dispose();
	}

	/**
	 * Permite obtener el periodo calculado en el correspondiente JTextField
	 * 
	 * @return el texto de dicho JTextField
	 */
	public static String obtenerPeriodo() {
		return txtfldTiempoTranscurrido.getText();

	}

	/**
	 * Método que permite comprobar si existe modificacion
	 * 
	 * @return true o false en funcion del estado de modificado
	 */
	public static boolean isModificado() {
		return modificado;
	}

	/**
	 * Método que permite establecer el estado del campo modificado
	 * 
	 * @param modificado,
	 *            el campo modificado pasado como parámetro
	 */
	public static void setModificado(boolean modificado) {
		FechasGUI.modificado = modificado;
	}
}
