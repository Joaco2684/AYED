package tp2.ej4;

import java.util.LinkedList;
import java.util.Queue;

import tp2.ej1.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;

	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public void imprimirArbol(BinaryTree<Integer> arbol) {
		if (arbol.hasLeftChild()) {
			imprimirArbol(arbol.getLeftChild());
		}
		System.out.print(arbol.getData());
		if (arbol.hasRightChild()) {
			imprimirArbol(arbol.getRightChild());
		}
	}
	
	public int retardoReenvio() { //Por niveles
		int tot = 0;
		BinaryTree<Integer> ab;
		Queue<BinaryTree<Integer>> cola = new LinkedList<BinaryTree<Integer>>();
		cola.add(this.arbol);
		cola.add(null);
		int max = -1;
		while (!cola.isEmpty()) {
			ab = cola.poll();
			if (ab != null) {
				max = Math.max(max, ab.getData());
				if (ab.hasLeftChild()) {
					cola.add(ab.getLeftChild());
				}
				if (ab.hasRightChild()) {
					cola.add(ab.getRightChild());			
				}
			} else {
				tot += max;
				max = 0;
				if (!cola.isEmpty()) { //Cuando la cola esta vacia(ultimo nivel) procesa igual el max
					cola.add(null); 
				}
				
			}
		}
		
		return tot;
	}
	
	public int retardoReenvio(BinaryTree<Integer> red) { //Pot profundidad
        int retHI = 0;
        int retHD = 0;
        if(red.hasLeftChild())
            retHI = retardoReenvio(red.getLeftChild());
        if(red.hasRightChild())
            retHD = retardoReenvio(red.getRightChild());
        return (Math.max(retHI, retHD)+ red.getData());
    }
	
	public static void main (String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
		ab.addLeftChild(new BinaryTree<Integer>(2));
		ab.addRightChild(new BinaryTree<Integer>(6));
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
		RedBinariaLlena red = new RedBinariaLlena(ab);
		
		System.out.print("El mayor retardo posible es de: " + red.retardoReenvio() + " segundos.");
		System.out.print("El mayor retardo posible es de: " + red.retardoReenvio(ab) + " segundos.");
	}
	
}
