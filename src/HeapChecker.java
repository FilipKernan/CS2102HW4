import java.util.LinkedList;

public class HeapChecker {
    boolean addEltTester(IHeap original, IBinTree addedHeap){
        if(isHeap(addedHeap)){
            return heapsTheSame(original.makeEltsList(new LinkedList<>()), addedHeap.makeEltsList(new LinkedList<>()), true);
        }
        return false;
    }

    boolean remMinEltTester(IHeap original, IBinTree removedHeap){
        if (isHeap(removedHeap)){
            return heapsTheSame(original.makeEltsList(new LinkedList<>()), removedHeap.makeEltsList(new LinkedList<>()), false);
        }
        return false;
    }
    public boolean heapsTheSame(LinkedList<Integer> first, LinkedList<Integer> second, boolean addOrRemove) {              // ADD IS TRUE REMOVE IS FALSE
        if (first.size() != second.size()) {
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
            if (addOrRemove) {
                return (first.size() == 0 && second.size() == 1);
            } else {
                return (first.size() == 1 && second.size() == 0);
            }
        }
    }


    public boolean isHeap(IBinTree data){
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