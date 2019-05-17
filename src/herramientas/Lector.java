package herramientas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lector {

	private int[][] matrizMapa = new int[31][28];
	private String ruta = "./Archivos/01.txt";
	private String cadena = "";

	public static void main(String[] args) {
		Lector lector = new Lector();
	}

	public Lector() {
		super();
		leerArchivo();
		crearMatrizNum();
	}

	private void leerArchivo() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(this.ruta);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				this.cadena += linea;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void crearMatrizNum() {
		String[] aux = this.cadena.split(" ");
		for (int i = 0, k = 0; i < this.matrizMapa.length; i++) {
			for (int j = 0; j < this.matrizMapa[i].length; j++, k++) {
				this.matrizMapa[i][j] = Integer.valueOf(aux[k]);
			}
		}
	}

	public int[][] getMatrizMapa() {
		return matrizMapa;
	}

}
