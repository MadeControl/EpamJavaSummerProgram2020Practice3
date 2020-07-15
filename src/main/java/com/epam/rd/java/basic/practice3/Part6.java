package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    private static final String TEXT = Util.readFile("part6.txt");
    private static final String REGEX = "[.[^\\s\\n]]+";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static void main(String[] args) {

        System.out.println(Part6.convert(TEXT));

    }

    public static String convert(String input) {

        Matcher matcher1, matcher2;
        String[] stringsOfText = input.split("\n");
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : stringsOfText) {

            matcher1 = PATTERN.matcher(string);

            while (matcher1.find()) {

                int count = 0;
                String tempWord = matcher1.group();;
                matcher2 = PATTERN.matcher(input);

                while (matcher2.find()) {

                    if (matcher2.group().equals(tempWord)) {

                        count++;
                        if (count >= 2) {
                            stringBuilder.append("_");
                            break;
                        }

                    }

                }
                stringBuilder.append(tempWord).append(" ");
            }
            stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), "\n");

        }
        return stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length()).toString();
    }
}
