/**
 * Created by Elliott on 3/20/2017.
 */
public class BStest {
    public static void main(String args[]){
        BST<Integer> test = new BST<>();
        test.insert(1);
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insert(5);
        test.insert(6);
//        test.insert(7);
//        test.insert(8);
//        test.insert(9);
//        test.insert(5);
//        test.insert(6);
//        test.insert(4);
//        test.insert(3);
//        test.insert(7);
//        test.insert(2);
//        test.insert(8);
        System.out.println(test.exists(2));
        System.out.println("inOrderPrint");
        test.inOrderPrint();
        test.printTree();
        test.balance();
        test.printTree();
    }
}
