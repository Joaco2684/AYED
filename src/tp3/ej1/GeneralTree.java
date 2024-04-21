package tp3.ej1;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;


public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public List <Integer> numerosImparesMayoresQuePreOrden(Integer n) {
        List <Integer> l = new LinkedList<Integer>();
        if(!this.isEmpty()) this.numerosImparesMayoresQuePreOrden(n, l);
        return l;
    }
    
    private void numerosImparesMayoresQuePreOrden(Integer n, List <Integer> l) {
        int dato = (Integer) this.getData();
        if(dato %2 != 0 && dato > n) l.add(dato);
        List<GeneralTree<T>> children = this.getChildren();
        for(GeneralTree<T> child: children) {
            child.numerosImparesMayoresQuePreOrden(n, l);
        } 
    }
    
    public List<Integer> numerosImparesMayoresQueInOrden (Integer n) {
        List <Integer> l = new LinkedList<Integer>();
        if(!this.isEmpty()) this.numerosImparesMayoresQueInOrden(n, l);
        return l;
    }

    private void numerosImparesMayoresQueInOrden (Integer n, List <Integer> l) {
        List<GeneralTree<T>> children = this.getChildren();
        if(this.hasChildren()) {
            children.get(0).numerosImparesMayoresQueInOrden(n, l);
        }
        int dato = (Integer) this.getData();
        if(dato %2 != 0 && dato > n) l.add(dato);
        for(int i=1; i < children.size(); i++) {
            children.get(i).numerosImparesMayoresQueInOrden(n, l);
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePostOrden (Integer n) {
        List <Integer> l = new LinkedList<Integer>();
        if(!this.isEmpty()) this.numerosImparesMayoresQuePostOrden(n, l);
        return l;
    }
    
    private void numerosImparesMayoresQuePostOrden (Integer n, List<Integer> l) {
        List<GeneralTree<T>> children = this.getChildren();
        for (GeneralTree<T> child: children) {
            child.numerosImparesMayoresQuePostOrden(n, l);
        }
        int dato = (Integer) this.getData();
        if(dato %2 != 0 && dato > n) l.add(dato);
    }
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <T> a, Integer n) { //Anda mal
        List<Integer> result = new LinkedList<Integer>();
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        queue.enqueue(a);
        while(!queue.isEmpty()) {
            aux = queue.dequeue();
            if(!aux.isEmpty()) {
                int dato = (Integer) this.getData();
                if(dato %2 != 0 && dato > n) result.add(dato);
            }
            List<GeneralTree<T>> children = aux.getChildren();
            for(GeneralTree<T> child: children) {
                queue.enqueue(child);
            }
        }
        return result;
    }

	
	public int altura() {	 
		if (this.isLeaf()) {
			return 0; //Llegué a la hoja
		}
		int altMax = -1;
		for (GeneralTree<T> child: this.getChildren()) {
			altMax = Math.max(altMax, child.altura()); //Calcula el max entre cada altura de cada hijo
		}
		return altMax + 1; //Sumo un nivel
	}
	
	
	public int nivel(T dato){
		return nivelHelper(this,dato, 0);
	  }

	private int nivelHelper(GeneralTree<T> arbol, T dato, int nivel) {
		if (arbol.isEmpty()) {
			return -1;
		}
		
		if (arbol.getData() == dato) {
			return nivel;
		}
		
		for (GeneralTree<T> hijo: arbol.getChildren()) {
			int nivEncontrado = nivelHelper(hijo,dato,nivel+1);
			if (nivEncontrado != -1) { //Mientras no se encontró el dato
				return nivEncontrado;
			}
		}
		
		return -1; //Si no estaba en ninguno de sus hijos
		
	}
	
	public int ancho(){
		int anchoMax=-1;
		int cant = 0;
		GeneralTree<T> act;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			act = cola.dequeue();
			if (act != null) {
				for (GeneralTree<T> hijo: act.getChildren()) {
					cola.enqueue(hijo);
					cant++;
				}		
			} else {
				anchoMax = Math.max(anchoMax, cant);
				cant = 0;
				if (!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		return anchoMax;
	}
}