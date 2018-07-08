package com.aktug.junitexamples.testDoubles;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class spy {
    @Spy
    List<String> listSpy = new ArrayList<String>();

    @Mock
    List<String> listMock = new ArrayList<String>();


    @Test
    public void testSpyReturnsRealValues() throws Exception {
        String s = "dobie";
        listSpy.add(new String(s));

        verify(listSpy).add(s);
        assertEquals(1, listSpy.size());
    }

    @Test(expected = RuntimeException.class)
    public void testSpyReturnsStubbedValues() throws Exception {
        listSpy.add(new String("dobie"));
        assertEquals(1, listSpy.size());

        when(listSpy.get(anyInt())).thenThrow(new RuntimeException());
        listSpy.get(0);
    }

    @Test
    public void testSpyReturnsStubbedValues2() {

        int size = 5;
        when(listSpy.size()).thenReturn(1, size);

        int mockedListSize = listSpy.size();
        assertEquals(1, mockedListSize);

        mockedListSize = listSpy.size();
        assertEquals(5, mockedListSize);

        mockedListSize = listSpy.size();
        assertEquals(5, mockedListSize);
    }

    @Test
    public void testMockReturnsZero() throws Exception {
        String s = "dobie";

        listMock.add(new String(s));

        verify(listMock).add(s);
        assertEquals(0, listMock.size());
    }

}
