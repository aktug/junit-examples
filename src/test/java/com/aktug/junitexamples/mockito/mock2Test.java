package com.aktug.junitexamples.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class mock2Test {

    @Mock
    List<String> mockList;

    /*@RunWith(MockitoJUnitRunner.class)

    OR Programmaticaly

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {


        mockList.add("one");
        mockList.add("two");
        Mockito.verify(mockList).add("one");

        assertEquals(0, mockList.size());

        Mockito.verify(mockList, times(1)).add("one");
        Mockito.verify(mockList, times(1)).add("two");

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());

    }
}

