package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;

/**
 * Clase que gestiona la GUI de LocalDate
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class LocalDateGUI extends FechasGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public LocalDateGUI() {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LocalDateGUI.class.getResource("/resources/favicon.png")));
		setModal(true);
		setResizable(false);
		setTitle("LocalDate\r\n");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(java.awt.Color.WHITE);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

	}

}
