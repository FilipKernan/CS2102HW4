import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {
    TestHeap test1 = new TestHeap(5,
            new TestHeap(6,
            new TestHeap(12, null,null), null),
            new TestHeap(42,
            new TestHeap( 50 , null, null),
            new TestHeap( 100, null , null)));

    @Test
    public void testHeap1Adding(){

    }

    @Test
    public void testHeap2Adding(){

    }
    @Test
    public void testHeap3Adding(){

    }
    @Test
    public void testHeap1Remove(){

    }
    @Test
    public void testHeap2Remove(){

    }
    @Test
    public void testHeap3Remove(){

    }
}