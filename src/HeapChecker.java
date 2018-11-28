import java.util.LinkedList;

public class HeapChecker {
    boolean addEltTester(IHeap original, IBinTree addedHeap){
        if(addedHeap.isHeap()){

        }

        return false;
    }

    boolean remMinEltTester(IHeap original, IBinTree removedHeap){
        if (removedHeap.isHeap()){

        }


        return false;
    }




    LinkedList<Integer> makeEltsList(IBinTree original, LinkedList<Integer> soFar) {
        if(original.getRight() == null && original.getLeft() == null) {
            soFar.add(original.getData());
            return soFar;
        } else {
            soFar.add(original.getData());
            soFar.addAll(makeEltsList(original.getLeft(), soFar));
            soFar.addAll(makeEltsList(original.getRight(), soFar));
            return soFar;
        }
    }
}