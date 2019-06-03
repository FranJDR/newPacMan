package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import herramientas.Teclado;
import modelo.Control;

public class Lienzo extends java.awt.Canvas {

	private BufferedImage imgMap;

	private int ancho = 0, alto = 0;

	public Lienzo(BufferedImage imgMap, Teclado teclado) {
		super();
		this.ancho = imgMap.getWidth();
		this.alto = imgMap.getHeight();
		this.imgMap = imgMap;

		addKeyListener(teclado);
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(this.ancho, this.alto));
		setFocusable(true);
		requestFocus();
	}

	public void dibujar(Control mapa) {
		BufferStrategy buffer = getBufferStrategy();
		if (buffer == null) {
			createBufferStrategy(4);
			return;
		}
		Graphics g = buffer.getDrawGraphics();

		// dibujar
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1920, 1080);
		g.drawImage(this.imgMap.getSubimage(0, 0, this.imgMap.getWidth(), this.imgMap.getHeight()), 7, 0, null);
		mapa.dibujar(g);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		buffer.show();
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public BufferedImage getImg() {
		return imgMap;
	}

}
