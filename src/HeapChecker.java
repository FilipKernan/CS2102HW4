import java.util.LinkedList;

public class HeapChecker {
    boolean addEltTester(IHeap original, IBinTree addedHeap){
        //

        return false;
    }

    boolean remMinEltTester(IHeap original, IBinTree hRemoved){



        return false;
    }



    boolean isHeap(IBinTree tree){
        if(tree.getRight() == null && tree.getLeft() == null){
            return true;
        }else if(tree.getLeft() == null && tree.getRight() != null){
            return tree.getRight().getData() > tree.getData() && isHeap(tree.getRight());
        }else if(tree.getRight() == null && tree.getLeft() != null){
            return tree.getLeft().getData() > tree.getData() && isHeap(tree.getLeft());
        }else{
            return tree.getLeft().getData() > tree.getData() && tree.getRight().getData() > tree.getData() &&
                    isHeap(tree.getLeft())  && isHeap(tree.getRight());
        }

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