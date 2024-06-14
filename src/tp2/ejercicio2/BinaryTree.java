package tp2.ejercicio2;


import tp1.ej8.Queue;

public class BinaryTree<T> {
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
	
	public int contarHojas() {
		if (this.isLeaf()) {
			return 1;
		}
		
		int sum = 0;
		if (this.hasRightChild()) {
			sum += this.getRightChild().contarHojas();
			
		}
		if (this.hasLeftChild()) {
			sum += this.getLeftChild().contarHojas();
		}
		return sum;
	}
	
	public BinaryTree<T> espejo(){
		BinaryTree<T> aux = new BinaryTree<>(this.getData());
		if (this.hasLeftChild()) {
			aux.addRightChild(this.getLeftChild().espejo());
		}
		if (this.hasRightChild()) {
			aux.addLeftChild(this.getLeftChild().espejo());
		}
		return aux;
	}
	
	public void entreNiveles(int n,int m) {
		Queue<BinaryTree<T>> cola = new Queue<>();
		BinaryTree<T> act;
		cola.enqueue(this);
		cola.enqueue(null);
		int nivel=0;
		while (!cola.isEmpty() && nivel<=m) {
			act = cola.dequeue();
			if (act != null) {
				if (nivel >= n) {
					System.out.println(act.getData());
				}
				if (act.hasLeftChild()) {
					cola.enqueue(act.getLeftChild());
				}
				if (act.hasRightChild()) {
					cola.enqueue(act.getRightChild());
				}
			} else {
				nivel++;
				cola.enqueue(null);
			}
		}
	}
	
	public void imprimirEntreNiveles() {
		BinaryTree<T> nodo = null;
		Queue<BinaryTree<T>> cola = new Queue<>();
		
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			nodo = cola.dequeue();
			if (nodo != null) {
				System.out.println(nodo.getData());
				if (nodo.hasLeftChild()) {
					cola.enqueue(nodo.getLeftChild());
				}
				if (nodo.hasRightChild()) {
					cola.enqueue(nodo.getRightChild());
				}
			}
			else if (!cola.isEmpty()) {
				cola.enqueue(null);
			}
		}
	}
	
}
