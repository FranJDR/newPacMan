package modelo;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import herramientas.Teclado;

public class Jugador {

	private Point posicion;
	private BufferedImage sprite;
	private int ladoSprite = 50;

	private int imgFila = 0;
	private int imgColumna = 0;

	private BufferedImage[][] spriteDireccion = new BufferedImage[4][3];

	public Jugador(Point posicion, BufferedImage sprite) {
		super();
		this.posicion = posicion;
		this.sprite = sprite;
		for (int i = 0, j = 2; i < 2; i++, j++) {
			this.spriteDireccion[0][j] = sprite.getSubimage(i * 16, j * 16, 16, 16);
			this.spriteDireccion[1][j] = sprite.getSubimage(i * 16, j * 16, 16, 16);
			this.spriteDireccion[2][i] = sprite.getSubimage(i * 16, j * 16, 16, 16);
			this.spriteDireccion[3][i] = sprite.getSubimage(i * 16, j * 16, 16, 16);
		}
		for (int k = 0; k < spriteDireccion.length; k++) {
			this.spriteDireccion[k][2] = sprite.getSubimage(4 * 16, 0 * 16, 16, 16);
		}

	}

	public void dibujar(Graphics g) {
		g.drawImage(this.sprite.getSubimage(0, 0, 16, 16), (int) posicion.getX(), (int) posicion.getY(), ladoSprite,
				ladoSprite, null);
	}

	public void mover(Teclado teclado) {
		teclado.actualizar();
		if (this.imgColumna == 3)
			this.imgColumna = 0;

		String direccion = teclado.getDiereccion();
		switch (direccion) {
		case "N":
			this.getPosicion().translate(0, -1);
			this.imgFila = 0;
			break;
		case "S":
			this.getPosicion().translate(0, 1);
			this.imgFila = 0;
			break;
		case "E":
			this.getPosicion().translate(1, 0);
			this.imgFila = 0;
			break;
		case "O":
			this.getPosicion().translate(-1, 0);
			this.imgFila = 0;
			break;
		default:
			break;
		}

		this.imgColumna++;

	}

	public Point getPosicion() {
		return posicion;
	}

	public double getX() {
		return this.posicion.getX();
	}

	public double getY() {
		return this.posicion.getY();
	}

}
