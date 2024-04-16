package tp1.ej2;

public class creadorDeArray {
	
	public static int[] generarArray(int n) {
		int[] vector = new int[n];
		for (int i=0; i<vector.length; i++) {
			vector[i] = n*(i+1);
		}
		return vector;
	}
	
	
}
