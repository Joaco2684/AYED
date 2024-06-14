package tp3.ej1ej3ej5;

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
    
    public List<Integer> numerosImparesMayoresQuePorNiveles( Integer n) { 
        List<Integer> result = new LinkedList<Integer>();
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        queue.enqueue(this);
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
	
	private int nivelHelper(T dato, int nivel) {
		int flag = -1;
		if (dato.equals(this.getData())) {
			return nivel;
		}
		for (GeneralTree<T> child: this.getChildren()) {
			flag = child.nivelHelper(dato, nivel+1);
			if (flag > -1) {
				return flag;
			}
		}
		return -1;
	}
	
	public int nivel1(T dato) {
		if (!this.isEmpty()) {
			return this.nivelHelper(dato, 0);
		} else {
			return -1;
		}
	}
	
	
	
	
	public int nivel(T dato){
		int niv = 0;
		GeneralTree<T> act;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			act = cola.dequeue();
			if (act != null) {
				if (act.getData() == dato) return niv;
				for (GeneralTree<T> hijo: act.getChildren()) {
					cola.enqueue(hijo);
				}
			} else if (!cola.isEmpty()){
				niv++;
				cola.enqueue(null);
			}
		}
		
		return -1;
	}
	
	public int ancho() {
		int anchoMax=-1;
		int cant=0;
		Queue<GeneralTree<T>> cola = new Queue<>();
		GeneralTree<T> act;
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			act = cola.dequeue();
			if (act!=null) {
				cant++;
				for (GeneralTree<T> child: act.getChildren()) {
					cola.enqueue(child);
				}
			} else if (!cola.isEmpty()){
				cola.enqueue(null);
				anchoMax = Math.max(anchoMax,cant);
				cant=0;
			}
		}
		return anchoMax;
	}
	
	public boolean esAncestro1(T a,T b) {
		GeneralTree<T> arbol = buscarNodo(a,this);
		if (arbol != null) {
			if (buscarNodo(b, arbol) != null) {
				
			}
		} return false;
	}
	
	private GeneralTree<T> buscarNodo(T nodo, GeneralTree<T> arbol) {
		if (arbol.getData() == nodo) {
			return arbol;
		}
		for (GeneralTree<T> child: arbol.getChildren()) {
			GeneralTree<T> hijo = buscarNodo(nodo, child);
			if (hijo != null) {
				return hijo;
			}
		}
		return null;
	}
	
	private GeneralTree<T> buscarAncestro(T elem, GeneralTree<T> nodo) {
		if (nodo.getData().equals(elem)) {
			return nodo;
		}
		GeneralTree<T> flag = null;
		for (GeneralTree<T> child: nodo.getChildren()) {
			flag = buscarAncestro(elem, child);
			if (flag != null) {
				return flag;
			}
		}
		return null;
	}
	
	
	public boolean esAncestro(T a,T b) {
		GeneralTree<T> nodoA = buscarAncestro(a,this);
		if (nodoA!=null) {
			GeneralTree<T> nodoB = buscarAncestro(b,nodoA);
			if (nodoB!=null) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean esAncestro2(T a, T b) {
		GeneralTree<T> nodoA = buscarAnc(a,b,this); //Devuelve null si no lo encuentra o está antes b
		if (nodoA != null) {
			GeneralTree<T> nodoB = buscarAnc(b,b,nodoA); //Le mando b en lugar de A para que no entre al if de "b antes de a" usado para nodoA
			if (nodoB!=null) {
				return true;
			}
		}
		return false;
		
	}
	
	private GeneralTree<T> buscarAnc(T a,T b, GeneralTree<T> arbol) {
		GeneralTree<T> act;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(arbol);
		while (!cola.isEmpty()) {
			act = cola.dequeue();
			if (act.getData() == a) return act;
			if (act.getData() == b) return null;
			for (GeneralTree<T> hijo: act.getChildren()) {
				cola.enqueue(hijo);
			}
		}
		return null;
	}
	
	 public List<Integer> numerosePorNiveles() {
		List<Integer> result = new LinkedList<Integer>();
	    GeneralTree<T> aux;
	    Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
	    queue.enqueue(this);
	    queue.enqueue(null);
        while(!queue.isEmpty()) {
        	aux = queue.dequeue();
        	if (aux != null) {
        		result.add((Integer) aux.getData());
            	for (GeneralTree<T> child: aux.getChildren()) {
            		queue.enqueue(child);
            	}
            } else if (!queue.isEmpty()) {
            	result.add(null);
            	queue.enqueue(null);
            }
        }
        return result;
	 }
	
	
	
}