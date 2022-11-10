import org.junit.Test;
import task2.Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {

    private final Task2 task2 = new Task2();

    @Test
    public void testCorrectCalculate(){
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("#start # asd #hhh gdh #dds; #hhh-55. dsd #sda #dds #dfsd #qqqqqq #sf");
        stringArrayList.add("one # #start gdh #dds#not #hHh55. dsd #sda #dds #dfsd #qqqqqq #s");
        stringArrayList.add("two #hhh gdh #dds #hhh55. dsd #sda #dds #dfsd #add #sdasdf");
        Map<String, Integer> actual = task2.topFive(stringArrayList);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("#dds",3);
        expected.put("#hhh",2);
        expected.put("#hhh55",2);
        expected.put("#dfsd",3);
        expected.put("#sda",3);
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectCalculateOneString(){
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("#start#willNotBeHashTag");
        Map<String, Integer> actual = task2.topFive(stringArrayList);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("#start",1);

        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectCalculateIdenticalStrings(){
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("#start #START");
        stringArrayList.add("#stArt #START");
        Map<String, Integer> actual = task2.topFive(stringArrayList);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("#start",2);

        assertEquals(expected, actual);
    }
    @Test
    public void testCorrectCalculateStringsWithIllegalSigns(){
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("#abc?cc");
        stringArrayList.add("#ABc/cc");
        Map<String, Integer> actual = task2.topFive(stringArrayList);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("#abc",2);

        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectCalculateWithEmptyArray(){
        List<String> stringArrayList = new ArrayList<>();
        Map<String, Integer> actual = task2.topFive(stringArrayList);
        assertEquals(Collections.EMPTY_MAP, actual);
    }

    @Test
    public void testWithNull(){
        List<String> stringList = null;
        NullPointerException exception = assertThrows(NullPointerException.class, () ->{
            task2.topFive(stringList);
        });
        assertEquals(exception.getMessage(), "there is must be list of Strings");
    }

}
