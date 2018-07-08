package com.aktug.junitexamples.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class spy2Test {

    @Spy
    List<String> spyList = new ArrayList<String>();

    @Test
    public void whenNotUseSpyAnnotation_thenCorrect() {


        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size(); // Stubbed
        assertEquals(100, spyList.size());
    }
}

