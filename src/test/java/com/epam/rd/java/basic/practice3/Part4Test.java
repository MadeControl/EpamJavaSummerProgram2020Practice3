package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Test;

public class Part4Test {

    @Test
    public void hashMD5Test(){

        final String string = "asdf";
        final String algorithm = "MD5";
        final String expectedString = "912EC803B2CE49E4A541068D495AB570";
        Assert.assertEquals(expectedString, Part4.hash(string, algorithm));

    }

    @Test
    public void hashSHA256Test(){

        final String string = "asdf";
        final String algorithm = "SHA-256";
        final String expectedString = "F0E4C2F76C58916EC258F246851BEA091D14D4247A2FC3E18694461B1816E13B";
        Assert.assertEquals(expectedString, Part4.hash(string, algorithm));

    }

}