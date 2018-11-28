import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {
    TestHeap test1 = new TestHeap(5,
            new TestHeap(6,
            new TestHeap(12, new MtHeap(),new MtHeap()), new MtHeap()),
            new TestHeap(42,
            new TestHeap( 50 , new MtHeap(), new MtHeap()),
            new TestHeap( 100, new MtHeap() , new MtHeap())));

    TestHeap2 test2 = new TestHeap2 (6,
            new TestHeap2(7, new MtHeap(), new MtHeap()),
            new TestHeap2(10, new MtHeap(),
                    new TestHeap2(14, new MtHeap(), new MtHeap())));

    TestHeap3 test3 = new TestHeap3 (40,
            new TestHeap3(50, new MtHeap(),
                    new TestHeap3(80, new MtHeap(), new MtHeap())),
            new TestHeap3(70, new MtHeap(), new MtHeap()));


    @Test
    public void testHeap1Adding(){
        IBinTree added = test1.addElt(8);

        assertFalse(HeapChecker.addEltTester(test1, added));
    }

    @Test
    public void testHeap2Adding(){
        IBinTree added = test2.addElt(8);
        assertTrue(HeapChecker.addEltTester(test2, added));
    }
    @Test
    public void testHeap3Adding(){
        IBinTree added = test3.addElt(8);
        assertFalse(HeapChecker.addEltTester(test3, added));
    }
    @Test
    public void testHeap1Remove(){
        IBinTree removed = test1.remMinElt();
        assertTrue(HeapChecker.remMinEltTester(test1, removed));
    }
    @Test
    public void testHeap2Remove(){
        IBinTree removed = test2.remMinElt();
        assertFalse(HeapChecker.remMinEltTester(test2, removed));
    }
    @Test
    public void testHeap3Remove(){
        IBinTree removed = test3.remMinElt();
        assertTrue(HeapChecker.remMinEltTester(test3, removed));
    }
}