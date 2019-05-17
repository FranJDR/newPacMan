package control;

import herramientas.Teclado;
import modelo.Control;
import vista.Lienzo;
import vista.Ventana;

public class Juego {

	private Teclado teclado;
	private Ventana ventana;
	private Lienzo lienzo;
	private Control control;

	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.play();
	}

	public void play() {
		this.teclado = new Teclado();
		this.control = new Control();
		this.lienzo = new Lienzo(this.control.getMapa(), this.teclado);
		this.ventana = new Ventana(this.lienzo);
		buclePrincipal();
	}

	private void buclePrincipal() {
		boolean salir = false;
		do {
			this.lienzo.dibujar(this.control);
		} while (!salir);

	}

}
