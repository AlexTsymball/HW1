import org.junit.Test;
import task1.Task1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    private final Task1 task1 = new Task1();

    @Test
    public void testCorrectCalculate(){
        int[] arrayOfInt = new int[]{1, 2, 4, -5, 11, 54, -6, -334, 234, 0};
        int[] actual = task1.arrMoreThanZeroReverseOrder(arrayOfInt);
        assertArrayEquals(new int[]{234, 54, 11, 4, 2, 1, 0}, actual);
    }

    @Test
    public void testCorrectCalculateNegativeArray(){
        int[] arrayOfInt = new int[]{-1, -2, -4, -5, -11, -54, -6, -334, -234};
        int[] actual = task1.arrMoreThanZeroReverseOrder(arrayOfInt);
        assertArrayEquals(new int[]{}, actual);
    }

    @Test
    public void testCorrectCalculateWithEmptyArray(){
        int[] arrayOfInt = new int[]{};
        int[] actual = task1.arrMoreThanZeroReverseOrder(arrayOfInt);
        assertArrayEquals(new int[]{}, actual);
    }

    @Test
    public void testWithNull(){
        int[] arrayOfInt = null;
        NullPointerException exception = assertThrows(NullPointerException.class, () ->{
            task1.arrMoreThanZeroReverseOrder(arrayOfInt);
        });
        assertEquals(exception.getMessage(), "there is must be array");
    }
}
