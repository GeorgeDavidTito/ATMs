package algoritmos;
/*
 * ASUMIMOS QUE:
 * 
 * N y M son números enteros dentro del intervalo [1, 30.000]
 * Cada elemento de los arreglos A, B, C es un número entero dentro del rango [1, 2 * M];
 * A [K] ≤ B [K].
 * Cada elemento del arreglo C esta comprendido en algun elemento de A [K] y B [K].
 * 
 * */

public class ClavandoTablones {

	public static void main(String[] args) {

		int[] arregloA = { 1, 4, 5, 8 };
		int[] arregloB = { 4, 5, 9, 10 };
		int[] arregloC = { 4, 6, 7, 10, 2 };

		System.out.println(solucion(arregloA, arregloB, arregloC));

	}

	/*
	 * Como estrategia utilizamos una busqueda binaria, ya que tiene complejidad
	 * cuadratica
	 */

	public static int solucion(int[] arregloA, int[] arregloB, int[] arregloC) {

		int inicio = 0;
		int fin = arregloC.length;
		int numMinimoClavos = -1;
		int mitad;
		while (fin >= inicio) {

			mitad = (inicio + fin) / 2;

			if (buscar(arregloA, arregloB, arregloC, mitad)) {
				fin = mitad - 1;
				numMinimoClavos = mitad;
			} else {
				inicio = mitad + 1;
			}
		}

		return numMinimoClavos;

	}

	public static boolean buscar(int[] arregloA, int[] arregloB, int[] arregloC, int m) {

		int[] clavos = new int[2 * arregloC.length + 1];

		for (int i = 0; i < m; i++) {

			clavos[arregloC[i]] += 1;

		}

		for (int i = 1; i < clavos.length; i++) {
			clavos[i] += clavos[i - 1];

		}

		for (int i = 0; i < arregloA.length; i++) {
			if (esCero(clavos[arregloB[i]], clavos[arregloA[i] - 1])) {

				return false;
			}
		}
		return true;
	}

	public static boolean esCero(int posA, int posB) {

		return (posA - posB) == 0;
	}
}
