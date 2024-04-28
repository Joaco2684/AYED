package tp3.ej2;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ej1ej3ej5.GeneralTree;

public class RecorridosAG {
    private GeneralTree<Integer> a;
    
    public RecorridosAG() {}
    
    public RecorridosAG(GeneralTree<Integer> a) {
        this.a = a;
    }
    
    public List <Integer> numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a, Integer n) {
        List <Integer> l = new LinkedList<Integer>();
        if(!a.isEmpty()) this.numerosImparesMayoresQuePreOrden(a, n, l);
        return l;
    }
    
    private void numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a, Integer n, List <Integer> l) {
        int dato = a.getData();
        if(dato %2 != 0 && dato > n) l.add(dato);
        List<GeneralTree<Integer>> children = a.getChildren();
        for(GeneralTree<Integer> child: children) {
            numerosImparesMayoresQuePreOrden(child, n, l);
        }
    }
    
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
        List <Integer> l = new LinkedList<Integer>();
        if(!a.isEmpty()) this.numerosImparesMayoresQueInOrden(a, n, l);
        return l;
    }

    private void numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n, List <Integer> l) {
        List<GeneralTree<Integer>> children = a.getChildren();
        if(a.hasChildren()) {
            numerosImparesMayoresQueInOrden(children.get(0), n, l);
        }
        int dato = a.getData();
        if(dato %2 != 0 && dato > n) l.add(dato);
        for(int i=1; i < children.size(); i++) {
            numerosImparesMayoresQueInOrden(children.get(i), n, l);
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
        List <Integer> l = new LinkedList<Integer>();
        if(!a.isEmpty()) this.numerosImparesMayoresQuePostOrden(a, n, l);
        return l;
    }
    
    private void numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n, List<Integer> l) {
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> child: children) {
            numerosImparesMayoresQuePostOrden(child, n, l);
        }
        int dato = a.getData();
        if(dato %2 != 0 && dato > n) l.add(dato);
    }
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
        List<Integer> result = new LinkedList<Integer>();
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
        queue.enqueue(a);
        while(!queue.isEmpty()) {
            aux = queue.dequeue();
            if(!aux.isEmpty()) {
                int dato = aux.getData();
                if(dato %2 != 0 && dato > n) result.add(dato);
            }
            List<GeneralTree<Integer>> children = aux.getChildren();
            for(GeneralTree<Integer> child: children) {
                queue.enqueue(child);
            }
        }
        return result;
    }
    
    public List<Integer> PorNiveles(GeneralTree <Integer> a, Integer n) {
        List<Integer> result = new LinkedList<Integer>();
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
        queue.enqueue(a);
        while(!queue.isEmpty()) {
            aux = queue.dequeue();
            if(!aux.isEmpty()) {
                int dato = aux.getData();
                result.add(dato);
            }
            List<GeneralTree<Integer>> children = aux.getChildren();
            for(GeneralTree<Integer> child: children) {
                queue.enqueue(child);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(21));
        children2.add(new GeneralTree<Integer>(22));
        children2.add(new GeneralTree<Integer>(23));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(31));
        children3.add(new GeneralTree<Integer>(32));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
        List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
        childen.add(a1);childen.add(a2);childen.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(11, childen);
        
        
        RecorridosAG rec = new RecorridosAG();
        
        System.out.println("PREORDEN:" + a.numerosImparesMayoresQuePreOrden(0));
        System.out.println("INORDEN:" + a.numerosImparesMayoresQueInOrden(0));
        System.out.println("POSTORDEN:" + a.numerosImparesMayoresQuePostOrden(0));
        System.out.println("POR NIVELES:" + rec.PorNiveles(a,0));
        System.out.print(a.esAncestro1(2, 22));
        
        
        
 }

}
