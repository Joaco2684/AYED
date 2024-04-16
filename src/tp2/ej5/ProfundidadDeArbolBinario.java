package tp2.ej5;

import tp2.ej1.BinaryTree;

public class ProfundidadDeArbolBinario {
	
	private BinaryTree<Integer> arbol;
	
	
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}


	public int sumaElementosProfundidad(int p) {
		return sumaRecursiva(this.arbol,p,0);
	}
	
	private int sumaRecursiva(BinaryTree<Integer> a, int p, int n) {
		
		if (n==p) {
			return a.getData();
		} 
		int suma = 0;
		if (a.hasLeftChild()) {
			suma+= sumaRecursiva(a.getLeftChild(), p, n+1);
		}
		if (a.hasRightChild()) {
			suma += sumaRecursiva(a.getRightChild(), p, n+1);
		}
		return suma;
	}
	

	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
		ab.addLeftChild(new BinaryTree<Integer>(2));
		ab.addRightChild(new BinaryTree<Integer>(6));
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
		ProfundidadDeArbolBinario metodo = new ProfundidadDeArbolBinario(ab);
		System.out.println(metodo.sumaElementosProfundidad(2));
	}

}
