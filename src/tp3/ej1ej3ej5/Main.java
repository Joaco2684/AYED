package tp3.ej1ej3ej5;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
        List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
        children1.add(new GeneralTree<Integer>(4));
        children1.add(new GeneralTree<Integer>(7));
        children1.add(new GeneralTree<Integer>(5));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>((13), children1);

        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(6));
        children2.add(new GeneralTree<Integer>(10));
        children2.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>((25), children2);

        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(9));
        children3.add(new GeneralTree<Integer>(12));
        children3.add(new GeneralTree<Integer>(19));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>((11), children3);

        List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
        children4.add(a1);
        children4.add(a2);
        children4.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>((14), children4);

        System.out.println(a.esAncestro(14,11));
    }

}
