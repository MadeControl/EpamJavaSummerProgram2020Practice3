package com.epam.rd.java.basic.practice3;

public class Part5 {

    public static void main(String[] args) {
        final String arrow = " --> ";
        for(int i = 1; i <= 100; i++){
            System.out.println(i+arrow+decimal2Roman(i)+arrow+roman2Decimal(decimal2Roman(i)));
        }

    }

    public static String decimal2Roman(int dec) {
        if( dec <= 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder stringBuilder = new StringBuilder();
        final Numeral[] values = Numeral.values();

        for (int i = values.length - 1; i >= 0; i--) {
            while (dec >= values[i].weight) {
                stringBuilder.append(values[i]);
                dec -= values[i].weight;
            }
        }
        return stringBuilder.toString();
    }

    public static int roman2Decimal(String roman) {
        int result = 0;

        for(int i = 0; i < roman.length()-1; i++) {
            if (number(roman.charAt(i)) < number(roman.charAt(i+1))) {
                result -= number(roman.charAt(i));
            } else {
                result += number(roman.charAt(i));
            }
        }
        result += number(roman.charAt(roman.length()-1));
        return result;
    }

    private static int number(char letter) {
        switch(letter) {
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default: return 0;
        }
    }

    private enum Numeral {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100);

        int weight;

        Numeral(int weight) {
            this.weight = weight;
        }
    }
}
