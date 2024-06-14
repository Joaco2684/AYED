package tp2.ejercicio4;

import tp2.ejercicio2.BinaryTree;

public class RedBinariaLlena {
	
	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public int retardoReenvio() {
		if (!arbol.isEmpty()) {
			return calculcarRetardo(arbol);
		}
		return -1;
	}
	
	private int calculcarRetardo(BinaryTree<Integer> a) {
		int iz = 0;
		int der = 0;
		if (a.hasLeftChild()) {
			iz  = calculcarRetardo(a.getLeftChild());
		}
		if (a.hasRightChild()) {
			der = calculcarRetardo(a.getRightChild());
		}
		return Math.max(iz, der)+a.getData();
	}
}
