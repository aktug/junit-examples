package com.aktug.junitexamples.mockito;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        spyTest.class,
        spy2Test.class})
public class testSuit {
    // Run all tests in spyTest & spy2Test
}
