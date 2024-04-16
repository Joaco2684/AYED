package tp1.ej2;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] a;
		a = creadorDeArray.generarArray(s.nextInt());
		for (int i:a) {
			System.out.println(i);
		}
	}
}
