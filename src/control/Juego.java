package control;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import interfaces.Acciones;
import modelo.Lector;
import modelo.Mapa;
import modelo.Personaje;
import modelo.Sprite;
import modelo.Teclado;
import modelo.TipoPersonajes;
import vista.Lienzo;
import vista.Ventana;

public class Juego {

	private Teclado teclado;
	private Lienzo lienzo;
	private Ventana ventana;
	private Sprite sprite;
	private Lector lector;

	private ArrayList<Acciones> personajes;

	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.play();
	}

	public void play() {
		this.sprite = new Sprite();
		this.teclado = new Teclado();
		this.lienzo = new Lienzo(this.sprite.getMap01(), this.teclado);
		this.ventana = new Ventana(this.lienzo);
		this.lector = new Lector();

		this.personajes = new ArrayList<Acciones>();
		this.personajes.add(new Mapa(this.lector.getMatrizMapa(), this.sprite.getCocos()));
		this.personajes.add(new Personaje(TipoPersonajes.pacman, this.sprite.getPacman(), new Point(400, 400)));
		this.personajes.add(new Personaje(TipoPersonajes.blinky, this.sprite.getBlinky(), new Point(300, 300)));
		this.personajes.add(new Personaje(TipoPersonajes.clyde, this.sprite.getClyde(), new Point(200, 200)));
		this.personajes.add(new Personaje(TipoPersonajes.inky, this.sprite.getInky(), new Point(100, 100)));
		this.personajes.add(new Personaje(TipoPersonajes.pinky, this.sprite.getPinky(), new Point(250, 250)));

		buclePrincipal();
	}

	private void buclePrincipal() {
		boolean salir = false;
		do {
			this.lienzo.dibujar(this.personajes);
			for (Acciones personaje : this.personajes) {
				personaje.mover(this.teclado);
			}
		} while (!salir);

	}

}
