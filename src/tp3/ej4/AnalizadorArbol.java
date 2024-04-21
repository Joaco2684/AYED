package tp3.ej4;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ej1ej3ej5.GeneralTree;

public class AnalizadorArbol {
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		double promMax = -1;
		int sum = 0;
		int cant = 0;
		GeneralTree<AreaEmpresa> act;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			act = cola.dequeue();
			if (act != null) {
				sum += act.getData().getDelay();
				cant++;
				for (GeneralTree<AreaEmpresa> hijo: act.getChildren()) {
					cola.enqueue(hijo);
				}
			}else if (!cola.isEmpty()){ 
				promMax = Math.max(promMax, sum / cant);
				sum = 0;
				cant = 0;
				cola.enqueue(null);
			}
		}
		return promMax;
	}
	
	 public static void main(String[] args) {
	        List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<GeneralTree<AreaEmpresa>>();
	        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("A",4)));
	        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("B",7)));
	        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("C",5)));
	        GeneralTree<AreaEmpresa> a1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J",13), children1);
	        
	        List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<GeneralTree<AreaEmpresa>>();
	        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("D",6)));
	        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("E",10)));
	        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("F",18)));
	        GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K",25), children2);
	        
	        List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<GeneralTree<AreaEmpresa>>();
	        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("G",9)));
	        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("H",12)));
	        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("I",19)));
	        GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L",10), children3);
	        
	        List<GeneralTree<AreaEmpresa>> children4 = new LinkedList<GeneralTree<AreaEmpresa>>();
	        children4.add(a1);
	        children4.add(a2);
	        children4.add(a3);
	        GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M",14), children4);
	        
	        AnalizadorArbol arb = new AnalizadorArbol();
	        System.out.println("El mayor promedio entre todos los valores promedios de los niveles es: " + arb.devolverMaximoPromedio(a));
	    }
	
}
