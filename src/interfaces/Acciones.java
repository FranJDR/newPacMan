package interfaces;

import java.awt.Graphics;

import herramientas.Teclado;

public abstract interface Acciones {

	public void dibujar(Graphics g);

	public void mover(Teclado teclado);

}
