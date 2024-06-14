package tp2.ejercicio6;

import tp2.ejercicio2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> suma() {
		sumaRec(arbol);
		return arbol;
	}
	
	private int sumaRec(BinaryTree<Integer> a) {
		if (a.isLeaf()) {
			int peso = a.getData();
			a.setData(0);
			return peso;
		}
		int suma = 0;
		if (a.hasLeftChild()) {
			suma += sumaRec(a.getLeftChild());
		}
		if (a.hasRightChild()) {
			suma += sumaRec(a.getRightChild());
		}
		int act = a.getData();
		a.setData(suma);
		return suma + act;
	}
}
