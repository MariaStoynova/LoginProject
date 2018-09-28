package eu.distinct_solutions.loginproject;

import org.junit.Test;


import static org.junit.Assert.*;

public class MyActivityTest {


    @Test
    public void testSumOfTwoInt() {
        int param1 = 1;
        int param2 = 4;
        int expected = 5;



        int result = MyActivity.Sum(param1, param2);
        assertEquals(expected, result);

    }
}