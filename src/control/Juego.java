package control;

import modelo.Control;
import vista.Lienzo;
import vista.Ventana;

public class Juego {

	private Lienzo lienzo;
	private Control control;
	private Ventana ventana;

	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.play();
	}

	public void play() {
		this.control = new Control();
		this.lienzo = new Lienzo(this.control.getMapa(), this.control.getTeclado());
		this.ventana = new Ventana(this.lienzo);
		buclePrincipal();
	}

	private void buclePrincipal() {
		boolean salir = false;
		do {
			this.control.actualizarTeclado();
			this.lienzo.dibujar(this.control);
			this.control.moverPersonajes();
		} while (!salir);

	}

}
