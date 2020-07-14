package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Test;

public class Part2Test {

    @Test
    public void convertTest(){

        final String TEXT = Util.readFile("part2.txt");
        final String expectedString =
                "Min: I, s, m\n" +
                "Max: younger, anybody, assured, changed";
        Assert.assertEquals(expectedString, Part2.convert(TEXT));

    }

}