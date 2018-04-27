package algoritmos;
/*
 * ASUMIMOS QUE:
 * 
 * No hay distinción entre mayúsculas y minúsculas
 * Si N = cadena.length() y M = subcadena.length()
 * Entonces:  N > M.
 *  
 * */

import java.util.Arrays;

public class BuscandoAnagramas {

	public static void main(String[] args) {

		System.out.println(solucion("hola, que buena ola Laomir", "OAL"));
	}

	public static int solucion(String cadena, String subCadena) {

		String cadenaMay = cadena.toUpperCase();
		String subCadenaMay = subCadena.toUpperCase();
		String nuevaSubCadena = new String();

		int tamañoSubCadena = subCadenaMay.length();
		int fin = cadenaMay.length() - tamañoSubCadena;
		int cantidadAnagramas = 0;

		for (int ind = 0; ind <= fin; ind++, tamañoSubCadena++) {

			nuevaSubCadena = cadenaMay.substring(ind, tamañoSubCadena);

			if (esAnagrama(nuevaSubCadena, subCadenaMay)) {
				cantidadAnagramas++;
			}
		}

		return cantidadAnagramas;
	}

	public static boolean esAnagrama(String s1, String s2) {

		char[] array1 = s1.toCharArray();
		char[] array2 = s2.toCharArray();

		Arrays.sort(array1);
		Arrays.sort(array2);
		return new String(array1).equals(new String(array2));
	}

}
