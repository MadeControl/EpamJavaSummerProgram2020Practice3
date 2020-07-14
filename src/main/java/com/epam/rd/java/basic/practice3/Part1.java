package com.epam.rd.java.basic.practice3;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final String TEXT = Util.readFile("part1.txt");
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String REGEX = "(.+);((.+)\\s(.+));(([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+))";
    private static StringBuilder stringBuilder;
    private static String[] arrayEmails = {};

    public static void main(String[] args) {

        Part1.convert1(TEXT);
        Part1.convert2(TEXT);
        Part1.convert3(TEXT);
        Part1.convert4(TEXT);

    }

    public static String convert1(String input) {
        pattern = Pattern.compile(REGEX);
        stringBuilder = new StringBuilder();
        String[] texts = input.split("\n");

        for (String newString : texts) {
            matcher = pattern.matcher(newString);
            while (matcher.find()) {
                stringBuilder.append(matcher.group(1)).append(": ").append(matcher.group(5)).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public static String convert2(String input) {
        pattern = Pattern.compile(REGEX);
        stringBuilder = new StringBuilder();
        String[] texts = input.split("\n");

        for (String newString : texts) {
            matcher = pattern.matcher(newString);
            while (matcher.find()) {
                stringBuilder
                        .append(matcher.group(4)).append(" ").append(matcher.group(3)) // It will be Surname Name(example: Ivanov Ivan)
                        .append(" (email: ").append(matcher.group(5))
                        .append(")\n");
            }
        }
        return stringBuilder.toString();

    }

    public static String convert3(String input) {
        pattern = Pattern.compile(REGEX);
        stringBuilder = new StringBuilder();
        String[] texts = input.split("\n");

        for (String newString : texts) {
            matcher = pattern.matcher(newString);
            while (matcher.find()) {
                String string = matcher.group(7) + "." + matcher.group(8);
                addEmailInArray(string);
            }
        }

        for(String email : arrayEmails){
            stringBuilder.append(email).append(" ==> ");
            for(String newString : texts){
                matcher = pattern.matcher(newString);
                while (matcher.find()) {
                    String tempEmail = matcher.group(7) + "." + matcher.group(8);
                    if(tempEmail.equals(email)){
                        stringBuilder.append(matcher.group(1)).append(", ");
                    }
                }
            }
            stringBuilder.replace(stringBuilder.length()-2, stringBuilder.length(), "\n");
        }
        return stringBuilder.toString();


    }

    public static String convert4(String input) {
        pattern = Pattern.compile(REGEX);
        stringBuilder = new StringBuilder();
        String[] texts = input.split("\n");
        final Random random = new Random();

        for (String newString : texts) {
            matcher = pattern.matcher(newString);
            while (matcher.find()) {
                stringBuilder.append(matcher.group(0)).append(";");
                for(int i = 0; i < 4; i++){
                    int digit = (random.nextInt(10));
                    stringBuilder.append(digit);
                }
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private static void addEmailInArray(String email){
        for (String arrayEmail : arrayEmails) {
            if (email.equals(arrayEmail)) {
                return;
            }
        }
        String[] oldArrayEmails = arrayEmails;
        arrayEmails = new String[arrayEmails.length+1];
        System.arraycopy(oldArrayEmails, 0, arrayEmails, 0, oldArrayEmails.length);
        arrayEmails[arrayEmails.length-1] = email;
    }
}