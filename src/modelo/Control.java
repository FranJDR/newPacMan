package modelo;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import herramientas.Lector;
import herramientas.Sprite;
import herramientas.Teclado;

public class Control {

	private Teclado teclado;
	private Lector lector;
	private Sprite sprite;
	private Jugador jugador;
	private ArrayList<Fantasmas> fantasmas;

	public Control() {
		super();
		this.teclado = new Teclado();
		this.sprite = new Sprite();
		this.lector = new Lector();
		this.fantasmas = new ArrayList<Fantasmas>();
		this.fantasmas.add(new Fantasmas(TipoPersonajes.blinky, this.sprite.getBlinky(), new Point(300, 300)));
		this.fantasmas.add(new Fantasmas(TipoPersonajes.clyde, this.sprite.getClyde(), new Point(200, 200)));
		this.fantasmas.add(new Fantasmas(TipoPersonajes.inky, this.sprite.getInky(), new Point(100, 100)));
		this.fantasmas.add(new Fantasmas(TipoPersonajes.pinky, this.sprite.getPinky(), new Point(250, 250)));
		this.jugador = new Jugador(new Point(400, 400), this.sprite.getPacman());
	}

	public void dibujar(Graphics g) {
		for (int i = 0; i < this.lector.getMatrizMapa().length; i++) {
			for (int j = 0; j < this.lector.getMatrizMapa()[i].length; j++) {
				if (this.lector.getMatrizMapa()[i][j] == 0)
					g.drawImage(this.sprite.getSubimageCocos(0, 0, 47, 47), j * 30, i * 30, 25, 25, null);
				if (this.lector.getMatrizMapa()[i][j] == 3)
					g.drawImage(this.sprite.getSubimageCocos(47, 0, 47, 47), j * 30, i * 30, 25, 25, null);
			}
		}
		dibujarPersonajes(g);
	}

	public void moverPersonajes() {
		this.jugador.mover(this.teclado);
		for (Fantasmas fantasmas : this.fantasmas) {
			fantasmas.mover(this.jugador.getPosicion());
		}
		getComerCocos();
	}

	private void dibujarPersonajes(Graphics g) {
		this.jugador.dibujar(g);
		for (Fantasmas fantasmas : this.fantasmas) {
			fantasmas.dibujar(g);
		}
	}

	private void getComerCocos() {
		int i = (int) this.jugador.getY() / 30;
		int j = (int) this.jugador.getX() / 30;
		if (this.lector.getMatrizMapa()[i][j] == 0)
			this.lector.getMatrizMapa()[i][j] = 2;
	}

	public BufferedImage getMapa() {
		return this.sprite.getMap01();
	}

	public Teclado getTeclado() {
		return teclado;
	}

	public void actualizarTeclado() {
		this.teclado.actualizar();
	}

}
