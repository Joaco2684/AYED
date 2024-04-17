package tp2.ej7;

import tp2.ej1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> a = new BinaryTree<Integer>();
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.a = arbol;
	}
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> nodo = buscar(num, a);
		int hi, hd;
		
		if (nodo == null) {
			return false;
		}
		
		if (nodo.hasLeftChild()) { //(en vez de nodo decia a)
			hi = cantidad(nodo.getLeftChild());
		}
		else hi = -1;
		if (nodo.hasRightChild()) {
			hd = cantidad(nodo.getRightChild());
		}
		else hd = -1;
		System.out.print(hi + " " + hd);
		return hi >hd;
	}
	
	private BinaryTree<Integer> buscar(int num, BinaryTree<Integer> a) {
		BinaryTree<Integer> hi = new BinaryTree<Integer>();
		BinaryTree<Integer> hd = new BinaryTree<Integer>();
		hi = null; //HAY QUE INICIALIZARLOS EN NULL
		hd = null; //HAY QUE INICIALIZARLOS EN NULL
		if (a.getData() == num) {
			return a;
		}
		if (a.hasLeftChild()) {
			hi = buscar(num, a.getLeftChild());
		}
		if (hi != null) {
			return hi;
		}
		if (a.hasRightChild()) {
			hd = buscar(num, a.getRightChild());
		}
		if (hd != null) {
			return hd;
		}
		return null;
	}
	
	private int cantidad(BinaryTree<Integer> a) {
		boolean izq = a.hasLeftChild(), der = a.hasRightChild();
		int suma = 0;
		if ((izq && der == false) || (der && izq == false)) {
			suma++;
		}
		if (izq) {
			suma += cantidad(a.getLeftChild());
		}
		if (der) {
			suma += cantidad(a.getRightChild());
		}
		return suma;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<Integer>(2);
		BinaryTree<Integer> siete = new BinaryTree<Integer>(7);
		BinaryTree<Integer> vTres = new BinaryTree<Integer>(23);
		vTres.addLeftChild(new BinaryTree<Integer>(-3));
		BinaryTree<Integer> seis = new BinaryTree<Integer>(6);
		seis.addLeftChild(new BinaryTree<Integer>(55));
		seis.addRightChild(new BinaryTree<Integer>(11));
		siete.addLeftChild(vTres);
		siete.addRightChild(seis);
		raiz.addLeftChild(siete); //TERMINO RAMA IZQUIERDA
		BinaryTree<Integer> menosCinco = new BinaryTree<Integer>(-5);
		BinaryTree<Integer> dNueve = new BinaryTree<Integer>(19);
		BinaryTree<Integer> cuatro = new BinaryTree<Integer>(4);
		cuatro.addLeftChild(new BinaryTree<Integer>(18));
		dNueve.addRightChild(cuatro);
		menosCinco.addLeftChild(dNueve);
		raiz.addRightChild(menosCinco);
		
		
		
		
		ParcialArboles p = new ParcialArboles(raiz);
		raiz.imprimirEntreNiveles();
		System.out.print(p.isLeftTree(7));
		
	}
}
