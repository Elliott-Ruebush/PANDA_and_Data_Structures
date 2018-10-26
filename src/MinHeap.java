/**
 * This is a min heap class
 * to be used with Djisktra's
 * Modification made by Mr. Kramer
 * * No more balancing on deletions or insertions
 * * No longer returns int[] anywhere
 * * Actual implementation of sifting on insertions & deletions
 * @author Haoda Wang
 * @author Mr. Kramer
 */
import java.util.*;

public class MinHeap {
    private ArrayList<Pair> list = new ArrayList<Pair>();

    /**
     * Add object to heap
     * @param   v   initial cost
     * @param   n   node number
     */
    public void insert(int v, int n) {
        list.add(new Pair(v, n));
        int curr = list.size() - 1; //current index of array for sifting
        boolean done = false;
        while(!done) {
            int parent = (curr - 1) / 2;
            if (parent < 0) {
                done = true;
            } else if (list.get(curr).weight < list.get(parent).weight) {
                Pair swap = list.get(curr);
                list.set(curr, list.get(parent));
                list.set(parent, swap);
                curr = parent;
            } else {
                done = true;
            }
        }
    }

    /**
     * Delete the top object
     * @return weight value of top object (Elliott changed to node value)
     * 1-12-2017: delete now handles deleting the final node and can handle nodes with weights
     * equal to Integer.MAX_VALUE
     */
    public int delete() {
        int temp;
        temp = list.get(0).node;

        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int curr = 0;
        boolean done = false;
        if (list.size() == 0) done = true;
        while(!done) {
            int rchild = (curr + 1) * 2;
            int lchild = (curr + 1) * 2 - 1;
            int cw = list.get(curr).weight;
            int lcw = Integer.MAX_VALUE;
            if (lchild < list.size()) lcw = list.get(lchild).weight;
            int rcw = Integer.MAX_VALUE;
            if (rchild < list.size()) rcw = list.get(rchild).weight;
            if (cw <= lcw && cw <= rcw) {
                done = true;
            } else if (lcw < rcw) {
                Pair swap = list.get(lchild);
                list.set(lchild, list.get(curr));
                list.set(curr, swap);
                curr = lchild;
            } else {
                Pair swap = list.get(rchild);
                list.set(rchild, list.get(curr));
                list.set(curr, swap);
                curr = rchild;
            }
        }

        return temp;
    }

    /**
     * Look at weight value of top object
     * @return weight value of top object
     */
    public int peek() {
        int temp = list.get(0).weight;
        return temp;
    }

    /**
     * Look at the value of top object
     * @return node value of top object
     */
    public int peekNode() {
        int temp;
        temp = list.get(0).node;
        return temp;
    }

    /**
     * Balance the heap
     */
    public void balance() {
        Collections.sort(list);
    }

    public void debugPrint() {
        for(Pair x : list) {
            System.out.println(x.weight + "," + x.node);
        }
    }

    private class Pair implements Comparable<Pair> {
        public final Integer weight;
        public final Integer node;
        public Pair(int w, int n) {
            this.weight = w;
            this.node = n;
        }

        @Override
        public int compareTo(Pair s) {
            return weight.compareTo(s.weight);
        }
    }
}