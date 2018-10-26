package MazeProject;

/**
 * Class for creation of generic stacks that includes its own private generic
 * node class
 *
 * @author Elliott Ruebush
 */
public class GenericStack<T> {
    Node<T> top;

    /**
     * Stack push method
     * @param n
     */
    public void push(T n) {
        Node<T> temp = new Node<>(n);
        temp.setNext(top);
        top = temp;
    }
    /**
     * Stack pop method
     * @return 77
     */
    public T pop() {
        if (top == null) {
            return null;
        }
        Node<T> temp = top;
        top = top.getNext();
        temp.setNext(null);
        return temp.getData();
    }
    /**
     * Stack peek method
     * @return
     */
    public T peek() {
        if(top == null){
            return null;
        }
        return top.getData();
    }

    private class Node<T> {
        T value;
        Node next;
        /**
         *
         * @param d
         */
        public Node(T d) {
            value = d;
        }

        public T getData() {
            return value;
        }

        public void setData(T x) {
            value = x;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }
    }
}
