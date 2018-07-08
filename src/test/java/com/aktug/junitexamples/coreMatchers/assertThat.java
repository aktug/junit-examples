package com.aktug.junitexamples.coreMatchers;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class assertThat {
    // JUnit Matchers assertThat
    @Test
    public void testAssertThatBothContainsString() {
        assertThat("albumen", both(containsString("a")).and(containsString("b")));
    }

    @Test
    public void testAssertThatHasItems() {
        assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
    }

    @Test
    public void testAssertThatEveryItemContainsString() {
        assertThat(Arrays.asList(new String[]{"fun", "ban", "net"}), everyItem(containsString("n")));
    }

    @Test
    public void testAssertThatHamcrestCoreMatchers() {
        assertThat("good", allOf(equalTo("good"), startsWith("good")));
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        assertThat(7, not(CombinableMatcher.either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }

    private int totalNumberOfApplicants = 0;

    @Before
    public void setData() {
        this.totalNumberOfApplicants = 9;
    }

    @Test
    public void testAssertThatEqual() {
        assertThat("123", is("123"));
    }

    @Test
    public void testAssertThatNotEqual() {
        assertThat(totalNumberOfApplicants, is(123));
    }

    @Test
    public void testAssertThatObject() {
        assertThat("123", isA(String.class));
    }

    @Test
    public void testAssertThatWMessage() {
        assertThat("They are not equal!", "123", is("1234"));
    }
}
