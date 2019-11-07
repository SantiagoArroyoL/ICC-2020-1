package practica14;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LectorCSV {

	public static List<String[]> leer(String ruta) throws IOException {

	List<String> lineas = Files.readAllLines(Paths.get(ruta));

	// 18.0, -255.4323426639282


	List<String[]> arregloLineas = null;

	for (String i : lineas) {
		arregloLineas.add(i.trim().split(", "));
		// if (i == " ") {
		// 	throw IOException;
		// }
	}


	return arregloLineas;

	}
}
