package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Test;

public class Part5Test {

    @Test
    public void decimal2RomanTest(){

        Assert.assertEquals("I", Part5.decimal2Roman(1));
        Assert.assertEquals("IV", Part5.decimal2Roman(4));
        Assert.assertEquals("V", Part5.decimal2Roman(5));
        Assert.assertEquals("X", Part5.decimal2Roman(10));
        Assert.assertEquals("XL", Part5.decimal2Roman(40));
        Assert.assertEquals("L", Part5.decimal2Roman(50));
        Assert.assertEquals("XC", Part5.decimal2Roman(90));
        Assert.assertEquals("C", Part5.decimal2Roman(100));

    }

    @Test
    public void roman2DecimalTest(){

        Assert.assertEquals(1, Part5.roman2Decimal("I"));
        Assert.assertEquals(4, Part5.roman2Decimal("IV"));
        Assert.assertEquals(5, Part5.roman2Decimal("V"));
        Assert.assertEquals(10, Part5.roman2Decimal("X"));
        Assert.assertEquals(40, Part5.roman2Decimal("XL"));
        Assert.assertEquals(50, Part5.roman2Decimal("L"));
        Assert.assertEquals(90, Part5.roman2Decimal("XC"));
        Assert.assertEquals(100, Part5.roman2Decimal("C"));

    }

}