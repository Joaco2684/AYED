package tp2.ej3;

import java.util.LinkedList;
import java.util.List;

import tp2.ej1.BinaryTree;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;

	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public LinkedList<Integer> numerosPares() {
		LinkedList<Integer> lista = new LinkedList<>();
		if(!arbol.isEmpty()) {
			//Invocar cualquiera de los modulos.
			paresPre(lista,arbol);
		}
		return lista;
	}
	
	private void paresPre(LinkedList<Integer> l, BinaryTree<Integer> a) {
		if (a.getData() % 2 == 0) {
			l.add(a.getData());
		}
		if (a.hasLeftChild()) {
			paresPre(l,a.getLeftChild());
		}
		if (a.hasRightChild()) {
			paresPre(l,a.getRightChild());
		}	
	}	
	
	private void paresPost(LinkedList<Integer> l, BinaryTree<Integer> a) {
		if (a.hasLeftChild()) {
			paresPre(l,a.getLeftChild());
		}
		if (a.hasRightChild()) {
			paresPre(l,a.getRightChild());
		}
		if (a.getData() % 2 == 0) {
			l.add(a.getData());
		}
	}	
	
	private void paresIn(LinkedList<Integer> l, BinaryTree<Integer> a) {
		if (a.hasLeftChild()) {
			paresPre(l,a.getLeftChild());
		}
		if (a.getData() % 2 == 0) {
			l.add(a.getData());
		}
		if (a.hasRightChild()) {
			paresPre(l,a.getRightChild());
		}	
	}	
}
