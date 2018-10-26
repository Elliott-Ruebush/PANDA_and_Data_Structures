/**
 * Two linked list heads are passed and the two linked lists are added into a doubly linked list. The new doubly linked
 * list is output backwards, representing the actual number (Because the two inputs are reversed, the outputting of the doubly linked list backwards represents the number that
 * is being calculated).
 *
 * @author Elliott Ruebush
 */
public class ListAdder {
    public void run(Node headOne, Node headTwo){
        //Checking our inputs and printing them out
        Node currentOne = headOne;
        System.out.print("First list: ");
        while(currentOne.getNext() != null){
            System.out.print(currentOne.getData());
            currentOne = currentOne.getNext();
        }
        Node currentTwo = headTwo;
        System.out.print("\nSecond list: ");
        while(currentTwo.getNext() != null){
            System.out.print(currentTwo.getData());
            currentTwo = currentTwo.getNext();
        }

        //Reset our inputs
        currentOne = headOne;
        currentTwo = headTwo;

        //Initialize doubly linked list
        DoublyLLNode headDub = new DoublyLLNode();
        DoublyLLNode currentDub = headDub;
        DoublyLLNode prevDub = currentDub;

        //Variable for carrying tens
        int extraTens = 0;

        //Loop for adding
        while(currentOne.getNext() != null || currentTwo.getNext() != null){
            if(currentOne.getNext() != null){
                currentDub.setData(currentOne.getData());
                currentOne = currentOne.getNext();
            }
            if(currentTwo.getNext() != null){
                currentDub.setData(currentDub.getData() + currentTwo.getData());
                currentTwo = currentTwo.getNext();
            }

            currentDub.setData(currentDub.getData() + extraTens);
            extraTens = 0;
            if(currentDub.getData() > 9 && currentOne.getNext() != null || currentTwo.getNext() != null){
                extraTens = (int) (currentDub.getData() / 10);
                currentDub.setData(currentDub.getData() - (extraTens * 10));
            }
            currentDub.setNext(new DoublyLLNode());
            currentDub = currentDub.getNext();
            currentDub.setPrev(prevDub);
            prevDub = currentDub;
        }

        currentDub = currentDub.getPrev();
        System.out.print("\nFinal number: ");
        do{
            System.out.print(currentDub.getData());
            currentDub = currentDub.getPrev();
        }
        while(currentDub != null);
    }
}
