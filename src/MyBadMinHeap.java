/**
 * Created by Elliott on 5/3/2017.
 */
import java.util.ArrayList;

/**
 * Min-heap class with methods for inserting, deleting and peeking. The class is slightly modified to make it
 * more effective for Dijkstra's. The class contains an additional arraylist containing node costs.
 */
public class MyBadMinHeap
{
    ArrayList<Integer> costs = new ArrayList<Integer>();
    ArrayList<Integer> nodes = new ArrayList<Integer>();

    /**
     * Takes a node and cost, inserting the node into a minheap and inserting the cost into an arraylist at index node
     * @param cost
     * @param node
     */
    public void insert(int cost, int node) {
        //For Dijkstra's the project page says that the costs of nodes will correspond to the index that is the number representing that node
        costs.set(node, cost);

        nodes.add(node);
        siftUpLastElement(nodes);

    }

    /**
     * Takes the last element of a minheap arraylist and sifts it up to the proper position.
     * (Based off https://www.youtube.com/watch?v=W81Qzuz4qH0 [Heaps video from class])
     * @param arrList
     */
    private void siftUpLastElement(ArrayList<Integer> arrList){
        int k = arrList.size() - 1;
        while(k > 0){
            //While we haven't reached the root of the heap, keep sifting up until the proper position is reached
            int parentLocation = (k - 1)/2;
            int parent = arrList.get(parentLocation);
            int insertedVal = arrList.get(k);
            if(insertedVal < parent){
                //Then swap parent with the node to be inserted
                arrList.set(k, parent);
                arrList.set(parentLocation, insertedVal);
                k = parentLocation;
            }else{
                break;
            }
        }
    }

    /**
     * Deletes the root value, reorganizes the heap, and returns the root val
     *
     * @return rootVal
     */
    public int delete() {
        int rootVal = nodes.get(0);
        nodes.set(0, nodes.get(nodes.size() - 1));
        nodes.remove(nodes.size() - 1);
        siftDownRoot(nodes);
        return rootVal;
    }

    /**
     * Sifts down the root value to the appropriate place within a minheap based on an arraylist
     *
     * @param arrList
     */
    private void siftDownRoot(ArrayList<Integer> arrList){
        int parentInd = 0;
        int leftInd = 2 * parentInd + 1;
        while(leftInd < arrList.size()){
            int rightInd = leftInd + 1;
            int smallerChildInd = 0;
            if(rightInd < arrList.size()){
                if(arrList.get(rightInd) > arrList.get(leftInd)){
                    smallerChildInd = rightInd;
                }else{
                    smallerChildInd = leftInd;
                }
            }
            if(arrList.get(parentInd) < arrList.get(smallerChildInd)){
                int temp = arrList.get(parentInd);
                arrList.set(parentInd, arrList.get(smallerChildInd));
                arrList.set(smallerChildInd, temp);
                parentInd = smallerChildInd;
                leftInd = 2 * parentInd + 1;
            }else{
                break;
            }

        }
    }
    //The two peeks are the same thing?
    /**
     * Returns the value of the node at the top of the heap
     * @return 5
     */
    public int peek() {
        return nodes.get(0);
    }

    /**
     * Also returns the value of the node at the top of the heap
     * @return 2
     */
    public int peekNode() {
        return nodes.get(0);
    }
}