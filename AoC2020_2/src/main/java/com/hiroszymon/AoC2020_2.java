package com.hiroszymon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AoC2020_2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Utils.readInput();
        List<String[]> values = input.stream().map(e->e.split(" ")).collect(Collectors.toList());

        //Part 1
        List<String> validPasswords = new ArrayList<>();
        for(String[] value : values){
            int countFrom = Integer.parseInt(value[0].split("-")[0]);
            int countTo = Integer.parseInt(value[0].split("-")[1]);
            char letter = value[1].charAt(0);
            long letterCount = value[2].chars().filter(e->e==letter).count();
            if(letterCount>=countFrom && letterCount<=countTo)
                validPasswords.add(value[2]);
        }
        System.out.println(input.size());
        System.out.println(validPasswords);
        System.out.println(validPasswords.size());

        //Part 2
        validPasswords = new ArrayList<>();
        for(String[] value : values){
            int pos1 = Integer.parseInt(value[0].split("-")[0])-1;
            int pos2 = Integer.parseInt(value[0].split("-")[1])-1;
            char letter = value[1].charAt(0);
            if(value[2].length()>pos1) {
                if (value[2].charAt(pos1) == letter &&  (value[2].length()<pos2 || value[2].charAt(pos2) != letter)) {
                    validPasswords.add(value[2]);
                }
                else if (value[2].length()>pos2 && value[2].charAt(pos1) != letter && value[2].charAt(pos2) == letter) {
                    validPasswords.add(value[2]);
                }
            }

        }
        System.out.println(input.size());
        System.out.println(validPasswords);
        System.out.println(validPasswords.size());

    }
}
