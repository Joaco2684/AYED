package tp2.ej8;

import tp2.ej1.BinaryTree;

public class ParcialArboles {

	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1.isEmpty() || arbol2.isEmpty()) {
			return arbol1.isEmpty() && arbol2.isEmpty(); //Devuelve true si los dos arboles estan vacio => es Prefijo
		}
		return verificarTodo(arbol1,arbol2);
	}
	
	private boolean verificarTodo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1.getData() == arbol2.getData()) {
			return true;
		}
		boolean es = true;
		if (arbol1.hasLeftChild()) {
			if (arbol2.hasLeftChild()) {
				es = es && verificarTodo(arbol1.getLeftChild(), arbol2.getRightChild());
			} else {
				return false;
			}
		}
		if (arbol1.hasRightChild()) {
			if (arbol2.hasRightChild()) {
				es = es && verificarTodo(arbol1.getRightChild(), arbol2.getRightChild());
			} else {
				return false;
			}
		}
		return es;
		
	}
	
}
