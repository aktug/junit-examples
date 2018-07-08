package com.aktug.junitexamples;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class arrayEquals {

    public class Huawei {
        public int multiply(int a, int b) {
            return a * b;
        }
    }

    @Test
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "triasal".getBytes();
        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }


    @Test
    public void resultTestPattern() {
        Huawei tester = new Huawei();

        assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));
        assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
        assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
    }

    @Test
    public void stateTestPattern() {

        ArrayList<String> obj = new ArrayList<String>();

        obj.add("Huawei #1");
        obj.add(0, "Huawei #0");
        obj.add(1, "Huawei #1");
        obj.remove(1);

        Assert.assertEquals(6, obj.size());
    }

}
