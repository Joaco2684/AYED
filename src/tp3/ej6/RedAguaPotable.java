package tp3.ej6;

import tp3.ej1ej3ej5.GeneralTree;

public class RedAguaPotable {
	GeneralTree<Character> arbol;

	public RedAguaPotable(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}
	
	public double minimoCaudal(double caudal) {
		if (!arbol.isEmpty()) {
			return calcularMin(caudal, arbol);
		}
		return -1;
	}
	
	private double calcularMin(double caudal, GeneralTree<Character> nodo) {
		if (nodo.isLeaf()) {
			return caudal;
		}
		double min = 9999;
		double cantCaudAct = caudal / nodo.getChildren().size();
		for (GeneralTree<Character> hijo: nodo.getChildren()) {
			double cantHijo = calcularMin(cantCaudAct, hijo);
			min = Math.min(min, cantHijo);
		}
		return min;
	}
	
}
