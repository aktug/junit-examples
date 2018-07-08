package com.aktug.junitexamples.mockito;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.ArgumentMatchers.startsWith;

public  class rules2 {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsNothing() {

    }

    @Test
    public void throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }

    @Test
    public void throwsNullPointerExceptionWithMessage() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("happened?");
        thrown.expectMessage(startsWith("What"));
        throw new NullPointerException("What happened?");
    }

    @Test
    public void throwsNullPointerExceptionExceptIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        throw new NullPointerException("What happened?");
    }
    @Test(expected = IllegalArgumentException.class)
    public void sameThing() {
        throw new NullPointerException("What happened?");
    }
}
