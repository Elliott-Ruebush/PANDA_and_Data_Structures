import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 *
 * @author Elliott Ruebush
 * @param <T>
 */
public class BST<T> {

    BSTNode<T> root;

    /**
     * creates a node to be inserted and calls insertRecursive to determine
     * where to insert the new node
     *
     * @param insertMe
     */
    public void insert(T insertMe) {
//Make our new node to insert, now we just need to find where to insert it
        BSTNode newInsertNode = new BSTNode<T>();
        newInsertNode.setVal(insertMe);
        root = insertRecursive(newInsertNode, root);
    }

    /**
     * Recursively traverses the tree to determine where a node with a new value
     * should be inserted
     *
     * @param nodeNext
     * @param parent
     * @return A BSTNode reference for root.
     */
    private BSTNode insertRecursive(BSTNode<T> nodeNext, BSTNode<T> parent){
        if (parent == null) {
            return nodeNext;
        } else if (nodeNext.getC().compareTo(parent.getVal()) < 0) {
            parent.setLeft(insertRecursive(nodeNext, parent.getLeft()));
        } else/*if node is greater or equal to the inserted number*/ {
            parent.setRight(insertRecursive(nodeNext, parent.getRight()));
        }
        return parent;
    }

    /**
     * Calls inOrderPrintRecursive to print out the tree
     */
    public void inOrderPrint(){
        inOrderPrintRecursive(root);
    }

    /**
     * Recursively traverses the tree in order, printing out the value of each
     * node that is visited
     *
     * @param node
     */
    private void inOrderPrintRecursive(BSTNode node){
        if (node == null) {
            return;
        }
//Go down the left side until it stops
        inOrderPrintRecursive(node.getLeft());
//Then print value out
        System.out.println(node.getVal());
//Then go down the right side
        inOrderPrintRecursive(node.getRight());
    }

    /**
     * returns true if a value is present in the tree and false if not present,
     * determined by calling existsRecursive
     *
     * @param checkMe
     * @return true
     */
    public boolean exists(T checkMe){
        return existsRecursive(checkMe, root);
    }

    /**
     * Recursively traverses the tree, comparing node values to a value being
     * checked for existence
     *
     * @param checkMe
     * @param node
     * @return true
     */
    private boolean existsRecursive(T checkMe, BSTNode<T> node){
        //Can't just return because we only want to return something if a specific state
        if (node == null) {
            return false;
        } else if (node.getC().compareTo(checkMe) == 0) {
            return true;
        } else if (node.getC().compareTo(checkMe) > 0) {
            /*If the value of the node is more than the check, then the check is less
             than the value of the node
             and would be located to the left*/
            return existsRecursive(checkMe, node.getLeft());
        } else {
            /*If node's value is less than the check, then check is greater and would be
             located to the right*/
            return existsRecursive(checkMe, node.getRight());
        }
    }

    /**
     * Prints out the tree level-by-level using breadth first traversal.
     *
     * @param
     * @return
     */
    public void printTree(){
        System.out.println("\nPrinting...");
        Queue<BSTNode> q = new LinkedList<>();
        BSTNode<T> placeholder = new BSTNode<>();
        if(root != null){
            q.add(root);
            q.add(placeholder);
        }
        BSTNode current;
        while(!(q.isEmpty())){
            current = q.remove();
            if(current != placeholder){
                System.out.print(current.getVal() + "\t");
                if(current.getLeft() != null) {
                    q.add(current.getLeft());
                }
                if(current.getRight() != null) {
                    q.add(current.getRight());
                }
            }else if(current == placeholder){
                System.out.print("\n");
                if(!(q.isEmpty())){
                    q.add(placeholder);
                }
            }
        }
    }

    /**
     * Balances the tree using ArrayLists
     */
    public void balance(){
        System.out.println("\nBalancing...");
        ArrayList<T> inOrderList = new ArrayList<>();
        inOrderList = makeInOrderArrayList(root, inOrderList);
        root.setVal(inOrderList.get((int) inOrderList.size() / 2));
        List<T> leftList = inOrderList.subList(0, inOrderList.size()/2);
        List<T> rightList = inOrderList.subList(((int) inOrderList.size()/2) + 1, inOrderList.size());
        root = balanceRecursive(leftList, rightList, root);

    }

    /**
     * Recursive function used to balance the tree by taking params
     * @param leftList
     * @param rightList
     * @param node
     * @return
     */
    private BSTNode balanceRecursive(List leftList, List rightList, BSTNode node){

        if(leftList.size() >= 1) {
            BSTNode<T> tempLeft = new BSTNode<>();
            tempLeft.setVal((T) leftList.get(leftList.size() / 2));
            node.setLeft(tempLeft);
            balanceRecursive(leftList.subList(0, leftList.size() / 2), leftList.subList((leftList.size() / 2) + 1,
                    leftList.size()), node.getLeft());
        }
        if(rightList.size() >= 1) {
            BSTNode<T> tempRight = new BSTNode<>();
            tempRight.setVal((T) rightList.get(rightList.size() / 2));
            node.setRight(tempRight);
            balanceRecursive(rightList.subList(0, rightList.size() / 2), rightList.subList(((int) rightList.size() / 2) + 1,
                    rightList.size()), node.getRight());
        }
        return root;
    }

    private ArrayList makeInOrderArrayList(BSTNode node, ArrayList arrL){
        if (node == null) {
            return arrL;
        }
//Go down the left side until it stops
        makeInOrderArrayList(node.getLeft(), arrL);
//Then add values to the ArrayList
        arrL.add(node.getVal());
//Then go down the right side
        makeInOrderArrayList(node.getRight(), arrL);
        return arrL;
    }

    /**
     *
     * @param <X>
     */
    public class BSTNode<X> {

        X val;
        BSTNode<X> left;
        BSTNode<X> right;
        boolean discovered = false;

        BSTNode getLeft() {
            return left;
        }

        BSTNode getRight() {
            return right;
        }

        void setLeft(BSTNode bn) {
            left = bn;
        }

        void setRight(BSTNode bn) {
            right = bn;
        }

        X getVal() {
            return val;
        }

        void setVal(X v) {
            val = v;
        }

        void setDiscovered(){
            discovered = true;
        }

        boolean getDiscovered(){
            return discovered;
        }
//need a version of get that returns a comparable object,
//because compareTo won't work on generic types by default
//use get when you need to access the value, use getc
//when you need to do a comparison
//This will crash if a non-comparable object is used.

        Comparable getC() {
            return (Comparable) val;
        }
    }
}