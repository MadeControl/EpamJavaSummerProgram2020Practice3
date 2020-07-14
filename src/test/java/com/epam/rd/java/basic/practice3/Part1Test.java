package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Test;

public class Part1Test {

    private static final String TEXT = Util.readFile("part1.txt");

    @Test
    public void convert1Test(){

        final String expectedString =
                "ivanov: ivanov@mail.com\n" +
                "петров: petrov@google.com\n" +
                "obama: obama@google.com\n" +
                "bush: bush@mail.com\n";

        Assert.assertEquals(expectedString, Part1.convert1(TEXT));

    }

    @Test
    public void convert2Test(){

        final String expectedString =
                        "Ivanov Ivan (email: ivanov@mail.com)\n" +
                        "Петров Петр (email: petrov@google.com)\n" +
                        "Obama Barack (email: obama@google.com)\n" +
                        "Буш Джордж (email: bush@mail.com)\n";

        Assert.assertEquals(expectedString, Part1.convert2(TEXT));

    }

    @Test
    public void convert3Test(){

        final String expectedString =
                "Ivanov Ivan (email: ivanov@mail.com)\n" +
                        "Петров Петр (email: petrov@google.com)\n" +
                        "Obama Barack (email: obama@google.com)\n" +
                        "Буш Джордж (email: bush@mail.com)\n";

        Assert.assertEquals(expectedString, Part1.convert3(TEXT));

    }


}