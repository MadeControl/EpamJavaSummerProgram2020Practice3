package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    private static final String TEXT = Util.readFile("part6.txt");

    public static void main(String[] args) {

        System.out.println(Part6.convert(TEXT));

    }

    public static String convert(String input) {

        final String regex = "[.[^\\s\\n]]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1;
        Matcher matcher2;
        String[] stringsOfText1 = input.split("\n");
        StringBuilder stringBuilder = new StringBuilder();

        for (String string1 : stringsOfText1) {

            matcher1 = pattern.matcher(string1);

            while (matcher1.find()) {

                int count = 0;
                String tempWord;
                tempWord = matcher1.group();
                matcher2 = pattern.matcher(input);

                while (matcher2.find()) {

                    if (matcher2.group().equals(tempWord)) {

                        count++;
                        if (count >= 2) {
                            break;
                        }

                    }

                }
                if(count >= 2){
                    stringBuilder.append("_");
                }
                stringBuilder.append(tempWord).append(" ");
            }
            stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), "\n");

        }

        return stringBuilder.toString();
    }
}
