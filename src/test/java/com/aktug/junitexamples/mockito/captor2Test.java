package com.aktug.junitexamples.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class captor2Test {

    @Mock
    List mockList;

    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void whenNotUseSpyAnnotation_thenCorrect() {

        mockList.add("one");
        Mockito.verify(mockList).add(argCaptor.capture());


        assertEquals("This should be 'one'","two", argCaptor.getValue());
    }

    @Test
    public void GivenNullUsernameWhenCreateStudentThenShouldThrowException() {
        fail();
    }
}

