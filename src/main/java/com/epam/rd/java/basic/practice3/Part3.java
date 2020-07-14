package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    private static final String TEXT = Util.readFile("part3.txt");

    public static void main(String[] args) {

        Part3.convert(TEXT);

    }

    public static String convert(String input) {

        final String regex = "[.[^\\s]]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        StringBuilder stringBuilder = new StringBuilder();
        String[] stringsInText = input.split("\n");

        for(String string : stringsInText){
            matcher = pattern.matcher(string);
            while (matcher.find()){
                stringBuilder
                        .append(checkWordHasThreeAndMoreLetters(matcher.group()))
                        .append(" ");
            } stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), "\n");
        }

        return stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length()).toString();
    }

    private static String checkWordHasThreeAndMoreLetters(String word){

        if(word.length() >= 3){
            char[] arrayLetters = word.toCharArray();
            if(Character.isLowerCase(arrayLetters[0])){
                arrayLetters[0] = Character.toUpperCase(arrayLetters[0]);
            } else {
                arrayLetters[0] = Character.toLowerCase(arrayLetters[0]);
            }
            return String.valueOf(arrayLetters);
        }  else {
            return word;
        }

    }
}
