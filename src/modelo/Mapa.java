package modelo;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import interfaces.Acciones;

public class Mapa implements Acciones {

	private int[][] colisionables;

	private BufferedImage cocos;

	public Mapa(int[][] colisionables, BufferedImage cocos) {
		super();
		this.colisionables = colisionables;
		this.cocos = cocos;
	}

	public void getComerCocos(Point point) {
		int i = (int) point.getY() / 30;
		int j = (int) point.getX() / 30;
		if (this.colisionables[i][j] == 0)
			this.colisionables[i][j] = 2;
	}

	@Override
	public void dibujar(Graphics g) {
		for (int i = 0; i < colisionables.length; i++) {
			for (int j = 0; j < colisionables[i].length; j++) {
				if (colisionables[i][j] == 0)
					g.drawImage(this.cocos.getSubimage(0, 0, 47, 47), j * 30, i * 30, 25, 25, null);
				if (colisionables[i][j] == 3)
					g.drawImage(this.cocos.getSubimage(47, 0, 47, 47), j * 30, i * 30, 25, 25, null);
			}
		}

	}

	@Override
	public void mover(Teclado teclado) {
	}

}
