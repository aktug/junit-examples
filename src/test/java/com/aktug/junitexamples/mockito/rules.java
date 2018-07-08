package com.aktug.junitexamples.mockito;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertTrue;


public class rules {

    @Rule
    public final TestRule globalTimeout = Timeout.millis(1);

    public static String log;


    @Test
    public void testInfiniteLoop1() {
        log += "ran1";
        for (; ; ) {
        }
    }

    @Test
    public void testInfiniteLoop2() {
        log += "ran2";
        for (; ; ) {
        }
    }


}
