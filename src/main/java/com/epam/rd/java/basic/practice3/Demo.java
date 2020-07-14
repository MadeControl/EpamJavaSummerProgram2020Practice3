package com.epam.rd.java.basic.practice3;

public class Demo {
    
    public static void main(String[] args) {
        String text = Util.readFile("part1.txt");
        Part1.convert1(text);
        Part1.convert2(text);
        Part1.convert3(text);
        Part1.convert4(text);

        text = Util.readFile("part2.txt");
        Part2.convert(text);

    }

}
