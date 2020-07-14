package com.epam.rd.java.basic.practice3;

import java.io.IOException;
import java.nio.file.*;

public class Util {

    private static final String ENCODING = "Cp1251"; //you can change it to UTF-8

    public static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(readFile("part1.txt"));
    }

}

//import java.io.File;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Util {
//    public static String getInput(String fileName) {
//        StringBuilder sb = new StringBuilder();
//        try {
//            Scanner scanner = new Scanner(new File(fileName), "UTF-8");
//            while (scanner.hasNextLine()) {
//                sb.append(scanner.nextLine()).append(System.lineSeparator());
//            }
//            scanner.close();
//            return sb.toString().trim();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//        String input = Util.getInput("part1.txt");
//        System.out.println(input);
//    }
//}