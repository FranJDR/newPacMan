package modelo;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import herramientas.Lector;
import herramientas.Sprite;
import herramientas.Teclado;
import interfaces.Acciones;

public class Control {

	private Lector lector;
	private Sprite sprite;

	private ArrayList<Personaje> personajes = new ArrayList<Personaje>();

	private BufferedImage cocos;

	public Control() {
		super();
		this.sprite = new Sprite();
		this.lector = new Lector();
		this.cocos = sprite.getCocos();

		this.personajes.add(new Personaje(TipoPersonajes.pacman, this.sprite.getPacman(), new Point(400, 400)));
		this.personajes.add(new Personaje(TipoPersonajes.blinky, this.sprite.getBlinky(), new Point(300, 300)));
		this.personajes.add(new Personaje(TipoPersonajes.clyde, this.sprite.getClyde(), new Point(200, 200)));
		this.personajes.add(new Personaje(TipoPersonajes.inky, this.sprite.getInky(), new Point(100, 100)));
		this.personajes.add(new Personaje(TipoPersonajes.pinky, this.sprite.getPinky(), new Point(250, 250)));

	}

	public void dibujar(Graphics g) {
		for (int i = 0; i < this.lector.getMatrizMapa().length; i++) {
			for (int j = 0; j < this.lector.getMatrizMapa()[i].length; j++) {
				if (this.lector.getMatrizMapa()[i][j] == 0)
//					g.drawImage(this.cocos.getSubimage(0, 0, 47, 47), j * 30, i * 30, 25, 25, null);
					if (this.lector.getMatrizMapa()[i][j] == 3)
//					g.drawImage(this.cocos.getSubimage(47, 0, 47, 47), j * 30, i * 30, 25, 25, null);
						g.drawImage(this.sprite.getCocos().getSubimage(47, 0, 47, 47), j * 30, i * 30, 25, 25, null);
			}
		}
		dibujarPersonajes(g);
	}

	public void moverPersonajes(Teclado teclado) {
		for (Acciones personaje : this.personajes) {
			personaje.mover(teclado);
		}
		getComerCocos();
	}

	private void dibujarPersonajes(Graphics g) {
		for (Acciones personaje : this.personajes) {
			personaje.dibujar(g);
		}
	}

	private void getComerCocos() {
		for (Personaje personaje : this.personajes) {
			if (personaje.getPersonaje() == TipoPersonajes.pacman) {
				int i = (int) personaje.getY() / 30;
				int j = (int) personaje.getX() / 30;
				if (this.lector.getMatrizMapa()[i][j] == 0)
					this.lector.getMatrizMapa()[i][j] = 2;
				break;
			}
		}
	}

	public BufferedImage getMapa() {
		return this.sprite.getMap01();
	}

}
