package tp2.ejercicio7;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
	BinaryTree<Integer> arbol;

	public ParcialArboles(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	private BinaryTree<Integer> buscarSub(BinaryTree<Integer> a, int num) {
		if (a.isLeaf()) return null;
		if (a.getData() == num) return a;
		BinaryTree<Integer> aux = null;
		if (a.hasLeftChild()) {
			aux = buscarSub(a.getLeftChild(), num);
		}
		if (a.hasRightChild() && aux==null) {
			aux = buscarSub(a.getRightChild(), num);
		}
		return aux;
	}
	
	private int contarHijosUnicos(BinaryTree<Integer> a) {
		if (a.isLeaf()) {
			return 0;
		}
		if (!a.hasLeftChild() && a.hasRightChild()) {
			return 1 + contarHijosUnicos(a.getRightChild());
		}
		if (a.hasLeftChild() && !a.hasRightChild()) {
			return 1 + contarHijosUnicos(a.getLeftChild());
		}
		return contarHijosUnicos(a.getLeftChild()) + contarHijosUnicos(a.getRightChild());
	}
	
	private boolean esIzquierdo(BinaryTree<Integer> a) {
		int iz=-1;
		int der=-1;
		if (a.hasLeftChild()) {
			iz = contarHijosUnicos(a.getLeftChild());
		}
		if (a.hasRightChild()) {
			der = contarHijosUnicos(a.getRightChild());
		}
		return (iz>der);
	}
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> subArbol = buscarSub(arbol,num);
		
		if (subArbol==null) {
			return false;
		}
		return esIzquierdo(subArbol);
	}
	
	 public static void main (String[] args) { 
	        System.out.println("Test Ejercicio 7");
	        
	        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
	        ab.addLeftChild(new BinaryTree<Integer>(7));
	        ab.addRightChild(new BinaryTree<Integer>(-5));
	        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
	        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
	        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
	        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
	        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
	        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
	        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
	        ab.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
	        ab.entreNiveles(0, 4);
	        
	        ParcialArboles parcialArb = new ParcialArboles(ab);
	        System.out.println("Resultado=" + parcialArb.isLeftTree(7));
	        System.out.println("Resultado=" + parcialArb.isLeftTree(2));
	        System.out.println("Resultado=" + parcialArb.isLeftTree(-5));
	        System.out.println("Resultado=" + parcialArb.isLeftTree(19));
	        System.out.println("Resultado=" + parcialArb.isLeftTree(-3));
	    }
	
	
}
