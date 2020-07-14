package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final String TEXT = Util.readFile("part1.txt");
    private static Pattern pattern;
    private static Matcher matcher;
    private static String regex;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) {

        Part1.convert1(TEXT);

    }

    public static String convert1(String input) {
//        regex = "([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)";
        regex = "(.+);(.+);(.+)";
        pattern = Pattern.compile(regex);
        stringBuilder = new StringBuilder();
        String[] texts = TEXT.split("\n");

        for(String newString : texts){
            matcher = pattern.matcher(newString);
            while (matcher.find()){
                stringBuilder.append(matcher.group(1)).append(": ").append(matcher.group(3)).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public static String convert2(String input) {
        regex = "(.+);(.+);(.+)";
        pattern = Pattern.compile(regex);
        stringBuilder = new StringBuilder();
        String[] texts = TEXT.split("\n");

        for(String newString : texts){
            matcher = pattern.matcher(newString);
            while (matcher.find()){
                String[] array = matcher.group(2).split("\\s");
                stringBuilder
                        .append(array[1]).append(" ").append(array[0]) // It will be Surname Name(example: Ivanov Ivan)
                        .append(" (email: ").append(matcher.group(3))
                        .append(")\n");
            }
        }
        return stringBuilder.toString();

    }

    public static String convert3(String input) {
        regex = "(.+);(.+);(([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+))";
        pattern = Pattern.compile(regex);
        stringBuilder = new StringBuilder();
        String[] texts = TEXT.split("\n");
        String[] emails = new String[2];
        for(String newString : texts){
            matcher = pattern.matcher(newString);
            while (matcher.find()){
                String[] array = matcher.group(2).split("\\s");
                stringBuilder
                        .append(array[1]).append(" ").append(array[0]) // It will be Surname Name(example: Ivanov Ivan)
                        .append(" (email: ").append(matcher.group(3))
                        .append(")\n");
            }
        }
        return stringBuilder.toString();


    }

    public static String convert4(String input) {
        return null;
    }
}