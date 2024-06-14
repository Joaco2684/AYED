package tp3.Gematria;

import tp3.ej1ej3ej5.GeneralTree;

public class GematriaParcial {
	public int contar(GeneralTree<Integer> arbol, int valor) {
		if (!arbol.isEmpty()) {
			return contarHelper(arbol,valor,0);
		} else {
			return -1;
		}
	}
	
	private int contarHelper(GeneralTree<Integer> nodo, int valor,int suma) {
		if (nodo.isLeaf()) {
			if (suma + nodo.getData() == valor) {
				return 1;
			} else return 0;
		}
		if (nodo.getData() + suma < valor) {
			int cant=0;
			for (GeneralTree<Integer> child: nodo.getChildren()) {
				cant += contarHelper(child, valor, suma+nodo.getData());
			}
			return cant;
		}
		return 0;
		
	}
	
}
