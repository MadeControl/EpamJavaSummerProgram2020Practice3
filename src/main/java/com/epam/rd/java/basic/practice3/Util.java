package com.epam.rd.java.basic.practice3;

import java.io.IOException;
import java.nio.file.*;

public class Util {

    private static final String ENCODING = "Cp1251"; //you can change it to UTF-8

    public static String readFile(String path) {
        String res;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            return null;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(readFile("part1.txt"));
    }

}