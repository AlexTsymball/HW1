import org.junit.Test;
import task3.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {

    private final Task3 task3 = new Task3();

    @Test
    public void testCorrectCalculate(){
        List<Shape> shapeArrayList = new ArrayList<>();
        shapeArrayList.add(new Cube(4));
        shapeArrayList.add(new Sphere(5));
        shapeArrayList.add(new Cylinder(44.4,2));
        List<Shape> actual = task3.sortShape(shapeArrayList);
        List<Shape> expected = new ArrayList<>();
        expected.add(new Cube(4));
        expected.add(new Sphere(5));
        expected.add(new Cylinder(44.4,2));

        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectCalculateWithNegative(){
        List<Shape> shapeArrayList = new ArrayList<>();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            shapeArrayList.add(new Cube(-4));
            shapeArrayList.add(new Sphere(-5));
            shapeArrayList.add(new Cylinder(-44.4,-2));
            task3.sortShape(shapeArrayList);
        });
        assertEquals(exception.getMessage(), "value can't be less than or equals 0");
    }

    @Test
    public void testCorrectCalculateWithVeryBigValue(){
        List<Shape> shapeArrayList = new ArrayList<>();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            shapeArrayList.add(new Cube(Double.MAX_VALUE));
            shapeArrayList.add(new Sphere(5));
            shapeArrayList.add(new Cylinder(44.4,2));
            task3.sortShape(shapeArrayList);
        });
        assertEquals(exception.getMessage(), "too big value for correct calculate this operation");

    }

    @Test
    public void testCorrectCalculateWithEmpty(){
        List<Shape> shapeArrayList = new ArrayList<>();
        List<Shape> actual = task3.sortShape(shapeArrayList);
        assertEquals(Collections.EMPTY_LIST, actual);

    }

    @Test
    public void testCorrectCalculateWithNull(){
        List<Shape> shapeList = null;

        NullPointerException exception = assertThrows(NullPointerException.class, () ->{
            task3.sortShape(shapeList);
        });
        assertEquals(exception.getMessage(), "there is must be list of shapes");

    }
}
