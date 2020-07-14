package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Test;

public class Part3Test {

    private static final String TEXT = Util.readFile("part3.txt");

    @Test
    public void convertTest(){

        final String expectedString =
                "when I Was Younger\n" +
                "I Never Needed";
        Assert.assertEquals(expectedString, Part3.convert(TEXT));

    }

}