package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -5312021087947087655L;

	private JPanel principal;

	public Ventana(Lienzo canvas) {
		super();
		crearVentana(canvas);
	}

	private void crearVentana(Lienzo canvas) {
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PAC-MAN");
		setUndecorated(false);
		setResizable(false);
		setVisible(true);
		setBounds(20, 20, canvas.getAncho()+30, canvas.getAlto() + 30);
		setLocationRelativeTo(null);
		getContentPane().add(canvas);
	}

}
