package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Test;

public class Part6Test {

    private static final String TEXT = Util.readFile("part6.txt");

    @Test
    public void convertTest(){

        final String expectedString = "This _is _a _test\n" +
                "_And this _is _also _a _test\n" +
                "_And these are _also tests\n" +
                "_test\n" +
                "_Это _тест\n" +
                "_Это _также _тест\n" +
                "И это _также тесты";

        Assert.assertEquals(expectedString, Part6.convert(TEXT));

    }

}