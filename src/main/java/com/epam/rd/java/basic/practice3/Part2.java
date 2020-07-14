package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    private static final String TEXT = Util.readFile("part2.txt");
    private static int min;
    private static int max;
    private static String[] arrayWordsOfMinLength;
    private static String[] arrayWordsOfMaxLength;

    public static void main(String[] args) {

        Part2.convert(TEXT);

    }

    public static String convert(String input) {

        arrayWordsOfMinLength = new String[0];
        arrayWordsOfMaxLength = new String[0];
        min = 10;
        max = 0;
        final String regex = "[.[^-',\\s]]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        StringBuilder stringBuilder = new StringBuilder();
        String[] stringsOfText = input.split("\n");

        for(String stringOfText : stringsOfText){
            matcher = pattern.matcher(stringOfText);
            while (matcher.find()){
                checkWord(matcher.group());
            }
        }
        stringBuilder.append("Min: ");
        fillStringBuilder(stringBuilder, arrayWordsOfMinLength);
        stringBuilder.append("Max: ");
        fillStringBuilder(stringBuilder, arrayWordsOfMaxLength);
        return stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length()).toString();

    }

    private static void checkWord(String word){

        if(word.length() > max){
            max = word.length();
            arrayWordsOfMaxLength = new String[]{word};
        } else if(word.length() < min){
            min = word.length();
            arrayWordsOfMinLength = new String[]{word};
        } else if(word.length() == max){
            addInArrayWordsOfMaxLength(word);
        } else if(word.length() == min){
            addInArrayWordsOfMinLength(word);
        }

    }

    private static void addInArrayWordsOfMinLength(String word){

        if(isUniqueWordInArray(word, arrayWordsOfMinLength)){
            String[] oldArray = arrayWordsOfMinLength;
            arrayWordsOfMinLength = new String[arrayWordsOfMinLength.length+1];
            System.arraycopy(oldArray, 0, arrayWordsOfMinLength, 0, oldArray.length);
            arrayWordsOfMinLength[arrayWordsOfMinLength.length-1] = word;
        }

    }

    private static void addInArrayWordsOfMaxLength(String word){

        if(isUniqueWordInArray(word, arrayWordsOfMaxLength)){
            String[] oldArray = arrayWordsOfMaxLength;
            arrayWordsOfMaxLength = new String[arrayWordsOfMaxLength.length+1];
            System.arraycopy(oldArray, 0, arrayWordsOfMaxLength, 0, oldArray.length);
            arrayWordsOfMaxLength[arrayWordsOfMaxLength.length-1] = word;
        }

    }

    private static StringBuilder fillStringBuilder(StringBuilder stringBuilder, String[] array){

        if(array.length != 0){
            for(String word : array){
                stringBuilder.append(word).append(", ");
            }
            return stringBuilder.replace(stringBuilder.length()-2, stringBuilder.length(), "\n");
        } else {
            return stringBuilder.append("\n");
        }

    }

    private static boolean isUniqueWordInArray(String word, String[] array){

        for(String element: array){
            if(word.equals(element)){
                return false;
            }
        } return true;

    }
}
