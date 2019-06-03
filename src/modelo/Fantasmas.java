package modelo;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import herramientas.Teclado;

public class Fantasmas {

	private Point posicion;
	private BufferedImage sprite;
	private TipoPersonajes personaje;
	private int ladoSprite = 50;

	public Fantasmas(TipoPersonajes personaje, BufferedImage sprite, Point posicion) {
		super();
		this.personaje = personaje;
		this.posicion = posicion;
		this.sprite = sprite;
	}

	public void mover(Point jugador) {
		switch (this.personaje) {
		case blinky:
			moverBlinky();
			break;
		case inky:
			moverInky();
			break;
		case clyde:
			moverClyde();
			break;
		case pinky:
			moverPinky();
			break;
		default:
			break;
		}

	}

	public void dibujar(Graphics g) {
		g.drawImage(this.sprite.getSubimage(0, 0, 16, 16), (int) posicion.getX(), (int) posicion.getY(), ladoSprite,
				ladoSprite, null);
	};

	private void moverPinky() {
		// TODO Auto-generated method stub

	}

	private void moverClyde() {
		// TODO Auto-generated method stub

	}

	private void moverInky() {
		// TODO Auto-generated method stub

	}

	private void moverBlinky() {
		// TODO Auto-generated method stub

	}

	public Point getPosicion() {
		return posicion;
	}

	public TipoPersonajes getPersonaje() {
		return personaje;
	}

	public double getY() {
		return this.posicion.getY();
	}

	public double getX() {
		return this.posicion.getX();
	}

}
