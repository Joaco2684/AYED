package tp3.ej7;

import java.util.LinkedList;
import java.util.List;

import tp3.ej1ej3ej5.GeneralTree;

public class Caminos {
	GeneralTree<Integer> arbol;

	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> caminoAHojaMasLejana() {
		if (!arbol.isEmpty()) {
			List<Integer> listaAct = new LinkedList<Integer>();
			List<Integer> listaMax = new LinkedList<Integer>();
			calcularCam(arbol, listaAct, listaMax);
			return listaMax;
		}
		return null;
	}
	
	private void calcularCam(GeneralTree<Integer> a, List<Integer> listaAct, List<Integer> listaMax) {
		listaAct.add(a.getData());
		if (a.isLeaf()) {
			if (listaAct.size() > listaMax.size()) {
				listaMax.clear();
				listaMax.addAll(listaAct);
			}
		} else {
			for (GeneralTree<Integer> child: a.getChildren()) {
				calcularCam(child,listaAct,listaMax);
			}
		}
		listaAct.remove(listaAct.size() - 1);
	}
	
	public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(6, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(10));
        subChildren2.add(subA);
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(17, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(9, subChildren3);
        
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(16));
        subChildren4.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(14, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(subB);
        subChildren5.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(15, subChildren5);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol);
        
        Caminos cam = new Caminos(a);
        
        System.out.println("Camino a hoja mas lejana: " + cam.caminoAHojaMasLejana());
 }
}
