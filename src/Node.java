/**
 * Class for nodes of a singly linked list with getter and setter methods
 *
 * @author Elliott Ruebush
 */
public class Node{
    int data;
    Node next;

    //Getter and setter methods are used because they are better practice and are easier to change and because
    //the public variables can violate encapsulation
    public int getData(){
        return data;
    }

    public void setData(int x){
        data = x;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node n){
        next = n;
    }
}