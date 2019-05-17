package herramientas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Sprite {

	private int ladoSprite = 16;

	private BufferedImage map01;

	private BufferedImage pacman;
	private BufferedImage blinky;
	private BufferedImage clyde;
	private BufferedImage inky;
	private BufferedImage pinky;

	private BufferedImage cocos;

	public Sprite() {
		super();
		BufferedImage spriteFantasmas = obtenerImagen("./Sprite/SpriteFantasmas.png");

		int ancho = spriteFantasmas.getWidth();
		int alto = spriteFantasmas.getHeight() / 4;

		this.blinky = spriteFantasmas.getSubimage(0 * this.ladoSprite, 0 * this.ladoSprite, ancho, alto);
		this.clyde = spriteFantasmas.getSubimage(0 * this.ladoSprite, 1 * this.ladoSprite, ancho, alto);
		this.inky = spriteFantasmas.getSubimage(0 * this.ladoSprite, 2 * this.ladoSprite, ancho, alto);
		this.pinky = spriteFantasmas.getSubimage(0 * this.ladoSprite, 3 * this.ladoSprite, ancho, alto);

		this.map01 = obtenerImagen("./Sprite/map01.png");

		this.pacman = obtenerImagen("./Sprite/SpritePacMan.png");

		this.cocos = obtenerImagen("./Sprite/SpritePuntos.png");
	}

	public static BufferedImage obtenerImagen(String ruta) {
		BufferedImage retorno = null;
		try {
			retorno = ImageIO.read(new File(ruta));
		} catch (Exception e) {
		}
		return retorno;
	}

	public BufferedImage getMap01() {
		return map01;
	}

	public BufferedImage getPacman() {
		return pacman;
	}

	public BufferedImage getBlinky() {
		return blinky;
	}

	public BufferedImage getClyde() {
		return clyde;
	}

	public BufferedImage getInky() {
		return inky;
	}

	public BufferedImage getPinky() {
		return pinky;
	}

	public BufferedImage getCocos() {
		return cocos;
	}

	public Image getSubimageCocos(int x, int y, int w, int h) {
		return this.cocos.getSubimage(x, y, w, h);
	}

}
