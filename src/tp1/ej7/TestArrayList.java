package tp1.ej7;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import tp1.ej3.Estudiante;

public class TestArrayList {
	
	private static boolean estaBalanceado(String s) {
		ArrayList<Character> cierre = new ArrayList<Character>();
		cierre.add(')');
		cierre.add(']');
		cierre.add('}');
		boolean ok=true;
		if ((s.length() %2 != 0 ) || (s.length()>0) && (cierre.contains(s.charAt(0)))) {
			ok = false;
		} else {
			ArrayList<Character> apertura = new ArrayList<Character>();
			apertura.add('(');
			apertura.add('[');
			apertura.add('{');
			
			Stack<Character> pila = new Stack<Character>();
			char act,elem;
			int i=0;
			while (i < s.length() && ok) {
				act = s.charAt(i);
				if (apertura.contains(act)) {
					pila.push(act);
				} else {
					if (!pila.isEmpty()) {
						elem = pila.pop();
						if (apertura.indexOf(elem) != cierre.indexOf(act)) {
							ok = false;
						}
					} else {
						ok=false;
					}
				}
				i++;
			}
			ok = pila.isEmpty();
		}
		
		return ok;
	}
	
	public static void main(String[]args) {
		System.out.print(estaBalanceado("({[})"));
		
	}
}
