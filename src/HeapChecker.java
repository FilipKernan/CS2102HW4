import java.util.LinkedList;

public class HeapChecker {
    static boolean addEltTester(IHeap original, IBinTree addedHeap){
        if(isHeap(addedHeap)){
            return heapsTheSame(makeEltsList(original, new LinkedList<>()), makeEltsList(addedHeap, new LinkedList<>()), true);
        }
        return false;
    }

    boolean remMinEltTester(IHeap original, IBinTree removedHeap){
        if (isHeap(removedHeap)){
            return heapsTheSame(makeEltsList(original, new LinkedList<>()), makeEltsList(removedHeap, new LinkedList<>()), false);
        }
        return false;
    }

    /**
     * makeEltsList is a method that consumes a BST and an empty list and returns a linkedlist of integers containing all of the nodes of the given BST
     * @param original is the BST that is being turned into a list
     * @param soFar is a blank linkedlist used as an iterator, since this method utilizes untrustworthy recursion
     * @return is a linkedlist of integers containing every element of the original BST
     */

    static public LinkedList<Integer> makeEltsList(IBinTree original, LinkedList<Integer> soFar) {
        if(original.getRight() == null && original.getLeft() == null) {
            soFar.add(original.getData());
            System.out.println(soFar);      //DEBUGGING
            return soFar;
        } else {
            soFar.add(original.getData());
            soFar.addAll(makeEltsList(original.getLeft(), soFar));
            soFar.addAll(makeEltsList(original.getRight(), soFar));
            return soFar;
        }
    }

    /**
     * heapsTheSame checks to see if the two given linkedlists contain the exact same numbers, except for one
     * @param first the first linkedlist, which is created from the original BST
     * @param second the second linkedlist, which is created from the BST that has had one part either added or removed
     * @param addOrRemove a boolean that tells the method whether a node was added or removed, and therefore which list (first or second) should have the extra element
     * @return if everything checks out, and the list are the same except for one extra element where it is supposed to be, it returns true
     */

    static public boolean heapsTheSame(LinkedList<Integer> first, LinkedList<Integer> second, boolean addOrRemove) {              // ADD IS TRUE REMOVE IS FALSE

        if (first.size() - second.size() == 1 || second.size() - first.size() == 1) {
            return false;
        } else {
            for (int i = 0; i < first.size(); i++) {
                for (int j = 0; j < second.size(); j++) {
                    if (first.get(i) == second.get(j)) {
                        first.remove(i);
                        second.remove(j);
                    }
                }
            }
            System.out.println(first);
            System.out.println(second);

            if (addOrRemove) {
                return (first.size() == 0 && second.size() == 1);
            } else {
                return (first.size() == 1 && second.size() == 0);
            }
        }
    }

    /**
     * Checks if a IBinTree is a Heap
     * @param data The IBinTree that you are checking
     * @return whether or not the IBinTree is a heap
     */
    static public boolean isHeap(IBinTree data){
        if(data.getRight() == null && data.getLeft() == null){
            return true;
        }else if(data.getLeft() == null && data.getRight() != null){
            return data.getRight().getData() > data.getData() && isHeap(data.getRight());
        }else if(data.getRight() == null && data.getLeft() != null){
            return data.getLeft().getData() > data.getData() && isHeap(data.getLeft());
        }else{
            return data.getLeft().getData() > data.getData() && data.getRight().getData() > data.getData() &&
                    isHeap(data.getLeft())  && isHeap(data.getRight());
        }

    }
}