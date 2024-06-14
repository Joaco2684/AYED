package tp2.ejercicio9;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
	
	private static void sumAndDifHelper(BinaryTree<Integer> tree, BinaryTree<SumDif> sad,int sum,int parent) {
		SumDif sumAndDif = new SumDif(sum+tree.getData(), tree.getData()-parent);
		sad.setData(sumAndDif);
		
		if (tree.hasLeftChild()) {
			sad.addLeftChild(new BinaryTree<SumDif>());
			sumAndDifHelper(tree.getLeftChild(),sad.getLeftChild(),sum+tree.getData(),tree.getData());
		}
		
		if (tree.hasRightChild()) {
			sad.addRightChild(new BinaryTree<SumDif>());
			sumAndDifHelper(tree.getRightChild(),sad.getRightChild(),sum+tree.getData(),tree.getData());
		}
		
	}
	
	public BinaryTree<SumDif> sumAndDif(BinaryTree<Integer> arbol) {
		BinaryTree<SumDif> a = new BinaryTree<>();
		sumAndDifHelper(arbol,a,0,0);
		return a;
	}
}
