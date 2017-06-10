package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * Clase para la ventana GUI de ayuda
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class Ayuda extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Ayuda ayuda;
	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Create the dialog.
	 */
	private Ayuda() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setBackground(new Color(102, 204, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/resources/favicon.png")));
		setResizable(false);
		setTitle("Ayuda del ejercicio de repaso nº 1");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(new Color(204, 255, 255));
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 198);
		contentPanel.add(scrollPane);
		{
			JTextPane txtpnAyuda = new JTextPane();
			txtpnAyuda.setEditable(false);
			txtpnAyuda.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			scrollPane.setViewportView(txtpnAyuda);
			txtpnAyuda.setForeground(SystemColor.desktop);
			txtpnAyuda.setToolTipText("Desarrollado por Guillermo Boquizo S\u00E1nchez");
			txtpnAyuda.setBackground(new Color(204, 255, 255));
			txtpnAyuda.setText("Ayuda del ejercicio de repaso n\u00BA 1\r\n\r\nBarra de Men\u00FA\r\nVinculada a un objeto de tipo JMenuBar\r\n\r\nMen\u00FA\r\nVinculados a objetos de tipo JMenu\r\n\r\nElementos del men\u00FA\r\nVinculados a objetos de tipo JMenuItem\r\n\r\nBotones\r\nVinculados a objetos de tipo JButton\r\n\r\nScroller\r\nVinculado a un objeto de tipo ScrollPane\r\n\r\nPaneles de contenido:\r\nVinculados a objetos de tipo JPanel\r\n\r\nEtiquetas:\r\nVinculadas a objetos de tipo JLabel\r\n\r\nIconos:\r\nVinculados a objetos ImageIcon\r\n\r\nPaquetes utilizados:\r\n\r\nEn la clase VentanaPrincipal:\r\n\r\njava.awt.EventQueue;\r\njava.awt.Toolkit;\r\njavax.swing.JFrame;\r\njavax.swing.JPanel;\r\njavax.swing.border.EmptyBorder;\r\njavax.swing.JMenuBar;\r\njavax.swing.JMenu;\r\njavax.swing.JMenuItem;\r\njavax.swing.JSeparator;\r\njava.awt.event.ActionListener;\r\njava.awt.event.ActionEvent;\r\njavax.swing.KeyStroke;\r\njava.awt.event.KeyEvent;\r\njava.awt.event.InputEvent;\r\n\r\nEn la clase AcercaDe:\r\n\r\njava.awt.EventQueue;\r\njava.awt.Toolkit;\r\njavax.swing.JFrame;\r\njavax.swing.JPanel;\r\njavax.swing.border.EmptyBorder;\r\njavax.swing.JMenuBar;\r\njavax.swing.JMenu;\r\njavax.swing.JMenuItem;\r\njavax.swing.JSeparator;\r\njava.awt.event.ActionListener;\r\njava.awt.event.ActionEvent;\r\njavax.swing.KeyStroke;\r\njava.awt.event.KeyEvent;\r\njava.awt.event.InputEvent;\r\n\r\nEn la clase Ayuda:\r\n\r\njava.awt.BorderLayout;\r\njava.awt.Color;\r\njavax.swing.JDialog;\r\njavax.swing.JPanel;\r\njavax.swing.JTextPane;\r\njava.awt.SystemColor;\r\njava.awt.event.ActionEvent;\r\njava.awt.event.ActionListener;\r\njavax.swing.JButton;\r\njava.awt.Toolkit;\r\njava.awt.ComponentOrientation;\r\njavax.swing.JScrollPane;\r\njavax.swing.border.BevelBorder;");
		}
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnAceptar.setBackground(new Color(255, 204, 204));
		btnAceptar.setToolTipText("Pulsa para salir");
		btnAceptar.setBounds(313, 229, 91, 23);
		contentPanel.add(btnAceptar);
	}

	/**
	 * Método que permite instanciar una sola ventana de ayuda, según el patrón Singleton
	 * @return
	 */
	public static Ayuda getInstance() {
		if (ayuda == null)
			ayuda = new Ayuda();
		return ayuda;
	}
}
