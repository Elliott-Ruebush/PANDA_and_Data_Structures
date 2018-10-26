/**
 * Class for nodes of a doubly linked list, with getter and setter methods
 *
 * @author Elliott Ruebush
 */
public class DoublyLLNode{
    int data;
    DoublyLLNode next;
    DoublyLLNode prev;

    public int getData(){
        return data;
    }

    public void setData(int x){
        data = x;
    }

    public DoublyLLNode getNext(){
        return next;
    }

    public DoublyLLNode getPrev(){
        return prev;
    }

    public void setNext(DoublyLLNode n){
        next = n;
    }

    public void setPrev(DoublyLLNode n){
        prev = n;
    }
}