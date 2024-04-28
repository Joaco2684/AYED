package tp3.ej9;

import java.util.LinkedList;
import java.util.List;

import tp3.ej1ej3ej5.GeneralTree;

public class ParcialArboles {
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol ) {
		if (!arbol.isEmpty()) {
			return verMenor(arbol);
		} return false;
	}
	
	private static boolean verMenor(GeneralTree<Integer> nodo) {
		boolean flag = true;
		if (!nodo.isLeaf()) {
			int min = Integer.MAX_VALUE;
			for (GeneralTree<Integer> child: nodo.getChildren()) {
				min = Math.min(min,child.getData()); //Calculo valor del hijo minimo
				flag = (flag && verMenor(child)); //Reviso que sus hijos cumplan la condición de ser igual al menor de sus otro hijos
			}
			if (min == nodo.getData()) {
				return (flag && true); //Veo si los demas nodos hijos devolvieron true (son hojas o cumplen con la condicion)
			} else {
				return false; //Si el hijo minimo es disntitno al nodo padre
			}
		}
		return true; // Si es una hoja
	}
	
	//SOLUCIÓN DADA POR  CHATGPT:
	
	public static boolean esDeSeleccion2(GeneralTree<Integer> arbol) {
	    if (arbol.isEmpty()) {
	        return false; // Si el árbol está vacío, no es de selección
	    }
	    return verificaSeleccion2(arbol);
	}

	private static boolean verificaSeleccion2(GeneralTree<Integer> nodo) {
	    if (nodo.isLeaf()) {
	        return true; // Si el nodo es una hoja, cumple la condición
	    }
	    
	    int min = Integer.MAX_VALUE;
	    boolean todosHijosSeleccion = true;

	    for (GeneralTree<Integer> hijo : nodo.getChildren()) {
	        if (!verificaSeleccion2(hijo)) {
	            todosHijosSeleccion = false;
	        }
	        min = Math.min(min, hijo.getData());
	    }

	    return todosHijosSeleccion && (min == nodo.getData());
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
        subChildren4.add(new GeneralTree<Integer>(12));
        //subChildren4.add(new GeneralTree<Integer>(18));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(12, subChildren4);
        //GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(18, subChildren4);
        
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
