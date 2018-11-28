import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.LinkedList;

public class HeapChecker {
    static boolean addEltTester(IHeap original, IBinTree addedHeap){
        System.out.println("Hello");
        if(isHeap(addedHeap)){
            System.out.println("Hello2");
            return heapsTheSame(makeEltsList(original, new LinkedList<>()), makeEltsList(addedHeap, new LinkedList<>()), true);
        }

        return false;
    }

    static boolean remMinEltTester(IHeap original, IBinTree removedHeap){
        System.out.println("Hello");
        if (isHeap(removedHeap)){
            System.out.println("Hello2");
            LinkedList<Integer> originalList = makeEltsList(original, new LinkedList<>());
            System.out.println("makeEltsList is working");
            LinkedList<Integer> changedList = makeEltsList(removedHeap, new LinkedList<>());
            System.out.println("Original:" + originalList);
            System.out.println("changed:" + changedList);

            return heapsTheSame(originalList, changedList, false);
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
            if (original.getData() != 0) {
                soFar.add(original.getData());
            }
           // System.out.println(soFar);      //DEBUGGING
            return soFar;
        } else {
            if (original.getData() != 0 ) { soFar.add(original.getData()); }
            makeEltsList(original.getLeft(), soFar);
            makeEltsList(original.getRight(), soFar);
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
        if(!addOrRemove) {
            int minimum = -1;
            for (int q = 0; q < first.size(); q++) {
                if (minimum == -1 || first.get(q) < minimum) {
                    minimum = first.get(q);
                }
            }
            first.remove(first.indexOf(minimum));
        }

        LinkedList<Integer> listOfBinaries = new LinkedList<>();
        int total = 0;
        for (int i = 0; i < first.size(); i++) {
            if (second.contains(first.get(i))) {
                listOfBinaries.add(0);
            } else {
                listOfBinaries.add(1);
            }
        }
        for (int j = 0; j < listOfBinaries.size(); j++) {
            total = total + listOfBinaries.get(j);
        }
        System.out.println(total);
        if (total == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a IBinTree is a Heap
     * @param data The IBinTree that you are checking
     * @return whether or not the IBinTree is a heap
     */
    static public boolean isHeap(IBinTree data){
        if(data.getRight().size() == 0 && data.getLeft().size() == 0){
            return true;
        }else if(data.getLeft().size() == 0 && data.getRight().size() != 0){
            return data.getRight().getData() > data.getData() && isHeap(data.getRight());
        }else if(data.getRight().size() == 0 && data.getLeft().size() != 0){
            return data.getLeft().getData() > data.getData() && isHeap(data.getLeft());
        }else{
            return data.getLeft().getData() > data.getData() && data.getRight().getData() > data.getData() &&
                    isHeap(data.getLeft())  && isHeap(data.getRight());
        }

    }
}