package ajedrez.piezas;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rand = new Random();
		Posicion pos = new Posicion(1,rand.nextInt(8));
		Color color = Color.BLANCO;
		Peon uno = new Peon(color,pos);
		for (int i = 0; i < 10; i++) {
			uno.obtenerJugadasLegales();
			uno.asignarPosicion()
		}

	}
}
