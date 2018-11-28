import java.util.LinkedList;

class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;

    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }

    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
    }

    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    @Override
    public IBinTree getLeft() {
        return left;
    }

    @Override
    public IBinTree getRight() {
        return right;
    }

    @Override
    public int getData() {
        return data;
    }



    public LinkedList<Integer> makeEltsList(LinkedList<Integer> soFar) {
        if(this.getRight() == null && this.getLeft() == null) {
            soFar.add(this.getData());
            return soFar;
        } else {
            soFar.add(this.getData());
            soFar.addAll(this.getLeft().makeEltsList(soFar));
            soFar.addAll(this.getRight().makeEltsList(soFar));
            return soFar;
        }
    }


}