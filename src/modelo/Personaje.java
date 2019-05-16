package modelo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import interfaces.Acciones;

public class Personaje implements Acciones {

	private Point posicion;
	private BufferedImage sprite;
	private TipoPersonajes personaje;
	private int ladoSprite = 50;

	public Personaje(TipoPersonajes personaje, BufferedImage sprite, Point posicion) {
		super();
		this.personaje = personaje;
		this.posicion = posicion;
		this.sprite = sprite;
	}

	@Override
	public void mover(Teclado teclado) {
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
		case pacman:
			moverPacman(teclado);
			break;
		}

	}

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(this.sprite.getSubimage(0, 0, 16, 16), (int) posicion.getX(), (int) posicion.getY(), ladoSprite,
				ladoSprite, null);
	};

	private void moverPacman(Teclado teclado) {
		// TODO Auto-generated method stub

	}

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

}
