package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * Clase para la ventana GUI AcercaDe
 * 
 * @author Guillermo Boquizo Sanchez
 * @version 2.0
 *
 */
public class AcercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		getContentPane().setBackground(new Color(255, 204, 153));
		setTitle("Acerca de...\r\n");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDe.class.getResource("/resources/favicon.png")));
		setResizable(false);
		setBounds(100, 100, 605, 550);
		getContentPane().setLayout(null);
		contentPanel.setToolTipText("");
		contentPanel.setBounds(0, 0, 0, 0);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblAcercaDe = new JLabel(
				"<html>\r\n<h1>I.E.S Gran Capit\u00E1n, 2017</h1>\t\r\n\r\n<h2>Ejercicio de repaso n\u00BA 1.</h2>\r\n\t<h3>Desarrollado por:</h3>\r\n\t\t<ul>\r\n\t\t\t<li>Guillermo Boquizo S\u00E1nchez</li>\r\n\r\n\r\n\t\t\t<li>Versi\u00F3n: 1.0</li>\r\n\t\r\n\t\t\t<li>Creado el 31 de mayo de 2017</li>\r\n\t</ul>\r\n</html>");
		lblAcercaDe.setToolTipText("Descripci\u00F3n de la autor\u00EDa del ejercicio\r\n");
		lblAcercaDe.setForeground(new Color(0, 0, 51));
		lblAcercaDe.setBounds(10, 11, 424, 185);
		getContentPane().add(lblAcercaDe);
		lblAcercaDe.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblimagen = new JLabel("");
		lblimagen.setToolTipText("Gif animado insertado en un JLabel");
		lblimagen.setForeground(Color.WHITE);
		lblimagen.setBounds(29, 249, 213, 220);
		getContentPane().add(lblimagen);

		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(new Color(255, 204, 153));
		panel.setLayout(null);
		panel.setBounds(252, 377, 133, 92);
		getContentPane().add(panel);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setToolTipText("Pulsa para salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(10, 11, 117, 48);
		panel.add(btnSalir);
		lblimagen.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/resources/gif.gif")));
	}
}
