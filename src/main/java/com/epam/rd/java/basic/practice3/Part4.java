package com.epam.rd.java.basic.practice3;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    private static Logger logger = LoggerFactory.getLogger(Part4.class);

    public static void main(String[] args) {

        final String string = "asdf";
        Part4.hash(string, "MD5");
        Part4.hash(string, "SHA-256");

    }

    public static String hash(String input, String algorithm) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(input.getBytes());
            byte[] arrayHash = digest.digest();

            for(byte element : arrayHash){
                stringBuilder.append(convertToHex(element));
            }

            return stringBuilder.toString();

        } catch (NoSuchAlgorithmException ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    private static String convertToHex(byte someByte){
        String string = Integer.toHexString(someByte);
        if(someByte < 0){
            string = string.substring(string.length()-2);
        }
        if(string.length() == 1){
            string = "0" + string;
        }
        return allLettersToUpperCase(string);

    }

    private static String allLettersToUpperCase(String string){
        char[] array = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(char element : array){
            stringBuilder.append(Character.toUpperCase(element));
        } return stringBuilder.toString();
    }
}
