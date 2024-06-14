package tp3.ejercicio9;


import java.util.LinkedList;
import java.util.List;


import tp1.ej8.Queue;
import tp3.ej1ej3ej5.GeneralTree;

public class ClaseParcial {
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		GeneralTree<Integer> act;
		cola.enqueue(arbol);
		while (!cola.isEmpty()) {
			act = cola.dequeue();
			int min = 99999;
			for (GeneralTree<Integer> child: act.getChildren()) {
				min = Math.min(min, act.getData());
				cola.enqueue(child);
			}
			if ((min != act.getData()) && (act.hasChildren())) return false;
		}
		return true;
	} 
	
	public static void main(String[] args) {
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(35, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(35, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(35));
        subChildren3.add(new GeneralTree<Integer>(83));
        subChildren3.add(new GeneralTree<Integer>(90));
        subChildren3.add(new GeneralTree<Integer>(33));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(33, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(14));
        //subChildren4.add(new GeneralTree<Integer>(12));
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(18, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(12, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(25));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol); 
        
        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccion(a));
        
        /*No iba a hacer otro arbol, probe seteando los datos y me daba true igual,
        la idea es descomentar esto y las otras lineas comentadas para probar el segundo
        arbol de la practica mostrado como ejemplo. Ademas de comentar los nodos con valor 12*/
        //System.out.println("Es de seleccion el segundo arbol: " + esDeSeleccion(a)); 
    }
	
}
