package controles;

import java.util.Scanner;
import java.util.*;

public class PrimerControl {

	// VARIABLES STATIC

	static double suma = 0;
	static final double precio = 1.45;
	static double gasto;

	public static void main(String[] args) {

		// SCANNER

		Scanner sc = new Scanner(System.in);

		System.out.println(
				"Introduzca sus datos separados por comas en el siguiente orden: " + "email, nombre, apellido:");
		StringTokenizer entrada = new StringTokenizer(sc.nextLine(), ", ");

		// VARIABLES SCANNER

		String email = entrada.nextToken();
		String nombre = entrada.nextToken();
		String apellido = entrada.nextToken();

		// EMAIL CORRECTO?

		if (emailBoolean(email) == false) {
			do {
				System.err.println("Su email es incorrecto, introdúzcalo nuevamente:");
				email = sc.nextLine();
			} while (emailBoolean(email) == false);
		}

		// NOMBRE CORRECTO?

		if (nombreBoolean(nombre) == false) {
			do {
				System.err.println("Su nombre es incorrecto, introdúzcalo nuevamente:");
				nombre = sc.nextLine();
			} while (nombreBoolean(nombre) == false);
		}

		// APELLIDO CORRECTO?

		if (apellidoBoolean(apellido) == false) {
			do {
				System.err.println("Su apellido es incorrecto, introdúzcalo nuevamente:");
				apellido = sc.nextLine();
			} while (apellidoBoolean(apellido) == false);
		}

		// EMAIL, NOMBRE, APELLIDO CORRECTO

		if (emailBoolean(email) == true && nombreBoolean(nombre) == true && apellidoBoolean(apellido) == true) {
			System.out.println("Inicio de sesión correcto");
			array();
		}

		sc.close();

	}

	public static boolean emailBoolean(String email) {

		// COMPROBACION EMAIL

		int contador = 0;
		if (email.length() > 15) {
			contador += 1;
		}
		if (email.substring((email.length() - 4), (email.length())).equals(".com")) {
			contador += 1;
		}
		if (email.substring(1, email.length()).contains("@")) {
			contador += 1;
		}

		if (contador == 3)
			return true;
		else
			return false;
	}

	public static boolean nombreBoolean(String nombre) {

		// COMPROBACION NOMBRE

		if (nombre.substring(0, 1).equals("L") && nombre.substring(1, 2).equals("U")
				&& nombre.substring(2, nombre.length()).equals("Z"))
			return true;
		else
			return false;
	}

	public static boolean apellidoBoolean(String apellido) {

		// COMPROBACION APELLIDO

		if (apellido.substring(0, 1).equals("c") && apellido.substring(1, 2).equals("a")
				&& apellido.substring(2, 3).equals("r") && apellido.substring(3, 4).equals("i")
				&& apellido.substring(4, 5).equals("t") && apellido.substring(5, apellido.length()).equals("a"))
			return true;
		else
			return false;
	}

	public static void array() {

		// RELLENAR

		double[][] array = new double[5][7];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (10 * Math.random());
			}
		}

		array[array.length - 5][array[array.length - 5].length - 7] = 0;

		for (int j = (array[array.length - 1].length - 4); j < (array[array.length - 1].length); j++) {
			array[4][j] = 0;
		}

		// IMPRIMIR

		System.out.print("\nTabla de gasto de luz en kWh/día durante el mes de noviembre:");
		System.out.print("\nLUN  | MAR  | MIER | JUEV | VIER | SAB  | DOM  |");
		for (int i = 0; i < array.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < array[i].length; j++) {
				System.out.printf("%.2f | ", array[i][j]);
			}
		}

		// SUMAR

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				suma += array[i][j];
			}
		}

		// MULTIPLICAR

		gasto = suma * precio;
		System.out.printf("\n\nEl gasto total del mes es %.2f€", suma);

		// NO ME HA DADO TIEMPO A CALCULAR EL MAYOR GASTO EN UN DÍA

	}

}
