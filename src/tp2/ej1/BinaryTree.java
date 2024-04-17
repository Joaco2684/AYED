package tp2.ej1;

import java.util.*;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		if (this.isLeaf())	{
			return 1;
		}
		int suma = 0;
		if (this.hasLeftChild()) {
			suma += this.getLeftChild().contarHojas();
		}
		if (this.hasRightChild()) {
			suma += this.getRightChild().contarHojas();
		}
		return suma;
	}
		
		
    	 
    public BinaryTree<T> espejo(){
    	BinaryTree<T> e = new BinaryTree<T>(this.data);
    	if (this.hasLeftChild()) {
    		e.addRightChild(this.getLeftChild().espejo());
    	}
    	if (this.hasRightChild()) {
    		e.addLeftChild(this.getRightChild().espejo());
    	}
    	return e;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		BinaryTree<T> ab;
		Queue<BinaryTree<T>> cola = new LinkedList<BinaryTree<T>>();
		cola.add(this);
		cola.add(null);
		int nivel = 0;
		while (!cola.isEmpty() && nivel <=m) {
			ab = cola.poll();
			if (ab!=null) {
				if (nivel>= n && nivel <=m) {
					System.out.print(ab.getData());
				}
				if (ab.hasLeftChild()) {
					cola.add(ab.getLeftChild());
				}
				if (ab.hasRightChild()) {
					cola.add(ab.getRightChild());
				}
			} else if (!cola.isEmpty()) {
				nivel++;
				cola.add(null);
			}
		}
			
	}
	
	public void imprimirEntreNiveles() {
		BinaryTree<T> nodo = null;
		Queue<BinaryTree<T>> cola = new LinkedList<BinaryTree<T>>();
		
		cola.add(this);
		cola.add(null);
		while (!cola.isEmpty()) {
			nodo = cola.remove();
			if (nodo != null) {
				System.out.println(nodo.getData());
				if (nodo.hasLeftChild()) {
					cola.add(nodo.getLeftChild());
				}
				if (nodo.hasRightChild()) {
					cola.add(nodo.getRightChild());
				}
			}
			else if (!cola.isEmpty()) {
				cola.add(null);
			}
		}
	}
}
		

