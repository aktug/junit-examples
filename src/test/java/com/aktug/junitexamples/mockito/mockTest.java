package com.aktug.junitexamples.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class mockTest {


    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {

        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");

        assertEquals(0, mockList.size());
        Mockito.verify(mockList).add("one");

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());

    }
}

